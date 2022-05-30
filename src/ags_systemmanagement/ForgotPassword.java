/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Prem Sharaan
 */
public class ForgotPassword extends javax.swing.JFrame {
    private final String userDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\User.txt";
    private String projectDir;
    
    /**
     * Creates new form ForgotPassword
     */
    public ForgotPassword() {
        initComponents();
        initGUI();
    }

  //Method for clearing any available user cache
    private void clearCache(){
         deleteSession clearSession = new deleteSession();
         clearSession.clearUserSession();
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
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblLoginLogo = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        btnResetPassword = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblUserRole = new javax.swing.JLabel();
        lblUsername1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtReNewPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 241, 255));
        jLabel1.setText("Forgot Password");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 146, 176));
        jLabel2.setText("Please provide your account username and email");

        btnBack.setBackground(new java.awt.Color(17, 34, 64));
        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(100, 255, 218));
        btnBack.setText("Go Back");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(100, 255, 218));
        lblUsername.setText("USERNAME");

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Lao Sangam MN", 0, 16)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsernameMousePressed(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(100, 255, 218));
        lblPassword.setText("New Passoword");

        txtNewPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtNewPassword.setFont(new java.awt.Font("Lao Sangam MN", 0, 16)); // NOI18N
        txtNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtNewPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtNewPassword.setEchoChar('*');
        txtNewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNewPasswordMousePressed(evt);
            }
        });
        txtNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewPasswordActionPerformed(evt);
            }
        });

        btnResetPassword.setBackground(new java.awt.Color(100, 255, 218));
        btnResetPassword.setFont(new java.awt.Font("Beirut", 1, 15)); // NOI18N
        btnResetPassword.setForeground(new java.awt.Color(0, 0, 0));
        btnResetPassword.setText("Reset Password");
        btnResetPassword.setBorder(null);
        btnResetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetPasswordMouseClicked(evt);
            }
        });
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Leelawadee UI Semilight", 2, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("AGS Management System");

        lblUserRole.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        lblUserRole.setForeground(new java.awt.Color(100, 255, 218));
        lblUserRole.setText("Retype New Password");

        lblUsername1.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        lblUsername1.setForeground(new java.awt.Color(100, 255, 218));
        lblUsername1.setText("Email");

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Lao Sangam MN", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        txtReNewPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtReNewPassword.setFont(new java.awt.Font("Lao Sangam MN", 0, 16)); // NOI18N
        txtReNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtReNewPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtReNewPassword.setEchoChar('*');
        txtReNewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtReNewPasswordMousePressed(evt);
            }
        });
        txtReNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReNewPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblLoginLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtReNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(505, 505, 505))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblTitle)
                        .addGap(41, 41, 41)
                        .addComponent(lblLoginLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblUsername1)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lblUserRole)
                        .addGap(18, 18, 18)
                        .addComponent(txtReNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1237, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       this.dispose();
       openFrame openFrame = new openFrame();
       openFrame.openLogin();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked

    }//GEN-LAST:event_txtUsernameMouseClicked

    private void txtUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMousePressed

    }//GEN-LAST:event_txtUsernameMousePressed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed

    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed

    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtNewPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNewPasswordMousePressed

    }//GEN-LAST:event_txtNewPasswordMousePressed

    private void txtNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPasswordActionPerformed

    }//GEN-LAST:event_txtNewPasswordActionPerformed

    private void btnResetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetPasswordMouseClicked

    }//GEN-LAST:event_btnResetPasswordMouseClicked

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        updatePassword();
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailMousePressed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtReNewPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtReNewPasswordMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReNewPasswordMousePressed

    private void txtReNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReNewPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }
    
       
      // This method handles password comparison 
    private boolean comparePassword() {
        boolean isSimilar = false;
        String firstPass = String.valueOf(txtNewPassword.getPassword());
        String secondPass = String.valueOf(txtReNewPassword.getPassword());
        if ("".equals(firstPass) || "".equals(secondPass)) {
            isSimilar = false;
        } else if (firstPass.equals(secondPass)) {
            isSimilar = true;
        }
        return isSimilar;
    }
    
         // This is a new exception class
    public void emptyInputFields() throws Exception {
        UserEmailValidation invalidate = new UserEmailValidation();   
        if ("".equals(txtUsername.getText())) {
            throw new Exception("Empty user username");
        }
        if ("".equals(String.valueOf(txtNewPassword.getPassword()))) {
            throw new Exception("Empty user password");
        }
        if ("".equals(String.valueOf(txtReNewPassword.getPassword()))) {
            throw new Exception("Empty user retype password");
        }
       
        if ("".equals(txtEmail.getText())) {
            throw new Exception("Empty user email");
        }

        if (invalidate.runValidate(txtEmail, false)) {
            throw new Exception("Invalid user email address format");
        }
        
    
    }
    
     
     //This method raise message for empty fields, password comparison and username validation.
    private void validateInput() {
         if ( "".equals(txtUsername.getText()) && "".equals(txtEmail.getText()) && "".equals(txtNewPassword.getText()) && "".equals(txtReNewPassword.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input all the fields to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        }else if ("".equals(txtUsername.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input username to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(String.valueOf(txtNewPassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Invalid input! Pleass input password to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(String.valueOf(txtReNewPassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input retype password to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
       } else if ("".equals(txtEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input email to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if (!comparePassword()) {
            JOptionPane.showMessageDialog(null, "Password is not same!", "Password mismatch!", JOptionPane.WARNING_MESSAGE);
        }   else if(!checkMatch(txtUsername.getText(), txtEmail.getText())) {
            JOptionPane.showMessageDialog(null, "There isnt match for the username and email provided", "Match not exista!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
      // This method handles all validation related to the fields
    private void userInputCharacterValidator() {
        txtUsername.getDocument().addDocumentListener(new userDocumentListener() {
            UserUsernameValidation invalidate = new UserUsernameValidation();

            @Override
            public void changedUpdate(DocumentEvent e) {
                invalidate.runValidate(txtUsername);
                invalidate.setRegex("testing");
                invalidate.getRegex();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                invalidate.runValidate(txtUsername);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                invalidate.runValidate(txtUsername);
            }

        });
        
        txtNewPassword.getDocument().addDocumentListener(new userDocumentListener() {
            UserPasswordValidation invalidate = new UserPasswordValidation();

            @Override
            public void changedUpdate(DocumentEvent e) {
                invalidate.runValidate(txtNewPassword);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                invalidate.runValidate(txtNewPassword);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                invalidate.runValidate(txtNewPassword);
            }
        });
        
        txtReNewPassword.getDocument().addDocumentListener(new userDocumentListener() {
            UserPasswordValidation invalidate = new UserPasswordValidation();

            @Override
            public void changedUpdate(DocumentEvent e) {
                invalidate.runValidate(txtReNewPassword);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                invalidate.runValidate(txtReNewPassword);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                invalidate.runValidate(txtReNewPassword);
            }
        });
        
       
    }
    
    
        // This method clears all the fields
    private void clearTxtFields() {   
        txtUsername.setText("");
        txtNewPassword.setText("");
        txtReNewPassword.setText("");
        txtEmail.setText("");
   
    }
    
       //This method is to check whether the username is available or not
    public boolean checkMatch(String userUsername, String userEmail) {
        boolean notFound = false;
        // This array is to store all lines
        String[] userDetails;
        try {
            // This sets the file which going to be accessed
            File userFile = new File(userDB);
            Scanner searchMatch = new Scanner(userFile);
            // Read till last line of file
            while (searchMatch.hasNext()) {
                // Read the next line.
                String inputUsername = searchMatch.nextLine();
                // Split the details by using the colon and store in an array.
                userDetails = inputUsername.split(":");
                if (userDetails[3].equals(userUsername) && userEmail.equals(userDetails[8])) {
                    notFound = true;
                }
            }
            searchMatch.close();
        } catch (Exception ex) {

        }
        return notFound;
    }
    
    
    

      //This method will update new user details
    private void updatePassword() {
        File file = new File(userDB);
        ArrayList<String> userArray = new ArrayList<>();  //This is for temporary array to hold the user data
        try {
                    
                 //This will get all details and set the details into a variable
                String username = txtUsername.getText();
                String password = txtNewPassword.getText();
                String email = txtEmail.getText();
             
            
            try ( FileReader fr = new FileReader(file)) {
                Scanner readFile = new Scanner(fr);
                String detailLine;
                String[] detailArr;  //This temp array is to store the details which is gonna be updated                                     
                while ((detailLine = readFile.nextLine()) != null) {
                    //This is to split each line using colon to check if the username is present
                    detailArr = detailLine.split(":");
                    //If the username is present, add the old data
                    //Add the new data in the temporary array                  

                          
                    if (detailArr[3].equals(username) && detailArr[8].equals(email)) {                        
                        userArray.add(detailArr[0] + ":"
                                + detailArr[1]+ ":"
                                + detailArr[2]+ ":"
                                + detailArr[3] + ":"
                                + password + ":"
                                + detailArr[5] + ":" 
                                + detailArr[6] + ":"
                                + detailArr[7] + ":" 
                                + detailArr[8] + ":"       
                                + detailArr[9] + ":" 
                                + detailArr[10] + ":"
                                + detailArr[11]);
                    } else {
                        //search other doesnt match and add the line
                        userArray.add(detailLine);
       
                    }
                 }
         
               
                fr.close();
            } catch (Exception e) {

            }
        } catch (Exception e) {
   
        }

        try {
              
            if (!comparePassword()) {  // This compare the password and retype password
                throw new Exception("Password and retype password entered not same!");
            } else if (!checkMatch(txtUsername.getText(), txtEmail.getText())) {
                throw new Exception("Match not exit");       
             }else {
                boolean hasUpdated = false;
                //this is to set the buffered write to write the data into temporary array again back to text file        
                try ( PrintWriter pw = new PrintWriter(file)) {
                    for (String str : userArray) {
                        pw.println(str); //this will write all the data in the temporary array back to the file line by line
                        hasUpdated = true;
                    }
                    //This will display a success message indicates that the details has been updated
                    if (hasUpdated) {
                        JOptionPane.showMessageDialog(null, "User Password has been updated successfully!", "Account successfully updated!", JOptionPane.INFORMATION_MESSAGE);
                        pw.close();              
                        clearTxtFields();;
                    }

                } catch (IOException ex) {
                    Logger.getLogger(CentreManager_ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "User Password has not been updated successfully!", "Error Occured!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            validateInput();
        }

    }

    
    //This method for Jframe initiation
    public void initGUI() {
        //Initializing the logo
        projectDir = System.getProperty("user.dir") + "\\src\\ImageSrc\\";
        System.out.println(projectDir);
        ImageIcon imageLogin = new ImageIcon(projectDir + "logo.png");
        Image imgLogin = imageLogin.getImage();
        lblLoginLogo.setIcon(new ImageIcon(imgLogin));
        
        //setting the frame name
        this.setTitle("Forgot Passowrd Page");
          
        //This sets the items not focusable
        btnBack.setFocusable(false);

        

//         // This is  an anon class handles textfield changes for username input
//        txtUsername.getDocument().addDocumentListener(new userDocumentListener() {
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//               enableLoginBtn(txtUsername);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                enableLoginBtn(txtUsername);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//               enableLoginBtn(txtUsername);
//
//            }
//        });
//
//        // This anon class handles textfield changes for password input
//        txtPassword.getDocument().addDocumentListener(new userDocumentListener() {
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                enableLoginBtn(txtPassword);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//               enableLoginBtn(txtPassword);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                enableLoginBtn(txtPassword);
//
//            }
//        });
//        
        /*
        // This anon class handles textfield changes for user role combobpx     
        ((JTextField)cbxUserRole.getEditor().getEditorComponent()).getDocument().addDocumentListener(new userDocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                enableLoginBtn(cbxUserRole);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               enableLoginBtn(cbxUserRole);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                enableLoginBtn(cbxUserRole);

            }
        });
      */
        
        //To handle the closing window
       addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Closing Window", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.YES_OPTION) {               
                    clearCache();
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
          userInputCharacterValidator();
    
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLoginLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtReNewPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
