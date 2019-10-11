/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author licence
 */
public class Joueur {
    private int score;
    private ArrayList<Carte> paquet;
    
    public Joueur(){
        this.score = 0;
        Carte[] deck = new Carte[0];
        this.paquet = new ArrayList(Arrays.asList(deck));
    }
    
    public Carte tirer(){
        Carte a = this.paquet.get(0);
        this.paquet.remove(a);
        return a;
    }
    
    public void ajouter(Carte a){
        this.paquet.add(a);
    }

    @Override
    public String toString() {
        return "Joueur{" + "score=" + score + ", paquet=" + paquet + '}';
    }
    
    public boolean paquetVide(){
    	if(this.paquet.size() == 0) {
    		return true;
    	}
    	return false;
    }
    
    public int nombreCartes() {
    	return this.paquet.size();
    }
    
    public void gagner() {
    	this.score++;
    }
    
    public int score() {
    	return this.score;
    }
    
    
    //Fonction egalte qui pourra etre utiliser en jeu afin de gerer toutes les egalites
    public boolean egalite(Joueur adverse) {
    	System.out.println("Bataille !");
    	if(this.nombreCartes()!=0 && adverse.nombreCartes()!=0) {
	    	Carte a = this.tirer();
	    	Carte b = adverse.tirer();
	    	//On recupere la taille du paquet du joueur dans l'eventuel cas de la gestion d'une nouvelle egalite
	    	int taillePaquet = this.nombreCartes();
	    	if(a.comparateur(b)) {
	    		System.out.println("Votre carte est plus forte");
	    		this.ajouter(a);
	    		this.ajouter(b);
	    		return true;
	    	}
	    	else if(b.comparateur(a)) {
	    		System.out.println("Votre carte est moins forte");
	    		adverse.ajouter(b);
	    		adverse.ajouter(a);
	    		return true;
	    	}
	    	else {
	    		System.out.println("Nouvelle egalite !");
	    		//Si la bataille est encore égale on relance la fonction
	    		//On verifie que l'egalite a bien eu lieu
	    		if(this.egalite(adverse)) {
		    		//Ensuite on verifie la maniere dont le paquet du joueur a evolué afin de savoir si il a perdu la nouvelle bataille ou si il l'a emporte
		    		if(taillePaquet < this.nombreCartes()) {
		    			this.ajouter(a);
		    			this.ajouter(b);
		    			return true;
		    		}
		    		else if(taillePaquet > this.nombreCartes()) {
		    			adverse.ajouter(b);
		    			adverse.ajouter(a);
		    			return true;
		    		}
	    		}
	    		//Sinon on donne les cartes au joueur à qui il reste encore des cartes
	    		else {
	    			if(this.nombreCartes()==0) {
	    				adverse.ajouter(b);
	    				adverse.ajouter(a);
	    				return true;
	    			}
	    			else {
	    				this.ajouter(a);
	    				this.ajouter(b);
	    			}
	    		}
	    	}
    	}
    	return false;
    }
    
    
    
}
