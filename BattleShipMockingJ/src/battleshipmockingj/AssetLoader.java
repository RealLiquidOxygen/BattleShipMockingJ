/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmockingj;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Cursor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author owoye001
 */
public class AssetLoader extends javax.swing.JFrame {
    
     Task task; //handle async load of music file and update progress bar. 
     
     int numberOfPlayers = 1; //number of store players
     
     int numberOfTrashTalks = 24; //number of trash talk
     
     //public static String remainingString = "src/battleshipmockingj/Sounds/"; //to locate where the sound file are located TWO VERSIONS
     
     public static String remainingString = "Sounds/"; //to locate where the sound file are located
     
     public static MP3Player theme;
    
    public static ArrayList<ImageIcon> players; //screeen images
    public static ArrayList<MP3Player> sounds;
    
    private class Task extends SwingWorker <Void, Void> {

        @Override
        protected Void doInBackground() {
            String remainingString = AssetLoader.remainingString;
            int progress = 0;
            setProgress(0);
            
            //Assuming their is one players - default profile picture 
           
            players.add(new ImageIcon((getClass().getResource("Players/ProfilePictures/" + 1 + ".jpg"))));
            if (progress<30){
                progress = progress  + 25; //40 maximum
                setProgress(progress);
            }
           
           
           //load mp3 talk file here. 
            
            for (int i = 0 ; i <= numberOfTrashTalks; i++) {
            sounds.add(new MP3Player(new File(remainingString + i + ".mp3"))); //load the button sound
            progress = progress  + 2;
            setProgress(progress);
            }
           
            int remaining = 100 - progress;
            progress += remaining;
            setProgress(progress);
            
            return null;
        }
        
        
        /**
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AssetLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
            setCursor(Cursor.getDefaultCursor()); // turn off the wait cursor
            SwingUtilities.invokeLater(() -> {
                BattleShipMainDisplay battleShipMainDisplay = new BattleShipMainDisplay();
                battleShipMainDisplay.setBackground(Color.black);
                battleShipMainDisplay.setLocationRelativeTo(null);
                battleShipMainDisplay.setVisible(true);
                BattleShipMockingJ.loader.setVisible(false);
                theme.stop();
            });
        }
        
    }

    /**
     * Creates new form AssetLoader
     */
    public AssetLoader() { 
        
       //set splash background to black 4
        initComponents();
        this.getContentPane().setBackground(Color.black);
        
        //customizing progress bar here 
        loadAssets.setBackground(Color.black);
        loadAssets.setForeground(Color.green);
        loadAssets.setStringPainted(true);
        
        //initializing array list here for assets - sound and pictures 
        players = new ArrayList();
        sounds = new ArrayList();
        
        //loading theme song here. 
         theme = new MP3Player (new File(remainingString + "0" + ".mp3"));
         theme.play();
        
         //setting cursor to wait cursor here 
         setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                 
                  
        //create load task
        task = new Task();

        //adding property change listener here 
        PropertyChangeListener prop = (PropertyChangeEvent pce) -> {
            if ("progress".equals(pce.getPropertyName())) {
                int progress1 = (Integer) pce.getNewValue();
                loadAssets.setValue(progress1);
            }
        };

        task.addPropertyChangeListener(prop);
       
        //executing tasks here 
        task.execute();
        
         //task.doInBackground();
      
        
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
        jLabel2 = new javax.swing.JLabel();
        loadAssets = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BattleShip Mocking J");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        setForeground(new java.awt.Color(0, 51, 255));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("BattleShip Mocking J");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Version 2.0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Loading....");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loadAssets, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(106, 106, 106)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(loadAssets, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AssetLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssetLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssetLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssetLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssetLoader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar loadAssets;
    // End of variables declaration//GEN-END:variables
}

 

