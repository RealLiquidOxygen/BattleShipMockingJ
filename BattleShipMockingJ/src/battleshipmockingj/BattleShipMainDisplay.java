/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmockingj;

import static battleshipmockingj.AssetLoader.remainingString;
import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author owoye001
 */
public class BattleShipMainDisplay extends javax.swing.JFrame {

    
    
    public static ImageIcon images[]; //player images
    private  ImageIcon defaultImage;
    private  ImageIcon currentImage;
    private boolean GameStatusStart = false; //game has not started 
    int HitCount1 = 0;
        int MissCount1 = 0;
        int HitCount2 = 0;
        int MissCount2 = 0;
    /**
     * Creates new form BattleShipMainDisplay
     */
    public BattleShipMainDisplay() {
        initComponents();
        
        setSize(1355, 1133);
        
        getContentPane().setBackground(Color.BLACK);
        
        
        //odd load player information button made invisible 
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        
        defaultImage = new ImageIcon(AssetLoader.players.get(0)
                
                .getImage().getScaledInstance(330, 310, 4)); //displays default user's image

        currentImage = defaultImage; //at load user image is default image 
        FirstPlayer.setIcon(defaultImage); //default picture
        SecondPlayer.setIcon(defaultImage);
        
        MP3Player hit=new MP3Player (new File(remainingString + "hit" + ".mp3"));
        MP3Player miss=new MP3Player (new File(remainingString + "missed" + ".mp3"));
        
        //add status listener to this
        firstPlayerStatusLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                AssetLoader.sounds.get(1).play();
                if(e.getClickCount()==1){
                    // pass who is playing
                    firstPlayerStatusLabel.setBackground(Color.red);
                    secondPlayerStatusLabel.setBackground(Color.green);
                    if (GameStatusStart==true){
                    player1Details.setText("<html><p>Hit Count: " + HitCount1 + "</p><p>Miss Count: " + ++MissCount1 + "</p></html>");
                    //miss.play();
                    }
                    
                } else if(e.getClickCount()==2){
                    //mock player here and pass who is playing
                    firstPlayerStatusLabel.setBackground(Color.red);
                    secondPlayerStatusLabel.setBackground(Color.green);
                    if (GameStatusStart==true){
                        --MissCount1;
                    player1Details.setText("<html><p>Hit Count: " + ++HitCount1 + "</p><p>Miss Count: " + MissCount1 + "</p></html>");
                    hit.play();
                    }
                 }
            }
        });
        
        //add status listener to this object
        secondPlayerStatusLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                AssetLoader.sounds.get(1).play();
                if(e.getClickCount()==1){
                    // pass who is playing
                    firstPlayerStatusLabel.setBackground(Color.green);
                    secondPlayerStatusLabel.setBackground(Color.red);
                    if (GameStatusStart==true){
                    player2Details.setText("<html><p>Hit Count: " + HitCount2 + "</p><p>Miss Count: " + ++MissCount2  + "</p></html>");
                    //miss.play();
                    }
                } else if(e.getClickCount()==2){
                    //mock player here and pass who is playing
                    firstPlayerStatusLabel.setBackground(Color.green);
                    secondPlayerStatusLabel.setBackground(Color.red);
                    if (GameStatusStart==true) {
                        --MissCount2;
                    player2Details.setText("<html><p>Hit Count: " + ++HitCount2 + "</p><p>Miss Count: " + MissCount2  + "</p></html>");
                    new MP3Player (new File(remainingString + "hit" + ".mp3")).play();
                    hit.play();
                    }
                 }
            }
        });
       
        
    }
    
     private void SwearAtThePlayers() {
                SecureRandom scr = new SecureRandom();
                
                int guess = scr.nextInt(25);
                
                while (guess==0){
                    guess = scr.nextInt(25);
                }
                 AssetLoader.sounds.get(guess).play();
            }
    
     public ArrayList LoadPlayerInfo(){
         ArrayList list = new ArrayList<>();
         JFileChooser filechoose = new JFileChooser(); //open dialog box 
                filechoose.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
                int result = filechoose.showOpenDialog(this); //show dialog box here
                if (result == JFileChooser.APPROVE_OPTION) { //if the us clicks okay on the file chooser dialog box 

                    File file = filechoose.getSelectedFile(); //get the selected file object here. 
                    String sname = file.getAbsolutePath(); //returns the absolute path of the file  

                    currentImage = new ImageIcon(new ImageIcon(sname).getImage().
                            getScaledInstance(330, 310, 4)); //getting a scaled instance of the picture loaded by the customer

                    list.add(CollectUserName());
                    list.add(currentImage);
                    return list;
                     } else {
                    list.add(CollectUserName());
                    list.add(defaultImage);
                    return list;
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

        jLabel1 = new javax.swing.JLabel();
        FirstPlayer = new javax.swing.JLabel();
        SecondPlayer = new javax.swing.JLabel();
        firstPlayerStatusLabel = new javax.swing.JLabel();
        secondPlayerStatusLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInstruction = new javax.swing.JTextArea();
        jLPlayer2 = new javax.swing.JLabel();
        jLPlayer1 = new javax.swing.JLabel();
        jButtonStartGame = new javax.swing.JButton();
        jLabelTime = new javax.swing.JLabel();
        player1Details = new javax.swing.JLabel();
        player2Details = new javax.swing.JLabel();
        jButtonSwear = new javax.swing.JButton();

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

        FirstPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FirstPlayer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(FirstPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 330, 310));

        SecondPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SecondPlayer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(SecondPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 250, 330, 310));

        firstPlayerStatusLabel.setBackground(new java.awt.Color(255, 255, 255));
        firstPlayerStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstPlayerStatusLabel.setText("STATUS");
        firstPlayerStatusLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        firstPlayerStatusLabel.setOpaque(true);
        getContentPane().add(firstPlayerStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 210, 120));

        secondPlayerStatusLabel.setBackground(new java.awt.Color(255, 255, 255));
        secondPlayerStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondPlayerStatusLabel.setText("STATUS");
        secondPlayerStatusLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        secondPlayerStatusLabel.setOpaque(true);
        getContentPane().add(secondPlayerStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, 210, 110));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 51));
        jButton1.setText("Load Info");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 720, 310, 60));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 51));
        jButton2.setText("Load Info");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 720, 280, 60));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 51));
        jButton3.setText("History");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 810, 260, 70));

        jTextAreaInstruction.setColumns(20);
        jTextAreaInstruction.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jTextAreaInstruction.setRows(5);
        jTextAreaInstruction.setText("Single Click On Status\nFor No Hit\n\nDouble Click on Status\nFor a Hit\n\nClick Stop Game When\n\nGame Over");
        jTextAreaInstruction.setWrapStyleWord(true);
        jTextAreaInstruction.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jScrollPane1.setViewportView(jTextAreaInstruction);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 460, 390));

        jLPlayer2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLPlayer2.setForeground(new java.awt.Color(0, 204, 51));
        jLPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLPlayer2.setText("Annonymous");
        getContentPane().add(jLPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 370, 70));

        jLPlayer1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLPlayer1.setForeground(new java.awt.Color(0, 204, 51));
        jLPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLPlayer1.setText("Annonymous");
        getContentPane().add(jLPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 400, 70));

        jButtonStartGame.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonStartGame.setForeground(new java.awt.Color(0, 204, 51));
        jButtonStartGame.setText("Start Game");
        jButtonStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartGameActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonStartGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 890, 460, 100));

        jLabelTime.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 51, 51));
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTime.setText("00:00:00");
        getContentPane().add(jLabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 270, 120));

        player1Details.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        player1Details.setForeground(new java.awt.Color(0, 204, 51));
        player1Details.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Details.setText("<html><p>Hit Count: 0</p><p>Miss Count: 0</p></html>");
        player1Details.setToolTipText("");
        getContentPane().add(player1Details, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 810, 180, 140));

        player2Details.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        player2Details.setForeground(new java.awt.Color(0, 204, 51));
        player2Details.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Details.setText("<html><p>Hit Count: 0</p><p>Miss Count: 0</p></html>");
        player2Details.setToolTipText("");
        getContentPane().add(player2Details, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 810, 180, 140));

        jButtonSwear.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButtonSwear.setForeground(new java.awt.Color(255, 51, 51));
        jButtonSwear.setText("Swear");
        jButtonSwear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSwearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSwear, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 750, 180, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        ArrayList result = LoadPlayerInfo(); //arraylist of result 
      
        FirstPlayer.setIcon((ImageIcon)result.get(1)); //user's picture
        jLPlayer1.setText((String)result.get(0)); //setting the user name here 

               

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
         ArrayList result = LoadPlayerInfo(); //arraylist of result 
         
        SecondPlayer.setIcon((ImageIcon)result.get(1)); //user's picture
        jLPlayer2.setText((String)result.get(0)); //setting the user name here
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartGameActionPerformed
        // start game session here 
        AssetLoader.theme.stop();
        
        AssetLoader.sounds.get(1).play();
        //asking user if they want to enter user info here 
        if (GameStatusStart==false){
            
             int selectedOption = JOptionPane.showConfirmDialog(this, 
                                  "Does both parites want to enter user data?", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION); 
        if (selectedOption == JOptionPane.YES_OPTION) {
            //collecting user 1 and 2 data here.
            //used a button before, but then I decided to just use the buttons as methods. 
            jButton1.doClick();
            jButton2.doClick();
            
        } 
        jButtonStartGame.setText("Stop Game");
        GameStatusStart = true; //game as started
        
        //ensuring that user is ready to start a game session here 
        AreYouReady();
        
        } else {
            
            //stop the game reset counter to default conditions 
            //user wants to stop a current game session here 
            ResetGame();
        }
    }//GEN-LAST:event_jButtonStartGameActionPerformed
BattleShipHistory battHistory; //JFrame variable to help with making the JFrame visible or not 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       //loads the history screen 
        AssetLoader.theme.stop(); //stop theme song
        
        AssetLoader.sounds.get(1).play(); //play button click
        
        battleShipMainDisplay = this;
        
        setVisible(false); //hide current frame
        
        //necessary error handling 
        if (battHistory==null){
         battHistory =  new BattleShipHistory();
         battHistory.setVisible(true);
      }else{ //this condition might never happen.
          battHistory.dispose();
          battHistory=null;
          battHistory =  new BattleShipHistory();
          battHistory.setVisible(true);
      }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonSwearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSwearActionPerformed
        // TODO add your handling code here:
        SwearAtThePlayers();
    }//GEN-LAST:event_jButtonSwearActionPerformed

    public static BattleShipMainDisplay battleShipMainDisplay;
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
            java.util.logging.Logger.getLogger(BattleShipMainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BattleShipMainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BattleShipMainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BattleShipMainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 battleShipMainDisplay = new BattleShipMainDisplay();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel FirstPlayer;
    public javax.swing.JLabel SecondPlayer;
    public javax.swing.JLabel firstPlayerStatusLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonStartGame;
    private javax.swing.JButton jButtonSwear;
    private javax.swing.JLabel jLPlayer1;
    private javax.swing.JLabel jLPlayer2;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabelTime;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextAreaInstruction;
    private javax.swing.JLabel player1Details;
    private javax.swing.JLabel player2Details;
    public javax.swing.JLabel secondPlayerStatusLabel;
    // End of variables declaration//GEN-END:variables

    
    //this method collects user name 
    private String CollectUserName() {
       
        String playername;
        
        int selectedOption = JOptionPane.showConfirmDialog(this, 
                                  "Do you wanna specify your name?", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION); 
        if (selectedOption == JOptionPane.YES_OPTION) {
             playername = JOptionPane.showInputDialog("Please enter your name ");

                return playername;
        } else {
        
        return "Annonymous";
        }

    }

    //this method ensure the users are ready to start their session. 
    private void AreYouReady() {
       
        
         int selectedOption = JOptionPane.showConfirmDialog(this, 
                                  "Do you want to continue?", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION); 
        if (selectedOption == JOptionPane.YES_OPTION) {
             //start game timer
             startTimer();
             firstPlayerStatusLabel.setBackground(Color.green);
                    secondPlayerStatusLabel.setBackground(Color.red);
            
        } else { 
           
        GameStatusStart=false;
        jButtonStartGame.setText("Start Game");
        firstPlayerStatusLabel.setBackground(Color.white);
                    secondPlayerStatusLabel.setBackground(Color.white);
            
        }
    }

    
    //resets game to default conditions and also saves game history
    private void ResetGame() {
        
        //save history 
        
        //stop timer first
        stopTimer();
        
        
          int selectedOption = JOptionPane.showConfirmDialog(this, 
                                  "Do you want to save who won into history?", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION); 
        if (selectedOption == JOptionPane.YES_OPTION) {
           //save game session to database
           
           //ask who won the game
           
            Object[] options = { jLPlayer1.getText().toString(), jLPlayer2.getText().toString(), "Cancel"};

           int result = JOptionPane.showOptionDialog(this,//parent container of JOptionPane
            "Who won this battle? ",
            "BattleShip Mocking J",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,//do not use a custom Icon
            options,//the titles of buttons
            options[1]);//default button title
           
            if (result == JOptionPane.YES_OPTION){
                appendToHistory(jLPlayer1.getText() + " beat " + jLPlayer2.getText() +"\nGame Details\n---------------\n1. Hit Count: " + HitCount1 + "\n2. Miss Count: " + MissCount1 + "\n in " + jLabelTime.getText() + " on " + new Date());
                 JOptionPane.showMessageDialog(this, "History saved", "BattleShip Mocking J", JOptionPane.INFORMATION_MESSAGE);
            } else if (result == JOptionPane.NO_OPTION){
                appendToHistory(jLPlayer2.getText() + " beat " + jLPlayer1.getText() +"\nGame Details\n---------------\n1. Hit Count: " + HitCount2 + "\n2. Miss Count: " + MissCount2 + "\n in " + jLabelTime.getText() + " on " + new Date());
                JOptionPane.showMessageDialog(this, "History saved", "BattleShip Mocking J", JOptionPane.INFORMATION_MESSAGE);
            } else if (result == JOptionPane.CANCEL_OPTION){
                 JOptionPane.showMessageDialog(this, "History not saved", "BattleShip Mocking J", JOptionPane.INFORMATION_MESSAGE);
            }
            
        //ask user if they want to play again
         //ask if both users want to play again
            int selectedOptioned = JOptionPane.showConfirmDialog(this, 
                                  "Do you want to play again?", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION); 
            if (selectedOptioned == JOptionPane.YES_OPTION) {
                 //sstart another game session
                 stopTimer();
                 jButtonStartGame.setText("Stop Game");
                 AreYouReady();
                GameStatusStart = true; //game as started
                 firstPlayerStatusLabel.setBackground(Color.green);
                    secondPlayerStatusLabel.setBackground(Color.red);
                     HitCount1 = 0;
                         MissCount1 = 0;
                         HitCount2 = 0;
                         MissCount2 = 0;
                        player1Details.setText("<html><p>Hit Count: " + "0" + "</p><p>Miss Count: " + "0"  + "</p></html>");
                        player2Details.setText(player1Details.getText());

            } else { 
                //reset game here
               FirstPlayer.setIcon(defaultImage); //user's picture
               jLPlayer1.setText("Annonymous"); //setting the user name here
               SecondPlayer.setIcon(defaultImage); //user's picture
               jLPlayer2.setText("Annonymous"); //setting the user name here
               GameStatusStart=false; //reset
               jButtonStartGame.setText("Start Game");
                firstPlayerStatusLabel.setBackground(Color.white);
                    secondPlayerStatusLabel.setBackground(Color.white);
                      HitCount1 = 0;
                         MissCount1 = 0;
                         HitCount2 = 0;
                         MissCount2 = 0;
                        player1Details.setText("<html><p>Hit Count: " + "0" + "</p><p>Miss Count: " + "0"  + "</p></html>");
                        player2Details.setText(player1Details.getText());
                        
               stopTimer();
                
            }
           
            
        } else { 
           //do not save session to database. 
           //ask if both users want to play again
            int selectedOptioned = JOptionPane.showConfirmDialog(this, 
                                  "Do you want to play again?", 
                                  "Choose", 
                                  JOptionPane.YES_NO_OPTION); 
            if (selectedOptioned == JOptionPane.YES_OPTION) {
                 //sstart another game session
                 stopTimer();
                 jButtonStartGame.setText("Stop Game");
                 AreYouReady();
                GameStatusStart = true; //game as started
                 firstPlayerStatusLabel.setBackground(Color.green);
                    secondPlayerStatusLabel.setBackground(Color.red);
                     HitCount1 = 0;
                         MissCount1 = 0;
                         HitCount2 = 0;
                         MissCount2 = 0;
                        player1Details.setText("<html><p>Hit Count: " + "0" + "</p><p>Miss Count: " + "0"  + "</p></html>");
                        player2Details.setText(player1Details.getText());

            } else { 
                //reset game here
               FirstPlayer.setIcon(defaultImage); //user's picture
               jLPlayer1.setText("Annonymous"); //setting the user name here
               SecondPlayer.setIcon(defaultImage); //user's picture
               jLPlayer2.setText("Annonymous"); //setting the user name here
               GameStatusStart=false; //reset
               jButtonStartGame.setText("Start Game");
                firstPlayerStatusLabel.setBackground(Color.white);
                    secondPlayerStatusLabel.setBackground(Color.white);
                     HitCount1 = 0;
                         MissCount1 = 0;
                         HitCount2 = 0;
                         MissCount2 = 0;
                        player1Details.setText("<html><p>Hit Count: " + "0" + "</p><p>Miss Count: " + "0"  + "</p></html>");
                        player2Details.setText(player1Details.getText());
               stopTimer();
                
            }
        }
        
    }
    
    public void appendToHistory (String input) {

      BufferedWriter bw = null;

      try {
         // APPEND MODE SET HERE "History/History.bsj"
        // bw = new BufferedWriter(new FileWriter(getClass().getResource("History/History.bsj").toString().substring(6), true)); //in netbeans only
         bw = new BufferedWriter(new FileWriter("History/History.bsj", true)); //outside of netbean, jar file launch
	 bw.write(input);
	 bw.newLine();
	 bw.flush();
      } catch (IOException ioe) {
	 ioe.printStackTrace();
      } finally {                       // always close the file
	 if (bw != null) try {
	    bw.close();
	 } catch (IOException ioe2) {
	    // just ignore it
	 }
      } // end try/catch/finally

   } // end test()

    TimeElapsed timerCounter = null;
    private void startTimer() {
        timerCounter = new TimeElapsed();
    }
    
    //stop game session timer 
    private void stopTimer() {
        
        try{
         timerCounter.timerCounterReal.stop();
         timerCounter = null;
        } catch (NullPointerException e){
            timerCounter = null;
        }
    }

}
