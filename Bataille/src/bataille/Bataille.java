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
        Carte test = new Carte();
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        ArrayList<Carte> paquet = new ArrayList();
        paquet = test.getPaquet();
        System.out.println(paquet.size());
        System.out.println(paquet);
        for(int i =0; i<paquet.size(); i++){
            joueur1.ajouter(paquet.get(i));
            i++;
            joueur2.ajouter(paquet.get(i));
        }
        System.out.println(joueur1);
        System.out.println(joueur2);
        while(!joueur1.paquetVide() && !joueur2.paquetVide()){
        	 Carte a = joueur1.tirer();
             Carte b = joueur2.tirer();
             System.out.println(a.comparateur(b));
             if(a.comparateur(b)) {
             	System.out.println("Votre carte est plus forte !");
             	joueur1.ajouter(a);
             	joueur1.ajouter(b);
             	joueur1.gagner();
             }
             else if(b.comparateur(a)) {
             	System.out.println("Votre carte est moins forte !");
             	joueur2.ajouter(b);
             	joueur2.ajouter(a);
             	joueur2.gagner();
             }
             else {
             	System.out.println("Egalite !");
             	// Une nouvelle bataille se joue pour obtenir 4 cartes
             	int paquetEgalite = joueur1.nombreCartes();
             	if(joueur1.egalite(joueur2)) {
	             	if(paquetEgalite < joueur1.nombreCartes()) {
	             		joueur1.ajouter(a);
	             		joueur1.ajouter(b);
	             		joueur1.gagner();
	             	}
	             	else if(paquetEgalite > joueur1.nombreCartes()) {
	             		joueur2.ajouter(b);
	             		joueur2.ajouter(a);
	             		joueur2.gagner();
	             	}
             	}
             	else {
             		if(joueur1.nombreCartes()==0) {
             			joueur2.ajouter(b);
             			joueur2.ajouter(a);
             			joueur2.gagner();
             		}
             		else {
             			joueur1.ajouter(a);
             			joueur1.ajouter(b);
             			joueur1.gagner();
             		}
             	}
             }
             System.out.println(joueur1.nombreCartes());
             System.out.println(joueur2.nombreCartes());
             System.out.println(joueur1);
             System.out.println(joueur2);
        }
        if(joueur2.nombreCartes()==0) {
       	 System.out.println("Le joueur 1 a gagné !!");
        }
        else {
       	 System.out.println("Le joueur 2 a gagné !!");
        }
        System.out.println("Score final :  Joueur 1 : "+ joueur1.score() + " | Joueur 2 : " + joueur2.score());
    }
    
    
}
