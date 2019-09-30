package edu.cecar.controladores;

import edu.cecar.modelos.Album;
import edu.cecar.modelos.Coment;
import edu.cecar.modelos.Photo;
import edu.cecar.modelos.Post;
import edu.cecar.modelos.User;
import edu.cecar.componentes.singletons.SingletonAccesoAPI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONObject;

/**
 * Clase: ControladorAPIGoRest
 *
 * @version: 0.1
 *
 * @since: 14/09/2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public final class ControladorAPIGoRest {

    public ArrayList<User> obtenerUser() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            JSONObject acceso = SingletonAccesoAPI.getinstanceUser();
            JSONArray jsonArrayResult = acceso.getJSONArray("result");
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                User user = new User(Integer.parseInt(jsonArrayResult.getJSONObject(i).get("id").toString()), jsonArrayResult.getJSONObject(i).get("first_name").toString(), jsonArrayResult.getJSONObject(i).get("last_name").toString(), jsonArrayResult.getJSONObject(i).get("gender").toString(), jsonArrayResult.getJSONObject(i).get("dob").toString(), jsonArrayResult.getJSONObject(i).get("email").toString(), jsonArrayResult.getJSONObject(i).get("phone").toString(), jsonArrayResult.getJSONObject(i).get("website").toString(), jsonArrayResult.getJSONObject(i).get("address").toString(), jsonArrayResult.getJSONObject(i).get("status").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("self").get("href").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("edit").get("href").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("avatar").get("href").toString());
                users.add(user);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorAPIGoRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public ArrayList<Post> obtenerPost() {
        ArrayList<Post> posts = new ArrayList<Post>();
        try {
            JSONObject acceso = SingletonAccesoAPI.getinstancePost();
            JSONArray jsonArrayResult = acceso.getJSONArray("result");
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                Post post = new Post(Integer.parseInt(jsonArrayResult.getJSONObject(i).get("id").toString()), Integer.parseInt(jsonArrayResult.getJSONObject(i).get("user_id").toString()), jsonArrayResult.getJSONObject(i).get("title").toString(), jsonArrayResult.getJSONObject(i).get("body").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("self").get("href").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("edit").get("href").toString());
                posts.add(post);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorAPIGoRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }

    public ArrayList<Coment> obtenerComent() {
        ArrayList<Coment> coments = new ArrayList<Coment>();
        try {
            JSONObject acceso = SingletonAccesoAPI.getinstanceComment();
            JSONArray jsonArrayResult = acceso.getJSONArray("result");
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                Coment coment = new Coment(Integer.parseInt(jsonArrayResult.getJSONObject(i).get("id").toString()), Integer.parseInt(jsonArrayResult.getJSONObject(i).get("post_id").toString()), jsonArrayResult.getJSONObject(i).get("body").toString(), jsonArrayResult.getJSONObject(i).get("name").toString(), jsonArrayResult.getJSONObject(i).get("email").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("self").get("href").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("edit").get("href").toString());
                coments.add(coment);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorAPIGoRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coments;
    }

    public ArrayList<Album> obtenerAlbum() {
        ArrayList<Album> albums = new ArrayList<Album>();
        try {
            JSONObject acceso = SingletonAccesoAPI.getinstanceAlbum();
            JSONArray jsonArrayResult = acceso.getJSONArray("result");
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                Album album = new Album(Integer.parseInt(jsonArrayResult.getJSONObject(i).get("id").toString()), Integer.parseInt(jsonArrayResult.getJSONObject(i).get("user_id").toString()), jsonArrayResult.getJSONObject(i).get("title").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("self").get("href").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("edit").get("href").toString());
                albums.add(album);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorAPIGoRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albums;
    }

    public ArrayList<Photo> obtenerPhoto() {
        ArrayList<Photo> photos = new ArrayList<Photo>();
        try {
            JSONObject acceso = SingletonAccesoAPI.getinstancePhoto();
            JSONArray jsonArrayResult = acceso.getJSONArray("result");
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                Photo photo = new Photo(Integer.parseInt(jsonArrayResult.getJSONObject(i).get("id").toString()), Integer.parseInt(jsonArrayResult.getJSONObject(i).get("album_id").toString()), jsonArrayResult.getJSONObject(i).get("title").toString(), jsonArrayResult.getJSONObject(i).get("url").toString(), jsonArrayResult.getJSONObject(i).get("thumbnail").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("self").get("href").toString(), jsonArrayResult.getJSONObject(i).getJSONObject("_links").getJSONObject("edit").get("href").toString());
                photos.add(photo);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorAPIGoRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return photos;
    }

}
