import javax.swing.*;
import java.awt.*;
 
public class PanneauCentre extends JPanel{
 

  public PanneauCentre(){
    super();
    this.setBackground(Color.WHITE);	// Met un fond blanc
  }
 
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(Dessin d: Donnees.listeD){
      if(d.getForme() == "cercle"){	// Dessin du Cercle
        g.setColor(d.getCouleur());
        g.fillOval(d.getX(), d.getY(), d.getTaille(), d.getTaille());
      }
      if(d.getForme() == "carre"){	// Dessin du Carre
        g.setColor(d.getCouleur());
        g.fillRect(d.getX(),d.getY(),d.getTaille(),d.getTaille());
      }
    }
  }
}