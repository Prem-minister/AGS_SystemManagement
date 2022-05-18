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
import javax.swing.JTextField;
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


 class openFrame{   
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
 }



