/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
public class CentreManager_BookingTrainingSession extends javax.swing.JFrame {
     private final String trainingSlotsDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt";
     private final String userDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\User.txt";
     private String cusID,trainerID, trainingID, todayFormattedDate, formattedDate;
     DecimalFormat deciFormat = new DecimalFormat("0000");
     private Date trainingDate;
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     Date today = new Date();

    
    /**
     * Creates new form BookingTrainingSession
     */
    public CentreManager_BookingTrainingSession() {
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
       if (chkCustomerID.getSelectedIndex()>0 && trainingDate != null && chkTrainingID.getSelectedIndex()> 0 && chkTrainingTime.getSelectedIndex() > 0 &&  !txtFees.getText().isEmpty()) {
            btnBook.setEnabled(true);
            btnClear.setEnabled(true);
        } else {
            btnBook.setEnabled(false);
            btnClear.setEnabled(false);
        }
    }
    
    
     //This gets the training slot details from the textfile to the table
     private void getTrainingSlotDetails() {
        try {
            todayFormattedDate= dateFormat.format(today);
            DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM yy");
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
                      String trainingID = userDataRow[0];
                      String trainerName = userDataRow[2];
                      Date date = dateFormat.parse(userDataRow[3]);
                      String formatTableDate = dateFormatTable.format(date);
                      String startTime = userDataRow[4];
                      String endTime = userDataRow[5];
                      String status = userDataRow[6];
                      if ("*".equals(status)){
                         status = "Not Booked";                   
                      }else{                         
                         status = "Booked";
                      }
                   if(userDataRow[3].compareTo(todayFormattedDate) >= 0){
                       model.addRow(new Object[] {trainingID, trainerName, formatTableDate, startTime,endTime, status});
                   }
            }
        } catch (Exception ex) {
            Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //This method retrieves the details from the jtabel and set it inside the respective fields when the user cell click.
    private void selectRowTable() {
         try {
             DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM yy");
             enableBtn();
             int index = tblTrainingSession.getSelectedRow();
             
             TableModel model = tblTrainingSession.getModel();
             String trainingid = model.getValueAt(index, 0).toString();
             Date trainingdate = dateFormatTable.parse(model.getValueAt(index, 2).toString());
             String startime = model.getValueAt(index, 3).toString();;
             String endtime = model.getValueAt(index, 4).toString();;
             String status = model.getValueAt(index, 5).toString();;
                       
             if(status == "Booked"){
                 JOptionPane.showMessageDialog(null, "The selected training session has been booked!", "Training  Booked!", JOptionPane.ERROR_MESSAGE);               
             }else{
                 trainingID = trainingid;
                 chkTrainingID.setSelectedItem(trainingid);
                 dateTraining.setDate(trainingdate);
                 chkTrainingTime.setSelectedItem(startime + " - "+ endtime);
             }
         } catch (ParseException ex) {
             Logger.getLogger(CentreManager_BookingTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
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
        btnBook = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        chkCustomerID = new javax.swing.JComboBox<>();
        lblCustomerID = new javax.swing.JLabel();
        lblTrainerID = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        chkTrainingID = new javax.swing.JComboBox<>();
        chkTrainingTime = new javax.swing.JComboBox<>();
        lblPaymentAmount = new javax.swing.JLabel();
        dateTraining = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrainingSession = new javax.swing.JTable();
        txtCusName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtFees = new javax.swing.JTextField();
        btnManage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 900));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(230, 241, 255));
        lblTitle.setText("Booking Training Session");

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

        btnBook.setBackground(new java.awt.Color(204, 255, 204));
        btnBook.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBook.setForeground(new java.awt.Color(0, 51, 51));
        btnBook.setText("Book");
        btnBook.setActionCommand("Update");
        btnBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookMouseEntered(evt);
            }
        });
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
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

        lblTrainerID.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTrainerID.setForeground(new java.awt.Color(100, 255, 218));
        lblTrainerID.setText("Training ID :");

        lblDate.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(100, 255, 218));
        lblDate.setText("Training Date :");

        lblTime.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(100, 255, 218));
        lblTime.setText("Training Time :");

        chkTrainingID.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainingID.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainingID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---" }));
        chkTrainingID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrainingIDActionPerformed(evt);
            }
        });

        chkTrainingTime.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainingTime.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainingTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---" }));
        chkTrainingTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrainingTimeActionPerformed(evt);
            }
        });

        lblPaymentAmount.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblPaymentAmount.setForeground(new java.awt.Color(100, 255, 218));
        lblPaymentAmount.setText("Fees :");

        dateTraining.setBackground(new java.awt.Color(255, 255, 255));
        dateTraining.setDateFormatString("dd MMM yyyy");
        dateTraining.setMaxSelectableDate(new java.util.Date(253370736000000L));
        dateTraining.setMinSelectableDate(new java.util.Date(-62135798400000L));
        dateTraining.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTrainingPropertyChange(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tblTrainingSession.setBackground(new java.awt.Color(255, 255, 255));
        tblTrainingSession.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        tblTrainingSession.setForeground(new java.awt.Color(0, 0, 0));
        tblTrainingSession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Training ID", "Trainer Name", "Date", "Start Time", "End Time", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        txtCusName.setBackground(new java.awt.Color(255, 255, 255));
        txtCusName.setFont(new java.awt.Font("Lao Sangam MN", 1, 16)); // NOI18N
        txtCusName.setForeground(new java.awt.Color(0, 0, 0));
        txtCusName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 255, 204)));
        txtCusName.setPreferredSize(new java.awt.Dimension(89, 22));

        lblName.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(100, 255, 218));
        lblName.setText("Customer Name:");

        txtFees.setBackground(new java.awt.Color(255, 255, 255));
        txtFees.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtFees.setForeground(new java.awt.Color(0, 0, 0));
        txtFees.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 255, 204)));
        txtFees.setCaretColor(new java.awt.Color(237, 237, 237));
        txtFees.setMinimumSize(new java.awt.Dimension(64, 20));
        txtFees.setPreferredSize(new java.awt.Dimension(64, 20));
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

        btnManage.setBackground(new java.awt.Color(204, 255, 204));
        btnManage.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnManage.setForeground(new java.awt.Color(0, 51, 51));
        btnManage.setText("Manage Booking");
        btnManage.setActionCommand("Update");
        btnManage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnManage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManageMouseEntered(evt);
            }
        });
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCustomerID, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(lblTrainerID)
                                                .addGap(8, 8, 8)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(chkCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chkTrainingID, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblDate)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dateTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblName)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFees, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(chkTrainingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(63, 63, 63))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSystemName, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblTitle)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(134, 134, 134))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrainerID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkTrainingID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkTrainingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFees, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblSystemName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTitle))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackMouseEntered

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        int selection = JOptionPane.showConfirmDialog(null, "Going back to main menu will cancel the ongoing booking training sessions. Continue?", "Returning to Main Menu!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            this.dispose();
            openFrame openFrame = new openFrame();
            openFrame.openManagerMainMenu();
        }
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBookMouseEntered

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
         try {
             bookSlot();
             //addPayment(trainerID, (String) chkCustomerID.getSelectedItem(), (String) chkTrainerID.getSelectedItem(), txtFees.getText(), today); 
         } catch (Exception ex) {
             Logger.getLogger(CentreManager_BookingTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       clearTxtFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void dateTrainingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTrainingPropertyChange
        
        if(dateTraining.getDate() != null){         
             if(!checkTrainingSlots(dateTraining.getDate())){
                    JOptionPane.showMessageDialog(null, "There is no  training session available for the date. Please schedule sessions to book! ", "No session found!", JOptionPane.ERROR_MESSAGE);
                    dateTraining.setDate(null);
               }else{                                    
                    enableBtn();     
             }
             
         }
              
    }//GEN-LAST:event_dateTrainingPropertyChange

    private void tblTrainingSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainingSessionMouseClicked
        selectRowTable();
    }//GEN-LAST:event_tblTrainingSessionMouseClicked

    private void chkCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCustomerIDActionPerformed
        enableBtn();
        getCustomerName();
    }//GEN-LAST:event_chkCustomerIDActionPerformed

    private void chkTrainingIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainingIDActionPerformed
        enableBtn();
        getTrainingSlot();
    }//GEN-LAST:event_chkTrainingIDActionPerformed

    private void chkTrainingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainingTimeActionPerformed
        enableBtn();
    }//GEN-LAST:event_chkTrainingTimeActionPerformed

    private void txtFeesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFeesFocusLost
        
    }//GEN-LAST:event_txtFeesFocusLost

    private void txtFeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFeesActionPerformed

    }//GEN-LAST:event_txtFeesActionPerformed

    private void txtFeesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFeesKeyPressed
       enableBtn();
    }//GEN-LAST:event_txtFeesKeyPressed

    private void btnManageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManageMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManageMouseEntered

    private void btnManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageActionPerformed
             this.dispose();
             openFrame openFrame = new openFrame();
             openFrame.openManagerManageBookingSession();
    }//GEN-LAST:event_btnManageActionPerformed

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
            java.util.logging.Logger.getLogger(CentreManager_BookingTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentreManager_BookingTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentreManager_BookingTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentreManager_BookingTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentreManager_BookingTrainingSession().setVisible(true);
            }
        });
    }
    
        
    private void clearTxtFields(){
            chkCustomerID.setSelectedIndex(0);
            txtCusName.setText("");
            chkTrainingID.setSelectedIndex(0);
            dateTraining.setDate(null);          
            chkTrainingTime.setSelectedIndex(0);
            txtFees.setText("");           
    }
    
    private void validateInput() throws Exception { 
         TrainingFeesValidation invalidate = new TrainingFeesValidation();
         if ("".equals(txtFees.getText()) || "RM".equals(txtFees.getText()) ) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please input valid training fees to update booking. Eg RM10.10", "Invalid insertion detected!", JOptionPane.WARNING_MESSAGE);     
         }else if (!"".equals(txtFees.getText()) && !"RM".equals(txtFees.getText()) && invalidate.runValidate(txtFees, false)) {
             throw new Exception("Invalid fees format");
         } else if(recordExist(dateTraining.getDate(), (String) chkTrainingTime.getSelectedItem(), (String) chkCustomerID.getSelectedItem())){
             JOptionPane.showMessageDialog(null, "The customer has booked training session for picked date and time", "Booking Exists!", JOptionPane.ERROR_MESSAGE);
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
  
      
    public final void getTrainingSlot() {    
        try {
           trainerID = chkTrainingID.getSelectedItem().toString(); 
           formattedDate= dateFormat.format(dateTraining.getDate());
           File trainingFile = new File(trainingSlotsDB);
           Scanner readFile = new Scanner(trainingFile);
           chkTrainingTime.removeAllItems();
           chkTrainingTime.addItem("---none---");
            while (readFile.hasNextLine()){
                 String line = readFile.nextLine();
                 String detailArray[] = line.split(":");
                 if (trainerID.equals(detailArray[0])) {
                     chkTrainingTime.addItem(detailArray[4] + " - " + detailArray[5]);
                     trainerID = detailArray[1];
                 }
         
            }
            readFile.close();
        } catch (Exception e) {

        }

    }
 
      
      //This will check the available slots for the day
     private boolean checkTrainingSlots(Date slotDate){       
        boolean slotFound = false;
        String detailArray[];
         try {
             File trainingFile = new File(trainingSlotsDB);
             Scanner readFile = new Scanner(trainingFile);
             chkTrainingID.removeAllItems();
             chkTrainingID.addItem("---none---");
             while (readFile.hasNextLine()){
                 String line = readFile.nextLine();
                 detailArray = line.split(":");
                 formattedDate= dateFormat.format(slotDate);
                 if (formattedDate.compareTo(detailArray[3]) == 0 && "*".equals(detailArray[6])) {
                     chkTrainingID.addItem(detailArray[0]);
                     slotFound = true;
                 }
              }
             readFile.close();
        } catch (Exception ex) {

        }
        return slotFound;
    }
     
     
           
    //This method is to check whether the selected record already exist or nope
    public boolean recordExist(Date trainingDate, String trainingTime, String cusID) {
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
                //formatting date
                formattedDate = dateFormat.format(trainingDate);
                System.out.println(formattedDate);
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
    private void bookSlot() throws Exception {
        //This sets the file directory
        File trainingFile = new File(trainingSlotsDB);
        ArrayList<String> trainingArray = new ArrayList<>();  //This is for temporary array to hold the staff data
        try {
               String trainingID  = (String) chkTrainingID.getSelectedItem();
               String[] fees = txtFees.getText().split("RM",2);
               String cusID = (String)chkCustomerID.getSelectedItem();
            
          try ( FileReader fr = new FileReader(trainingFile)) {
                Scanner readFile = new Scanner(fr);
                String detailLine;
                String[] detailArr;  //This temp array is to store the details which is gonna be updated                                     
                while ((detailLine = readFile.nextLine()) != null) {
                    //This is to split each line using colon to check if the username is present
                    detailArr = detailLine.split(":");
                    //If the training is present, add the old data
                    //Add the new data in the temporary array
                                    
                    if (detailArr[0].equals(trainingID) && "*".equals(detailArr[6])) {
                        trainingArray.add(detailArr[0] + ":"
                                + detailArr[1]+ ":"
                                + detailArr[2] + ":"
                                + detailArr[3]+ ":"
                                + detailArr[4] + ":"
                                + detailArr[5]+ ":"
                                + cusID+ ":"
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
            if(!"".equals(txtFees.getText()) && !"RM".equals(txtFees.getText()) && invalidate.runValidate(txtFees, false)){
                 throw new Exception("Invalid fees format");
            }else if (invalidate.runValidate(txtFees, false)){
                throw new Exception("Invalid fees format");  
            }else if(recordExist(dateTraining.getDate(), (String) chkTrainingTime.getSelectedItem(), (String) chkCustomerID.getSelectedItem())){    
                System.out.println("im working");
                throw new Exception("Record exists");           
            }else{                  
             boolean hasUpdated = false;
                //this is to set the bufferd write to write the data into temporary array again back to text file        
                try (PrintWriter pw = new PrintWriter(trainingFile)) {
                    for (String str : trainingArray) {
                        pw.println(str); //this will write all the data in the temporary array back to the file line by line
                        hasUpdated = true;
                    }
                    //This will display a success message indicates that the details has been updated
                    if (hasUpdated) {
                        JOptionPane.showMessageDialog(null, "Training has been booked successfully!", "Training successfully booked!", JOptionPane.INFORMATION_MESSAGE);
                        pw.close();
                        clearTxtFields();
                        //this will refresh the table when it is successful
                        DefaultTableModel model = (DefaultTableModel) tblTrainingSession.getModel();
                        model.setRowCount(0);
                        getTrainingSlotDetails();
                    }

                }      
        } 
                
        } catch (Exception e) {
            validateInput();

        }

    }
    
    
   
    //This method for Jframe initiation
    public void initGUI() {

        //setting the frame name
        this.setTitle("Booking Training Sesssions");
                   
        //This will padding for the textfields
        txtCusName.setBorder(BorderFactory.createCompoundBorder(txtCusName.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtFees.setBorder(BorderFactory.createCompoundBorder(txtFees.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));

        //This sets the items not focusable
        btnBook.setFocusable(false);
        btnClear.setFocusable(false);
        btnGoBack.setFocusable(false);
        btnManage.setFocusable(false);
        tblTrainingSession.setFocusable(false);
        tblTrainingSession.setDefaultEditor(Object.class, null);

        
        //This disbables the fields
         btnBook.setEnabled(false);
         btnClear.setEnabled(false);
         
         //This makes the texfield not editable
         txtCusName.setEditable(false);
         
         //disabling user input from keyboard
         JTextFieldDateEditor editor = (JTextFieldDateEditor) dateTraining.getDateEditor();
         editor.setEditable(false);
      
        //This will restrict from changing contents in the table
        tblTrainingSession.setDefaultEditor(Object.class, null);
        
        //Disable past dates from date picker
        dateTraining.getJCalendar().setMinSelectableDate(today);

        
        //get training details into table
        getTrainingSlotDetails(); 
        
        //Getting Customer IDs
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
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnManage;
    private javax.swing.JComboBox<String> chkCustomerID;
    private javax.swing.JComboBox<String> chkTrainingID;
    private javax.swing.JComboBox<String> chkTrainingTime;
    private com.toedter.calendar.JDateChooser dateTraining;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPaymentAmount;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTrainerID;
    private javax.swing.JTable tblTrainingSession;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtFees;
    // End of variables declaration//GEN-END:variables
}
