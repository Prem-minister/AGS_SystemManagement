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
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Customer_MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form Customer_MainMenu
     */
    
    public Customer U;
    private String projectDir, userID;
    
    public Customer_MainMenu() {
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
        C_ProfileBtn = new javax.swing.JButton();
        C_UptProfile_Label = new javax.swing.JLabel();
        C_Schedule_Label = new javax.swing.JLabel();
        C_ScheduleBtn1 = new javax.swing.JButton();
        Customer_LogOutBtn = new javax.swing.JButton();
        T_MM_Date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        T_MMLabel.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        T_MMLabel.setForeground(new java.awt.Color(255, 255, 255));
        T_MMLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_MMLabel.setText("Main Menu");

        C_ProfileBtn.setBackground(new java.awt.Color(102, 102, 102));
        C_ProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ags_systemmanagement/rsc/userIcon.jpg"))); // NOI18N
        C_ProfileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        C_ProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_ProfileBtnActionPerformed(evt);
            }
        });

        C_UptProfile_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        C_UptProfile_Label.setForeground(new java.awt.Color(255, 255, 255));
        C_UptProfile_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C_UptProfile_Label.setText("Update Profile");

        C_Schedule_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        C_Schedule_Label.setForeground(new java.awt.Color(255, 255, 255));
        C_Schedule_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C_Schedule_Label.setText("Training Schedule");

        C_ScheduleBtn1.setBackground(new java.awt.Color(204, 204, 204));
        C_ScheduleBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ags_systemmanagement/rsc/timeTableIcon.png"))); // NOI18N
        C_ScheduleBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        C_ScheduleBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_ScheduleBtn1ActionPerformed(evt);
            }
        });

        Customer_LogOutBtn.setBackground(new java.awt.Color(255, 0, 0));
        Customer_LogOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        Customer_LogOutBtn.setText("Log Out");
        Customer_LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_LogOutBtnActionPerformed(evt);
            }
        });

        T_MM_Date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        T_MM_Date.setForeground(new java.awt.Color(255, 255, 0));
        T_MM_Date.setText("01/11/2022");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(T_MMLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(T_MM_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Customer_LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(C_ProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_UptProfile_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(C_Schedule_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_ScheduleBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(144, 144, 144)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(T_MMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Customer_LogOutBtn)
                    .addComponent(T_MM_Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(C_ProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_ScheduleBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(C_UptProfile_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_Schedule_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(90, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void C_ProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_ProfileBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Customer_Profile C = new Customer_Profile(U);
        C.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        C.setLocation(dim.width/2-C.getSize().width/2, dim.height/2-C.getSize().height/2);
    }//GEN-LAST:event_C_ProfileBtnActionPerformed

    private void C_ScheduleBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_ScheduleBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C_ScheduleBtn1ActionPerformed

    
    //log out action
    private void Customer_LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer_LogOutBtnActionPerformed
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
    }//GEN-LAST:event_Customer_LogOutBtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(Customer_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_MainMenu().setVisible(true);
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
                    if(userData[0].equals(userID) && userData[1].equals("Customer")){
                        break;
                    }
                    //clear userdata if it is not the correct user
                    Arrays.fill(userData, null);
                }
                rd.close();
                if(userData[0] != null){
                    U = new Customer(userData[0], userData[2], userData[3], userData[4], userData[5], userData[6], userData[7], userData[8]);
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
    private javax.swing.JButton C_ProfileBtn;
    private javax.swing.JButton C_ScheduleBtn1;
    private javax.swing.JLabel C_Schedule_Label;
    private javax.swing.JLabel C_UptProfile_Label;
    private javax.swing.JButton Customer_LogOutBtn;
    private javax.swing.JLabel T_MMLabel;
    private javax.swing.JLabel T_MM_Date;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
