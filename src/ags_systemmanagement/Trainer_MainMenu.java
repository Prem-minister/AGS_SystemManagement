/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Trainer_MainMenu extends javax.swing.JFrame {

    public Trainer U;
    private String projectDir, userID;
    /**
     * Creates new form Trainer_MainMenu
     * @throws java.io.IOException
     */
    public Trainer_MainMenu() {
        initComponents();
        GUI();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        T_MMLabel = new javax.swing.JLabel();
        Trainer_ProfileBtn = new javax.swing.JButton();
        T_UptProfile_Label = new javax.swing.JLabel();
        T_Schedule_Label = new javax.swing.JLabel();
        Trainer_ScheduleBtn1 = new javax.swing.JButton();
        Trainer_SessionsBtn = new javax.swing.JButton();
        T_Sessions_Label = new javax.swing.JLabel();
        Trainer_LogOutBtn = new javax.swing.JButton();
        T_MM_Date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        T_MMLabel.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        T_MMLabel.setForeground(new java.awt.Color(255, 255, 255));
        T_MMLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_MMLabel.setText("Main Menu");

        Trainer_ProfileBtn.setBackground(new java.awt.Color(102, 102, 102));
        Trainer_ProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ags_systemmanagement/rsc/userIcon.jpg"))); // NOI18N
        Trainer_ProfileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Trainer_ProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Trainer_ProfileBtnActionPerformed(evt);
            }
        });

        T_UptProfile_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        T_UptProfile_Label.setForeground(new java.awt.Color(255, 255, 255));
        T_UptProfile_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_UptProfile_Label.setText("Update Profile");

        T_Schedule_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        T_Schedule_Label.setForeground(new java.awt.Color(255, 255, 255));
        T_Schedule_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_Schedule_Label.setText("Training Schedule");

        Trainer_ScheduleBtn1.setBackground(new java.awt.Color(204, 204, 204));
        Trainer_ScheduleBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ags_systemmanagement/rsc/timeTableIcon.png"))); // NOI18N
        Trainer_ScheduleBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Trainer_ScheduleBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Trainer_ScheduleBtn1ActionPerformed(evt);
            }
        });

        Trainer_SessionsBtn.setBackground(new java.awt.Color(204, 204, 204));
        Trainer_SessionsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ags_systemmanagement/rsc/sessionsIcon.png"))); // NOI18N
        Trainer_SessionsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Trainer_SessionsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Trainer_SessionsBtnActionPerformed(evt);
            }
        });

        T_Sessions_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        T_Sessions_Label.setForeground(new java.awt.Color(255, 255, 255));
        T_Sessions_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_Sessions_Label.setText("Sessions");

        Trainer_LogOutBtn.setBackground(new java.awt.Color(255, 0, 0));
        Trainer_LogOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        Trainer_LogOutBtn.setText("Log Out");
        Trainer_LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Trainer_LogOutBtnActionPerformed(evt);
            }
        });

        T_MM_Date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        T_MM_Date.setForeground(new java.awt.Color(255, 255, 0));
        T_MM_Date.setText("01/11/2022");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Trainer_ProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_UptProfile_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(T_Schedule_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Trainer_ScheduleBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Trainer_SessionsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_Sessions_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(T_MM_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Trainer_LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addComponent(T_MMLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(T_MMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Trainer_ProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Trainer_SessionsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Trainer_ScheduleBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(T_Sessions_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_UptProfile_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_Schedule_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Trainer_LogOutBtn)
                    .addComponent(T_MM_Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(130, 130, 130))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Trainer_SessionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Trainer_SessionsBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Trainer_Sessions TSe = new Trainer_Sessions();
        TSe.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        TSe.setLocation(dim.width/2-TSe.getSize().width/2, dim.height/2-TSe.getSize().height/2);
    }//GEN-LAST:event_Trainer_SessionsBtnActionPerformed

    private void Trainer_ProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Trainer_ProfileBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Trainer_Profile tp = new Trainer_Profile(U);
        tp.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        tp.setLocation(dim.width/2-tp.getSize().width/2, dim.height/2-tp.getSize().height/2);
    }//GEN-LAST:event_Trainer_ProfileBtnActionPerformed

    private void Trainer_ScheduleBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Trainer_ScheduleBtn1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Trainer_Schedule TS = new Trainer_Schedule();
        TS.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        TS.setLocation(dim.width/2-TS.getSize().width/2, dim.height/2-TS.getSize().height/2);
    }//GEN-LAST:event_Trainer_ScheduleBtn1ActionPerformed

    private void Trainer_LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Trainer_LogOutBtnActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            File cache = new File(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\UserCache.txt");
            
            if(cache.delete()){
                System.out.print("Cache Deleted!");
                this.dispose();
                openFrame openFrame = new openFrame();
                openFrame.openLogin();
            } else {
                System.out.print("Cache not deleted");
            }
            
        }
    }//GEN-LAST:event_Trainer_LogOutBtnActionPerformed

     //This method is to get userID and display it in textfield
    private void getUserID() {
       String[] userDetails;
        try {
            // This sets the directory of the project
            projectDir = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\";
            // This sets the file which going to be accessed
            File cacheFile = new File(projectDir + "UserCache.txt");
            if (!cacheFile.exists()) {
                cacheFile.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(cacheFile));
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(":");
                userID = data[1];
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trainer_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trainer_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trainer_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trainer_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new Trainer_MainMenu().setVisible(true);           
            }
        });
    }
    
    public void GUI(){
        setTitle("Main Menu");
        setResizable(false);
        
        System.out.print("test");
        
        //getting todays date
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();
        //setting the date in the mainmenu label
        T_MM_Date.setText(formatter.format(today));
        
        //getting Logged in User
        getUserID();
        System.out.print(userID);
        
        
        String[] userData = null;
        String line;
        if(!userID.isEmpty()){
            //getting all user infor for that logged in user
            try{
                BufferedReader rd = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\User.txt"));

                while((line = rd.readLine()) != null){
                    userData = line.split(":");
                    if(userData[0].equals(userID)){
                        break;
                    }
                    //clear userdata if it is not the correct user
                    Arrays.fill(userData, null);
                }
                rd.close();
                if(userData[0] != null){
                    U = new Trainer(userData[0], userData[3], userData[4], userData[5], userData[6], userData[7], userData[8], userData[10], userData[11]);
                }
            } catch(IOException e){
                
            }
        }
        
        
        
        
        //adding closing confirmation 
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int selection = JOptionPane.showConfirmDialog(null, "Want to exit? Exit will also log you out", "Closing App ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.YES_OPTION) {
                    File cache = new File(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\UserCache.txt");

                        if(cache.delete()){
                            System.out.print("Cache Deleted!");
                            dispose();
                        } else {
                            System.out.print("Cache not deleted");
                        }
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel T_MMLabel;
    private javax.swing.JLabel T_MM_Date;
    private javax.swing.JLabel T_Schedule_Label;
    private javax.swing.JLabel T_Sessions_Label;
    private javax.swing.JLabel T_UptProfile_Label;
    private javax.swing.JButton Trainer_LogOutBtn;
    private javax.swing.JButton Trainer_ProfileBtn;
    private javax.swing.JButton Trainer_ScheduleBtn1;
    private javax.swing.JButton Trainer_SessionsBtn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
