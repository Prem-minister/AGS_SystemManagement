/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ags_systemmanagement;

import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Prem Sharaan
 */
public class CentreManager_ViewTrainingSession extends javax.swing.JFrame {
    private final String projectDir = System.getProperty("user.dir") + "\\src\\db_TxtFiles\\TrainingSlots.txt";
    private final String pdfDir = System.getProperty("user.dir") + "\\src\\pdf\\ManagerTrainingSlots.pdf";    
    private boolean filter = false;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form CentreManager_ViewTrainingSession
     */
    public CentreManager_ViewTrainingSession() {
        initComponents();
        initGUI();
    }

       //Method for clearing any available user cachr
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
        lblTitle = new javax.swing.JLabel();
        lblSystemName = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrainingSessionRecords = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        btnClear2 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(10, 25, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 900));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(230, 241, 255));
        lblTitle.setText("View Training Session Records");

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

        btnFilter.setBackground(new java.awt.Color(204, 255, 204));
        btnFilter.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(0, 51, 51));
        btnFilter.setText("Filter");
        btnFilter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFilterMouseEntered(evt);
            }
        });
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tblTrainingSessionRecords.setBackground(new java.awt.Color(255, 255, 255));
        tblTrainingSessionRecords.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        tblTrainingSessionRecords.setForeground(new java.awt.Color(0, 0, 0));
        tblTrainingSessionRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Training ID", "Trainer ID", "Trainer Name", "Training Date", "Start Time", "End Time", "Customer ID", "Fees", "Payment Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTrainingSessionRecords.setToolTipText("");
        tblTrainingSessionRecords.setSelectionBackground(new java.awt.Color(0, 51, 51));
        tblTrainingSessionRecords.setSelectionForeground(new java.awt.Color(204, 255, 204));
        tblTrainingSessionRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTrainingSessionRecordsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTrainingSessionRecords);

        lblName.setFont(new java.awt.Font("Corsiva Hebrew", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(100, 255, 218));
        lblName.setText("Filter:");

        txtFilter.setBackground(new java.awt.Color(255, 255, 255));
        txtFilter.setFont(new java.awt.Font("Lao Sangam MN", 1, 16)); // NOI18N
        txtFilter.setForeground(new java.awt.Color(0, 0, 0));
        txtFilter.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtFilter.setPreferredSize(new java.awt.Dimension(89, 22));

        btnClear2.setBackground(new java.awt.Color(204, 204, 255));
        btnClear2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnClear2.setForeground(new java.awt.Color(0, 0, 51));
        btnClear2.setText("Clear");
        btnClear2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnClear2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClear2MouseEntered(evt);
            }
        });
        btnClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear2ActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(102, 0, 102));
        btnSave.setText("Save PDF");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addComponent(lblSystemName, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(26, 26, 26)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
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
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackMouseEntered

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        int selection = JOptionPane.showConfirmDialog(null, "Going back to main menu will cancel the ongoing filtering. Continue?", "Returning to Main Menu!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selection == JOptionPane.YES_OPTION) {
            this.dispose();
            openFrame openFrame = new openFrame();
            openFrame.openManagerMainMenu();
        }
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnFilterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilterMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFilterMouseEntered

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        clearTbl();
        if(filterTrainingRecords()){
            JOptionPane.showMessageDialog(null, "The payment records has been filtered accordingly.", "Records Filtered", JOptionPane.INFORMATION_MESSAGE);
        } else{
            try {
                JOptionPane.showMessageDialog(null, "No payment records were found according to the filter", "No Records", JOptionPane.ERROR_MESSAGE);
                getTrainingRecords();
            } catch (ParseException ex) {
                Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void tblTrainingSessionRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainingSessionRecordsMouseClicked

    }//GEN-LAST:event_tblTrainingSessionRecordsMouseClicked

    private void btnClear2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClear2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClear2MouseEntered

    private void btnClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear2ActionPerformed
        try {
            clearTbl();
            getTrainingRecords();
            txtFilter.setText("");
        } catch (ParseException ex) {
            Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClear2ActionPerformed

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            saveTrainingSessionRecords();
        } catch (IOException ex) {
            Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentreManager_ViewTrainingSession().setVisible(true);
            }
        });
    }
    
    
    private void clearTbl(){
        DefaultTableModel model = (DefaultTableModel)tblTrainingSessionRecords.getModel();
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
    }
    
      private void userinputCharacterValidation(){
        txtFilter.getDocument().addDocumentListener(new userDocumentListener() {
            userFilterValidation invalidate = new userFilterValidation();
            @Override
            public void changedUpdate(DocumentEvent e){
                invalidate.runValidate(txtFilter);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                invalidate.runValidate(txtFilter);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                invalidate.runValidate(txtFilter);
            }
            
        });
    }
     
     
    private void showFilterBtn(){
        if (filter){
            btnFilter.setEnabled(true);
        }
        else
        {
            btnFilter.setEnabled(false);
        }
     } 
    
    
    private void showFilterBtn(JTextField txt){
        if ("".equals(txt.getText())){
            filter = false;
        } 
        else {
            filter = true;
        }
        showFilterBtn();
     }
    
    
//     private void getTrainingRecords(){
//        try {
//            File trainingtxt = new File(projectDir);
//            BufferedReader br = new BufferedReader(new FileReader(trainingtxt));
//            Object[] tableLines = br.lines().toArray();
//            DefaultTableModel model = (DefaultTableModel)tblTrainingSessionRecords.getModel();
//            for(int i = 0; i < tableLines.length; i++){
//                String line = tableLines[i].toString().trim();
//                String[] dataRow = line.split(":");
//                model.addRow(dataRow);
//             
//            }
//        }
//        catch (FileNotFoundException ex){
//            Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

      public void getTrainingRecords() throws ParseException{
        try {
            DateFormat dateFormatTable = new SimpleDateFormat("dd MMMM yy");
            FileReader fr = new FileReader(projectDir);
            BufferedReader br = new BufferedReader(fr);
            //This sets the table into a table model
            DefaultTableModel model = (DefaultTableModel) tblTrainingSessionRecords.getModel();
            //This is to  get line  by line from the text file
            Object[] tableLines = br.lines().toArray();
            //This is to retrieve the content from the lines in the text file and set the content in to the jtable
            for (int i = 0; i < tableLines.length; i++) {         
                String detailsline = tableLines[i].toString().trim();
                String[] userDataRow = detailsline.split(":");
                String trainingid = userDataRow[0];
                String trainerid = userDataRow[1];
                String trainername = userDataRow[2];
                Date date = dateFormat.parse(userDataRow[3]);
                String formatTableDate = dateFormatTable.format(date);
                String starttime = userDataRow[4];
                String endtime = userDataRow[5];
                String userID = userDataRow[6];
                String fees = "RM" + userDataRow[7];
                String paymentstatus = userDataRow[8];
                
                if ("*".equals(userID)){
                    userID = "Not Booked";
                }
    
                model.addRow(new Object[] {trainingid, trainerid, trainername, formatTableDate, starttime, endtime, userID, fees, paymentstatus});
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CentreManager_ViewUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    
    
       private boolean filterTrainingRecords(){
        boolean Records = false;
        try {           
             File trainingRecords = new File(projectDir);
             BufferedReader br = new BufferedReader(new FileReader(trainingRecords));
             Object[] tableLines = br.lines().toArray();
             DefaultTableModel model = (DefaultTableModel)tblTrainingSessionRecords.getModel();
             for(int i = 0; i < tableLines.length; i++)
                {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                if(dataRow[0].contains(txtFilter.getText()) || dataRow[1].contains(txtFilter.getText()) || dataRow[2].contains(txtFilter.getText()) || dataRow[3].contains(txtFilter.getText()) || dataRow[4].contains(txtFilter.getText()) || dataRow[5].contains(txtFilter.getText()) || dataRow[6].contains(txtFilter.getText())|| dataRow[7].contains(txtFilter.getText()) || dataRow[8].contains(txtFilter.getText())){
                     model.addRow(dataRow);
                     Records = true;                
               }
            }
             
        }
        catch (FileNotFoundException ex){
          Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
       }
         return Records;
    }
    
       
      private void saveTrainingSessionRecords() throws IOException, FileNotFoundException{
               
            PdfWriter wr = new PdfWriter(pdfDir);
            PdfDocument pdffile = new PdfDocument(wr);
            Document doct = new Document(pdffile);
            
            Style titlestyle = new Style();
            titlestyle.setBold().setFontSize(18f).setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER);
            
            String title = "Training Session Records of the Customers";
            Paragraph doctitle = new Paragraph(title).addStyle(titlestyle);
            
            float columnWidth[] = {150f,150f,150f,150f,150f,150f,150f,150f,150f};
            Table tbl = new Table(columnWidth);
            doct.add(doctitle);
            tbl.addCell("Training ID").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Trainer ID").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Trainer Name").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Training Date").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Start Time").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("End Time").setFontColor(new DeviceRgb(23, 23, 23));            
            tbl.addCell("Customer ID").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Fees").setFontColor(new DeviceRgb(23, 23, 23));
            tbl.addCell("Payment Status").setFontColor(new DeviceRgb(23, 23, 23));
            
            
            
            for(int i = 0; i < tblTrainingSessionRecords.getRowCount(); i++){
                String trainingID = tblTrainingSessionRecords.getValueAt(i, 0).toString();
                String trainerID = tblTrainingSessionRecords.getValueAt(i, 1).toString();
                String trainername = tblTrainingSessionRecords.getValueAt(i, 2).toString();
                String trainingdate = tblTrainingSessionRecords.getValueAt(i, 3).toString();
                String starttime = tblTrainingSessionRecords.getValueAt(i, 4).toString();
                String endtime = tblTrainingSessionRecords.getValueAt(i, 5).toString();
                String cusID = tblTrainingSessionRecords.getValueAt(i, 6).toString();
                String fees = tblTrainingSessionRecords.getValueAt(i, 7).toString();
                String paymentstatus = tblTrainingSessionRecords.getValueAt(i, 8).toString();
                              
                tbl.addCell(trainingID);
                tbl.addCell(trainerID);
                tbl.addCell(trainername);
                tbl.addCell(trainingdate);
                tbl.addCell(starttime);
                tbl.addCell(endtime);
                tbl.addCell(cusID);
                tbl.addCell(fees);
                tbl.addCell(paymentstatus);

            }
            
           //write into the pdf
           doct.add(tbl);
           doct.close();
        
          JOptionPane.showMessageDialog(null, "Training Session Records Printed Successfully in PDF!", "Records Printed!", JOptionPane.INFORMATION_MESSAGE);
       
       if (Desktop.isDesktopSupported()) {
          try {
              File myFile = new File(pdfDir);             
              Desktop.getDesktop().open(myFile);
          } catch (IOException ex) {
              // no application registered for PDFs
          }     catch (java.io.IOException ex) {
                    Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
           }
         }

    }
          
       
       
       
    
          //This method is for initial start of the frame
    public void initGUI() {
     
        try {
               //setting the frame name
                this.setTitle("View Training Session");
         
            //This will padding for the textfields
            txtFilter.setBorder(BorderFactory.createCompoundBorder(txtFilter.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 4)));
            
            //Disable autofucous in buttons
            btnGoBack.setFocusable(false);
            btnFilter.setFocusable(false);
            btnClear2.setFocusable(false);
            btnSave.setFocusable(false);
            tblTrainingSessionRecords.setFocusable(false);
            tblTrainingSessionRecords.setDefaultEditor(Object.class, null);
            
            //Disable button
            btnFilter.setEnabled(false);
            
            txtFilter.getDocument().addDocumentListener(new userDocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    showFilterBtn(txtFilter);
                }
                
                @Override
                public void removeUpdate(DocumentEvent e) {
                    showFilterBtn(txtFilter);
                }
                
                @Override
                public void changedUpdate(DocumentEvent e) {
                    showFilterBtn(txtFilter);
                }
            });
            
            //getting login records
            getTrainingRecords();
            
            // This class handles window closing event
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    int selection = JOptionPane.showConfirmDialog(null, "Want to exit?", "Closing View Training Session", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
            
            userinputCharacterValidation();
        } catch (ParseException ex) {
            Logger.getLogger(CentreManager_ViewTrainingSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear2;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblTrainingSessionRecords;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
