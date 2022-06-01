/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Prem Sharaan
 */
public class CentreManager_ManageSchedule extends javax.swing.JFrame {
 private final String trainingSlotsDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt";
    private final String userDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\User.txt";
    private String projectDir, trainingSessionID,trainerID, formattedDate, todayFormattedDate;
    private Date trainingDate;
    //This variable will be used to scan the text file for deleting training session details process
    private static Scanner scan;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date today = new Date();
    /**
     * Creates new form CentreManager_ManageSchedule
     */
    public CentreManager_ManageSchedule() {
        initComponents();
        initGUI();
    }
    
           //Method for clearing any available user cachr
    private void clearCache(){
         deleteSession clearSession = new deleteSession();
         clearSession.clearUserSession();
    }
 
    private void enableBtn(){
       trainingDate = dateTraining.getDate();    
       if (chkTrainingID.getSelectedIndex() >0 && trainingDate != null && chkTrainerID.getSelectedIndex()> 0 && chkTrainerStartTime.getSelectedIndex() > 0 && chkTrainerEndTime.getSelectedIndex() > 0) {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnClear.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnClear.setEnabled(false);
        }
    }
    
    
     //This gets the training slot details from the textfile to the table
     private void getTrainingSlotDetails() {
        try {
            todayFormattedDate= dateFormat.format(today);
            DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM YYYY");
            FileReader fr = new FileReader(trainingSlotsDB);
            BufferedReader br = new BufferedReader(fr);
            //This sets the table into a table model
            DefaultTableModel model = (DefaultTableModel) tblTrainingSession.getModel();
            //This is to  get line  by line from the text file
            Object[] tableLines = br.lines().toArray();
            //This is to retrieve the content from the lines in the text file and set the content in to the jtable
            for (int i = 0; i < tableLines.length; i++) {         
                String detailsline = tableLines[i].toString().trim();
                String[] trainingDataRow = detailsline.split(":");
                      String trainingID = trainingDataRow[0];
                      String trainerID = trainingDataRow[1];
                      String trainerName = trainingDataRow[2];
                      Date date = dateFormat.parse(trainingDataRow[3]);
                      String formatTableDate = dateFormatTable.format(date);
                      String startTime = trainingDataRow[4];
                      String endTime = trainingDataRow[5];
                      String status = trainingDataRow[6];
                       if ("*".equals(status)){
                         status = "Not Booked";                   
                      }else{                         
                         status = "Booked";
                      }
                   if(trainingDataRow[3].compareTo(todayFormattedDate) >= 0 && trainingDataRow[6].equals("*")){
                       System.out.println(trainingDataRow[3] + " " + todayFormattedDate);
                       model.addRow(new Object[] {trainingID, trainerID, trainerName, formatTableDate, startTime, endTime, status});
                   }
            }
        } catch (Exception ex) {
            Logger.getLogger(CentreManager_ManageSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     
    
    //This method retrieves the details from the jtabel and set it inside the respective fields when the user cell click.
    private void selectRowTable() {
     try {
         DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM yyyy");
         enableBtn();;
         int index = tblTrainingSession.getSelectedRow();
         
         TableModel model = tblTrainingSession.getModel();
         String trainingid = model.getValueAt(index, 0).toString();
         String trainerid = model.getValueAt(index, 1).toString();;
         String trainername = model.getValueAt(index, 2).toString();;
         String trainingdate = model.getValueAt(index, 3).toString();;
         String starttime = model.getValueAt(index, 4).toString();;
         String endtime = model.getValueAt(index, 5).toString();;
         
         
         trainingSessionID = trainingid;
         trainerID = trainerid;
         chkTrainingID.setSelectedItem(trainingid);
         chkTrainerID.setSelectedItem(trainerid);
         txtName.setText(trainername);
         dateTraining.setDate(dateFormatTable.parse(trainingdate));
         chkTrainerStartTime.setSelectedItem(starttime);
         chkTrainerEndTime.setSelectedItem(endtime);
     } catch (ParseException ex) {
         Logger.getLogger(CentreManager_ManageSchedule.class.getName()).log(Level.SEVERE, null, ex);
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
        lblTitle = new javax.swing.JLabel();
        lblSystemName = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblTrainingID = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        chkTrainerID = new javax.swing.JComboBox<>();
        dateTraining = new com.toedter.calendar.JDateChooser();
        lblEndTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrainingSession = new javax.swing.JTable();
        chkTrainerStartTime = new javax.swing.JComboBox<>();
        chkTrainerEndTime = new javax.swing.JComboBox<>();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        chkTrainingID = new javax.swing.JComboBox<>();
        lblTrainerID1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 900));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(230, 241, 255));
        lblTitle.setText("Manage Training Session Schedule");

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

        lblTrainingID.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTrainingID.setForeground(new java.awt.Color(100, 255, 218));
        lblTrainingID.setText("Training ID :");

        lblDate.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(100, 255, 218));
        lblDate.setText("Training Date :");

        lblTime.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(100, 255, 218));
        lblTime.setText("Training Start Time :");

        chkTrainerID.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainerID.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---" }));
        chkTrainerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrainerIDActionPerformed(evt);
            }
        });

        dateTraining.setBackground(new java.awt.Color(255, 255, 255));
        dateTraining.setDateFormatString("dd MMM yyyy");
        dateTraining.setMaxSelectableDate(new java.util.Date(253370736000000L));
        dateTraining.setMinSelectableDate(new java.util.Date(-62135798400000L));
        dateTraining.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTrainingPropertyChange(evt);
            }
        });

        lblEndTime.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblEndTime.setForeground(new java.awt.Color(100, 255, 218));
        lblEndTime.setText("Training End Time :");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tblTrainingSession.setBackground(new java.awt.Color(255, 255, 255));
        tblTrainingSession.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        tblTrainingSession.setForeground(new java.awt.Color(0, 0, 0));
        tblTrainingSession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Training ID", "Trainer ID", "Trainer Name", "Date", "Start Time", "End Time", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        chkTrainerStartTime.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainerStartTime.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainerStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---", "10.00 a.m", "11.00 a.m", "12.00 a.m", "1.00 p.m", "2.00 p.m", "3.00 p.m", "4.00 p.m", "5.00 p.m", "6.00 p.m", "7.00 p.m", "8.00 p.m", "9.00 p.m", "10.00 p.m" }));
        chkTrainerStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrainerStartTimeActionPerformed(evt);
            }
        });

        chkTrainerEndTime.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainerEndTime.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainerEndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---", "10.00 a.m", "11.00 a.m", "12.00 a.m", "1.00 p.m", "2.00 p.m", "3.00 p.m", "4.00 p.m", "5.00 p.m", "6.00 p.m", "7.00 p.m", "8.00 p.m", "9.00 p.m", "10.00 p.m" }));
        chkTrainerEndTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrainerEndTimeActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(100, 255, 218));
        lblName.setText("Trainer Name :");

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Lao Sangam MN", 1, 16)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtName.setPreferredSize(new java.awt.Dimension(89, 22));

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

        chkTrainingID.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainingID.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainingID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---" }));
        chkTrainingID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrainingIDActionPerformed(evt);
            }
        });

        lblTrainerID1.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTrainerID1.setForeground(new java.awt.Color(100, 255, 218));
        lblTrainerID1.setText("Trainer ID :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkTrainerEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTrainingID)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEndTime)
                                            .addComponent(lblDate))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblName)
                                            .addGap(38, 38, 38)))
                                    .addComponent(lblTrainerID1))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblTime)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chkTrainingID, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chkTrainerID, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chkTrainerStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblSystemName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(721, 721, 721)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkTrainingID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrainingID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkTrainerID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrainerID1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkTrainerStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkTrainerEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndTime))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1381, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackMouseEntered

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
            this.dispose();
            openFrame openFrame = new openFrame();
            openFrame.openScheduleTrainingSlots();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
           updateTrainingSession();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         clearTxtFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void chkTrainerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainerIDActionPerformed
          enableBtn();
 //       getTrainerName();
    }//GEN-LAST:event_chkTrainerIDActionPerformed

    private void dateTrainingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTrainingPropertyChange
      enableBtn();
    }//GEN-LAST:event_dateTrainingPropertyChange

    private void tblTrainingSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainingSessionMouseClicked
      selectRowTable();
    }//GEN-LAST:event_tblTrainingSessionMouseClicked

    private void chkTrainerStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainerStartTimeActionPerformed
       enableBtn();
    }//GEN-LAST:event_chkTrainerStartTimeActionPerformed

    private void chkTrainerEndTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainerEndTimeActionPerformed
        enableBtn();
    }//GEN-LAST:event_chkTrainerEndTimeActionPerformed

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (chkTrainingID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Choose the training id to proceed delete this training session.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else {
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this scheduled training session?", "Deleting training session!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (selection == JOptionPane.YES_OPTION) {
                deleteTrainingSession((String) chkTrainerID.getSelectedItem(), (String) chkTrainingID.getSelectedItem(), txtName.getText(), dateTraining.getDate(), (String) chkTrainerStartTime.getSelectedItem(), (String) chkTrainerEndTime.getSelectedItem(), "*","*","unpaid");
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void chkTrainingIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainingIDActionPerformed
        enableBtn();
        searchTrainingID((String) chkTrainingID.getSelectedItem());
    }//GEN-LAST:event_chkTrainingIDActionPerformed

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
            java.util.logging.Logger.getLogger(CentreManager_ManageSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ManageSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentreManager_ManageSchedule().setVisible(true);
            }
        });
    }
    
            
    private void clearTxtFields(){
            chkTrainingID.setSelectedIndex(0);
            chkTrainerID.setSelectedIndex(0);
            txtName.setText("");
            chkTrainerID.setSelectedIndex(0);
            dateTraining.setDate(null);          
            chkTrainerStartTime.setSelectedIndex(0);
            chkTrainerEndTime.setSelectedIndex(0);      
    }
    
    
    
     private void validateInput() {
        if (chkTrainerStartTime.getSelectedIndex() >= chkTrainerEndTime.getSelectedIndex()) {
             chkTrainerStartTime.setSelectedIndex(0);
             chkTrainerEndTime.setSelectedIndex(0);
             JOptionPane.showMessageDialog(null, "Invalid End Time Selection! Please input end time bigger than the start time.", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);
        } else if(recordExist((String) chkTrainerID.getSelectedItem(),dateTraining.getDate(), (String) chkTrainerStartTime.getSelectedItem(),(String) chkTrainerEndTime.getSelectedItem())){ 
             JOptionPane.showMessageDialog(null, "Training Session Record Exists.", "Record Exists!", JOptionPane.ERROR_MESSAGE);
        }
      
     }
    
     
    //This method is to check whether the selected record already exist or nope
    public boolean recordExist(String trainerID, Date trainingDate, String startTime, String endTime ) {
        boolean notFound = false;
        // This array is to store all lines
        String[] trainingDetails;

        try {
            // This sets the file which going to be accessed
            File trainingFile = new File(trainingSlotsDB);
            if (!trainingFile.exists()) {
                trainingFile.createNewFile();
            }
            Scanner searchDetails = new Scanner(trainingFile);
            // Read till last line of file
            while (searchDetails.hasNext()) {
                // Read the next line.
                String inputTraining = searchDetails.nextLine();
                // Split the details by using the colon and store in an array.
                trainingDetails = inputTraining.split(":");
                //formatting date
                formattedDate = dateFormat.format(trainingDate);
                if (trainerID.equals(trainingDetails[1]) && formattedDate.equals(trainingDetails[3]) && startTime.equals(trainingDetails[4]) &&  endTime.equals(trainingDetails[5]) ) {
                    notFound = true;
                }
            }
            searchDetails.close();
        } catch (Exception ex) {

        }
        return notFound;
    }  
           
    
    public final void getTrainingID() {    
        try {
           todayFormattedDate= dateFormat.format(today); 
           File userFile = new File(trainingSlotsDB);
           Scanner readFile = new Scanner(userFile);
            while (readFile.hasNextLine()){
                 String line = readFile.nextLine();
                 String detailArray[] = line.split(":");
                 if (detailArray[3].compareTo(todayFormattedDate) >= 0 && detailArray[6].equals("*")) {
                     chkTrainingID.addItem(detailArray[0]);
                 }
         
            }
            readFile.close();
        } catch (Exception e) {

        }

    }
    
      
     public final void getTrainerName() {    
        try {
           trainerID = chkTrainerID.getSelectedItem().toString(); 
           File userFile = new File(userDB);
           Scanner readFile = new Scanner(userFile);
            while (readFile.hasNextLine()){
                 String line = readFile.nextLine();
                 String detailArray[] = line.split(":");
                 if (trainerID.equals(detailArray[0])) {
                    txtName.setText((detailArray[2]));
                 }
         
            }
            readFile.close();
        } catch (Exception e) {

        }

    }
    
   
    
    public final void getTrainerID() {    
            try {
               File userFile = new File(userDB);
               Scanner readFile = new Scanner(userFile);
                while (readFile.hasNextLine()){
                     String line = readFile.nextLine();
                     String detailArray[] = line.split(":");
                     if ("Centre Trainer".equals(detailArray[1]) && "true".equals(detailArray[9])) {
                         chkTrainerID.addItem(detailArray[0]);
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
            DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM yy");
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
                } else if (trainingid.equals(trainingDetails[0]) && "*".equals(trainingDetails[6])) {
                    trainingSessionID = trainingDetails[0];
                    trainerID = trainingDetails[1]; ;
                    chkTrainingID.setSelectedItem(trainingSessionID);
                    chkTrainerID.setSelectedItem(trainerID);
                    txtName.setText(trainingDetails[2]);
                    Date date = dateFormat.parse(trainingDetails[3]);
                    String formatTableDate = dateFormatTable.format(date);
                    dateTraining.setDate(dateFormatTable.parse(formatTableDate));
                    chkTrainerStartTime.setSelectedItem(trainingDetails[4]);
                    chkTrainerEndTime.setSelectedItem(trainingDetails[5]);
                    
                    hasRecord = true;
                    enableBtn();
                }
            }
            searchTrainingID.close();
        } catch (Exception ex) {

        }

    }
     
     
     
     //This method will update new user details
    private void updateTrainingSession() {
        File file = new File(trainingSlotsDB);
        ArrayList<String> userArray = new ArrayList<>();  //This is for temporary array to hold the user data
        try {
                    
                //This will get all details and set the details into a variable
                String trainingid = trainingSessionID;
                String trainerID = (String) chkTrainerID.getSelectedItem();
                String trainername = txtName.getText();
                Date dob = dateTraining.getDate();
                formattedDate = dateFormat.format(dob);
                String starttime = (String) chkTrainerStartTime.getSelectedItem();
                String endtime = (String) chkTrainerEndTime.getSelectedItem();

            
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
                                + trainerID + ":"
                                + trainername + ":"
                                + formattedDate + ":"
                                + starttime+ ":"
                                + endtime + ":" 
                                + detailArr[6] + ":"
                                + detailArr[7] + ":" 
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
            
            //This throws and shows the message when user selected start time bigger than end time
            if (chkTrainerStartTime.getSelectedIndex() >= chkTrainerEndTime.getSelectedIndex()) {
                throw new Exception("Invalid Start Time or End Time!");
            }else if(recordExist((String) chkTrainerID.getSelectedItem(),dateTraining.getDate(), (String) chkTrainerStartTime.getSelectedItem(),(String) chkTrainerEndTime.getSelectedItem())){ 
                  throw new Exception("Record Exists.");   
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
                        JOptionPane.showMessageDialog(null, "Training session has been updated successfully!", "Training Session successfully updated!", JOptionPane.INFORMATION_MESSAGE);
                        pw.close();              
                        clearTxtFields();
                        //this will refresh the table when it is successful
                        DefaultTableModel model = (DefaultTableModel) tblTrainingSession.getModel();
                        model.setRowCount(0);
                        getTrainingSlotDetails();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(CentreManager_ManageSchedule.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Training Details has not been updated successfully!", "Error Occured!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            validateInput();
        }

    } 


 
//     //This method delete the training sessionn details based on the training ID
    public void deleteTrainingSession(String TrainingID, String TrainerID, String TrainerName , Date Date, String StartTime, String EndTime, String Customer, String Fees, String Status) {     
        String trainingID = trainingSessionID;
        System.out.println(trainingID);
         //This sets the file directory of the project
        String tempFile = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\tempTraining.txt";
        File oldFile = new File(trainingSlotsDB); 
        File newFile = new File(tempFile);
        
        String currentLine;
        String data[];
        try {           
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            FileReader fr = new FileReader(trainingSlotsDB);
            BufferedReader br =  new BufferedReader(fr);
            
            while((currentLine = br.readLine()) != null){
                data = currentLine.split(":");
               if(!data[0].equalsIgnoreCase(trainingID)){
                   pw.println(currentLine);
               }
            }
       
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            //This will delete the old file
            oldFile.delete();
            //This renames the new file
            File rename = new File(trainingSlotsDB);
            newFile.renameTo(rename);
            
            clearTxtFields();
            DefaultTableModel model = (DefaultTableModel) tblTrainingSession.getModel();
            model.setRowCount(0);
            getTrainingSlotDetails();
            chkTrainingID.removeAllItems();
            chkTrainingID.addItem("---none---");
            getTrainingID();
            JOptionPane.showMessageDialog(null, "Scheduled training session has been deleted successfully!", "Trsining Sesssion successfully deleted!", JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! Training Session has not been deleted", "Error Occured!", JOptionPane.ERROR_MESSAGE);
            
        }
     
    }  
    
   
       //This method for Jframe initiation
    public void initGUI() {

        //setting the frame name
        this.setTitle("Manage Scheduled Training Sesssions");
                   
        //This will padding for the textfields
        txtName.setBorder(BorderFactory.createCompoundBorder(txtName.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        
        //This sets the items not focusable
        btnUpdate.setFocusable(false);
        btnClear.setFocusable(false);
        btnGoBack.setFocusable(false);
        tblTrainingSession.setFocusable(false);
        btnDelete.setFocusable(false);
        
        //This disbables the fields
         btnUpdate.setEnabled(false);
         btnClear.setEnabled(false);
         btnDelete.setEnabled(false);
         
         //This makes the texfield not editable
         txtName.setEditable(false);
         
         //disabling user input from keyboard
         JTextFieldDateEditor editor = (JTextFieldDateEditor) dateTraining.getDateEditor();
         editor.setEditable(false);
      
        //This will restrict from changing contents in the table
        tblTrainingSession.setDefaultEditor(Object.class, null);
        
        //Disable past dates from date picker
        dateTraining.getJCalendar().setMinSelectableDate(today);


        //Getting training ID
        getTrainingID();
        
        //Getting Trainer IDs
        getTrainerID();
        
        
        //get training details into table
        getTrainingSlotDetails(); 
        
        
        
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
    private javax.swing.JComboBox<String> chkTrainerEndTime;
    private javax.swing.JComboBox<String> chkTrainerID;
    private javax.swing.JComboBox<String> chkTrainerStartTime;
    private javax.swing.JComboBox<String> chkTrainingID;
    private com.toedter.calendar.JDateChooser dateTraining;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTrainerID1;
    private javax.swing.JLabel lblTrainingID;
    private javax.swing.JTable tblTrainingSession;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
