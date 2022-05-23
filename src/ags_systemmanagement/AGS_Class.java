/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ags_systemmanagement;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Prem Sharaan
 */

class userDocumentListener implements DocumentListener {
    @Override
    public void insertUpdate(DocumentEvent e) {
       
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
       
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
      
       
    }

}


class deleteSession {
  // This method is to delete a temporary staff session that has been created during verification
    public void clearUserSession() {
        final String projectDir;
        try {         
            // This sets the directory of the project
            projectDir = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\";
            File userCache = new File(projectDir + "UserCache.txt");
            if (userCache.exists()) {
                userCache.delete();
            }
        } catch (Exception ex) {

        }
    }

}

// This class to easily open required frames withouht calling it again and again
 class openFrame{  
       public void openLogin() {
            Login frame = new Login();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
       }
     
    public void openManagerMainMenu() {
            CentreManager_MainMenu frame = new CentreManager_MainMenu();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
    }
    
     public void openCustomerMainMenu() {
            Customer_MainMenu frame = new Customer_MainMenu();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
    }
     
     public void openTrainerMainMenu() {
            Trainer_MainMenu frame = new Trainer_MainMenu();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
    } 
   public void openManagerManageTrainingSession() {
            CentreManager_ScheduleTraining frame  = new CentreManager_ScheduleTraining();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
    } 
   
   
    public void openRegisterUser() {
            CentreManager_RegisterNewUser frame  = new CentreManager_RegisterNewUser();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
    } 
    
       
   public void openScheduleTrainingSlots() {
            CentreManager_ScheduleTraining frame  = new CentreManager_ScheduleTraining();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
    } 
  
   public void openBookingTrainingSession() {
            CentreManager_BookingTrainingSession frame  = new CentreManager_BookingTrainingSession();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
    } 
     
   public void openManagerManageUser() {
            CentreManager_ManageUser frame  = new CentreManager_ManageUser();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
            frame.setResizable(false);
    } 
   
 }


// This abstract class contains the essential methods for string validation
abstract class StringValidation {
    
    private String captionTitle, outputMsg, regex, negRegex;
    
    public StringValidation() {
        captionTitle = "Invalid input type!";
        outputMsg = "Textfields can only consists of letters, numbers and spacing.";
        regex = "^[a-zA-Z0-9 ]+";
        negRegex = "[^a-zA-Z0-9 ]";
    }
    
    public StringValidation(String captionTitle, String outputMsg, String regex, String negRegex) {
        this.captionTitle = captionTitle;
        this.outputMsg = outputMsg;
        this.regex = regex;
        this.negRegex = negRegex;
    }
    
    public StringValidation(String outputMsg, String regex, String negRegex) {
        captionTitle = "Invalid text input entered!";
        this.outputMsg = outputMsg;
        this.regex = regex;
        this.negRegex = negRegex;
    }
    
    public void setRegex(String regex){
        this.regex = regex;
    }
    
    public void setNegateRegex(String negRegex){
        this.negRegex = negRegex;
    }
    
    public void setPopup(String captionTitle, String outputMsg){
        this.captionTitle = captionTitle;
        this.outputMsg = outputMsg;
    }
    
    public String getRegex(){
        return regex;
    }
    
    public String getNegateRegex(){
        return negRegex;
    }
    
    public String getTitle(){
        return captionTitle;
    }
    
    public String getMessage(){
        return outputMsg;
    }
    
    public void runPopup(){
        JOptionPane.showMessageDialog(null, outputMsg, captionTitle, JOptionPane.WARNING_MESSAGE);
    }
    
    public void runValidate(JTextField txt){
        Runnable doDelete = new Runnable(){
            public void set(){
                String input = txt.getText();
                boolean matching = input.matches(getRegex());
                if (!matching && !"".equals(input)) {
                    runPopup();
                    String output = input.replaceAll(getNegateRegex(), "");
                    txt.setText(output);
                }
            }
            @Override
            public void run(){
                set();
            }
        };
        SwingUtilities.invokeLater(doDelete);
    }
    
}


// This subclass handles validation for full name
class UserFullNameValidation extends StringValidation {
    public UserFullNameValidation() {
        super();
        setPopup("Invalid staff's full name!", "Full Name can only contains of letters and spacing.");
        setRegex("^[a-zA-Z ]+");
        setNegateRegex("[^a-zA-Z ]");
    }
}

// This will handles the subclass for username validation
class UserUsernameValidation extends StringValidation {
       public UserUsernameValidation() {
        super();
        setPopup("Entered invalid  staff username!", "Username can only contains of letters, numbers and escaped symbols.");
        setRegex("^[-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]+");
        setNegateRegex("[^-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]");
    }
}


// This will handles the subclass for password validation
class UserPasswordValidation extends StringValidation {
      public UserPasswordValidation() {
        super();
        setPopup("Entered invalid staff password!", "Password can only contains of letters, numbers and escaped symbols.");
        setRegex("^[-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]+");
        setNegateRegex("[^-a-zA-Z0-9!@#$%^&*()\\{\\}\\[\\]\"\';\\\\/?|.,><~`_+=]");
    }
    
    public void runValidate(JPasswordField txt){
        Runnable doDelete = new Runnable(){
            public void set(){
                String input = String.valueOf(txt.getPassword());
                boolean matching = input.matches(getRegex());
                if (!matching && !"".equals(input)) {
                    runPopup();
                    String output = input.replaceAll(getNegateRegex(), "");
                    txt.setText(output);
                }
            }
            @Override
            public void run(){
                set();
            }
        };
        SwingUtilities.invokeLater(doDelete);
    }
}


// This subclass handles email validation
class UserEmailValidation extends StringValidation {
    public UserEmailValidation() {
        super();
        setPopup("Invalid user's email address!", "Please follow the email format. (eg: abc@gmail.com)");
        setRegex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
    
    public boolean runValidate(JTextField txt, boolean dispenseMessage){
        boolean invalidEmail = false;
        String input = txt.getText();
        boolean matching = input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        if (matching == false && !"".equals(input)) {
            if (dispenseMessage) {
                runPopup();
            }
            String output = "";
            txt.setText(output);
            invalidEmail = true;
        };
        return invalidEmail;
    }
    
}


// This subclass handles fees validation
class TrainingFeesValidation extends StringValidation {
    
    public TrainingFeesValidation() {
        super();
        setPopup("Entered invalid fees format!", "Payment must contains RM and Numbers only. (eg. RM1.00)");
        setRegex("RM+[0-9]+\\.[0-9]{2}$");
    }
    
    public boolean runValidate(JTextField txt, boolean dispenseMessage){
        boolean invalidFees = false;
        String input = txt.getText();
        boolean matching = input.matches("RM+[0-9]+\\.[0-9]{2}$");
        if (matching == false && !"".equals(input)) {
            if (dispenseMessage) {
                runPopup();
            }
            String output = "";
            txt.setText(output);
            invalidFees = true;
        };
        return invalidFees;
    }
    
}
