/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;

/**
 *
 * @author licence
 */
public class Carte {
    private static String[] valeur = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi", "A"};
    private static String[] couleur = {"carreau", "coeur", "pique", "trefle"};
    private String val;
    private String forme;
    
    public Carte(String a, String b){
        if(contains(valeur, a) && contains(couleur, b)){
            this.val = a;
            this.forme = b;
        }
        else {
            this.val = "";
            this.forme = "";
        }
    }
    
    public Carte(){
        this.val = "";
        this.forme = "";
    }
    
    static public boolean contains(String[] T, String val) {
        return Arrays.toString(T).contains(val);
    }
    
    public String toString(){
        return "[" + this.val + " de " + this.forme+ "]";
    }
    
    public String getValeur(){
        return this.val;
    }
    
    public String getForme(){
        return this.forme;
    }
    
    public void setValeur(String a){
        this.val = a;
    }
    
    public void setForme(String b){
        this.forme = b;
    }
    
   public boolean comparateur(Carte adverse){
       int a = 100;
       int b = 100;
       for(int i=0; i<valeur.length; i++){
           if(valeur[i].equals(this.val)){
               a =i;
           }
       }
       for(int i=0; i<valeur.length; i++){
           if(valeur[i].equals(adverse.getValeur())){
               b =i;
           }
       }
       if(a > b){
          //return "Votre carte est plus forte !";
    	   return true;
       }
       // return "Votre carte est moins forte !";
       return false;

   }
   
   public ArrayList getPaquet(){
        ArrayList<Carte> paquet = new ArrayList();
        for(int i=0; i<13; i++){
            for(int j=0; j<4; j++){
                paquet.add(new Carte(this.valeur[i], this.couleur[j]));
            }
        }
        Collections.shuffle(paquet);
        return paquet;
   }
   
   
    
}
