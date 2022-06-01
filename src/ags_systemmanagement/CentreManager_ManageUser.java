/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Prem Sharaan
 */
public class CentreManager_ManageUser extends javax.swing.JFrame {
    private final String userDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\User.txt";
    private String userID, profileImgDB, profileImgDir, projectDir, formattedDob, userImgDir;
    private Date dob;
    DecimalFormat deciFormat = new DecimalFormat("0000");
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date today = new Date();
    /**
     * Creates new form ManagerCustomer
     */
    public CentreManager_ManageUser() {
        initComponents();
        initGUI();
    }

     //Method for clearing any available user cachr
    private void clearCache(){
         deleteSession clearSession = new deleteSession();
         clearSession.clearUserSession();
    }
    
      //This gets the training slot details from the textfile to the table
     private void getUserDetails() {
        try {
            DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM yyyy");
            FileReader fr = new FileReader(userDB);
            BufferedReader br = new BufferedReader(fr);
            //This sets the table into a table model
            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
            //This is to  get line  by line from the text file
            Object[] tableLines = br.lines().toArray();
            //This is to retrieve the content from the lines in the text file and set the content in to the jtable
            for (int i = 0; i < tableLines.length; i++) {                                  
                 String detailsline = tableLines[i].toString().trim();
                 String[] detailDataRow = detailsline.split(":");
                 
                 
                 String userRole = detailDataRow[1];
                 String userStatus = detailDataRow[9];  //false = deleted true = still an user of system             
                 String userID = detailDataRow[0];                    
                 String userFullName = detailDataRow[2];
                 String userUserName = detailDataRow[3];
                 String userPassword = detailDataRow[4];
                 String userGender = detailDataRow[5];        
                 Date dob = dateFormat.parse(detailDataRow[6]);
                 String userDob = dateFormatTable.format(dob);
                 String userPhoneNumber = detailDataRow[7];
                 String userEmail = detailDataRow[8];
                 String userBankName = detailDataRow[10];
                 String userBankNum =  detailDataRow[11];           
     
                 if("true".equals(userStatus)){
                       
                       model.addRow(new Object[] {userID, 
                                                  userRole,
                                                  userFullName,
                                                  userUserName, 
                                                  userPassword, 
                                                  userGender, 
                                                  userDob,
                                                  userPhoneNumber,
                                                  userEmail,
                                                  userBankName,
                                                  userBankNum});                 
                                      
                 }   
                
            }
        } catch (Exception ex) {
            Logger.getLogger(CentreManager_ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    //This method retrieves the details from the jtabel and set it inside the respective fields when the user cell click.
    private void selectRowTable() {
        try {
            DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM yyyy");
            enableFields();
            int index = tblUser.getSelectedRow();
            
            TableModel model = tblUser.getModel();
            String userid = model.getValueAt(index, 0).toString();
            String userRole = model.getValueAt(index, 1).toString();;
            String fullname = model.getValueAt(index, 2).toString();;
            String username = model.getValueAt(index, 3).toString();;
            String password = model.getValueAt(index, 4).toString();;
            String gender = model.getValueAt(index, 5).toString();;
            Date dob = dateFormatTable.parse(model.getValueAt(index, 6).toString());
            String number = model.getValueAt(index, 7).toString();;
            String email = model.getValueAt(index, 8).toString();;
            String userbankname = model.getValueAt(index, 9).toString();;
            String userbanknum =  model.getValueAt(index, 10).toString();;
            
            
            userID = userid;
            chkUserID.setSelectedItem(userID);
            txtNewUsername.setText(username);
            txtUserRole.setText(userRole);
            txtFullName.setText(fullname);
            txtPassword.setText(password);
            txtPassword.setText(password);
            txtRetypePassword.setText(password);
            txtFullName.setText(fullname);
            chkGender.setSelectedItem(gender);
            userDOB.setDate(dob);
            txtNumber.setText(number);
            txtEmail.setText(email);
            chkBankName.setSelectedItem(userbankname);
            txtBankNum.setText(userbanknum);
        } catch (ParseException ex) {
            Logger.getLogger(CentreManager_ManageUser.class.getName()).log(Level.SEVERE, null, ex);
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
        btnGoBack = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblProfilePic = new javax.swing.JLabel();
        btnUploadImg = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtNewUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        lblRetypePassword = new javax.swing.JLabel();
        txtRetypePassword = new javax.swing.JPasswordField();
        txtFullName = new javax.swing.JTextField();
        chkGender = new javax.swing.JComboBox<>();
        lblName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNumber = new javax.swing.JFormattedTextField();
        lblNumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        lblUsername1 = new javax.swing.JLabel();
        lblUserID = new javax.swing.JLabel();
        chkUserID = new javax.swing.JComboBox<>();
        lblBankNum = new javax.swing.JLabel();
        lblBankName = new javax.swing.JLabel();
        chkBankName = new javax.swing.JComboBox<>();
        txtBankNum = new javax.swing.JFormattedTextField();
        lblnote = new javax.swing.JLabel();
        userDOB = new com.toedter.calendar.JDateChooser();
        lblDOB = new javax.swing.JLabel();
        txtUserRole = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 900));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 241, 255));
        jLabel1.setText("Manage User Information");

        lblTitle.setFont(new java.awt.Font("Leelawadee UI Semilight", 2, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("AGS Management System");

        btnGoBack.setBackground(new java.awt.Color(17, 34, 64));
        btnGoBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGoBack.setForeground(new java.awt.Color(100, 255, 218));
        btnGoBack.setText("Go Back");
        btnGoBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGoBackMouseEntered(evt);
            }
        });
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 204));
        btnSearch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(51, 51, 0));
        btnSearch.setText("Search");
        btnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(204, 255, 204));
        btnUpdate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 51, 51));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 204, 204));
        btnDelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(51, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUploadImg.setBackground(new java.awt.Color(0, 102, 102));
        btnUploadImg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUploadImg.setForeground(new java.awt.Color(237, 237, 237));
        btnUploadImg.setText("Upload Profile Image");
        btnUploadImg.setToolTipText("Button to reset every fields");
        btnUploadImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnUploadImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUploadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadImgActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(204, 204, 255));
        btnClear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 0, 51));
        btnClear.setText("Clear");
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearMouseEntered(evt);
            }
        });
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtNewUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtNewUsername.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N
        txtNewUsername.setForeground(new java.awt.Color(51, 51, 51));
        txtNewUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        txtNewUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewUsernameActionPerformed(evt);
            }
        });
        txtNewUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewUsernameKeyReleased(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(100, 255, 218));
        lblUsername.setText("Username :");

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        txtPassword.setEchoChar('*');

        lblPassword.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(100, 255, 218));
        lblPassword.setText("Password :");

        lblRetypePassword.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblRetypePassword.setForeground(new java.awt.Color(100, 255, 218));
        lblRetypePassword.setText("Retype Password :");

        txtRetypePassword.setBackground(new java.awt.Color(255, 255, 255));
        txtRetypePassword.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N
        txtRetypePassword.setForeground(new java.awt.Color(51, 51, 51));
        txtRetypePassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        txtRetypePassword.setEchoChar('*');

        txtFullName.setBackground(new java.awt.Color(255, 255, 255));
        txtFullName.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N
        txtFullName.setForeground(new java.awt.Color(51, 51, 51));
        txtFullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        txtFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullNameActionPerformed(evt);
            }
        });

        chkGender.setBackground(new java.awt.Color(255, 255, 255));
        chkGender.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N
        chkGender.setForeground(new java.awt.Color(0, 0, 0));
        chkGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "Male", "Female" }));
        chkGender.setBorder(null);
        chkGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkGenderActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(100, 255, 218));
        lblName.setText("Full Name : ");

        lblGender.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblGender.setForeground(new java.awt.Color(100, 255, 218));
        lblGender.setText("Gender :");

        lblEmail.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(100, 255, 218));
        lblEmail.setText("Email :");

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(51, 51, 51));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtNumber.setBackground(new java.awt.Color(255, 255, 255));
        txtNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        txtNumber.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumber.setToolTipText("");
        txtNumber.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N

        lblNumber.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblNumber.setForeground(new java.awt.Color(100, 255, 218));
        lblNumber.setText("Phone Number :");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tblUser.setBackground(new java.awt.Color(255, 255, 255));
        tblUser.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        tblUser.setForeground(new java.awt.Color(0, 0, 0));
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "User Role", "Full Name", "Username", "Password", "Gender", "Date of Birth", "Phone Numer", "Email", "Bank Name", "Bank Acc Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblUser.setToolTipText("");
        tblUser.setSelectionBackground(new java.awt.Color(51, 0, 0));
        tblUser.setSelectionForeground(new java.awt.Color(255, 204, 204));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        lblUsername1.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblUsername1.setForeground(new java.awt.Color(100, 255, 218));
        lblUsername1.setText("User Role :");

        lblUserID.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblUserID.setForeground(new java.awt.Color(100, 255, 218));
        lblUserID.setText("User ID :");

        chkUserID.setBackground(new java.awt.Color(255, 255, 255));
        chkUserID.setForeground(new java.awt.Color(0, 0, 0));
        chkUserID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---" }));
        chkUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUserIDActionPerformed(evt);
            }
        });

        lblBankNum.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblBankNum.setForeground(new java.awt.Color(100, 255, 218));
        lblBankNum.setText("Account Num:");

        lblBankName.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblBankName.setForeground(new java.awt.Color(100, 255, 218));
        lblBankName.setText("Bank Name:");

        chkBankName.setBackground(new java.awt.Color(255, 255, 255));
        chkBankName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chkBankName.setForeground(new java.awt.Color(0, 0, 0));
        chkBankName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---", "Affin Bank / Affin Islamic Bank", "Agrobank", "Alliance Bank", "CIMB Bank", "Citibank", "Hong Leong Bank", "Maybank", "OCBC Bank", "Public Bank" }));

        txtBankNum.setBackground(new java.awt.Color(255, 255, 255));
        txtBankNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 204), 2));
        txtBankNum.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtBankNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("################")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtBankNum.setToolTipText("");
        txtBankNum.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N

        lblnote.setBackground(new java.awt.Color(51, 51, 51));
        lblnote.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        lblnote.setForeground(new java.awt.Color(204, 255, 204));
        lblnote.setText("Additional Details For Centre Trainer");

        userDOB.setBackground(new java.awt.Color(255, 255, 255));
        userDOB.setDateFormatString("dd MMM yyyy");
        userDOB.setMaxSelectableDate(new java.util.Date(253370736000000L));
        userDOB.setMinSelectableDate(new java.util.Date(-62135798400000L));

        lblDOB.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblDOB.setForeground(new java.awt.Color(100, 255, 218));
        lblDOB.setText("Date of Birth :");

        txtUserRole.setBackground(new java.awt.Color(255, 255, 255));
        txtUserRole.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N
        txtUserRole.setForeground(new java.awt.Color(51, 51, 51));
        txtUserRole.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        txtUserRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserRoleActionPerformed(evt);
            }
        });
        txtUserRole.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserRoleKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDOB)
                    .addComponent(lblUsername)
                    .addComponent(lblPassword)
                    .addComponent(lblRetypePassword)
                    .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserID)
                    .addComponent(lblUsername1)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chkUserID, javax.swing.GroupLayout.Alignment.LEADING, 0, 213, Short.MAX_VALUE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRetypePassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserRole))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkGender, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(userDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(55, 55, 55)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnote)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblBankName)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblBankNum)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtBankNum, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lblProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnUploadImg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUploadImg, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkGender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblnote)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDOB)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(userDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBankName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBankNum)
                                    .addComponent(txtBankNum, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1616, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackMouseEntered

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
       int selection = JOptionPane.showConfirmDialog(null, "Going back to main menu will cancel the ongoing changing user details. Continue?", "Returning to Main Menu!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            this.dispose();
            openFrame openFrame = new openFrame();
            openFrame.openManagerMainMenu();
        }
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchUsername(txtNewUsername.getText());
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       updateUser();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         if (chkUserID.getSelectedIndex() == 0 || "".equals(txtNewUsername.getText())) {
            JOptionPane.showMessageDialog(null, "Pick the user id or search the user's username first to proceed delete this user.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else {
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the user account?", "Deleting user!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (selection == JOptionPane.YES_OPTION) {
                deleteUser();
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUploadImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadImgActionPerformed
         getProfileImage();
    }//GEN-LAST:event_btnUploadImgActionPerformed

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         clearManageDetails();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtNewUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewUsernameActionPerformed
      
    }//GEN-LAST:event_txtNewUsernameActionPerformed

    private void txtFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullNameActionPerformed

    private void chkGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkGenderActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        UserEmailValidation invalidate = new UserEmailValidation();
        invalidate.runValidate(txtEmail, true);
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        selectRowTable();
    }//GEN-LAST:event_tblUserMouseClicked

    private void txtNewUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewUsernameKeyReleased
      
    }//GEN-LAST:event_txtNewUsernameKeyReleased

    private void chkUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUserIDActionPerformed
       searchUserID((String)chkUserID.getSelectedItem());
    }//GEN-LAST:event_chkUserIDActionPerformed

    private void txtUserRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserRoleActionPerformed

    private void txtUserRoleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserRoleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserRoleKeyReleased

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
            java.util.logging.Logger.getLogger(CentreManager_ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentreManager_ManageUser().setVisible(true);
            }
        });
    }

        
    private void hideAddDetails(){
            lblnote.hide();
            lblBankName.hide();
            lblBankNum.hide();
            chkBankName.hide();
            txtBankNum.hide();
    }
    
    private void showAddDetails(){
            lblnote.show();
            lblBankName.show();
            lblBankNum.show();
            chkBankName.show();
            txtBankNum.show();   
    }
    
    
       private void disableFields() {
        txtPassword.setEditable(false);
        txtRetypePassword.setEditable(false);
        txtFullName.setEditable(false);
        txtEmail.setEditable(false);
        txtNumber.setEditable(false);
        chkGender.setEnabled(false);
        userDOB.setEnabled(false);
        chkBankName.setEnabled(false);
        txtBankNum.setEnabled(false);      
    }

    private void enableFields() {
        txtPassword.setEditable(true);
        txtRetypePassword.setEditable(true);
        txtFullName.setEditable(true);
        txtEmail.setEditable(true);
        txtNumber.setEditable(true);
        chkGender.setEnabled(true);
        userDOB.setEnabled(true);
        chkBankName.setEnabled(true);
        txtBankNum.setEnabled(true);
    }

       // This method clears all the fields
    private void clearManageDetails() {
        chkUserID.setSelectedIndex(0);
        txtUserRole.setText("");
        txtNewUsername.setText("");
        txtPassword.setText("");
        txtRetypePassword.setText("");
        userID = "";
        txtFullName.setText("");
        chkGender.setSelectedIndex(0);
        txtNumber.setText("");
        txtEmail.setText("");
        userDOB.setDate(null);
        chkBankName.setSelectedIndex(0);
        txtBankNum.setText("");
        disableFields();
        hideAddDetails();
        try {
            //Load default profile image for user
            loadDefaultImage();
        } catch (IOException ex) {
            Logger.getLogger(CentreManager_RegisterNewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void loadDefaultImage() throws IOException {
         // This sets the directory of the project
                profileImgDB = System.getProperty("user.dir") + "\\src\\ProfileImgSrc\\";
                File proImgSrc = new File(profileImgDB + "defaultProFile.jpg");
                BufferedImage bufImg = ImageIO.read(proImgSrc);
                Image imgScale = bufImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(imgScale);
                lblProfilePic.setIcon(scaledIcon);
    }
   
    
        
    public final void getUserID() {    
        try {
           File userFile = new File(userDB);
           Scanner readFile = new Scanner(userFile);
            while (readFile.hasNextLine()){
                 String line = readFile.nextLine();
                 String detailArray[] = line.split(":");
                 if ("true".equals(detailArray[9])) {
                     chkUserID.addItem(detailArray[0]);
                 }
         
            }
            readFile.close();
        } catch (Exception e) {

        }
    }
    
    
     private void searchUserID(String userid) {
        boolean hasRecord = false;
        String[] userDetails;   // This array is to store all lines
        try {
            // This sets the file which going to be accessed
            File userFile = new File(userDB);
            if (!userFile.exists()) {
                userFile.createNewFile();
            }

            Scanner searchUserID = new Scanner(userFile);
            // Read till last line of file
            while (searchUserID.hasNext()) {
                // Read the next line.
                String inputUsername = searchUserID.nextLine();
                // Split the details by using the colon and store in an array.
                userDetails = inputUsername.split(":");
                if (userid.equals(userDetails[0]) && "true".equals(userDetails[9])) {
                    userID = userDetails[0];
                    txtNewUsername.setText(userDetails[3]);
                    txtUserRole.setText(userDetails[1]);     
                    txtFullName.setText(userDetails[2]);
                    txtPassword.setText(userDetails[4]);
                    txtRetypePassword.setText(userDetails[4]);                           
                    chkGender.setSelectedItem(userDetails[5]);
                    dob = dateFormat.parse(userDetails[6]);
                    userDOB.setDate(dob);
                    txtNumber.setText(userDetails[7]);
                    txtEmail.setText(userDetails[8]);
                    
                    if("Centre Trainer".equals(txtUserRole.getText())){
                       showAddDetails();   
                       revalidate();
                       repaint();                     
                       chkBankName.setSelectedItem(userDetails[10]);
                       txtBankNum.setText(userDetails[11]);
                    }else{
                        hideAddDetails();
                        revalidate();
                        repaint();
                    
                    }
                    
                     // To get profile picture
                    userImgDir = System.getProperty("user.dir") + "\\src\\ProfileImgSrc\\" + userID + ".jpg";
                    File imgUser = new File(userImgDir);
                    String identifiedImg;
                    if (imgUser.exists()) {
                        identifiedImg = System.getProperty("user.dir") + "\\src\\ProfileImgSrc\\" + userID + ".jpg";
                    } else {
                        identifiedImg = System.getProperty("user.dir") + "\\src\\ProfileImgSrc\\defaultProfile.jpg";
                    }
                    BufferedImage bfImg = ImageIO.read(new File(identifiedImg));
                    Image imgScale = bfImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon resizeImg = new ImageIcon(imgScale);
                    lblProfilePic.setIcon(resizeImg);      
                  
                   
                    hasRecord = true;
                    enableFields();
                }
            }
            searchUserID.close();
        } catch (Exception ex) {

        }

    }
    

   
     private void searchUsername(String userUsername) {
        boolean hasRecord = false;
        String[] userDetails;   // This array is to store all lines
        try {
            // This sets the file which going to be accessed
            File userFile = new File(userDB);
            if (!userFile.exists()) {
                userFile.createNewFile();
            }

            Scanner searchUsername = new Scanner(userFile);
            // Read till last line of file
            while (searchUsername.hasNext()) {
                // Read the next line.
                String inputUsername = searchUsername.nextLine();
                // Split the details by using the colon and store in an array.
                userDetails = inputUsername.split(":");
                if (userUsername.equals(userDetails[3]) && "true".equals(userDetails[9])) {        
                    //setting details into textfields
                    userID = userDetails[0];
                    chkUserID.setSelectedItem(userDetails[0]);
                    txtUserRole.setText(userDetails[1]);     
                    txtFullName.setText(userDetails[2]);
                    txtPassword.setText(userDetails[4]);
                    txtRetypePassword.setText(userDetails[4]);                           
                    chkGender.setSelectedItem(userDetails[5]);
                    dob = dateFormat.parse(userDetails[6]);
                    userDOB.setDate(dob);
                    txtNumber.setText(userDetails[7]);
                    txtEmail.setText(userDetails[8]);
                    
                    if("Centre Trainer".equals(txtUserRole.getText())){
                       showAddDetails();   
                       revalidate();
                       repaint();                     
                       chkBankName.setSelectedItem(userDetails[10]);
                       txtBankNum.setText(userDetails[11]);
                    }else{
                        hideAddDetails();
                        revalidate();
                        repaint();      
                    }
                    
                    
                    // To get profile picture
                    userImgDir = System.getProperty("user.dir") + "\\src\\ProfileImgSrc\\" + userID + ".jpg";
                    File imgUser = new File(userImgDir);
                    String identifiedImg;
                    if (imgUser.exists()) {
                        identifiedImg = System.getProperty("user.dir") + "\\src\\ProfileImgSrc\\" + userID + ".jpg";
                    } else {
                        identifiedImg = System.getProperty("user.dir") + "\\src\\ProfileImgSrc\\defaultProfile.jpg";
                    }
                    BufferedImage bfImg = ImageIO.read(new File(identifiedImg));
                    Image imgScale = bfImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon resizeImg = new ImageIcon(imgScale);
                    lblProfilePic.setIcon(resizeImg);      
                  
                    hasRecord = true;
                    enableFields();
                }
            }
            searchUsername.close();
            if (!hasRecord) {
                //this will trigger an error message and clear all the text fields          
                JOptionPane.showMessageDialog(null, "User was not found.", "Username doesn't exists!", JOptionPane.ERROR_MESSAGE);
                this.clearManageDetails();

            }
        } catch (Exception ex) {

        }

    }
    
     
         // This is a new exception class
    public void emptyInputFields() throws Exception {
        UserEmailValidation invalidate = new UserEmailValidation();   
        if ("".equals(txtUserRole.getText())) {
            throw new Exception("Empty user role");
        }
        
        if ("".equals(txtNewUsername.getText())) {
            throw new Exception("Empty user username");
        }
        if ("".equals(String.valueOf(txtPassword.getPassword()))) {
            throw new Exception("Empty user password");
        }
        if ("".equals(String.valueOf(txtRetypePassword.getPassword()))) {
            throw new Exception("Empty user retype password");
        }
        if ("".equals(txtFullName.getText())) {
            throw new Exception("Empty user full name");
        }
        if ("".equals(txtNumber.getText())) {
            throw new Exception("Empty user phone number");
        }
        
        if (userDOB.getDate() == null) {
            throw new Exception("Empty user date");
        }
        
        if ("".equals(txtEmail.getText())) {
            throw new Exception("Empty user email");
        }

        if (invalidate.runValidate(txtEmail, false)) {
            throw new Exception("Invalid user email address format");
        }
        
        if (txtUserRole.getText() == "Centre Trainer"){        
           if (chkBankName.getSelectedIndex() == 0) {
                throw new Exception("Empty trainer bank name");
           }
           if ("".equals(txtBankNum.getText())) {
                throw new Exception("Empty trainer bank number");          
           }
        }
    }
    
     
     //This method raise message for empty fields, password comparison and username validation.
    private void validateInput() {
         if (chkUserID.getSelectedIndex() == 0 && "".equals(txtUserRole.getText()) && "".equals(txtNewUsername.getText()) && "".equals(txtFullName.getText()) && "".equals(txtNumber.getText()) && "".equals(txtEmail.getText()) && chkGender.getSelectedIndex() == 0 && userDOB.getDate()== null && chkBankName.getSelectedIndex() ==0 && "".equals(txtBankNum.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input all the fields to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if (chkUserID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "User not selcted!", "User not selected!", JOptionPane.WARNING_MESSAGE);
        }else if ("".equals(txtNewUsername.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input username to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if (userDOB.getDate()== null) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input date of birth.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);           
        } else if ("".equals(String.valueOf(txtPassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Invalid input! Pleass input password to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(String.valueOf(txtRetypePassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input retype password to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(txtFullName.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input full name to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if (chkGender.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Gender is not selected!", "Gender unselected!", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(txtEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input email to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if ("   -       ".equals(txtNumber.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please input phone number to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if (!comparePassword()) {
            JOptionPane.showMessageDialog(null, "Password is not same!", "Password mismatch!", JOptionPane.WARNING_MESSAGE);
        } else if(usernameValidation(txtNewUsername.getText())) {
            JOptionPane.showMessageDialog(null, "Username is already taken by another user! Use a different Username to proceed.", "Username is in use!", JOptionPane.ERROR_MESSAGE);
        } else if(txtUserRole.getText() == "Centre Trainer" && "".equals(txtNewUsername.getText()) && "".equals(txtFullName.getText()) && "".equals(txtNumber.getText()) && "".equals(txtEmail.getText()) && chkGender.getSelectedIndex() == 0 && userDOB.getDate()== null &&  chkBankName.getSelectedIndex() == 0  && "".equals(txtBankNum.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please input all the fields to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if (txtUserRole.getText() == "Centre Trainer"  &&  chkBankName.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please input bank name to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);     
        }else if (txtUserRole.getText() == "Centre Trainer" && "".equals(txtBankNum.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please input bank number to proceed.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);     
        }
    }
    
    
    //This method is to check whether the username is available or not
    public boolean usernameValidation(String userUsername) {
        boolean notFound = false;
        // This array is to store all lines
        String[] userDetails;
        try {
            // This sets the file which going to be accessed
            File userFile = new File(userDB);
            if (!userFile.exists()) {
                userFile.createNewFile();
            }
            Scanner searchUsername = new Scanner(userFile);
            // Read till last line of file
            while (searchUsername.hasNext()) {
                // Read the next line.
                String inputUsername = searchUsername.nextLine();
                // Split the details by using the colon and store in an array.
                userDetails = inputUsername.split(":");
                if (!userDetails[0].equals(userID) && userUsername.equals(userDetails[3])) {
                    notFound = true;
                }
            }
            searchUsername.close();
        } catch (Exception ex) {

        }
        return notFound;
    }
    
    
      // This method handles password comparison 
    private boolean comparePassword() {
        boolean isSimilar = false;
        String firstPass = String.valueOf(txtPassword.getPassword());
        String secondPass = String.valueOf(txtRetypePassword.getPassword());
        if ("".equals(firstPass) || "".equals(secondPass)) {
            isSimilar = false;
        } else if (firstPass.equals(secondPass)) {
            isSimilar = true;
        }
        return isSimilar;
    }
    
    
    
   
     // This method handles all validation related to the fields
    private void userInputCharacterValidator() {
        txtNewUsername.getDocument().addDocumentListener(new userDocumentListener() {
            UserUsernameValidation invalidate = new UserUsernameValidation();

            @Override
            public void changedUpdate(DocumentEvent e) {
                invalidate.runValidate(txtNewUsername);
                invalidate.setRegex("testing");
                invalidate.getRegex();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                invalidate.runValidate(txtNewUsername);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                invalidate.runValidate(txtNewUsername);
            }

        });
        
        txtPassword.getDocument().addDocumentListener(new userDocumentListener() {
            UserPasswordValidation invalidate = new UserPasswordValidation();

            @Override
            public void changedUpdate(DocumentEvent e) {
                invalidate.runValidate(txtPassword);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                invalidate.runValidate(txtPassword);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                invalidate.runValidate(txtPassword);
            }
        });
        
        txtRetypePassword.getDocument().addDocumentListener(new userDocumentListener() {
            UserPasswordValidation invalidate = new UserPasswordValidation();

            @Override
            public void changedUpdate(DocumentEvent e) {
                invalidate.runValidate(txtRetypePassword);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                invalidate.runValidate(txtRetypePassword);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                invalidate.runValidate(txtRetypePassword);
            }
        });
        
          txtFullName.getDocument().addDocumentListener(new userDocumentListener() {
            UserFullNameValidation invalidate = new UserFullNameValidation();

            @Override
            public void changedUpdate(DocumentEvent e) {
                invalidate.runValidate(txtFullName);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                invalidate.runValidate(txtFullName);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                invalidate.runValidate(txtFullName);
            }
        }); 
       
    }

    
    
   private void getProfileImage() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            //improve this later to allow more extensions
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Only jpg allowed", "jpg");
            fileChooser.setFileFilter(filter);
            int selected = fileChooser.showOpenDialog(null);
            //this open dialog to pick the imaege
            if (selected == JFileChooser.APPROVE_OPTION) { 
                File file = fileChooser.getSelectedFile(); 
                //storing the directory of the image into a variable
                String getImageDir = file.getAbsolutePath();
                BufferedImage bufImg = ImageIO.read(new File(getImageDir));
                Image imgScale = bufImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon imgIcon = new ImageIcon(imgScale);
                lblProfilePic.setIcon(imgIcon);
                profileImgDir = getImageDir; 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There were an error occured getting the image!!");
        }

    }
      
      
     private void updateProfileImg() {
            profileImgDB = System.getProperty("user.dir") + "\\src\\ProfileImgSrc\\";
            String newImgName =  profileImgDB+userID + "." + "jpg";
            File path = new File(profileImgDir); 
            File newImg = new File(newImgName);  
            File originalImgPath = new File(profileImgDB);

        try {
            Files.copy(path.toPath(), newImg.toPath(), StandardCopyOption.REPLACE_EXISTING); 
            boolean success = originalImgPath.renameTo(newImg);

            if (!success) {
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
   
    }  
     
     
     //This method will update new user details
    private void updateUser() {
        File file = new File(userDB);
        ArrayList<String> userArray = new ArrayList<>();  //This is for temporary array to hold the user data
        try {
                    
                 //This will get all details and set the details into a variable
                String userid = userID;
                String userRole = txtUserRole.getText();
                String username = txtNewUsername.getText();
                String password = txtPassword.getText();
                String fullname = txtFullName.getText();
                String gender = (String) chkGender.getSelectedItem();  
                Date dob = userDOB.getDate();
                formattedDob= dateFormat.format(dob);
                String number = txtNumber.getText();
                String email = txtEmail.getText();
                String bankname,banknum;
                if("Centre Trainer".equals(userRole)){
                   bankname = (String) chkBankName.getSelectedItem();
                   banknum = txtBankNum.getText();
                }else{
                    bankname = "-";
                    banknum = "-";
                }

            
            try ( FileReader fr = new FileReader(file)) {
                Scanner readFile = new Scanner(fr);
                String detailLine;
                String[] detailArr;  //This temp array is to store the details which is gonna be updated                                     
                while ((detailLine = readFile.nextLine()) != null) {
                    //This is to split each line using colon to check if the username is present
                    detailArr = detailLine.split(":");
                    //If the username is present, add the old data
                    //Add the new data in the temporary array                  

                          
                    if (detailArr[0].equals(userid)) {                        
                        userArray.add(detailArr[0] + ":"
                                + detailArr[1]+ ":"
                                + fullname + ":"
                                + username + ":"
                                + password + ":"
                                + gender + ":" 
                                + formattedDob + ":"
                                + number + ":" 
                                + email + ":"       
                                + detailArr[9] + ":" 
                                + bankname + ":"
                                + banknum);
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
              
            if (usernameValidation(txtNewUsername.getText())) {
                throw new Exception("Username is already in use by another user.");
            } else if (!comparePassword()) {  // This compare the password and retype password
                throw new Exception("Password and retype password entered not same!");
            } else if (chkGender.getSelectedIndex() == 0) { // This is will be displayed when the combo box is selected default
                JOptionPane.showMessageDialog(null, "Gender not selected!", "Gender unselected!", JOptionPane.ERROR_MESSAGE);              
            } else {
                boolean hasUpdated = false;
                //this is to set the buffered write to write the data into temporary array again back to text file        
                try ( PrintWriter pw = new PrintWriter(file)) {
                    for (String str : userArray) {
                        pw.println(str); //this will write all the data in the temporary array back to the file line by line
                        hasUpdated = true;
                    }
                    //This will display a success message indicates that the details has been updated
                    if (hasUpdated) {
                        updateProfileImg();
                        JOptionPane.showMessageDialog(null, "User Details has been updated successfully!", "Account successfully updated!", JOptionPane.INFORMATION_MESSAGE);
                        pw.close();              
                        clearManageDetails();
                        //this will refresh the table when it is successful
                        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
                        model.setRowCount(0);
                        getUserDetails();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(CentreManager_ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "User Details has not been updated successfully!", "Error Occured!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            validateInput();
        }

    }

    
     //This method delete user accounts but the details will be still there
    private void deleteUser() {
        File file = new File(userDB);
        ArrayList<String> userArray = new ArrayList<>();  //This is for temporary array to hold the user data
        try {
                    
                 //This will get all details and set the details into a variable
                String userid = userID;
            
            try ( FileReader fr = new FileReader(file)) {
                Scanner readFile = new Scanner(fr);
                String detailLine;
                String[] detailArr;  //This temp array is to store the details which is gonna be updated                                     
                while ((detailLine = readFile.nextLine()) != null) {
                    //This is to split each line using colon to check if the username is present
                    detailArr = detailLine.split(":");
                    //If the username is present, add the old data
                    //Add the new data in the temporary array                  
                          
                    if (detailArr[0].equals(userid)) {                        
                        userArray.add(detailArr[0] + ":"
                                + detailArr[1]+ ":"
                                + detailArr[2] + ":"
                                +detailArr[3]+ ":"
                                + detailArr[4] + ":"
                                + detailArr[5]+ ":" 
                                + detailArr[6] + ":"
                                + detailArr[7] + ":" 
                                + detailArr[8] + ":"       
                                + "false" + ":" 
                                + detailArr[10]+ ":"
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
      
                boolean hasUpdated = false;
                //this is to set the buffered write to write the data into temporary array again back to text file        
                try ( PrintWriter pw = new PrintWriter(file)) {
                    for (String str : userArray) {
                        pw.println(str); //this will write all the data in the temporary array back to the file line by line
                        hasUpdated = true;
                    }
                    //This will display a success message indicates that the details has been updated
                    if (hasUpdated) {
                        JOptionPane.showMessageDialog(null, "User Details has been deleted successfully!", "Account successfully deleted!", JOptionPane.INFORMATION_MESSAGE);
                        pw.close();              
                        clearManageDetails();
                        //this will refresh the table when it is successful
                        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
                        model.setRowCount(0);
                        getUserDetails();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(CentreManager_ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "User Details has not been updated successfully!", "Error Occured!", JOptionPane.ERROR_MESSAGE);
                }
        
        } catch (Exception e) {
    
        }

    }
    
    
    public void initGUI(){
          //setting the frame name
        this.setTitle("Manage User");
         
        //This will padding for the textfields
        txtNewUsername.setBorder(BorderFactory.createCompoundBorder(txtNewUsername.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(txtPassword.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtFullName.setBorder(BorderFactory.createCompoundBorder(txtFullName.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtRetypePassword.setBorder(BorderFactory.createCompoundBorder(txtRetypePassword.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtEmail.setBorder(BorderFactory.createCompoundBorder(txtEmail.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtNumber.setBorder(BorderFactory.createCompoundBorder(txtNumber.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtBankNum.setBorder(BorderFactory.createCompoundBorder(txtBankNum.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));

        //Disable autofucous in buttons
        btnGoBack.setFocusable(false);
        btnClear.setFocusable(false);
        btnUploadImg.setFocusable(false);
        tblUser.setFocusable(false);
        tblUser.setDefaultEditor(Object.class, null);
      
         //disabling user input from keyboard
         JTextFieldDateEditor editor = (JTextFieldDateEditor) userDOB.getDateEditor();
         editor.setEditable(false);
          
         userDOB.getJCalendar().setMaxSelectableDate(today);
    
        try {
            //Load default profile image for user
            loadDefaultImage();
        } catch (IOException ex) {
            Logger.getLogger(CentreManager_ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        //Hide additional details textfields
        hideAddDetails();
       
        
        //disabling textfields input
         disableFields();
        txtUserRole.setEditable(false);
         
         
        //get user ID
        getUserID();
         
        //get user details to table
        getUserDetails();

        // This class handles window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int selection = JOptionPane.showConfirmDialog(null, "Want to exit?", "Closing User Register", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (selection == JOptionPane.YES_OPTION) {
                   //This will clear the login session
                    clearCache();
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    dispose();
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

       userInputCharacterValidator();
    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUploadImg;
    private javax.swing.JComboBox<String> chkBankName;
    private javax.swing.JComboBox<String> chkGender;
    private javax.swing.JComboBox<String> chkUserID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBankName;
    private javax.swing.JLabel lblBankNum;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblProfilePic;
    private javax.swing.JLabel lblRetypePassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JLabel lblnote;
    private javax.swing.JTable tblUser;
    private javax.swing.JFormattedTextField txtBankNum;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtNewUsername;
    private javax.swing.JFormattedTextField txtNumber;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRetypePassword;
    private javax.swing.JTextField txtUserRole;
    private com.toedter.calendar.JDateChooser userDOB;
    // End of variables declaration//GEN-END:variables
}
