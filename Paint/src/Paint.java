
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
 
public class Paint extends JFrame{
  private Dimension screen;
  
 // Declaration des différentes section (Nord, Sud, Centre) 	
  
  private JPanel nord;
  private JPanel sud;
  private PanneauCentre centre;
 
 // Declaration d'une barre de menu
  
  private JMenuBar menu;
  private JMenu file;
  private JMenu apropos;
  private JMenuItem annuler;
  private JMenuItem supprimerTout;
  private JMenuItem fond;
  private JMenuItem quitter;

 // Attribut concernant la Section nord
  
  private JComboBox listCouleur;
  private JComboBox listForme;
 
  private JLabel couleur;
  private JLabel forme;
  
  private JLabel taille;
  private JTextField taille1;
 
  private JToggleButton Crayon;
  private ImageIcon Crayon1;
  
  private JToggleButton Gomme;
  private ImageIcon Gomme1;
  
 
// Attribut concernant la Section Sud
  
  private JButton deleteAll;
  private JButton cancel;
  private JButton alignH;
  private JButton alignV;
  private JButton background;
  
// Attribut d'evenement
  
  private Event e = new Event();
  
  private String lien;
  private Container p = new Container();
 
  public Paint(){
    super("Paint");
    this.setSize(1000, 800);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.initialise();
    this.setVisible(true);
  }
 
  public void initialise(){
    this.menu();
    this.Nord();
    this.Centre();
    this.Sud();
  }
 
  //Création de la barre de menu
  public void menu(){
    this.menu = new JMenuBar();
    this.file = new JMenu("Fichier");
    this.apropos = new JMenu("A propos");
    this.annuler = new JMenuItem("Annuler");
    this.supprimerTout = new JMenuItem("Supprimer tout");
    this.fond = new JMenuItem("Couleur d'arrière-plan");
    this.quitter = new JMenuItem("Quitter");
 
    //this.sauver.addActionListener(this.e);
    this.annuler.addActionListener(e);
    this.supprimerTout.addActionListener(e);
    this.fond.addActionListener(e);
    this.quitter.addActionListener(this.e);
    this.apropos.addMenuListener(this.e);
    
    annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
    supprimerTout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
    fond.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
    quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));
 
    this.file.add(this.annuler);
    this.file.add(this.supprimerTout);
    this.file.add(this.fond);
    this.file.add(this.quitter);
    this.menu.add(this.file);
    this.menu.add(this.apropos);
    this.setJMenuBar(this.menu);
  }
 
  //Partie haute de la fenêtre
  public void Nord(){
    this.nord = new JPanel(new FlowLayout());
 
    this.couleur = new JLabel("Couleur : ");
    this.forme = new JLabel("Forme : ");
    this.taille = new JLabel("Taille : ");
 
    this.listCouleur = new JComboBox(Donnees.couleurs);
    this.listForme = new JComboBox(Donnees.formes);
 
    this.taille1 = new JTextField(10);
 
    this.Crayon = new JToggleButton(new ImageIcon(new ImageIcon("logoCrayon.png").getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT)));
    this.Gomme = new JToggleButton(new ImageIcon(new ImageIcon("logoGomme.png").getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT)));
 
    this.Crayon.addActionListener(e);
    this.Gomme.addActionListener(e);
 
 
    this.nord.add(this.couleur);
    this.nord.add(this.listCouleur);
    this.nord.add(this.forme);
    this.nord.add(this.listForme);
    this.nord.add(this.taille);
    this.nord.add(this.taille1);
    this.nord.add(this.Crayon);
    this.nord.add(this.Gomme);
 
    this.add(this.nord, BorderLayout.NORTH);
  }
 
  //Création de la zone de dessin de la fenêtre
  public void Centre(){
    this.centre = new PanneauCentre();
 
    this.centre.addMouseListener(e);
    this.centre.addMouseMotionListener(e);
 
    this.add(this.centre,BorderLayout.CENTER);
  }
 
  //Partie du bas de la fenêtre
  public void Sud(){
    this.sud = new JPanel();
 
    this.deleteAll = new JButton("Initialiser");
    this.cancel = new JButton("Revenir en arrière");
    this.alignV = new JButton("Alignement vertical");
    this.alignH = new JButton("Alignement horizontal");
    this.background = new JButton("Arrière-plan");
    
    this.deleteAll.addActionListener(e);
    this.cancel.addActionListener(e);
    this.alignH.addActionListener(e);
    this.alignV.addActionListener(e);
    this.background.addActionListener(e);
    
    this.deleteAll.setMnemonic(KeyEvent.VK_D);
    this.cancel.setMnemonic(KeyEvent.VK_Z);
    this.background.setMnemonic(KeyEvent.VK_A);
 
    this.sud.add(this.deleteAll);
    this.sud.add(this.cancel);
    this.sud.add(this.alignH);
    this.sud.add(this.alignV);
    this.sud.add(this.background);
 
    this.add(this.sud, BorderLayout.SOUTH);
  }
 

  
  public class Event implements MouseMotionListener,MouseListener,ActionListener, MenuListener{
	    private int dessinSelected = -1;
	    public void menuSelected(MenuEvent e){
	      Object src = e.getSource();
	      if(src.equals(apropos)){
	        JOptionPane.showMessageDialog(null,"Logiciel Paint réalisé dans le cadre de la L3 projet Web", "A propos", JOptionPane.INFORMATION_MESSAGE);
	      }
	    }
	    
	    public void menuCanceled(MenuEvent e){
	    	
	    }
	    
	    public void menuDeselected(MenuEvent e){
	    	
	    }
	    
	   
	    public void mouseMoved(MouseEvent e){
	      if(this.dessinSelected >= 0){
	        Dessin d = Donnees.listeD.get(this.dessinSelected);
	        d.setX(e.getX()-(d.getTaille()/2));
	        d.setY(e.getY()-(d.getTaille()/2));
	        centre.repaint();
	      }
	    }
	    public void mouseClicked(MouseEvent e){}
	    public void mouseExited(MouseEvent e){}
	    public void mouseEntered(MouseEvent e){}
	    public void mouseReleased(MouseEvent e){
	      this.dessinSelected = -1;
	    }
	    
	    //Dessiner une forme
	    public void mousePressed(MouseEvent e){
	      if(Crayon.isSelected()){
	        String s = taille1.getText();
	        int t;
	        if(s.equals("")) t = 50;
	        else t = Integer.parseInt(s);
	        String f = (String)listForme.getSelectedItem();
	        String c = (String)listCouleur.getSelectedItem();
	 
	        Dessin d = new Dessin(e.getX(),e.getY(),t,f,c);
	        Donnees.listeD.add(d);
	      }

	      //Effacer
	      if(Gomme.isSelected()){
	        String s = taille1.getText();
	        int t;
	        if(s.equals("")) t = 50;
	        else t = Integer.parseInt(s);
	        String f = (String)listForme.getSelectedItem();
	        String c = (String)listCouleur.getSelectedItem();
	        c = "blanc";
	 
	        Dessin d = new Dessin(e.getX(),e.getY(),t,f,c);
	        Donnees.listeD.add(d);
	      }
	 
	      centre.repaint();
	    }
	 
	    public void actionPerformed(ActionEvent e){
	      Object src = e.getSource();
	 
	      if(src.equals(quitter)) {
	    	  System.exit(0);
	      }
	 
	      boolean condition = (Crayon.isSelected() && Gomme.isSelected());
	      if(condition){
	        Crayon.setSelected(false);
	        Gomme.setSelected(false);
	        ((JToggleButton)e.getSource()).setSelected(true); // On active le dernier bouton activé
	      }
	 
	      //Tout supprimer
	      if(src.equals(deleteAll) || src.equals(supprimerTout)){
	        Donnees.listeD.removeAll(Donnees.listeD);
	      }
	 
	      //Annuler l'action
	      if(src.equals(cancel) || src.equals(annuler)){
	        if(Donnees.listeD.size()>0) {
	        	Donnees.listeD.remove(Donnees.listeD.size()-1);
	        }
	      }
	      
	 
	      //Aligner les dessins horizontalement
	      if(src == alignH){
	        int y = centre.getHeight()/2;
	        for(Dessin d: Donnees.listeD){
	          d.setY(y- (d.getTaille()/2));
	        }
	      }
	      
	      //Aligner les dessins verticalement
	      if(src == alignV){
	        int x = centre.getWidth()/2;
	        for(Dessin d: Donnees.listeD){
	          d.setX(x- (d.getTaille()/2));
	        }
	      }
	      
	      //Change la couleur du fond
	      if(src == background || src.equals(fond)) {
	    	  String c = (String)listCouleur.getSelectedItem();
	    	  Color couleur1;
	    	  if(c.equals("rouge")) couleur1 = Color.red;
	    	    else if(c.equals("blanc")) couleur1 = Color.white;
	    	    else if(c.equals("bleu")) couleur1 = Color.blue;
	    	    else if(c.contentEquals("vert")) couleur1 = Color.green;
	    	    else if(c.equals("noir")) couleur1 = Color.black;
	    	    else if(c.contentEquals("violet")) couleur1 = Color.magenta;
	    	    else if(c.contentEquals("orange")) couleur1 = Color.orange;
	    	    else if(c.contentEquals("rose")) couleur1 = Color.pink;
	    	    else if(c.contentEquals("jaune")) couleur1 = Color.yellow;
	    	    else if(c.contentEquals("cyan")) couleur1 = Color.CYAN;
	    	    else if(c.contentEquals("gris")) couleur1 = Color.gray;
	    	    else couleur1 = Color.white;
	    	  centre.setBackground(couleur1);
	      }
	      centre.repaint();
	    }

		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	  }
}