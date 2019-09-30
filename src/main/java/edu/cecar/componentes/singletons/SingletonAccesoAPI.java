package edu.cecar.componentes.singletons;

import java.io.IOException;
import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;
import us.monoid.web.Resty;

/**
 * Clase: SingletonAccesoAPI
 *
 * @version: 0.1
 *
 * @since: 15/09/2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public final class SingletonAccesoAPI {

    private static JSONObject conexionUser;
    private static JSONObject conexionPost;
    private static JSONObject conexionComment;
    private static JSONObject conexionAlbum;
    private static JSONObject conexionPhoto;

    public static JSONObject getinstanceUser() throws JSONException, IOException {
        if (conexionUser == null) {
            JSONObject jsonRoot = new Resty().json("https://gorest.co.in/public-api/users?_format=json&access-token=hLBPkVEjnOoZCtSr8qsTiNm2HYCeZyyRBXu9").object();
            conexionUser = jsonRoot;
        }
        return conexionUser;
    }

    public static JSONObject getinstancePost() throws IOException, JSONException {
        if (conexionPost == null) {
            JSONObject jsonRoot = new Resty().json("https://gorest.co.in/public-api/posts?_format=json&access-token=hLBPkVEjnOoZCtSr8qsTiNm2HYCeZyyRBXu9").object();
            conexionPost = jsonRoot;
        }
        return conexionPost;
    }

    public static JSONObject getinstanceComment() throws IOException, JSONException {
        if (conexionComment == null) {
            JSONObject jsonRoot = new Resty().json("https://gorest.co.in/public-api/comments?_format=json&access-token=hLBPkVEjnOoZCtSr8qsTiNm2HYCeZyyRBXu9").object();
            conexionComment = jsonRoot;
        }
        return conexionComment;
    }

    public static JSONObject getinstanceAlbum() throws IOException, JSONException {
        if (conexionAlbum == null) {
            JSONObject jsonRoot = new Resty().json("https://gorest.co.in/public-api/albums?_format=json&access-token=hLBPkVEjnOoZCtSr8qsTiNm2HYCeZyyRBXu9").object();
            conexionAlbum = jsonRoot;
        }
        return conexionAlbum;
    }

    public static JSONObject getinstancePhoto() throws IOException, JSONException {
        if (conexionPhoto == null) {
            JSONObject jsonRoot = new Resty().json("https://gorest.co.in/public-api/photos?_format=json&access-token=hLBPkVEjnOoZCtSr8qsTiNm2HYCeZyyRBXu9").object();
            conexionPhoto = jsonRoot;
        }
        return conexionPhoto;
    }

}
