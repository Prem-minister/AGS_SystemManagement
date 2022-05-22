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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Prem Sharaan
 */
public class CentreManager_ScheduleTraining extends javax.swing.JFrame {
    private final String trainingSlotsDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt";
    private final String userDB = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\User.txt";
    private String trainingSessionID,trainerID, formattedDate, todayFormattedDate;
    private int newTrainingID;
    private Date trainingDate;
    private final String userPrefixID = "TRS";
    DecimalFormat deciFormat = new DecimalFormat("0000");
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date today = new Date();
    
    /**
     * Creates new form ScheduleTrainingSession
     */
    public CentreManager_ScheduleTraining() {
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
       if (trainingDate != null && chkTrainerID.getSelectedIndex()> 0 && chkTrainerStartTime.getSelectedIndex() > 0 && chkTrainerEndTime.getSelectedIndex() > 0) {
            btnAdd.setEnabled(true);
            btnClear.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
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
                String[] staffDataRow = detailsline.split(":");
                      String trainingID = staffDataRow[0];
                      String trainerName = staffDataRow[2];
                      Date date = dateFormat.parse(staffDataRow[3]);
                      String formatTableDate = dateFormatTable.format(date);
                      String startTime = staffDataRow[4];
                      String endTime = staffDataRow[5];
                      String status = staffDataRow[6];
                      if ("*".equals(status)){
                         status = "Not Booked";                   
                      }else{                         
                         status = "Booked";
                      }
                   if(staffDataRow[3].compareTo(todayFormattedDate) >= 0){
                       System.out.println(staffDataRow[3] + " " + todayFormattedDate);
                       model.addRow(new Object[] {trainingID, trainerName, formatTableDate, startTime,endTime, status});
                   }
            }
        } catch (Exception ex) {
            Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(Level.SEVERE, null, ex);
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
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblTrainerID = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 900));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(230, 241, 255));
        lblTitle.setText("Scheduling Training Session");

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

        btnAdd.setBackground(new java.awt.Color(204, 255, 204));
        btnAdd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 51, 51));
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        lblTrainerID.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTrainerID.setForeground(new java.awt.Color(100, 255, 218));
        lblTrainerID.setText("Trainer ID :");

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

        chkTrainerStartTime.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainerStartTime.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainerStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---", "10.00 a.m", "11.00 a.m", "12.00 a.m", "1.00  p.m", "2.00  p.m", "3.00  p.m", "4.00  p.m", "5.00  p.m", "6.00  p.m", "7.00  p.m", "8.00  p.m", "9.00  p.m", "10.00 p.m" }));
        chkTrainerStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrainerStartTimeActionPerformed(evt);
            }
        });

        chkTrainerEndTime.setBackground(new java.awt.Color(255, 255, 255));
        chkTrainerEndTime.setForeground(new java.awt.Color(0, 0, 0));
        chkTrainerEndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---none---", "10.00 a.m", "11.00 a.m", "12.00 a.m", "1.00  p.m", "2.00  p.m", "3.00  p.m", "4.00  p.m", "5.00  p.m", "6.00  p.m", "7.00  p.m", "8.00  p.m", "9.00  p.m", "10.00 p.m" }));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblSystemName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTrainerID)
                        .addGap(103, 103, 103))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTime)
                                .addComponent(lblEndTime)
                                .addComponent(lblDate)
                                .addComponent(lblName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkTrainerID, 0, 262, Short.MAX_VALUE)
                    .addComponent(dateTraining, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(chkTrainerStartTime, 0, 262, Short.MAX_VALUE)
                    .addComponent(chkTrainerEndTime, 0, 262, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
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
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkTrainerID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrainerID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkTrainerStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkTrainerEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndTime))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackMouseEntered

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
       int selection = JOptionPane.showConfirmDialog(null, "Going back to main menu will cancel the ongoing adding training sessions. Continue?", "Returning to Main Menu!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            this.dispose();
            openFrame openFrame = new openFrame();
            openFrame.openManagerMainMenu();
        }
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addTrainingSlots((String) chkTrainerID.getSelectedItem(), txtName.getText(), dateTraining.getDate(),(String)chkTrainerStartTime.getSelectedItem(),(String) chkTrainerEndTime.getSelectedItem());

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearTxtFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void dateTrainingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTrainingPropertyChange
       enableBtn();

    }//GEN-LAST:event_dateTrainingPropertyChange

    private void tblTrainingSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainingSessionMouseClicked

    }//GEN-LAST:event_tblTrainingSessionMouseClicked

    private void chkTrainerStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainerStartTimeActionPerformed
        enableBtn();
    }//GEN-LAST:event_chkTrainerStartTimeActionPerformed

    private void chkTrainerEndTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainerEndTimeActionPerformed
        enableBtn();

    }//GEN-LAST:event_chkTrainerEndTimeActionPerformed

    private void chkTrainerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrainerIDActionPerformed
        enableBtn();
       getTrainerName();
    }//GEN-LAST:event_chkTrainerIDActionPerformed

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
            java.util.logging.Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentreManager_ScheduleTraining().setVisible(true);
            }
        });
    }
    
     private void clearTxtFields(){
            chkTrainerID.setSelectedIndex(0);
            txtName.setText("");
            dateTraining.setDate(null);          
            chkTrainerStartTime.setSelectedIndex(0);
            chkTrainerEndTime.setSelectedIndex(0);
            trainingSessionID = "";
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
     
    
    //This method is to increment the trainingsessionID
    private void trainingIDIncrementor() {
        boolean hasTrainingIDRecord = false;
        // This array is to store all lines
        String[] trainingDetails = null;
        try {
            // This sets the directory of the project
            File trainingFile = new File(trainingSlotsDB);
            if (!trainingFile.exists()) {
                trainingFile.createNewFile();
            }
            Scanner readFile;
            try {
                // Read lines from the file until no more are left.
                readFile = new Scanner(trainingFile);
                while (readFile.hasNext()) {
                    // Read the next line.
                    String nextTraining = readFile.nextLine();

                    // Split the line by using the colon ":" and store into  an array.
                    trainingDetails = nextTraining.split(":");
                    trainingDetails[0] = trainingDetails[0].replace("TRS", "");
                    hasTrainingIDRecord = true;
                }
                readFile.close();
                if (!hasTrainingIDRecord) {
                    JOptionPane.showMessageDialog(null, "The system does not find any training session details inside the text file", "Training Record is empty!", JOptionPane.ERROR_MESSAGE);
                    newTrainingID = 1;
                } else {
                    newTrainingID = Integer.parseInt(trainingDetails[0]) + 1;
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "Invalid input Training ID", "Invalid ID!", JOptionPane.ERROR_MESSAGE);
        }
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

    
    
    // This method handles the staff registration
    private void addTrainingSlots(String trainerID, String trainerName, Date trainingDate, String trainingStartTime, String trainingEndTime) {
         recordExist((String) chkTrainerID.getSelectedItem(),dateTraining.getDate(), (String) chkTrainerStartTime.getSelectedItem(),(String) chkTrainerEndTime.getSelectedItem());     
          try {          
             // To check whether inserted record exists
              if (recordExist((String) chkTrainerID.getSelectedItem(),dateTraining.getDate(), (String) chkTrainerStartTime.getSelectedItem(),(String) chkTrainerEndTime.getSelectedItem())){
                throw new Exception("Record Exists.");
              }
              
              //This throws and shows the message when user selected start time bigger than end time
              if (chkTrainerStartTime.getSelectedIndex() >= chkTrainerEndTime.getSelectedIndex()) {
                throw new Exception("Invalid Start Time or End Time!");
              }
            try {
                trainingSessionID = deciFormat.format(newTrainingID);
                formattedDate= dateFormat.format(trainingDate);
                FileWriter fw = new FileWriter(trainingSlotsDB, true);
                BufferedWriter bw  = new BufferedWriter(fw);
                bw.write(userPrefixID + trainingSessionID + ":" + trainerID + ":" + trainerName+ ":" + formattedDate + ":" + trainingStartTime + ":" +  trainingEndTime + ":" +  "*"  + "\n");
                JOptionPane.showMessageDialog(null, "New Training Session has be addedd successfully", "Training Session successfully added!", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
                trainingIDIncrementor();
                 //this will refresh the table when it is successful
                 DefaultTableModel model = (DefaultTableModel) tblTrainingSession.getModel();
                 model.setRowCount(0);
                 getTrainingSlotDetails();
                 clearTxtFields();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CentreManager_ScheduleTraining.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
               validateInput();
        }
    }


    
    //This method for Jframe initiation
    public void initGUI() {

        //setting the frame name
        this.setTitle("Scheduling Training Sesssions");
                   
        //This will padding for the textfields
        // chkTrainerID.setBorder(BorderFactory.createCompoundBorder(chkTrainerID.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        txtName.setBorder(BorderFactory.createCompoundBorder(txtName.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        //dateTraining.setBorder(BorderFactory.createCompoundBorder(dateTraining.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        //chkTrainerStartTime.setBorder(BorderFactory.createCompoundBorder(chkTrainerStartTime.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
        //chkTrainerEndTime.setBorder(BorderFactory.createCompoundBorder(chkTrainerEndTime.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
          
        //This sets the items not focusable
        btnAdd.setFocusable(false);
        btnClear.setFocusable(false);
        btnGoBack.setFocusable(false);
        tblTrainingSession.setFocusable(false);
        
        //This disbables the fields
         btnAdd.setEnabled(false);
         btnClear.setEnabled(false);
         
         //This makes the texfield not editable
         txtName.setEditable(false);
         
         //disabling user input from keyboard
         JTextFieldDateEditor editor = (JTextFieldDateEditor) dateTraining.getDateEditor();
         editor.setEditable(false);
      
        //This will restrict from changing contents in the table
        tblTrainingSession.setDefaultEditor(Object.class, null);
        
        //Disable past dates from date picker
        dateTraining.getJCalendar().setMinSelectableDate(today);


        //Getting Trainer IDs
        getTrainerID();
        
        
        //get training details into table
        getTrainingSlotDetails(); 
        
        
        //Increment the training session ID
        trainingIDIncrementor();
        
        
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JComboBox<String> chkTrainerEndTime;
    private javax.swing.JComboBox<String> chkTrainerID;
    private javax.swing.JComboBox<String> chkTrainerStartTime;
    private com.toedter.calendar.JDateChooser dateTraining;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTrainerID;
    private javax.swing.JTable tblTrainingSession;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
