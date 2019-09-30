package edu.cecar.modelos;

import java.io.Serializable;

/**
 * Clase: Album
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
public class Album implements Serializable{

    private static final long serialVersionUID = 1005L;
    private int id_album;
    private int id_user;
    private String title;
    private String self;
    private String edit;

    public Album(int id_album, int id_user, String title, String self, String edit) {
        this.id_album = id_album;
        this.id_user = id_user;
        this.title = title;
        this.self = self;
        this.edit = edit;
    }

    public Album() {
    }

    public int getId_album() {
        return id_album;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
