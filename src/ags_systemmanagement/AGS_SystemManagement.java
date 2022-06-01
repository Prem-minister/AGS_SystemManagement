/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ags_systemmanagement;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Prem Sharaan
 */
public class AGS_SystemManagement {

    /**
     * @param args the command line arguments test
     */
    public static void main(String[] args) {

          //CentreManager_ScheduleTraining frame = new CentreManager_ScheduleTraining();
          //CentreManager_MainMenu frame = new CentreManager_MainMenu();
          Login frame = new Login();
          //ForgotPassword frame = new ForgotPassword();
          //CentreManager_RegisterNewUser frame = new CentreManager_RegisterNewUser();
          //Customer_MainMenu frame = new Customer_MainMenu();
          //CentreManager_BookingTrainingSession frame = new CentreManager_BookingTrainingSession();
          //CentreManager_ManageUser frame = new CentreManager_ManageUser();
          //CentreManager_LoginActivity frame = new CentreManager_LoginActivity();
          //CentreManager_ManageBookingTrainingSession frame  = new CentreManager_ManageBookingTrainingSession();
          //CentreManager_ManageSchedule frame = new CentreManager_ManageSchedule();
          //CentreManager_ViewPayment frame = new CentreManager_ViewPayment();
          //CentreManager_ViewFeedback frame = new CentreManager_ViewFeedback();
          // CentreManager_ViewTrainingSession frame = new CentreManager_ViewTrainingSession();
          //CentreManager_ViewUser frame = new CentreManager_ViewUser();

          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
          frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
          frame.setVisible(true);
          frame.setResizable(false);;
    }
    
}
