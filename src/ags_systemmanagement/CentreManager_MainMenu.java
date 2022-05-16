/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import static java.lang.Thread.sleep;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Prem Sharaan
 */
public class CentreManager_MainMenu extends javax.swing.JFrame {
     //This variable is for setting project folder directory
    private String projectDir;
    /**
     * Creates new form CentreManagerMainMenu
     */
    public CentreManager_MainMenu() {
        initComponents();
        initGUI();
    }

     // This method is to delete a temporary user session that has been created during verification
    private void clearUserSession() {
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnLogOut = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        pnlBtn3 = new javax.swing.JPanel();
        btnManageFeedback = new javax.swing.JButton();
        btnUpdateProfile = new javax.swing.JButton();
        btnLoginLog = new javax.swing.JButton();
        btnManageCustomer = new javax.swing.JButton();
        btnManageTrainer = new javax.swing.JButton();
        btnManageAdmin = new javax.swing.JButton();
        pnlBtn1 = new javax.swing.JPanel();
        btnTrainingBooking = new javax.swing.JButton();
        pnlProfilePic = new javax.swing.JPanel();
        lblProfilePic = new javax.swing.JLabel();
        lblBtnTitle = new javax.swing.JLabel();
        pnlBtn2 = new javax.swing.JPanel();
        btnViewSession = new javax.swing.JButton();
        btnManageTraining = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 241, 255));
        jLabel1.setText("Centre Manager Main Menu");

        lblTitle.setFont(new java.awt.Font("Leelawadee UI Semilight", 2, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("AGS Management System");

        txtUsername.setBackground(new java.awt.Color(100, 255, 218));
        txtUsername.setFont(new java.awt.Font("Devanagari Sangam MN", 3, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(51, 51, 51));

        btnLogOut.setBackground(new java.awt.Color(17, 34, 64));
        btnLogOut.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(100, 255, 218));
        btnLogOut.setText("Log Out");
        btnLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogOutMouseEntered(evt);
            }
        });
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 204, 204));
        lblTime.setText("time");

        lblDate.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 204, 204));
        lblDate.setText("date");

        pnlBtn3.setBackground(new java.awt.Color(68, 68, 68));
        pnlBtn3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        btnManageFeedback.setBackground(new java.awt.Color(102, 0, 255));
        btnManageFeedback.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageFeedback.setForeground(new java.awt.Color(37, 42, 52));
        btnManageFeedback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/managefeedbac.png"))); // NOI18N
        btnManageFeedback.setBorder(null);
        btnManageFeedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageFeedbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageFeedbackMouseExited(evt);
            }
        });
        btnManageFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageFeedbackActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnManageFeedback);

        btnUpdateProfile.setBackground(new java.awt.Color(0, 204, 204));
        btnUpdateProfile.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnUpdateProfile.setForeground(new java.awt.Color(37, 42, 52));
        btnUpdateProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/updateprofile.png"))); // NOI18N
        btnUpdateProfile.setBorder(null);
        btnUpdateProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateProfileMouseExited(evt);
            }
        });
        btnUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProfileActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnUpdateProfile);

        btnLoginLog.setBackground(new java.awt.Color(153, 153, 255));
        btnLoginLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/loginlog.png"))); // NOI18N
        btnLoginLog.setBorder(null);
        btnLoginLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoginLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginLogMouseExited(evt);
            }
        });
        btnLoginLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginLogActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnLoginLog);

        btnManageCustomer.setBackground(new java.awt.Color(51, 51, 255));
        btnManageCustomer.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageCustomer.setForeground(new java.awt.Color(37, 42, 52));
        btnManageCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/registeruser.png"))); // NOI18N
        btnManageCustomer.setBorder(null);
        btnManageCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageCustomerMouseExited(evt);
            }
        });
        btnManageCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnManageCustomer);

        btnManageTrainer.setBackground(new java.awt.Color(102, 204, 0));
        btnManageTrainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/managetrainers.png"))); // NOI18N
        btnManageTrainer.setBorder(null);
        btnManageTrainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageTrainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageTrainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageTrainerMouseExited(evt);
            }
        });
        btnManageTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageTrainerActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnManageTrainer);

        btnManageAdmin.setBackground(new java.awt.Color(204, 0, 153));
        btnManageAdmin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageAdmin.setForeground(new java.awt.Color(37, 42, 52));
        btnManageAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/managesuer-removebg-preview.png"))); // NOI18N
        btnManageAdmin.setBorder(null);
        btnManageAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageAdminMouseExited(evt);
            }
        });
        btnManageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdminActionPerformed(evt);
            }
        });
        pnlBtn3.add(btnManageAdmin);

        pnlBtn1.setBackground(new java.awt.Color(68, 68, 68));
        pnlBtn1.setLayout(new java.awt.GridLayout(1, 1, 5, 5));

        btnTrainingBooking.setBackground(new java.awt.Color(102, 0, 102));
        btnTrainingBooking.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnTrainingBooking.setForeground(new java.awt.Color(37, 42, 52));
        btnTrainingBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/trainingbooking.png"))); // NOI18N
        btnTrainingBooking.setBorder(null);
        btnTrainingBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrainingBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrainingBookingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrainingBookingMouseExited(evt);
            }
        });
        btnTrainingBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrainingBookingActionPerformed(evt);
            }
        });
        pnlBtn1.add(btnTrainingBooking);

        pnlProfilePic.setBackground(new java.awt.Color(10, 25, 47));
        pnlProfilePic.setPreferredSize(new java.awt.Dimension(200, 200));

        lblProfilePic.setBackground(new java.awt.Color(10, 25, 47));
        lblProfilePic.setMaximumSize(new java.awt.Dimension(100, 100));
        lblProfilePic.setMinimumSize(new java.awt.Dimension(100, 100));
        lblProfilePic.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout pnlProfilePicLayout = new javax.swing.GroupLayout(pnlProfilePic);
        pnlProfilePic.setLayout(pnlProfilePicLayout);
        pnlProfilePicLayout.setHorizontalGroup(
            pnlProfilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilePicLayout.createSequentialGroup()
                .addComponent(lblProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        pnlProfilePicLayout.setVerticalGroup(
            pnlProfilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfilePicLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblBtnTitle.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        lblBtnTitle.setForeground(new java.awt.Color(204, 255, 204));
        lblBtnTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pnlBtn2.setBackground(new java.awt.Color(68, 68, 68));
        pnlBtn2.setLayout(new java.awt.GridLayout(1, 1, 5, 5));

        btnViewSession.setBackground(new java.awt.Color(204, 0, 51));
        btnViewSession.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnViewSession.setForeground(new java.awt.Color(37, 42, 52));
        btnViewSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/viewsession.png"))); // NOI18N
        btnViewSession.setBorder(null);
        btnViewSession.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewSessionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewSessionMouseExited(evt);
            }
        });
        btnViewSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSessionActionPerformed(evt);
            }
        });
        pnlBtn2.add(btnViewSession);

        btnManageTraining.setBackground(new java.awt.Color(255, 102, 0));
        btnManageTraining.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnManageTraining.setForeground(new java.awt.Color(37, 42, 52));
        btnManageTraining.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSrc/managebooking.png"))); // NOI18N
        btnManageTraining.setBorder(null);
        btnManageTraining.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageTraining.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageTrainingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManageTrainingMouseExited(evt);
            }
        });
        btnManageTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageTrainingActionPerformed(evt);
            }
        });
        pnlBtn2.add(btnManageTraining);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(lblBtnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addComponent(pnlBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(543, Short.MAX_VALUE)
                    .addComponent(pnlBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitle)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(lblTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pnlProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(lblBtnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(pnlBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(314, Short.MAX_VALUE)
                    .addComponent(pnlBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            clearUserSession();
            openLogin();
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogOutMouseEntered

    private void btnManageTrainingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageTrainingMouseEntered
      lblBtnTitle.setText("Manage Booking Training Sessions");
    }//GEN-LAST:event_btnManageTrainingMouseEntered

    private void btnManageTrainingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageTrainingMouseExited
      lblBtnTitle.setText("");
    }//GEN-LAST:event_btnManageTrainingMouseExited

    private void btnManageTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageTrainingActionPerformed
  
    }//GEN-LAST:event_btnManageTrainingActionPerformed

    private void btnManageFeedbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageFeedbackMouseEntered
        lblBtnTitle.setText("Manage Feedback");
    }//GEN-LAST:event_btnManageFeedbackMouseEntered

    private void btnManageFeedbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageFeedbackMouseExited
       lblBtnTitle.setText("");
    }//GEN-LAST:event_btnManageFeedbackMouseExited

    private void btnManageFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageFeedbackActionPerformed
    
    }//GEN-LAST:event_btnManageFeedbackActionPerformed

    private void btnManageCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageCustomerMouseEntered
            lblBtnTitle.setText("Manage Customer");

    }//GEN-LAST:event_btnManageCustomerMouseEntered

    private void btnManageCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageCustomerMouseExited
             lblBtnTitle.setText("");

    }//GEN-LAST:event_btnManageCustomerMouseExited

    private void btnManageCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerActionPerformed
        this.dispose();    
        openManageUser();            
    }//GEN-LAST:event_btnManageCustomerActionPerformed

    private void btnManageTrainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageTrainerMouseEntered
        lblBtnTitle.setText("Manage Centre Trainers");
    }//GEN-LAST:event_btnManageTrainerMouseEntered

    private void btnManageTrainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageTrainerMouseExited
        lblBtnTitle.setText("");
    }//GEN-LAST:event_btnManageTrainerMouseExited

    private void btnManageTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageTrainerActionPerformed
     
    }//GEN-LAST:event_btnManageTrainerActionPerformed

    private void btnManageAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageAdminMouseEntered
       lblBtnTitle.setText("Manage Admin");

    }//GEN-LAST:event_btnManageAdminMouseEntered

    private void btnManageAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageAdminMouseExited
        lblBtnTitle.setText("");

    }//GEN-LAST:event_btnManageAdminMouseExited

    private void btnManageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManageAdminActionPerformed

    private void btnUpdateProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateProfileMouseEntered
        lblBtnTitle.setText("Update Profile");
    }//GEN-LAST:event_btnUpdateProfileMouseEntered

    private void btnUpdateProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateProfileMouseExited
         lblBtnTitle.setText("");
    }//GEN-LAST:event_btnUpdateProfileMouseExited

    private void btnUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateProfileActionPerformed

    private void btnTrainingBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrainingBookingMouseEntered
       lblBtnTitle.setText("Book Training Session");
    }//GEN-LAST:event_btnTrainingBookingMouseEntered

    private void btnTrainingBookingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrainingBookingMouseExited
       lblBtnTitle.setText("");
    }//GEN-LAST:event_btnTrainingBookingMouseExited

    private void btnTrainingBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrainingBookingActionPerformed
     
    }//GEN-LAST:event_btnTrainingBookingActionPerformed

    private void btnViewSessionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewSessionMouseEntered
        lblBtnTitle.setText("View Booked Training Session");
    }//GEN-LAST:event_btnViewSessionMouseEntered

    private void btnViewSessionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewSessionMouseExited
       lblBtnTitle.setText("");
    }//GEN-LAST:event_btnViewSessionMouseExited

    private void btnViewSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSessionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewSessionActionPerformed

    private void btnLoginLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginLogMouseEntered
        lblBtnTitle.setText("View Login Logs");
    }//GEN-LAST:event_btnLoginLogMouseEntered

    private void btnLoginLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginLogMouseExited
        lblBtnTitle.setText("");
    }//GEN-LAST:event_btnLoginLogMouseExited

    private void btnLoginLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginLogActionPerformed

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
            java.util.logging.Logger.getLogger(CentreManager_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentreManager_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentreManager_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentreManager_MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {   
                new CentreManager_MainMenu().setVisible(true);
                
            }
        });
    }
    
     //SThis styles the username text panel
    private void styleUsernameField() {
        txtUsername.setHorizontalAlignment(JTextField.CENTER);
        txtUsername.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        txtUsername.setEditable(false);
    }

    
    //This sets current system date
    private void CurrentDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd, yyyy");
        String currentdate = myDateObj.format(myFormatObj);
        String date = currentdate.toString();
        lblDate.setText(date);
    }

    //This sets current system time
    private void CurrentTime() {
        Thread time = new Thread() {
            public void run() {
                try {
                    for (;;) {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.AM_PM);
                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);
                        String am_pm = "am_pm";
                        if (day == 0) {
                            am_pm = "AM";
                        } else {
                            am_pm = "PM";
                        }
                        lblTime.setText(hour + ":" + minute + ":" + second + " " + am_pm);
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };

        time.start();
    }
    
    
      //This method is to get username and display it in textfield
    private void getUsername() {
       String[] userCredential;
        try {
            // This sets the directory of the project
            projectDir = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\";
            // This sets the file which going to be accessed
            File cacheFile = new File(projectDir + "UserCache.txt");
            if (!cacheFile.exists()) {
                cacheFile.createNewFile();
            }
            Scanner searchUsername = new Scanner(cacheFile);
            // Read till last line of file
            while (searchUsername.hasNext()) {
                // Read the next line.
                String inputUsername = searchUsername.nextLine();
                // Split the details by using the colon and store in an array.
                userCredential = inputUsername.split(":");
                txtUsername.setText("Welcome " + userCredential[0]);
            }
            searchUsername.close();
        } catch (Exception ex) {

        }
    }
    
     public void openLogin(){
             Login frame = new Login();
             Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
             frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
             frame.setVisible(true);
    }
    
      public void openManageUser(){
             CentreManager_ManageUser frame = new CentreManager_ManageUser();
             Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
             frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
             frame.setVisible(true);
    }
     
     public void initGUI() {
              
        //This sets the button to not focus
        btnLogOut.setFocusable(false);
        btnTrainingBooking.setFocusable(false);
        btnManageCustomer.setFocusable(false);
        btnManageAdmin.setFocusable(false);  
        btnUpdateProfile.setFocusable(false);
        btnManageTraining.setFocusable(false);
        btnManageFeedback.setFocusable(false);
        btnLoginLog.setFocusable(false);
        txtUsername.setFocusable(false);
        
           
        //This will display the current time
        CurrentTime();

        //This will display the current date
        CurrentDate();

        //This will style the textfield
        styleUsernameField();
          
        //This will get the user's username and set it inside the textfield
        getUsername();
        
        // This class handles window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int selection = JOptionPane.showConfirmDialog(null, "Want to exit?", "Closing Main Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.YES_OPTION) {
                    openLogin(); 
                    //This will clear the login session
                    clearUserSession();
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    dispose();
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnLoginLog;
    private javax.swing.JButton btnManageAdmin;
    private javax.swing.JButton btnManageCustomer;
    private javax.swing.JButton btnManageFeedback;
    private javax.swing.JButton btnManageTrainer;
    private javax.swing.JButton btnManageTraining;
    private javax.swing.JButton btnTrainingBooking;
    private javax.swing.JButton btnUpdateProfile;
    private javax.swing.JButton btnViewSession;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBtnTitle;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblProfilePic;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBtn1;
    private javax.swing.JPanel pnlBtn2;
    private javax.swing.JPanel pnlBtn3;
    private javax.swing.JPanel pnlProfilePic;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
