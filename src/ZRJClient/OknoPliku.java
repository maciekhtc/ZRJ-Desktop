/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZRJClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.SwingWorker;

/**
 *
 * @author Maciej
 */
public class OknoPliku extends javax.swing.JFrame {

    /**
     * Creates new form OknoPliku
     */
    private Okno zrodlo;                            //referencja do obiektu okna wywołującego

    public OknoPliku(Okno zrodlo) {
        this.zrodlo = zrodlo;
        initComponents();
        if (zrodlo.getData_flow() == 1) {
            jButton3.setEnabled(true);
            jButton2.setEnabled(false);
            jButton1.setEnabled(false);
            jTextField1.setEnabled(false);
            jLabel1.setText("Recording...");
        } else if (zrodlo.getData_flow() == 0) {
            jButton2.setEnabled(true);
            jButton3.setEnabled(false);
            jButton1.setEnabled(true);
            jTextField1.setEnabled(true);
            jLabel1.setText("");
        } else if (zrodlo.getData_flow() == 2) {
            jButton3.setEnabled(true);
            jButton2.setEnabled(false);
            jButton1.setEnabled(false);
            jTextField1.setEnabled(false);
            jLabel1.setText("Playing...");
        }
        jTextField1.setText(zrodlo.getNazwaPliku());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setTitle("File");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Stop");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        zrodlo.setNazwaPliku(jTextField1.getText());
        if (!zrodlo.getNazwaPliku().isEmpty()) {
            jButton3.setEnabled(true);
            jButton2.setEnabled(false);
            jButton1.setEnabled(false);
            jTextField1.setEnabled(false);
            zrodlo.setData_flow(1);
            jLabel1.setText("Recording...");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
        jButton1.setEnabled(true);
        jTextField1.setEnabled(true);
        if (zrodlo.getData_flow() == 1) {
            zrodlo.setData_flow(0);
            new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {
                    File plik = new File(zrodlo.getNazwaPliku());
                    PrintWriter pw = new PrintWriter(plik);
                    for (String linia: zrodlo.getLista())
                    {
                        pw.println(linia);
                    }
                    pw.close();
                    zrodlo.getLista().clear();
                    return null;
                }
            }.execute();
        }
        zrodlo.setData_flow(0);
        jLabel1.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        zrodlo.setNazwaPliku(jTextField1.getText());
        if (!zrodlo.getNazwaPliku().isEmpty()) {
            jButton3.setEnabled(true);
            jButton2.setEnabled(false);
            jButton1.setEnabled(false);
            jTextField1.setEnabled(true);
            new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {
                    File plik = new File(zrodlo.getNazwaPliku());
                    BufferedReader br = new BufferedReader(new FileReader(plik));
                    String linia;
                    zrodlo.getLista().clear();
                    while ((linia = br.readLine()) != null) {
                        zrodlo.getLista().add(linia);
                    }
                    br.close();
                    return null;
                }
            }.execute();
            jTextField1.setEnabled(false);
            zrodlo.setData_flow(2);
            jLabel1.setText("Playing...");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        zrodlo.setNazwaPliku(jTextField1.getText());
        System.out.println("zamykanie");
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
