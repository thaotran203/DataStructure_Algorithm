/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.messengerapp;

import controller.msgController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class MessengerForm extends javax.swing.JFrame {

    MessengerApp messApp = new MessengerApp();
    /**
     * Creates new form MessengerForm
     */
    public MessengerForm() {
        initComponents();
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
        msg_send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_text = new javax.swing.JTextArea();
        msg_delete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_send.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        msg_send.setText("Send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        msg_text.setColumns(20);
        msg_text.setRows(5);
        jScrollPane1.setViewportView(msg_text);

        msg_delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        msg_delete.setText("Unsent");
        msg_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(msg_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(msg_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        msg_area.setEditable(false);
        msg_area.setColumns(20);
        msg_area.setRows(5);
        msg_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msg_areaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(msg_area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        String message = msg_text.getText();
        boolean isOK = true;
        
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You haven’t typed anything yet!!! Please retype");
        }
        else {
            // Start the timer
            long startTime = System.nanoTime();
            
            messApp.transfer(message);
            messApp.process();
            System.out.println(messApp.result());

            long endTime = System.nanoTime();
            // Calculate the elapsed time
            long elapsedTime = endTime - startTime;
            System.out.println("The system took " + elapsedTime / 1000000.0 + " miliseconds to run...");
            
            try {
                if (msgController.AddMessageToFile(messApp.result()) == 1){
                    JOptionPane.showMessageDialog(this, "Message has been sent successfully!");
                }
                
                else if (msgController.AddMessageToFile(messApp.result()) == -999){
                    JOptionPane.showMessageDialog(this, "Sent message fail!");
                }
                else if (msgController.AddMessageToFile(messApp.result()) == -1){
                    JOptionPane.showMessageDialog(this, "Sent message fail!");
                }
            } catch (IOException ex) {
                System.out.println("Occur error when accessing the file!");
            }
            messApp.clearStack();
            showMessage();
            msg_text.setText(null);
        }
    }//GEN-LAST:event_msg_sendActionPerformed

    private void msg_areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msg_areaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_msg_areaMouseClicked

    private void msg_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_deleteActionPerformed
        
        try{
            
            File oldFile = new File("C:\\Users\\ACER\\Documents\\NetBeansProjects\\MessengerApp\\src\\main\\java\\data\\Message.txt");
            File newFile = new File("C:\\Users\\ACER\\Documents\\NetBeansProjects\\MessengerApp\\src\\main\\java\\data\\newFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(oldFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));

            String oldLine = msg_area.getSelectedText();
            JOptionPane.showMessageDialog(this, msg_area.getSelectedText());
            
            String newLine = "";
            
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                if(currentLine.equals(oldLine)) {
                    bufferedWriter.write(newLine + System.getProperty("line.separator"));
                    continue;
                }
                bufferedWriter.write(currentLine + System.getProperty("line.separator"));
            }
            
            reader.close();
            bufferedWriter.close();
            
            PrintWriter writer = new PrintWriter("C:\\Users\\ACER\\Documents\\NetBeansProjects\\MessengerApp\\src\\main\\java\\data\\Message.txt");
            writer.print("");
            writer.close();
            
            
            BufferedReader readerTempFile = new BufferedReader(new FileReader(newFile));
            StringBuilder sb = new StringBuilder();
            String line = readerTempFile.readLine();
            while(line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = readerTempFile.readLine();
            }
            String everyThing = sb.toString();
            
            readerTempFile.close();
            
            FileWriter writer2 = new FileWriter(oldFile);

            writer2.write(everyThing);
            writer2.close();
            
            showMessage();
        } catch (IOException ex) {
            System.out.println("Occur error when accessing the file!");
        }
    }//GEN-LAST:event_msg_deleteActionPerformed

    public static void showMessage() {
        
        String filePath = "C:\\Users\\ACER\\Documents\\NetBeansProjects\\MessengerApp\\src\\main\\java\\data\\Message.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            String string = "";
            try {
                while ((st = br.readLine()) != null) {
                    if (!st.isEmpty() && !st.equals("\n")) {
                        string += st + "\n";
                    }
                }
                msg_area.setText(string);
            } catch (IOException ex) {
                System.out.println("Occur error when accessing the file!");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file does not exist in the system!");
        }
    }

    
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
            java.util.logging.Logger.getLogger(MessengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessengerForm().setVisible(true);
                showMessage();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_delete;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextArea msg_text;
    // End of variables declaration//GEN-END:variables
}