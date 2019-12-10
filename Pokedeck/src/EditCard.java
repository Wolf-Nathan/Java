import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditCard extends Menu {
	private JTextField nameText = new JTextField();
	private JButton but = new JButton("Save");
	private JTextField descriptionText = new JTextField();
	private String cardName;
	private int cardId;
	private String cardType;
	private int cardHP;
	
	public EditCard() {}
	
	public EditCard(ArrayList<Card> pokedeck, String name, String id) {
		this.pokedeck = pokedeck;
		this.cardName = name;
		Card c = new Card();
		for(int i = 0; i<this.pokedeck.size(); i++) {
			c = this.pokedeck.get(i);
			System.out.println(i);
			if(c.getName().equals(name) && c.getIDToString().equals(id)) {
				i=this.pokedeck.size();
			}
			System.out.println(pokedeck);
		}
		this.cardId = c.getID();
		this.cardType = c.getType();
		this.cardHP = c.getHP();
		this.panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Edit " + c.getName());
		this.setSize(240, 300);
		but.addActionListener(new ButtonListener());
		this.nameText.setText(c.getName());
		this.descriptionText.setText(c.getDescription());
		this.panel.add(nameText);
		this.panel.add(descriptionText);
		this.panel.add(but);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setContentPane(this.panel);
		this.setVisible(true);

	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			String name = nameText.getText();
			String description = descriptionText.getText();
			Card c = new Card(name, description, cardId, cardType, cardHP);
			for(int i=0; i<pokedeck.size(); i++) {
				Card temp = pokedeck.get(i);
				if(temp.getName().equals(cardName) && temp.getID() == cardId) {
					pokedeck.remove(i);
					pokedeck.add(c);
					break;
				}
			}
			System.out.println(c);
			System.out.println(pokedeck);
			setVisible(false);
			dispose();
		}
	}
	
}
