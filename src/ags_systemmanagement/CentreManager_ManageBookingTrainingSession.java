/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Prem Sharaan
 */
public class CentreManager_ManageBookingTrainingSession extends javax.swing.JFrame {
     private final String trainingSlotsDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt";
     private final String userDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\User.txt";
     private String cusID,trainerID, trainingID, todayFormattedDate, formattedDate;
     DecimalFormat deciFormat = new DecimalFormat("0000");
     private Date trainingDate;
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     DateFormat convDate = new SimpleDateFormat("dd MMMM yy");
     Date today = new Date();
    /**
     * Creates new form CentreManager_ManageBookingTrainingSession
     */
    public CentreManager_ManageBookingTrainingSession() {
        initComponents();
        initGUI();
    }

    //Method for clearing any available user cachr
    private void clearCache(){
         deleteSession clearSession = new deleteSession();
         clearSession.clearUserSession();
    }
   
     private void enableUpdate(){
       if (chkCustomerID.getSelectedIndex()>0 && chkTrainingID.getSelectedIndex() > 0) {
            btnUpdate.setEnabled(true);
            btnClear.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnClear.setEnabled(false);
        }
    }
    

     private void enableDelete(){   
       if (chkTrainingID.getSelectedIndex() > 0) {
            btnDelete.setEnabled(true);
        } else {
            btnDelete.setEnabled(false);
        }
    }
     

     //This gets the training slot details from the textfile to the table
     private void getBookedTrainingSlotDetails() {
        try {
            todayFormattedDate= dateFormat.format(today);
            FileReader fr = new FileReader(trainingSlotsDB);
            BufferedReader br = new BufferedReader(fr);
            //This sets the table into a table model
            DefaultTableModel model = (DefaultTableModel) tblTrainingSession.getModel();
            //This is to  get line  by line from the text file
            Object[] tableLines = br.lines().toArray();
            //This is to retrieve the content from the lines in the text file and set the content in to the jtable
            for (int i = 0; i < tableLines.length; i++) {         
                String detailsline = tableLines[i].toString().trim();
                String[] userDataRow = detailsline.split(":");
                      String trainingid = userDataRow[0];
                      String trainerid = userDataRow[1];
                      String trainerName = userDataRow[2];
                      Date date = dateFormat.parse(userDataRow[3]);
                      String formatTableDate = convDate.format(date);
                      String startTime = userDataRow[4];
                      String endTime = userDataRow[5];
                      String status = userDataRow[6];
                      String cusid = userDataRow[6];
                      String fees = "RM" + userDataRow[7]; 
                      String userFullName = "";
                      
                      if ("*".equals(status)){
                          status = "Not Booked";                   
                      }else{                         
                          status = "Booked";
                      }
                      
                       try {
                            File userFile = new File(userDB);
                            Scanner readFile = new Scanner(userFile);
                             while (readFile.hasNextLine()){
                                  String line = readFile.nextLine();
                                  String detailArray[] = line.split(":");
                                  if (cusid.equals(detailArray[0])) {
                                    userFullName = detailArray[2];
                                  }

                             }
                             readFile.close();
                         } catch (Exception e) {

                         }
               
                   if(userDataRow[3].compareTo(todayFormattedDate) >= 0 && !userDataRow[7].equals("*")){
                       model.addRow(new Object[] {trainingid, trainerid, trainerName, formatTableDate, startTime,endTime, status ,cusid, userFullName, fees});
                   }
            }
        } catch (Exception ex) {
            Logger.getLogger(CentreManager_ManageBookingTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
    
    //This method retrieves the details from the jtabel and set it inside the respective fields when the user cell click.
    private void selectRowTable() {
             DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM yyyy");
             enableUpdate();
             enableDelete();
            int index = tblTrainingSession.getSelectedRow();
            
            TableModel model = tblTrainingSession.getModel();
            String trainingid = model.getValueAt(index, 0).toString();
            String trainerid = model.getValueAt(index, 1).toString();;        
            String trainingname = model.getValueAt(index, 2).toString();;
            String trainingdate = model.getValueAt(index, 3).toString();;
            String startime = model.getValueAt(index, 4).toString();;
            String endtime = model.getValueAt(index, 5).toString();;
            String cusid = model.getValueAt(index, 7).toString();;
            String cusname = model.getValueAt(index, 8).toString();;
            String fees = model.getValueAt(index, 9).toString();; 
            
            trainingID = trainingid;
            cusID = cusid;       
            trainerID = trainerid;
            chkTrainingID.setSelectedItem(trainingid);
            chkCustomerID.setSelectedItem(cusID);         
            txtCusName.setText(cusname);
            txtTrainingDate.setText(trainingdate);
            txtTrainerName.setText(trainingname);
            txtTrainingTime.setText(startime + " - "+ endtime);
            txtFees.setText(fees);
     
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
        lblTitle = new javax.swing.JLabel();
        lblSystemName = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        chkCustomerID = new javax.swing.JComboBox<>();
        lblCustomerID = new javax.swing.JLabel();
        lblTrainerName = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        txtFees = new javax.swing.JFormattedTextField();
        lblPaymentAmount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrainingSession = new javax.swing.JTable();
        txtCusName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblBookingID = new javax.swing.JLabel();
        chkTrainingID = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        txtTrainingDate = new javax.swing.JTextField();
        txtTrainerName = new javax.swing.JTextField();
        txtTrainingTime = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 900));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(230, 241, 255));
        lblTitle.setText("Manage Booked Training Session");

        lblSystemName.setFont(new java.awt.Font("Leelawadee UI Semilight", 2, 24)); // NOI18N
        lblSystemName.setForeground(new java.awt.Color(204, 204, 204));
        lblSystemName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSystemName.setText("AGS Management System");

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

        chkCustomerID.setBackground(new java.awt.Color(255, 255, 255));
        chkCustomerID.setForeground(new java.awt.Color(0, 0, 0));
        chkCustomerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---" }));
        chkCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCustomerIDActionPerformed(evt);
            }
        });

        lblCustomerID.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblCustomerID.setForeground(new java.awt.Color(100, 255, 218));
        lblCustomerID.setText("Customer ID:");

        lblTrainerName.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTrainerName.setForeground(new java.awt.Color(100, 255, 218));
        lblTrainerName.setText("Trainer Name :");

        lblDate.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(100, 255, 218));
        lblDate.setText("Training Date :");

        lblTime.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(100, 255, 218));
        lblTime.setText("Training Time :");

        txtFees.setBackground(new java.awt.Color(255, 255, 255));
        txtFees.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 204), 2));
        txtFees.setForeground(new java.awt.Color(0, 0, 0));
        txtFees.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtFees.setText("RM");
        txtFees.setToolTipText("");
        txtFees.setFont(new java.awt.Font("Avenir Next", 0, 16)); // NOI18N
        txtFees.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFeesFocusLost(evt);
            }
        });
        txtFees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFeesActionPerformed(evt);
            }
        });
        txtFees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFeesKeyPressed(evt);
            }
        });

        lblPaymentAmount.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblPaymentAmount.setForeground(new java.awt.Color(100, 255, 218));
        lblPaymentAmount.setText("Fees :");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tblTrainingSession.setBackground(new java.awt.Color(255, 255, 255));
        tblTrainingSession.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        tblTrainingSession.setForeground(new java.awt.Color(0, 0, 0));
        tblTrainingSession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Training ID", "Trainer ID", "Trainer Name", "Date", "Start Time", "End Time", "Status", "Customer ID", "Customer Name", "Fees"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTrainingSession.setToolTipText("");
        tblTrainingSession.setSelectionBackground(new java.awt.Color(0, 51, 51));
        tblTrainingSession.setSelectionForeground(new java.awt.Color(204, 255, 204));
        tblTrainingSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTrainingSessionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTrainingSession);

        txtCusName.setBackground(new java.awt.Color(204, 204, 204));
        txtCusName.setFont(new java.awt.Font("Lao Sangam MN", 1, 16)); // NOI18N
        txtCusName.setForeground(new java.awt.Color(0, 0, 0));
        txtCusName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 255, 204)));
        txtCusName.setPreferredSize(new java.awt.Dimension(89, 22));

        lblName.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(100, 255, 218));
        lblName.setText("Customer Name:");

        lblBookingID.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblBookingID.setForeground(new java.awt.Color(100, 255, 218));
        lblBookingID.setText("Training ID:");

        chkTrainingID.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainingID.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainingID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---" }));
        chkTrainingID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrainingIDActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 204, 204));
        btnDelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(102, 0, 0));
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

        txtTrainingDate.setBackground(new java.awt.Color(204, 204, 204));
        txtTrainingDate.setFont(new java.awt.Font("Lao Sangam MN", 1, 16)); // NOI18N
        txtTrainingDate.setForeground(new java.awt.Color(0, 0, 0));
        txtTrainingDate.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 255, 204)));
        txtTrainingDate.setPreferredSize(new java.awt.Dimension(89, 22));

        txtTrainerName.setBackground(new java.awt.Color(204, 204, 204));
        txtTrainerName.setFont(new java.awt.Font("Lao Sangam MN", 1, 16)); // NOI18N
        txtTrainerName.setForeground(new java.awt.Color(0, 0, 0));
        txtTrainerName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 255, 204)));
        txtTrainerName.setPreferredSize(new java.awt.Dimension(89, 22));

        txtTrainingTime.setBackground(new java.awt.Color(204, 204, 204));
        txtTrainingTime.setFont(new java.awt.Font("Lao Sangam MN", 1, 16)); // NOI18N
        txtTrainingTime.setForeground(new java.awt.Color(0, 0, 0));
        txtTrainingTime.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 255, 204)));
        txtTrainingTime.setPreferredSize(new java.awt.Dimension(89, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblSystemName, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCustomerID)
                                    .addComponent(lblName)
                                    .addComponent(lblDate)
                                    .addComponent(lblTrainerName)
                                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCusName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFees)
                                        .addComponent(chkCustomerID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTrainingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTrainerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtTrainingTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblBookingID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chkTrainingID, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
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
                        .addComponent(lblSystemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(134, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkTrainingID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBookingID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrainingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrainerName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrainerName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrainingTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFees, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1325, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackMouseEntered

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
         this.dispose();
         openFrame openFrame = new openFrame();
         openFrame.openBookingTrainingSession();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         try {
             updateBook();
         } catch (Exception ex) {
             Logger.getLogger(CentreManager_ManageBookingTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         clearTxtFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void chkCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCustomerIDActionPerformed
          enableUpdate();
          getCustomerName();
    }//GEN-LAST:event_chkCustomerIDActionPerformed

    private void txtFeesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFeesFocusLost

    }//GEN-LAST:event_txtFeesFocusLost

    private void txtFeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFeesActionPerformed
        //enableBtn();
    }//GEN-LAST:event_txtFeesActionPerformed

    private void txtFeesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFeesKeyPressed

    }//GEN-LAST:event_txtFeesKeyPressed

    private void tblTrainingSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainingSessionMouseClicked
         selectRowTable();
    }//GEN-LAST:event_tblTrainingSessionMouseClicked

    private void chkTrainingIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainingIDActionPerformed
        enableUpdate();
        enableDelete();
        searchTrainingID((String)chkTrainingID.getSelectedItem());            
    }//GEN-LAST:event_chkTrainingIDActionPerformed

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteBooking();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(CentreManager_ManageBookingTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageBookingTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageBookingTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageBookingTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentreManager_ManageBookingTrainingSession().setVisible(true);
            }
        });
    }

       private void clearTxtFields(){
            chkTrainingID.setSelectedIndex(0);
            chkCustomerID.setSelectedIndex(0);
            txtCusName.setText("");
            txtTrainingDate.setText("");
            txtTrainerName.setText("");
            txtTrainingTime.setText("");
            txtFees.setText(""); 
            cusID = "";
            trainerID = "";
            trainingID = "";
    }
    
    
      private void validateInput(){      
         if ("".equals(txtFees.getText()) || "RM".equals(txtFees.getText()) ) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please input valid training fees to update booking. Eg RM10.10", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);     
         }else if(recordExist(txtTrainingDate.getText(), txtTrainingTime.getText(), (String) chkCustomerID.getSelectedItem())){
             JOptionPane.showMessageDialog(null, "The customer has booked training session for picked date and time", "Booking Exists!", JOptionPane.ERROR_MESSAGE);
         }
             
     }
       
      
     public void emptyInputFields() throws Exception {
        TrainingFeesValidation invalidate = new TrainingFeesValidation();
        if ("".equals(txtFees.getText())|| "RM".equals(txtFees.getText())) {
            throw new Exception("Empty fees");
        }else if (invalidate.runValidate(txtFees, false)) {
            throw new Exception("Invalid fees format");
         }
       
      }
      
       
    
    public final void getTrainingID() {    
        try {
           File userFile = new File(trainingSlotsDB);
           Scanner readFile = new Scanner(userFile);
            while (readFile.hasNextLine()){
                 String line = readFile.nextLine();
                 String detailArray[] = line.split(":");
                 if (detailArray[3].compareTo(todayFormattedDate) >= 0 && !detailArray[6].equals("*")) {
                     chkTrainingID.addItem(detailArray[0]);
                 }
         
            }
            readFile.close();
        } catch (Exception e) {

        }

    }
    
    
    public final void getCustomerID() {    
        try {
           File userFile = new File(userDB);
           Scanner readFile = new Scanner(userFile);
            while (readFile.hasNextLine()){
                 String line = readFile.nextLine();
                 String detailArray[] = line.split(":");
                 if ("Customer".equals(detailArray[1]) && "true".equals(detailArray[9])) {
                     chkCustomerID.addItem(detailArray[0]);
                 }
         
            }
            readFile.close();
        } catch (Exception e) {

        }

    }
    
    
    
     public final void getCustomerName() {    
        try {
           cusID = chkCustomerID.getSelectedItem().toString(); 
           File userFile = new File(userDB);
           Scanner readFile = new Scanner(userFile);
            while (readFile.hasNextLine()){
                 String line = readFile.nextLine();
                 String detailArray[] = line.split(":");
                 if (cusID.equals(detailArray[0])) {
                    txtCusName.setText(detailArray[2]);
                 }
         
            }
            readFile.close();
        } catch (Exception e) {

        }

    }
  
    private void searchTrainingID(String trainingid) {
        boolean hasRecord = false;
        String[] trainingDetails;   // This array is to store all lines
        try {

            // This sets the file which going to be accessed
            File trainingFile = new File(trainingSlotsDB); 
            Scanner searchTrainingID = new Scanner(trainingFile);
            // Read till last line of file
            while (searchTrainingID.hasNext()) {
                // Read the next line.
                String inputID = searchTrainingID.nextLine();
                // Split the details by using the colon and store in an array.
                trainingDetails = inputID.split(":");
                
                if(trainingid == "---none---"){                
                    clearTxtFields();
                } else if (trainingid.equals(trainingDetails[0]) && !"*".equals(trainingDetails[6])) {
                    trainingID = trainingDetails[0];
                    cusID = trainingDetails[6];
                    chkCustomerID.setSelectedItem(cusID);
                    Date date = dateFormat.parse(trainingDetails[3]);
                    String formatTableDate = convDate.format(date);
                    txtTrainingDate.setText(formatTableDate);                  
                    txtTrainingTime.setText(trainingDetails[4] + " - "  + trainingDetails[5]);
                    txtFees.setText(trainingDetails[7]);
                    txtTrainerName.setText(trainingDetails[2]);
                    trainerID = trainingDetails[1];
                    
                     try {
                            File userFile = new File(userDB);
                            Scanner readFile = new Scanner(userFile);
                             while (readFile.hasNextLine()){
                                  String line = readFile.nextLine();
                                  String detailArray[] = line.split(":");
                                  if (cusID.equals(detailArray[0])) {
                                      txtCusName.setText(detailArray[2]);
                                  }

                             }
                             readFile.close();
                         } catch (Exception e) {

                         }
                    
                    hasRecord = true;
                    enableUpdate();
                    enableDelete();
                }
            }
            searchTrainingID.close();
        } catch (Exception ex) {

        }

    }
    

    
     //This method is to check whether the selected record already exist or nope
    public boolean recordExist(String trainingdate, String trainingTime, String cusID) {
        boolean notFound = false;
        // This array is to store all lines
         String[] trainingDetails;
         String[] trainingtime = trainingTime.split(" - ",2);
        try {
            // This sets the file which going to be accessed
            File trainingFile = new File(trainingSlotsDB);
            Scanner searchDetails = new Scanner(trainingFile);
            // Read till last line of file
            while (searchDetails.hasNext()) {
                // Read the next line.
                String inputTraining = searchDetails.nextLine();
                // Split the details by using the colon and store in an array.
                trainingDetails = inputTraining.split(":");
                formattedDate =dateFormat.format(convDate.parse(trainingdate));
                System.out.println(formattedDate);
                //formatting date
                if (formattedDate.equals(trainingDetails[3]) && trainingtime[0].equals(trainingDetails[4]) &&  trainingtime[1].equals(trainingDetails[5]) && cusID.equals(trainingDetails[6])) {
                    notFound = true;
                }
            }
            searchDetails.close();
        } catch (Exception ex) {

        }
        return notFound;
      
    }

   

    
     //This method will update new staff details
    private void updateBook() throws Exception {
        File trainingFile = new File(trainingSlotsDB);
        ArrayList<String> trainingArray = new ArrayList<>();  //This is for temporary array to hold the staff data
                 //To check whether inserted record exists
        try {
         
              String cusID = (String)chkCustomerID.getSelectedItem();
              String[] fees = txtFees.getText().split("RM",2);
              String trainingID = (String) chkTrainingID.getSelectedItem();        
                       
            
          try ( FileReader fr = new FileReader(trainingFile)) {    
                Scanner readFile = new Scanner(fr);
                String detailLine;
                String[] detailArr;  //This temp array is to store the details which is gonna be updated                                     
                while ((detailLine = readFile.nextLine()) != null) {
                    //This is to split each line using colon to check if the username is present
                    detailArr = detailLine.split(":");
                    //If the training is present, add the old data
                    //Add the new data in the temporary array
                                    
                    if (detailArr[0].equals(trainingID) && !"*".equals(detailArr[6])) {
                        trainingArray.add(detailArr[0] + ":"
                                + detailArr[1]+ ":"
                                + detailArr[2] + ":"
                                + detailArr[3]+ ":"
                                + detailArr[4] + ":"
                                + detailArr[5]+ ":"
                                + cusID + ":"
                                + fees[1] + ":" 
                                + detailArr[8]);
                    } else {
                        //search other doesnt match and add the line
                        trainingArray.add(detailLine);
                    }
                }
                fr.close();
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }

        try {
             TrainingFeesValidation invalidate = new TrainingFeesValidation();
             if (invalidate.runValidate(txtFees, false)){
                 throw new Exception("Invalid payment format");
                 // To check whether inserted booking record exists
             }else if(recordExist(txtTrainingDate.getText(), txtTrainingTime.getText(), (String) chkCustomerID.getSelectedItem())){    
                System.out.println("im working");
                throw new Exception("Record exists");          
            }else {                  
             boolean hasUpdated = false;
                //this is to set the bufferd write to write the data into temporary array again back to text file        
                try (PrintWriter pw = new PrintWriter(trainingFile)) {
                    for (String str : trainingArray) {
                        pw.println(str); //this will write all the data in the temporary array back to the file line by line
                        hasUpdated = true;
                    }
                    //This will display a success message indicates that the details has been updated
                    if (hasUpdated) {
                        JOptionPane.showMessageDialog(null, "Booking has bee updated successfully!", "Booking successfully update!", JOptionPane.INFORMATION_MESSAGE);
                        pw.close();
                        clearTxtFields();
                        //this will refresh the table when it is successful
                        DefaultTableModel model = (DefaultTableModel) tblTrainingSession.getModel();
                        model.setRowCount(0);
                        getBookedTrainingSlotDetails();
                    }

                }      
        } 
                
        } catch (Exception e) {    
                validateInput();     
        }

    }
    
     
    
      //This method will delete the booked details
    private void deleteBooking() {
      File file = new File(trainingSlotsDB);
        ArrayList<String> userArray = new ArrayList<>();  //This is for temporary array to hold the user data
        try {
                    
               //This will get all details and set the details into a variable
                String trainingid = trainingID;
            
            try ( FileReader fr = new FileReader(file)) {
                Scanner readFile = new Scanner(fr);
                String detailLine;
                String[] detailArr;  //This temp array is to store the details which is gonna be updated                                     
                while ((detailLine = readFile.nextLine()) != null) {
                    //This is to split each line using colon to check if the username is present
                    detailArr = detailLine.split(":");
                    //If the username is present, add the old data
                    //Add the new data in the temporary array                  
                          
                    if (detailArr[0].equals(trainingid)) {                        
                        userArray.add(detailArr[0] + ":"
                                + detailArr[1]+ ":"
                                + detailArr[2] + ":"
                                + detailArr[3]+ ":"
                                + detailArr[4] + ":"
                                + detailArr[5]+ ":"
                                + "*" + ":"
                                + "*" + ":" 
                                + detailArr[8]);
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
                        JOptionPane.showMessageDialog(null, "Booking has been deleted successfully!", "Booking successfully deleted!", JOptionPane.INFORMATION_MESSAGE);
                        pw.close();              
                        clearTxtFields();
                        //this will refresh the table when it is successful
                        DefaultTableModel model = (DefaultTableModel) tblTrainingSession.getModel();
                        model.setRowCount(0);
                        getBookedTrainingSlotDetails();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(CentreManager_ManageBookingTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Booking has not been updated successfully!", "Error Occured!", JOptionPane.ERROR_MESSAGE);
                }
        
        } catch (Exception e) {
    
        }

    }
     
     
    
    //This method for Jframe initiation
    public void initGUI() {

        //setting the frame name
        this.setTitle("Manage Booked Training Sesssions");
                   
        //This will padding for the textfields
        txtCusName.setBorder(BorderFactory.createCompoundBorder(txtCusName.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtFees.setBorder(BorderFactory.createCompoundBorder(txtFees.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));

        //This sets the items not focusable
        btnUpdate.setFocusable(false);
        btnClear.setFocusable(false);
        btnGoBack.setFocusable(false);
        tblTrainingSession.setFocusable(false);
        tblTrainingSession.setDefaultEditor(Object.class, null);

        
        //This disbables the fields
         btnUpdate.setEnabled(false);
         btnClear.setEnabled(false);
         btnDelete.setEnabled(false);
       
         //This makes the texfield not editable
         txtCusName.setEditable(false);
         txtTrainingDate.setEditable(false);
         txtTrainerName.setEditable(false);
         txtTrainingTime.setEditable(false);
         
        
        //This will restrict from changing contents in the table
        tblTrainingSession.setDefaultEditor(Object.class, null);
        
        //get training details into table
        getBookedTrainingSlotDetails(); 
        
        //Getting  IDs
        getTrainingID();
        getCustomerID();
        
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
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> chkCustomerID;
    private javax.swing.JComboBox<String> chkTrainingID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBookingID;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPaymentAmount;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTrainerName;
    private javax.swing.JTable tblTrainingSession;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JFormattedTextField txtFees;
    private javax.swing.JTextField txtTrainerName;
    private javax.swing.JTextField txtTrainingDate;
    private javax.swing.JTextField txtTrainingTime;
    // End of variables declaration//GEN-END:variables
}
