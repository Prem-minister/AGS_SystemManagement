/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ags_systemmanagement;

/**
 *
 * @author User
 */
public class Customer extends Users{
    public String cus_Name;
    private String reset_pass, confirm_pass;

    public String getReset_pass() {
        return reset_pass;
    }

    public void setReset_pass(String reset_pass) {
        this.reset_pass = reset_pass;
    }

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }

    public String getCus_Name() {
        return cus_Name;
    }

    public void setCus_Name(String cus_Name) {
        this.cus_Name = cus_Name;
    }
    
    public Customer(String userID, String cus_Name, String user_name, String user_password,String user_gender, String user_DOB, String user_contact, String user_email) {
        super(userID, user_name, user_password, user_gender, user_DOB, user_contact, user_email);
        this.cus_Name = cus_Name;
    }
    
    
}
