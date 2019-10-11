/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille;
import java.util.ArrayList;

/**
 *
 * @author licence
 */
public class Bataille {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    	Partie partie = new Partie();
    	Joueur joueur1 = new Joueur();
    	Joueur joueur2 = new Joueur();
    	partie.partieBataille(joueur1, joueur2);
    }
    
    
}
