/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmockingj;

import java.awt.Color;



/**
 *
 * @author owoye001
 */
public class BattleShipMockingJ {
    public static AssetLoader loader;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //this is the main method 
        loader = new AssetLoader();
        loader.setBackground(Color.black);
        loader.setLocationRelativeTo(null);
        loader.setVisible(true);
        
    }
    
}
