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
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Prem Sharaan
 */
public class Customer_ProvideFeedback extends javax.swing.JFrame {

    /**
     * Creates new form CustomerProvideFeedback
     */
    Customer C;
    String[] Training_ID;
    
    public Customer_ProvideFeedback(Customer C) {
        initComponents();
        setCustomer(C);
        GUI();
    }

    private void setCustomer(Customer C) {
        this.C = C;
    }
    
    public Customer_ProvideFeedback() {}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Rating = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        lblTrainingSession = new javax.swing.JLabel();
        lblCentreTrainer = new javax.swing.JLabel();
        txtCentreTrainer = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        lblFeedback = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFeedback = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        Selected_TrainID_FB = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 241, 255));
        jLabel1.setText("Provide Feeback");

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

        lblTrainingSession.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblTrainingSession.setForeground(new java.awt.Color(100, 255, 218));
        lblTrainingSession.setText("Training Session ID:");

        lblCentreTrainer.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblCentreTrainer.setForeground(new java.awt.Color(100, 255, 218));
        lblCentreTrainer.setText("Centre Trainer:");

        txtCentreTrainer.setFont(new java.awt.Font("Avenir Next", 0, 15)); // NOI18N
        txtCentreTrainer.setForeground(new java.awt.Color(51, 51, 51));
        txtCentreTrainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 204), 2));
        txtCentreTrainer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCentreTrainerFocusLost(evt);
            }
        });
        txtCentreTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCentreTrainerActionPerformed(evt);
            }
        });

        lblDate.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(100, 255, 218));
        lblDate.setText("Rating:");

        lblFeedback.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblFeedback.setForeground(new java.awt.Color(100, 255, 218));
        lblFeedback.setText("Feedback:");

        txtFeedback.setColumns(20);
        txtFeedback.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtFeedback.setForeground(new java.awt.Color(51, 51, 51));
        txtFeedback.setRows(5);
        txtFeedback.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 255, 204)));
        jScrollPane1.setViewportView(txtFeedback);

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

        Selected_TrainID_FB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Selected_TrainID_FBActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(0, 51, 102));
        Rating.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(0, 51, 102));
        Rating.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(0, 51, 102));
        Rating.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(0, 51, 102));
        Rating.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setBackground(new java.awt.Color(0, 51, 102));
        Rating.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(383, 383, 383)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrainingSession, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCentreTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(25, 25, 25)
                                .addComponent(jRadioButton2)
                                .addGap(25, 25, 25)
                                .addComponent(jRadioButton3)
                                .addGap(25, 25, 25)
                                .addComponent(jRadioButton4)
                                .addGap(25, 25, 25)
                                .addComponent(jRadioButton5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addComponent(txtCentreTrainer)
                            .addComponent(Selected_TrainID_FB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59)))
                .addGap(304, 304, 304))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrainingSession, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Selected_TrainID_FB, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCentreTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCentreTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public String getSelectedButton(){
        String selected = "";
        if(jRadioButton1.isSelected()){
            selected = jRadioButton1.getText();
        } else if(jRadioButton2.isSelected()){
            selected = jRadioButton2.getText();
        } else if(jRadioButton3.isSelected()){
            selected = jRadioButton3.getText();
        } else if(jRadioButton4.isSelected()){
            selected = jRadioButton4.getText();
        } else if(jRadioButton5.isSelected()){
            selected = jRadioButton5.getText();
        }
        
        return selected;
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try{
            
            if(new File(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\CustomerFeedback.txt").exists()){
                BufferedReader r = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\CustomerFeedback.txt"));
                String line;
                String[] data;
                String LastLine ="";
                while((line = r.readLine()) != null){
                   LastLine = line;
                }
                r.close();

                String[] data123 = LastLine.split(":");
                String idd = data123[0];
                String[] id = idd.split("B");
                int id_adding = Integer.parseInt(id[1]);
                id_adding = id_adding +1;

                BufferedWriter wr = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\CustomerFeedback.txt", true));
                if(!txtFeedback.getText().isBlank())
                {
                    wr.write("FB" + id_adding + ":" + Selected_TrainID_FB.getSelectedItem() + ":" + getSelectedButton() + ":" + txtFeedback.getText()+ ":" + C.user_ID + "\n");
                    JOptionPane.showMessageDialog(null, "Successfully added feedback", "Feedback Added", 1);
                    btnUpdate.setEnabled(false);
                } else{
                    JOptionPane.showMessageDialog(null, "Feedback Message cannot be blank", "Missing fields", 1);
                }

                wr.close();
            } else { 
                try{
                    BufferedWriter wrr = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\CustomerFeedback.txt"));
                    if(!txtFeedback.getText().isBlank())
                    {
                        wrr.write("FB1" + ":" + Selected_TrainID_FB.getSelectedItem() + ":" + getSelectedButton() + ":" + txtFeedback.getText()+ ":" + C.user_ID + "\n");
                        JOptionPane.showMessageDialog(null, "Successfully added feedback", "Feedback Added", 1);
                        btnUpdate.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(null, "Feedback Message cannot be blank", "Missing fields", 1);
                    }
                    wrr.close();
                } catch(IOException e) {
                    System.out.print(e);
                }
            }
        } catch (IOException e){
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void txtCentreTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCentreTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCentreTrainerActionPerformed

    private void txtCentreTrainerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCentreTrainerFocusLost

    }//GEN-LAST:event_txtCentreTrainerFocusLost

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        this.setVisible(false);
        Customer_Schedule CS = new Customer_Schedule(C);
        
        CS.setVisible(true);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        CS.setLocation(dim.width/2-CS.getSize().width/2, dim.height/2-CS.getSize().height/2);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnGoBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackMouseEntered

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void Selected_TrainID_FBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Selected_TrainID_FBActionPerformed
        // TODO add your handling code here:
        // Check if there is any existing feedback 
        try{
            BufferedReader readFB = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\CustomerFeedback.txt"));
            int i =0;
            String line;
            String[] Data;
            while ((line = readFB.readLine()) != null) {
               Data = line.split(":");
               if(Data[1].equals(Selected_TrainID_FB.getSelectedItem())){
                   txtFeedback.setText(Data[3]);
                   btnUpdate.setEnabled(false);
                   //need to add radio btn
                   switch(Data[2]){
                       case "1" : jRadioButton1.setSelected(true); break;
                       case "2" : jRadioButton2.setSelected(true); break;
                       case "3" : jRadioButton3.setSelected(true); break;
                       case "4" : jRadioButton4.setSelected(true); break;
                       case "5" : jRadioButton5.setSelected(true); break;
                       
                   }
                   Arrays.fill(Data, null);

                   break;
                } else {
                   btnUpdate.setEnabled(true);
                   txtFeedback.setText("");
                   
                   jRadioButton1.setSelected(false); 
                    jRadioButton2.setSelected(false); 
                    jRadioButton3.setSelected(false); 
                    jRadioButton4.setSelected(false); 
                    jRadioButton5.setSelected(false);
                    
                    Arrays.fill(Data, null);
               }
                

            }
            
            readFB.close();
            
            BufferedReader readTRR = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt"));

            i =0;
            String[] temp_Data;
                               System.out.println("hello in readTRR");

            while ((line = readTRR.readLine()) != null) {
               temp_Data = line.split(":");
               System.out.println(line);

               if(temp_Data[0].equals(Selected_TrainID_FB.getSelectedItem())){
                   txtCentreTrainer.setText(temp_Data[2]);
                   i++;
               }
                
                Arrays.fill(temp_Data, null);

            }
            
            readTRR.close();
            
        } catch(IOException e){
            
        }
    }//GEN-LAST:event_Selected_TrainID_FBActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_ProvideFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_ProvideFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_ProvideFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_ProvideFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_ProvideFeedback().setVisible(true);
            }
        });
    }
    
    public void GUI(){
        
        try{
             //GETTING ALL SESSIONS FROM THIS TRAINER
            BufferedReader getCount = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt"));
            String line, line2;
            String[] Data;
            int count = 0;
            while((line2 = getCount.readLine()) !=null) count++;
            getCount.close();
            System.out.println(count);
            
            Training_ID = new String [(count)];
            
             
             
            BufferedReader readFB = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt"));

            
            
            int i =0;
            while ((line = readFB.readLine()) != null) {
               Data = line.split(":");
               System.out.print("testing in side while");
               if(Data[6].equals(C.user_ID)){
                   Training_ID[i] = Data[0];
                   Selected_TrainID_FB.addItem(Training_ID[i]);
                   i++;
               }
                
                Arrays.fill(Data, null);

            }
            
            readFB.close();
         } catch(IOException e){
             
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
    private javax.swing.ButtonGroup Rating;
    private javax.swing.JComboBox<String> Selected_TrainID_FB;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCentreTrainer;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFeedback;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTrainingSession;
    private javax.swing.JTextField txtCentreTrainer;
    private javax.swing.JTextArea txtFeedback;
    // End of variables declaration//GEN-END:variables
}
