package edu.cecar.modelos;

import java.io.Serializable;

/**
 * Clase: Post
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
public class Post implements Serializable {

    private static final long serialVersionUID = 1002L;
    private int id_post;
    private int id_user;
    private String title;
    private String body;
    private String self;
    private String edit;

    public Post(int id_post, int id_user, String title, String body, String self, String edit) {
        this.id_post = id_post;
        this.id_user = id_user;
        this.title = title;
        this.body = body;
        this.self = self;
        this.edit = edit;
    }

    public Post() {
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
