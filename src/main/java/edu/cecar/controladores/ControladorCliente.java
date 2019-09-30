/**
 * Clase: Cliente.java
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
 * Clase cliente que permite la subida y descarga de archivo hacia y desde el
 * servidor
 *
 */
import edu.cecar.componentes.utilidades.Utilidades;
import edu.CECAR.componentes.comunicaciones.SocketObjeto;
import edu.cecar.modelos.Album;
import edu.cecar.modelos.Archivo;
import edu.cecar.modelos.Coment;
import edu.cecar.modelos.Photo;
import edu.cecar.modelos.Post;
import edu.cecar.modelos.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public final class ControladorCliente {

    static SocketObjeto socketObjeto;

    /*public ControladorCliente(String IPServidor, int puerto) {
        socketObjeto = new SocketObjeto(IPServidor, puerto);
    }*/
    public boolean conectarClienteServidor(String IPServidor, int puerto) {
        socketObjeto = new SocketObjeto(IPServidor, puerto);
        return socketObjeto.getSocket() != null;

    }

    public void PeticionCliente(String operacion) {
        try {
            String ruta = System.getProperty("user.dir") + "\\Archivos\\";
            String nombreArchivo;
            Object object;
            switch (operacion) {
                case "login":

                    //*** Se inicia la subida de un  archivo **********************************
                    nombreArchivo = "archivo_credenciales.txt";
                    Archivo archivo_login = new Archivo(nombreArchivo, Utilidades.getBytes(ruta + nombreArchivo), "Subida");
                    socketObjeto.getSalida().writeObject(archivo_login);
                    //**************************************************************************

                    //*** Se inicia la descarga de un  archivo **********************************
                    archivo_login = new Archivo("respuesta_login.txt", "Descarga");
                    socketObjeto.getSalida().writeObject(archivo_login);
                    object = socketObjeto.getEntrada().readObject();
                    archivo_login = (Archivo) object;
                    Utilidades.escribirAchivo(ruta + "respuesta_login.txt", archivo_login.getBytes());
                    //**************************************************************************

                    //Thread.sleep(1000); //Se bloquea por lo explicado en clase
                    break;
                case "registro":

                    //*** Se inicia la subida de un  archivo **********************************
                    nombreArchivo = "archivo_registro.txt";
                    Archivo archivo = new Archivo(nombreArchivo, Utilidades.getBytes(ruta + nombreArchivo), "Subida");
                    socketObjeto.getSalida().writeObject(archivo);
                    //**************************************************************************

                    //*** Se inicia la descarga de un  archivo **********************************
                    archivo = new Archivo("respuesta_registro.txt", "Descarga");
                    socketObjeto.getSalida().writeObject(archivo);
                    object = socketObjeto.getEntrada().readObject();
                    archivo = (Archivo) object;
                    Utilidades.escribirAchivo(ruta + "respuesta_registro.txt", archivo.getBytes());
                    //**************************************************************************

                    //Thread.sleep(1000); //Se bloquea por lo explicado en clase
                    break;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            System.exit(0);
        }
    }

    public ArrayList<User> obtenerUsuarios() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Object object;
            socketObjeto.getSalida().writeObject(new Archivo("users", "Descarga"));
            object = socketObjeto.getEntrada().readObject();
            users = (ArrayList<User>) object;
            return users;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            //System.exit(0);
        }

        return users;
    }

    public ArrayList<Post> obtenerPosts() {
        ArrayList<Post> posts = new ArrayList<Post>();
        try {
            Object object;
            socketObjeto.getSalida().writeObject(new Archivo("posts", "Descarga"));
            object = socketObjeto.getEntrada().readObject();
            posts = (ArrayList<Post>) object;
            return posts;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            //System.exit(0);
        }

        return posts;
    }

    public ArrayList<Photo> obtenerPhotos() {
        ArrayList<Photo> photos = new ArrayList<Photo>();
        try {
            Object object;
            socketObjeto.getSalida().writeObject(new Archivo("photos", "Descarga"));
            object = socketObjeto.getEntrada().readObject();
            photos = (ArrayList<Photo>) object;
            return photos;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            //System.exit(0);
        }

        return photos;
    }

    public ArrayList<Coment> obtenerComents() {
        ArrayList<Coment> coments = new ArrayList<Coment>();
        try {
            Object object;
            socketObjeto.getSalida().writeObject(new Archivo("coments", "Descarga"));
            object = socketObjeto.getEntrada().readObject();
            coments = (ArrayList<Coment>) object;
            return coments;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            //System.exit(0);
        }

        return coments;
    }

    public ArrayList<Album> obtenerAlbums() {
        ArrayList<Album> albums = new ArrayList<Album>();
        try {
            Object object;
            socketObjeto.getSalida().writeObject(new Archivo("albums", "Descarga"));
            object = socketObjeto.getEntrada().readObject();
            albums = (ArrayList<Album>) object;
            return albums;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Se perdió la conexion con el servidor, intente nuevamente");
            //System.exit(0);
        }

        return albums;
    }

}
