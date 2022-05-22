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
          Login frame = new Login();
//          Trainer_MainMenu frame = new Trainer_MainMenu();
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
          frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
          frame.setVisible(true);
          frame.setResizable(false);
    }
    
}
