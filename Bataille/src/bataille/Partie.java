package bataille;

import java.util.ArrayList;
import java.util.Collections;

public class Partie {
    private static String[] valeur = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi", "A"};
    private static String[] couleur = {"carreau", "coeur", "pique", "trefle"};
    private ArrayList<Carte> jeu;
    
    
    public Partie() {
    	this.jeu = new ArrayList();
    }
    
    //Fonction qui initialise le jeu de cartes et le mélange
   public void jeu(){
        for(int i=0; i<13; i++){
            for(int j=0; j<4; j++){
                this.jeu.add(new Carte(this.valeur[i], this.couleur[j]));
            }
        }
        Collections.shuffle(this.jeu);
   }
   
   public void partieBataille(Joueur joueur1, Joueur joueur2) {
	   this.jeu();
	   this.distribution(joueur1, joueur2);
	   System.out.println(joueur1);
       System.out.println(joueur2);
       while(!joueur1.paquetVide() && !joueur2.paquetVide()){
      	 Carte a = joueur1.tirer();
           Carte b = joueur2.tirer();
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
           	// Le paquet égalité permet de stocker le nombre de cartes que possède le joueur1 avant que la bataille n'aie lieu
           	// Une fois la fonction égalité effectuée il suffit de comparer ce nombre avec le nouveau nombre de cartes du joueur1
           	// Si il en a plus c'est qu'il a remporté l'égalité et on lui ajoute les cartes en cours sinon elles vont au joueur 2
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
   
   public void distribution(Joueur joueur1, Joueur joueur2) {
	   for(int i =0; i<this.jeu.size(); i++){
           joueur1.ajouter(this.jeu.get(i));
           i++;
           joueur2.ajouter(this.jeu.get(i));
       }
   }
}
