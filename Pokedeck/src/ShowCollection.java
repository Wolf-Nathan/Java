import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ShowCollection extends Menu {
	
	
	public ShowCollection() {}
	
	public ShowCollection(ArrayList<Card> pokedeck) {
		this.pokedeck = pokedeck;
		this.panel = new JPanel();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(200, 300);
		this.setTitle("My Pokedeck");
		for(int i=0; i<this.pokedeck.size(); i++) {
			Card c = this.pokedeck.get(i);
			JLabel cardLabel = new JLabel(c.getName()+c.getDescription()+c.getID());
			this.panel.add(cardLabel);
		}
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setContentPane(this.panel);
		this.setVisible(true);
	}
}
