package edu.cecar.modelos;

import java.io.Serializable;

/**
 * Clase: Coment
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
public class Coment implements Serializable {

    private static final long serialVersionUID = 1004;
    private int id_coment;
    private int id_post;
    private String body;
    private String name;
    private String email;
    private String self;
    private String edit;

    public Coment(int id_coment, int id_post, String body, String name, String email, String self, String edit) {
        this.id_coment = id_coment;
        this.id_post = id_post;
        this.body = body;
        this.name = name;
        this.email = email;
        this.self = self;
        this.edit = edit;
    }

    public Coment() {
    }

    public int getId_coment() {
        return id_coment;
    }

    public void setId_coment(int id_coment) {
        this.id_coment = id_coment;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
