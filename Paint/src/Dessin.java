import java.awt.*;
 
public class Dessin{
  private int x;
  private int y;
  private int taille;
  private String forme;
  private Color couleur;
 
  public Dessin(int x,int y,int t, String f, String c){
    this.x = x-(t/2);
    this.y = y-(t/2);
    this.taille = t;
    this.forme = f;
 
    Color couleur1;
    if(c.equals("rouge")) couleur1 = Color.red;
    else if(c.equals("blanc")) couleur1 = Color.white;
    else if(c.equals("bleu")) couleur1 = Color.blue;
    else if(c.contentEquals("vert")) couleur1 = Color.green;
    else if(c.equals("noir")) couleur1 = Color.black;
    else if(c.contentEquals("violet")) couleur1 = Color.magenta;
    else couleur1 = Color.green;
    this.couleur = couleur1;
 
  }
 
  public int getX(){
	  return this.x;
  }
  
  public int getY(){
	  return this.y;
  }
 
  public String getForme(){
	  return  this.forme;
  }
  
  public int getTaille(){
	  return this.taille;
  }
  
  public Color getCouleur(){
	  return this.couleur;
  }
  
  public void setX(int x){
	  this.x = x;
  }
  
  public void setY(int y){
	  this.y = y;
  }
  
  public void setForme(String f){
	  this.forme = f;
  }
  
  public void setTaille(int t){
	  this.taille = t;
  }
  
  public void setCouleur(Color c){
	  this.couleur = c;
  }
 
}
 