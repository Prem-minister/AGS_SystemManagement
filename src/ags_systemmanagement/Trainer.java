/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ags_systemmanagement;

/**
 *
 * @author User
 */
public class Trainer extends Users{
    public String BankName;
    public String BankNo;

    public String getBankName() {
        return BankName;
    }

    public String getBankNo() {
        return BankNo;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public void setBankNo(String BankNo) {
        this.BankNo = BankNo;
    }

    
    
    public Trainer(String user_ID, String user_name, String user_password,String user_gender, String user_DOB,String user_Contact, String user_Email,String BankName, String BankNo) {
        super(user_ID, user_name, user_password, user_gender, user_DOB, user_Contact,user_Email);
        this.BankName = BankName;
        this.BankNo = BankNo;
    }
}
