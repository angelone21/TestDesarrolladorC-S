/**
 * Clase: ServidorArchivo.java
 *
 * Version: 1.0
 *
 * Fecha creaci�n: 26/09/2018
 *
 * Ultima Fecha  Modificacion:
 *
 * Autor: Ing. Jhon Jaime Mendez Alandete
 *
 * Copyright: CECAR
 */
package edu.cecar.controladores;

/**
 * Servidor que permite la subida y descarga de archivos desde y hacia los
 * clientes
 */
import java.io.IOException;

import edu.cecar.componentes.utilidades.Utilidades;
import edu.CECAR.componentes.comunicaciones.ServerSocketObjeto;
import edu.cecar.componentes.singletons.SingletonAccesoAPI;
import edu.cecar.modelos.Album;
import edu.cecar.modelos.Archivo;
import edu.cecar.modelos.Coment;
import edu.cecar.modelos.Photo;
import edu.cecar.modelos.Post;
import edu.cecar.modelos.User;
import java.util.List;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import us.monoid.json.JSONException;

public final class ControladorServidor {

    private String ruta = "ArchivosCompartidos/";

    public ControladorServidor(int puerto) {
        try {
            ControladorUser controladorUser = new ControladorUser();
            ControladorPost controladorPost = new ControladorPost();
            ControladorPhoto controladorPhoto = new ControladorPhoto();
            ControladorComent controladorComent = new ControladorComent();
            ControladorAlbum controladorAlbum = new ControladorAlbum();
            ControladorAPIGoRest controladorAPIGoRest = new ControladorAPIGoRest();
            SingletonAccesoAPI.getinstanceUser();
            SingletonAccesoAPI.getinstanceAlbum();
            SingletonAccesoAPI.getinstanceComment();
            SingletonAccesoAPI.getinstancePhoto();
            SingletonAccesoAPI.getinstancePost();
            ArrayList<User> users = controladorAPIGoRest.obtenerUser();
            ArrayList<Post> posts = controladorAPIGoRest.obtenerPost();
            ArrayList<Photo> photos = controladorAPIGoRest.obtenerPhoto();
            ArrayList<Coment> coments = controladorAPIGoRest.obtenerComent();
            ArrayList<Album> albums = controladorAPIGoRest.obtenerAlbum();
            try {
                controladorUser.eliminarTodo();
                controladorComent.eliminarTodo();
                controladorAlbum.eliminarTodo();
                controladorPhoto.eliminarTodo();
                controladorPost.eliminarTodo();
                for (int i = 0; i < users.size(); i++) {
                    controladorUser.guardar(users.get(i));
                }
                for (int i = 0; i < posts.size(); i++) {
                    controladorPost.guardar(posts.get(i));
                }
                for (int i = 0; i < albums.size(); i++) {
                    controladorAlbum.guardar(albums.get(i));
                }
                for (int i = 0; i < photos.size(); i++) {
                    controladorPhoto.guardar(photos.get(i));
                }
                for (int i = 0; i < coments.size(); i++) {
                    controladorComent.guardar(coments.get(i));
                }

            } catch (SQLException e) {

            }
            System.out.println("Servidor Montado");
            ServerSocketObjeto serverSocket = new ServerSocketObjeto(puerto); // Se bloquea esperando conexion
            boolean sw = true;
            while (sw) {

                try {
                    //Se bloque esperando un objeto que sea enviado por el cliente
                    Object object = serverSocket.getEntrada().readObject();

                    //Se realiza la conversi�n a un objeto de tipo Archivo
                    Archivo archivo = (Archivo) object;

                    if (archivo.getOperacion().equals("Subida")) { //se verifica si se sube o descarga

                        Utilidades.escribirAchivo(ruta + archivo.getNombre(), archivo.getBytes());
                        if (archivo.getNombre().equals("archivo_credenciales.txt")) {
                            try {
                                File archivo_credenciales = new File(ruta + "archivo_credenciales.txt");
                                File respuesta_login = new File(ruta + "respuesta_login.txt");
                                FileReader lector;
                                BufferedReader bf;
                                try (PrintWriter pw = new PrintWriter(respuesta_login)) {
                                    lector = new FileReader(archivo_credenciales);
                                    bf = new BufferedReader(lector);
                                    String contenido;
                                    ControladorUsuario controladorUsuario = new ControladorUsuario();
                                    ArrayList<String> credenciales = new ArrayList<String>();
                                    while ((contenido = bf.readLine()) != null) {
                                        credenciales.add(contenido);
                                    }
                                    if (controladorUsuario.consultarUsuario(credenciales.get(0), credenciales.get(1))) {
                                        pw.println("true");
                                    } else {
                                        pw.print("false");
                                    }
                                }
                                lector.close();
                                bf.close();
                            } catch (Exception ex) {

                            }
                        }
                        if (archivo.getNombre().equals("archivo_registro.txt")) {
                            try {
                                File archivo_registro = new File(ruta + "archivo_registro.txt");
                                File respuesta_registro = new File(ruta + "respuesta_registro.txt");
                                FileReader lector;
                                try (PrintWriter pw = new PrintWriter(respuesta_registro)) {
                                    lector = new FileReader(archivo_registro);
                                    BufferedReader bf = new BufferedReader(lector);
                                    String contenido;
                                    ControladorUsuario controladorUsuario = new ControladorUsuario();
                                    ArrayList<String> credenciales = new ArrayList<String>();
                                    while ((contenido = bf.readLine()) != null) {
                                        credenciales.add(contenido);
                                    }
                                    if (controladorUsuario.registrarUsuario(credenciales.get(0), credenciales.get(1))) {
                                        pw.println("true");
                                    } else {
                                        pw.print("false");
                                    }
                                }
                                lector.close();
                            } catch (Exception ex) {

                            }
                        }

                    } else if (archivo.getNombre().equals("users")) {
                        serverSocket.getSalida().writeObject(users);
                    } else if (archivo.getNombre().equals("posts")) {
                        serverSocket.getSalida().writeObject(posts);
                    } else if (archivo.getNombre().equals("photos")) {
                        serverSocket.getSalida().writeObject(photos);
                    } else if (archivo.getNombre().equals("coments")) {
                        serverSocket.getSalida().writeObject(coments);
                    } else if (archivo.getNombre().equals("albums")) {
                        serverSocket.getSalida().writeObject(albums);
                    } else {
                        byte[] bytes = Utilidades.getBytes(ruta + archivo.getNombre());
                        archivo.setBytes(bytes);
                        serverSocket.getSalida().writeObject(archivo);
                    }

                } catch (IOException e) {

                    System.out.println("Conexi�n cerrada de manera inesperada. " + e);
                    sw = false;

                } catch (ClassNotFoundException e) {

                    e.printStackTrace();

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        } catch (JSONException ex) {
            Logger.getLogger(ControladorServidor.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ControladorServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
