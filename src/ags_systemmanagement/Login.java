/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author Prem Sharaan
 */
public class Login extends javax.swing.JFrame {
     //Setting private string variables
    private boolean enteredUsername = false, enteredPassword = false, selectedUserRole = false;
    private String projectDir, UserID, UserRole, UserUsername,UserPassword,UserFullName, UserEmail, UserPhoneNumber, dateTime;
  
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        initGUI();
        
    }
  

    // This method is to create a temporary staff session that stores relevant user detail
    private void startUserSession(){
        try {
            // This sets the directory of the project
            projectDir = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\";
            File userCacheFile = new File(projectDir + "UserCache.txt");
            if (!userCacheFile.exists()) {
                userCacheFile.createNewFile();
            }
            FileWriter fw = new FileWriter(projectDir + "UserCache.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(UserUsername + ":" + UserID);
            bw.close();
        } catch (Exception ex) {

        }
        
    }
    
    //Method for clearing any available user cache
    private void clearCache(){
         deleteSession clearSession = new deleteSession();
         clearSession.clearUserSession();
    }
 
    
      //Store the records of the session of the user as a log file
     private void storeLog() {
        try {
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH.mm.ss");
            LocalDateTime now = LocalDateTime.now();
            dateTime = dateTimeFormat.format(now);
            projectDir = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\";
            File logFile = new File(projectDir + "LogFile.txt");
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            FileWriter fw = new FileWriter(projectDir + "LogFile.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.write(UserID + ":" + UserUsername + ":" + UserPassword + ":" + UserFullName + ":" + UserEmail + ":" + UserPhoneNumber + dateTime);
            pw.close();
        } catch (Exception ex) {

        }
        
        
    }
    
      
    private void enableLoginBtn() {
        if (enteredUsername && enteredPassword) {
            btnLogin.setEnabled(true);
            btnLogin.setBackground( new Color(100,255,218));
        } else {
            btnLogin.setEnabled(false);
           
        }
     }
  private void enableLoginBtn(JTextField txtField) {
         if ("".equals(txtField.getText())) {
             enteredUsername = false;
             btnLogin.setBackground(Color.GRAY);
         } else {
             enteredUsername = true;

         }
             enableLoginBtn();
     }

    private void enableLoginBtn(JPasswordField txtField) {
        if ("".equals(String.valueOf(txtPassword.getPassword()))) {
            enteredPassword = false;          
            btnLogin.setBackground(Color.GRAY);
        } else {
            enteredPassword = true;
        }
            enableLoginBtn();
     }
    
   /*
     private void enableLoginBtn(JComboBox comboField) {
        if (cbxUserRole.getSelectedIndex()> 0) {  
            selectedUserRole = true;
        } else {
            selectedUserRole = false;
            btnLogin.setBackground(Color.GRAY);         
        }
           enableLoginBtn();
     }

    */
        //To check what user role and direct the user based on their user role
    private void  confirmUserRole() throws IOException {
        if (cbxUserRole.getSelectedIndex() == 1) {
            openFrame openFrame = new openFrame();
            openFrame.openCustomerMainMenu();
            this.dispose();
        }
         if (cbxUserRole.getSelectedIndex() == 2) {
            openFrame openFrame = new openFrame();
            openFrame.openTrainerMainMenu();
            this.dispose();
        }
         
        if (cbxUserRole.getSelectedIndex() == 3) {
            openFrame openFrame = new openFrame();
            openFrame.openManagerMainMenu();
            this.dispose();
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
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblLoginLogo = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        chkBoxShow = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        lblForgotPass = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        cbxUserRole = new javax.swing.JComboBox<>();
        lblUserRole = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 241, 255));
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 146, 176));
        jLabel2.setText("Please provide your username and password");

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

        txtUsername.setFont(new java.awt.Font("Lao Sangam MN", 0, 16)); // NOI18N
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
        lblPassword.setText("PASSWORD");

        txtPassword.setFont(new java.awt.Font("Lao Sangam MN", 0, 16)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        chkBoxShow.setBackground(new java.awt.Color(10, 25, 47));
        chkBoxShow.setForeground(new java.awt.Color(136, 146, 176));
        chkBoxShow.setText("Show Password");
        chkBoxShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkBoxShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxShowActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(100, 255, 218));
        btnLogin.setFont(new java.awt.Font("Beirut", 1, 15)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblForgotPass.setForeground(new java.awt.Color(136, 146, 176));
        lblForgotPass.setText("Forgot Password?");
        lblForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseExited(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Leelawadee UI Semilight", 2, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("AGS Management System");

        cbxUserRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---", "Customer", "Centre Trainer", "Centre Manager" }));

        lblUserRole.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        lblUserRole.setForeground(new java.awt.Color(100, 255, 218));
        lblUserRole.setText("User Role");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkBoxShow))
                            .addComponent(lblUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoginLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(393, 393, 393))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(lblForgotPass, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(613, 613, 613)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(582, 582, 582)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLoginLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkBoxShow))
                .addGap(33, 33, 33)
                .addComponent(lblUserRole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblForgotPass)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       clearCache();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked

    }//GEN-LAST:event_txtUsernameMouseClicked

    private void txtUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMousePressed

    }//GEN-LAST:event_txtUsernameMousePressed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed

    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed

    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed

    }//GEN-LAST:event_txtPasswordMousePressed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void chkBoxShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxShowActionPerformed
        if (chkBoxShow.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_chkBoxShowActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
       
    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       if ( cbxUserRole.getSelectedItem().toString() == "---none---") {  
           JOptionPane.showMessageDialog(null, "Please select the user role!", "Warning", JOptionPane.WARNING_MESSAGE);
      }else if (userAuthentication()) {
            try {
                JOptionPane.showMessageDialog(null, "User Authentication is successful! Redirecting you to the user main menu.", "User Authentication Successfully!", JOptionPane.INFORMATION_MESSAGE);
                startUserSession();
                confirmUserRole();
                storeLog();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "User Authentication is not successful! Your username, password or User Role may be wrong.", "User Authentication Failed!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblForgotPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseEntered
       this.lblForgotPass.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblForgotPassMouseEntered

    private void lblForgotPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseExited
       this.lblForgotPass.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblForgotPassMouseExited
                                    

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {      
                
            }
        });
    }
    
    
    
   //This method is to verify the user using the user username, password and userole
    //This checks every credentials for multiple line
    private boolean userAuthentication() {
        boolean userVerified = false;
        // This array is to store all lines
        String[] userDetails;
        try {
            // This is to get the username and password from text field temporary
            String tempUsername = txtUsername.getText();
            String tempPassword = String.valueOf(txtPassword.getPassword());
            String tempUserRole = String.valueOf(cbxUserRole.getSelectedItem());

            // This sets the directory of the project
            projectDir = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\";
            // This sets the file which going to be accessed
            File userFile = new File(projectDir + "User.txt");

            if (!userFile.exists()) {
                userFile.createNewFile();
            }
            
            Scanner readFile = new Scanner(userFile);
            // Read till last line of file
            while (readFile.hasNext()) {
                String userInput = readFile.nextLine();

                // Split the details by using the colon and store in an array.
                userDetails = userInput.split(":");

                // Check every line for the credential to be matched
                if (tempUserRole.equals(userDetails[1]) && tempUsername.equals(userDetails[3]) && tempPassword.equals(userDetails[4])) {
                    //UserID = userDetails[0].replace("USR", "");
                    UserID = userDetails[0];
                    UserRole = userDetails[1];
                    UserFullName = userDetails[2];
                    UserUsername = userDetails[3];
                    UserPassword = userDetails[4];
                    UserEmail = userDetails [5];
                    UserPhoneNumber = userDetails[6];
                    userVerified = true;
                }
            }

            readFile.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return userVerified;
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
        this.setTitle("Login Page");
          
        //This sets the items not focusable
        btnBack.setFocusable(false);
        
        //Disabling the login button
        btnLogin.setEnabled(false);
        btnLogin.setBackground(Color.GRAY);
        

         // This is  an anon class handles textfield changes for username input
        txtUsername.getDocument().addDocumentListener(new userDocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
               enableLoginBtn(txtUsername);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableLoginBtn(txtUsername);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               enableLoginBtn(txtUsername);

            }
        });

        // This anon class handles textfield changes for password input
        txtPassword.getDocument().addDocumentListener(new userDocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                enableLoginBtn(txtPassword);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               enableLoginBtn(txtPassword);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                enableLoginBtn(txtPassword);

            }
        });
        
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
       
      
    }
   
    public void openCentreManagerMainMenu(){
             CentreManager_MainMenu frame = new CentreManager_MainMenu();
             Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
             frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
             frame.setVisible(true);
             frame.setResizable(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cbxUserRole;
    private javax.swing.JCheckBox chkBoxShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblForgotPass;
    private javax.swing.JLabel lblLoginLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
