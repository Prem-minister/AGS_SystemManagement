/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ags_systemmanagement;

/**
 *
 * @author User
 */
public class Users {
    public String user_ID, user_name, user_email,user_type, user_contact;
    protected String user_password;

    public Users (String user_ID, String user_name, String user_email, String user_type, String user_contact,String user_password){
        this.user_ID = user_ID;
        this.user_name = user_name;
        this.user_type = user_type;
        this.user_contact = user_contact;
        this.user_password = user_password;
        this.user_email = user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_email() {
        return user_email;
    }
    
    public String getUser_ID() {
        return user_ID;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getUser_contact() {
        return user_contact;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public void setUser_contact(String user_contact) {
        this.user_contact = user_contact;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
