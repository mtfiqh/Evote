/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Function.DataCalon;
import Function.DataVoter;
import Function.ListArray;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mtauf
 */
public class HasilVote extends javax.swing.JFrame {
    AdminPanel ap;
    ChartFrame chartFrame;
    Timer timer;
    /**
     * Creates new form HasilVote
     */
    public HasilVote() {
        initComponents();
        showData();
        timerOn();
    }
    public HasilVote(AdminPanel ap){
        this.ap=ap;
        initComponents();    
        showData();
        timerOn();
        this.setResizable(false);
    }
    void timerOn(){
        timer = new Timer(1000, new ActionListener() {
            int defaulCount=10;
            int countTimer=defaulCount;
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(countTimer);
                if(chartFrame!=null){
                     if(chartFrame.isVisible()){
                        countTimer--;
                        if(countTimer==0){
                            chartFrame.dispose();
                            showData();
                            showChart();
                            countTimer=defaulCount;
                            timer.restart();
                        }
                    }else{
                        countTimer=defaulCount;
                        timer.restart();
                    }
                }else{
                    countTimer=defaulCount;
                    timer.restart();
                }
            }
        });
        timer.start();

    }
    public void showData(){
//        get data mahasiswa
        ArrayList<DataVoter> listV = new ArrayList<>();
        listV= new ListArray().getListDataVoter("SELECT * FROM mahasiswa");
        int banyakV = listV.size();
        listV= new ListArray().getListDataVoter("SELECT * FROM mahasiswa where keterangan=0");
        int banyakNotVoteV = listV.size();
        listV=new ListArray().getListDataVoter("SELECT * FROM mahasiswa where keterangan=1 and vote_who is not null");
        int banyakVoteV = listV.size();
        listV=new ListArray().getListDataVoter("SELECT * FROM mahasiswa where keterangan=1 and vote_who is null");
        int banyakGolputV=listV.size();
        
//        GET DATA CALON
        ArrayList<DataCalon> listC=new ArrayList<>();
        listC=new ListArray().getListDataCalon("SELECT * FROM calon");
        String calonList="";
        String tempC="";
        for(int i=0;i<listC.size();i++){
            tempC=tempC+calonList;
            calonList="\t"+listC.get(i).getNim()+"\t"+listC.get(i).getNama()+"\t : "+listC.get(i).getDipilih()+"\n";
            System.out.println(tempC);
            System.out.println(calonList);
        }
        tempC=tempC+calonList;
        jTextArea1.setText("== DATA MAHASISWA ==\n"
                + "Banyak Mahasiswa\t : "+banyakV+"\n"
                + "Sudah Vote\t\t : "+banyakVoteV+"\n"
                + "Belum Vote\t\t : "+banyakNotVoteV+"\n"
                + "Golput\t\t : "+banyakGolputV+"\n\n"
                + "== DATA CALON ==\n"
                + "Banyak Calon\t\t : "+listC.size()+"\n"
                + "List Calon\t\t :\n"
                + tempC );
    }
    public void showChart(){
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
//        Get Array List
        ArrayList<DataCalon> list = new ArrayList<>();
        list= new ListArray().getListDataCalon("SELECT * FROM calon");
        for(int i=0;i<list.size();i++){
            dcd.setValue(list.get(i).getDipilih(), "Banyak Vote", list.get(i).getNama());
        }
        ArrayList<DataVoter> list2 = new ArrayList<>();
        list2 = new ListArray().getListDataVoter("SELECT * FROM mahasiswa where keterangan=1 and vote_who is NULL");
        dcd.setValue(list2.size(), "Banyak Vote", "GOLPUT");
        JFreeChart jChart = ChartFactory.createBarChart("Hasil Vote", "Calon", "Banyak Vote", dcd);
        
        CategoryPlot plot = jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
        chartFrame = new ChartFrame("Hasil Vote", jChart, true);
        chartFrame.setVisible(true);
        chartFrame.setSize(getWidth()+50,getHeight()+50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("TEST");
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAdminPanel/showchart.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAdminPanel/refresh.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showChart();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showData();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ap.setEnabled(true);
        if(chartFrame!=null){
            if(chartFrame.isVisible()){
                chartFrame.dispose();
            }
        }
        this.dispose();
        ap.setEnabled(true);
        timer.stop();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(HasilVote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HasilVote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HasilVote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HasilVote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HasilVote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
