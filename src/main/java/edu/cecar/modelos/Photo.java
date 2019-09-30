package edu.cecar.modelos;

import java.io.Serializable;

/**
 * Clase: Photo
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
public class Photo implements Serializable {

    private static final long serialVersionUID = 1003L;
    private int id_photo;
    private int id_album;
    private String title;
    private String url;
    private String thumbnail;
    private String self;
    private String edit;

    public Photo(int id_photo, int id_album, String title, String url, String thumbnail, String self, String edit) {
        this.id_photo = id_photo;
        this.id_album = id_album;
        this.title = title;
        this.url = url;
        this.thumbnail = thumbnail;
        this.self = self;
        this.edit = edit;
    }

    public Photo() {
    }

    public int getId_photo() {
        return id_photo;
    }

    public void setId_photo(int id_photo) {
        this.id_photo = id_photo;
    }

    public int getId_album() {
        return id_album;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

}
