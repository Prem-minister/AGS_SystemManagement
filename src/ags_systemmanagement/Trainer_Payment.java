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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Trainer_Payment extends javax.swing.JFrame {

    /**
     * Creates new form Trainer_Payment
     */
    Trainer T;
    String[] Training_ID;
    String status;
    String[] Line;
    String[] user_payment_record;
    double amount_paid = 0.00;
    DecimalFormat df = new DecimalFormat("#.00");
    
    public Trainer_Payment(Trainer T) {
        initComponents();
        setTrainer(T);
        GUI();
        
    }
    
    public void setTrainer(Trainer T) {
        this.T = T;
    }
    
    public Trainer_Payment() {
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        T_Payment_MethodGrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        T_Payment_SessionCbox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        T_Payment_AmtPaid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        T_Payment_Fees = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        T_Payment_ADD = new javax.swing.JTextField();
        T_Payment_SaveBtn = new javax.swing.JButton();
        backBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ags_systemmanagement/rsc/payment-icon.png"))); // NOI18N
        jLabel1.setText("Payment");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setLabelFor(T_Payment_SessionCbox);
        jLabel2.setText("Select Sessions :");

        T_Payment_SessionCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_Payment_SessionCboxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setLabelFor(T_Payment_AmtPaid);
        jLabel3.setText("Amount Paying:");

        T_Payment_AmtPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        T_Payment_AmtPaid.setToolTipText("");
        T_Payment_AmtPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_Payment_AmtPaidActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setLabelFor(T_Payment_Fees);
        jLabel4.setText("Remaining Fees:");

        T_Payment_Fees.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        T_Payment_Fees.setText("RM 129.20");
        T_Payment_Fees.setEnabled(false);
        T_Payment_Fees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_Payment_FeesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setLabelFor(T_Payment_AmtPaid);
        jLabel5.setText("Payment Method:");

        jRadioButton1.setBackground(new java.awt.Color(0, 51, 102));
        T_Payment_MethodGrp.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("DEBIT");
        jRadioButton1.setToolTipText("Debit card");

        jRadioButton2.setBackground(new java.awt.Color(0, 51, 102));
        T_Payment_MethodGrp.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("CREDIT");
        jRadioButton2.setToolTipText("Credit Card");

        jRadioButton3.setBackground(new java.awt.Color(0, 51, 102));
        T_Payment_MethodGrp.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("CASH");
        jRadioButton3.setToolTipText("Cash");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setLabelFor(T_Payment_ADD);
        jLabel6.setText("Payer address:");

        T_Payment_ADD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        T_Payment_ADD.setToolTipText("Payer Name");
        T_Payment_ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_Payment_ADDActionPerformed(evt);
            }
        });

        T_Payment_SaveBtn.setBackground(new java.awt.Color(0, 255, 255));
        T_Payment_SaveBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        T_Payment_SaveBtn.setForeground(new java.awt.Color(255, 0, 0));
        T_Payment_SaveBtn.setText("Save Payment");
        T_Payment_SaveBtn.setToolTipText("Add Payment Record");
        T_Payment_SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_Payment_SaveBtnActionPerformed(evt);
            }
        });

        backBTN.setBackground(new java.awt.Color(0, 51, 102));
        backBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ags_systemmanagement/rsc/Back-icon.png"))); // NOI18N
        backBTN.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(backBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(T_Payment_AmtPaid)
                                    .addComponent(T_Payment_SessionCbox, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(T_Payment_Fees, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(T_Payment_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(T_Payment_SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backBTN))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_Payment_SessionCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(T_Payment_Fees, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(T_Payment_AmtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(T_Payment_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(T_Payment_SaveBtn)
                .addGap(35, 35, 35))
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

    private void T_Payment_AmtPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_Payment_AmtPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_Payment_AmtPaidActionPerformed

    private void T_Payment_FeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_Payment_FeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_Payment_FeesActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void T_Payment_ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_Payment_ADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_Payment_ADDActionPerformed

    public void backToSession() {
        this.setVisible(false);
        Trainer_Sessions TS = new Trainer_Sessions(T);
        
        TS.setVisible(true);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        TS.setLocation(dim.width/2-TS.getSize().width/2, dim.height/2-TS.getSize().height/2);
    }
    
    private void T_Payment_SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_Payment_SaveBtnActionPerformed
        // TODO add your handling code here:
        //Saving payment record 
        String Selected_TID = (String) T_Payment_SessionCbox.getSelectedItem();
        Double r_fee = Double.parseDouble(T_Payment_Fees.getText());

        Double p_amt = 0.00;
        if(T_Payment_Fees.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "paid amount cannot be empty", "Payment not added", 2);
            return;
        }
        p_amt = Double.parseDouble(T_Payment_AmtPaid.getText());
        String selected = "";
        if(jRadioButton1.isSelected()){
            selected = "debit";
        } else if(jRadioButton2.isSelected()){
            selected = "credit";
        } else if(jRadioButton3.isSelected()){
            selected = "cash";
        }
        String status = "";
        String address = "";
        if(T_Payment_ADD.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Payer address cannot be empty", "Payment not added", 2);
            return;
        } 
        address = T_Payment_ADD.getText();
        
        if(p_amt > r_fee){
            JOptionPane.showMessageDialog(null, "Pay Amount cannot be greater than remaining fees", "Payment not added", 2);
            return;
        } 
        if(p_amt < r_fee) {
            status = "partially_paid";
        } else if (df.format(p_amt).equals(df.format(r_fee))) {
            status = "paid";
        }
        String LastLine = "";
        //write to Payment.txt
        if(new File(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Payment.txt").exists()) {
                try{
                    BufferedReader r = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Payment.txt"));
                    if(r.readLine()==null){
                        BufferedWriter wr = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Payment.txt", true));
                        wr.write("PID1" + ":" + Selected_TID + ":" + df.format(r_fee) + ":" + df.format(p_amt)+ ":" + selected + ":" + address + "\n");
                        JOptionPane.showMessageDialog(null, "Successfully added Payment", "Feedback Added", 1);
                        wr.close();
                        r.close();
                        backToSession();
                    } else {
                        String line;
                        String[] data;
                            
                        while((line = r.readLine()) != null){
                           LastLine = line;
                        }
                        r.close();
                        
                        String[] data123 = LastLine.split(":");
                        String idd = data123[0];
                        String[] id = idd.split("D");
                        int id_adding = Integer.parseInt(id[1]);
                        id_adding = id_adding +1;
                        
                        BufferedWriter wr = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Payment.txt", true));
                        wr.write("PID"+ id_adding + ":" + Selected_TID + ":" + df.format(r_fee) + ":" + df.format(p_amt)+ ":" + selected + ":" + address + "\n");
                        
                        wr.close();
                        // updating status
                        BufferedReader rd = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt"));
                
                        String[] training;
                        String line_t;
                
                         //Writting a temp file
                        BufferedWriter w = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Temp.txt"));
                        //while loop for each line in TrainingSlots.txt
                        while((line_t = rd.readLine())!= null){
                            //splitting the training data
                            training = line_t.split(":");
                            //comparing the editting user 
                            if(training[0].equals(Selected_TID)){
                                for(int i=0; i<training.length; i++){
                                    if(i!=8){
                                        wr.write(training[i] + ":");
                                    } else {
                                        wr.write( status + ":");
                                    }
                                
                                }
                                w.write("\n");
                            } else {
                                for(int i=0; i<training.length; i++){
                                    wr.write(training[i] + ":");
                                }
                                wr.write("\n");
                            }
                            //clearing array
                            Arrays.fill(training,null);
                        }
                
                            rd.close();
                            w.close();
                            

                            File fileToDelete = new File(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt");
                            File fileToChangeName = new File(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Temp.txt");

                            //deleting the old user file and renaming the temp file to new user file
                            fileToDelete.delete();
                            fileToChangeName.renameTo(fileToDelete);

                            JOptionPane.showMessageDialog(null, "Successfully added Payment", "Payment Added", 1);

                            backToSession();
                        }
                }catch(IOException e){
                    System.out.println("Error in adding payment");
                }
        } else {
            try{
                BufferedWriter wr = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Payment.txt", true));
                wr.write("PID1" + ":" + Selected_TID + ":" + df.format(r_fee) + ":" + df.format(p_amt)+ ":" + selected + ":" + address + "\n");
                JOptionPane.showMessageDialog(null, "Successfully added Payment", "Feedback Added", 1);
                wr.close();
                backToSession();
            } catch(IOException e){
                System.out.println("Error in adding payment");
            }
            
        } 
    }//GEN-LAST:event_T_Payment_SaveBtnActionPerformed

    
    
    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Trainer_Sessions TS = new Trainer_Sessions(T);
        
        TS.setVisible(true);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        TS.setLocation(dim.width/2-TS.getSize().width/2, dim.height/2-TS.getSize().height/2);
    }//GEN-LAST:event_backBTNActionPerformed

    private void T_Payment_SessionCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_Payment_SessionCboxActionPerformed
        // TODO add your handling code here:
        displayData();
    }//GEN-LAST:event_T_Payment_SessionCboxActionPerformed

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
            java.util.logging.Logger.getLogger(Trainer_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trainer_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trainer_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trainer_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trainer_Payment().setVisible(true);
            }
        });
    }
    
    //displaying data to GUI
    public void displayData(){
        int i=0;
        while(i<Line.length) {
            String[] data = Line[i].split(":");
            
            if(data[0].equals(T_Payment_SessionCbox.getSelectedItem())){
                if(data[8].equals("paid")){
                    T_Payment_Fees.setText("0.00");
                    T_Payment_SaveBtn.setEnabled(false);
                } else if(data[8].equals("partially_paid")){
                    //load the payment files and search for record    
                    try{
                        BufferedReader readPM = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Payment.txt"));

                        String[] payment_details;
                        String p_line;

                        int x =0;
                        while((p_line = readPM.readLine()) != null) {
                            payment_details = p_line.split(":");
                            if(payment_details[1].equals(data[0])){
                                x++;
                            }
                            Arrays.fill(data, null);
                        }

                        user_payment_record = new String[(x)];

                        readPM.close();

                        BufferedReader readP = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\Payment.txt"));
                        //getting line of payment details 
                        x=0;
                        while((p_line = readP.readLine())!=null){
                            payment_details = p_line.split(":");

                            if(payment_details[1].equals(data[0])){
                                user_payment_record[x] = p_line;
                                x++;
                            }

                            Arrays.fill(data, null);
                        }

                        readP.close();
                        
                    } catch (IOException e) {
                        System.out.print("File does not exist");
                    }

                    //getting  how much they paid.
                    int y=0;
                    if(user_payment_record != null){
                        while(y<user_payment_record.length){
                            String[] paid_data = user_payment_record[y].split(":");

                            amount_paid += Double.parseDouble(paid_data[3]);

                            y++;
                        }
                        
                        //setting remaining fees to Textfield
                        T_Payment_Fees.setText(df.format(amount_paid));
                    }
                    
                    T_Payment_SaveBtn.setEnabled(true);
                } else if (data[8].equals("unpaid")) {
                    T_Payment_Fees.setText(data[7]);
                    T_Payment_SaveBtn.setEnabled(true);
                }
                break;
            }
            
            i++;
        }
    }
    
    public void GUI(){
        

        //GETTING ALL SESSIONS FROM THIS TRAINER
         try{
            
            BufferedReader getCount = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt"));
            String line, line2;
            String[] Data;
            int count = 0;
            while((line2 = getCount.readLine()) !=null) count++;
            getCount.close();
            System.out.println(count);
            
            Training_ID = new String [(count)];
            Line = new String [(count)];
             
             
            BufferedReader readFB = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt"));

            int i =0;
            while ((line = readFB.readLine()) != null) {
               Data = line.split(":");
               System.out.print("testing in side while");
               if(Data[1].equals(T.user_ID)){
                   Line[i] = line;
                   Training_ID[i] = Data[0];
                   T_Payment_SessionCbox.addItem(Training_ID[i]);
                   i++;
               }
                
                Arrays.fill(Data, null);

            }
            
            readFB.close();
         } catch(IOException e){
             
         }
         
         displayData();
         
        
         
         
         
         
         
        
        
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
    private javax.swing.JTextField T_Payment_ADD;
    private javax.swing.JTextField T_Payment_AmtPaid;
    private javax.swing.JTextField T_Payment_Fees;
    private javax.swing.ButtonGroup T_Payment_MethodGrp;
    private javax.swing.JButton T_Payment_SaveBtn;
    private javax.swing.JComboBox<String> T_Payment_SessionCbox;
    private javax.swing.JButton backBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables
}
