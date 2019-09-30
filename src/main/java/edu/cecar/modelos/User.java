package edu.cecar.modelos;

import java.io.Serializable;

/**
 * Clase: User
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
public class User implements Serializable {

    private static final long serialVersionUID = 1001L;
    private int id_user;
    private String first_name;
    private String last_name;
    private String gender;
    private String dob;
    private String email;
    private String phone;
    private String website;
    private String adress;
    private String status;
    private String self;
    private String edit;
    private String avatar;
    

    public User() {
    }

    public User(int id_user, String first_name, String last_name, String gender, String dob, String email, String phone, String website, String adress, String status, String self, String edit, String avatar) {
        this.id_user = id_user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.status = status;
        this.self = self;
        this.edit = edit;
        this.avatar = avatar;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
