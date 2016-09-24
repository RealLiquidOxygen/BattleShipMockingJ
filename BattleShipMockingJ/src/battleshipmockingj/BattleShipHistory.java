/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmockingj;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author owoye001
 */
public class BattleShipHistory extends javax.swing.JFrame {

    
    
    /**
     * Creates new form BattleShipMainDisplay
     */
    public BattleShipHistory() {
        initComponents();
        
        //loading JFrame and resizing here. 
        
        setSize(1355, 1133);
        
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(new Color(153,153,153));
        
        //loading history into progressbar here 
        
         try
                {
                    //FileReader reader = new FileReader(getClass().getResource("History/History.bsj").toString().substring(6)); //in netbeans. the other one is outside of netbeans
                    FileReader reader = new FileReader("History/History.bsj");
                    BufferedReader br = new BufferedReader(reader);
                    jTextArea1.read( br, null );
                    br.close();
                    jTextArea1.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
        
    }
    
  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLPlayer1 = new javax.swing.JLabel();
        jButtonStartGame = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BattleShip Mocking J");
        setBackground(new java.awt.Color(153, 153, 153));
        setFocusTraversalPolicyProvider(true);
        setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("BattleShip Mocking J");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 610, -1));

        jLPlayer1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLPlayer1.setForeground(new java.awt.Color(0, 204, 51));
        jLPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLPlayer1.setText("HISTORY");
        getContentPane().add(jLPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 140, 400, 70));

        jButtonStartGame.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonStartGame.setForeground(new java.awt.Color(0, 204, 51));
        jButtonStartGame.setText("GO BACK");
        jButtonStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartGameActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonStartGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 890, 460, 100));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 50)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setMargin(new java.awt.Insets(100, 100, 100, 100));
        jTextArea1.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 1230, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartGameActionPerformed
        // TODO add your handling code here
        setVisible(false);
        BattleShipMainDisplay.battleShipMainDisplay.setVisible(true);
       
    }//GEN-LAST:event_jButtonStartGameActionPerformed
  static BattleShipHistory battleHistory;
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
            java.util.logging.Logger.getLogger(BattleShipHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BattleShipHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BattleShipHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BattleShipHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 battleHistory = new BattleShipHistory();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStartGame;
    private javax.swing.JLabel jLPlayer1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables


}
