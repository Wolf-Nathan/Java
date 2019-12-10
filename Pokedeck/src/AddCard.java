import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.Math;

public class AddCard extends Menu {

	private JTextField nameText = new JTextField("Card name");
	private JTextField descriptionText = new JTextField("Card description");
	private static String types[] = {
			"Steel", "Fighting", "Dragon", "Water", "Bug", "Dark", "Electric", "Fairy", "Fire", "Flying", 
			"Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock"
			};
	private JComboBox typeList = new JComboBox(types);
	
	public AddCard() {}
	
	public AddCard(ArrayList<Card> pokedeck) {
		this.panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(240, 300);
		this.setTitle("Add Card");
		this.setLocationRelativeTo(null);
		this.panel.add(this.nameText);
		this.panel.add(this.descriptionText);
		this.panel.add(this.typeList);
		JButton but = new JButton("Add this card");
		but.addActionListener(new ButtonListener());
		this.panel.add(but);
		this.setContentPane(panel);
		this.setVisible(true);
		this.pokedeck = pokedeck;
	}

	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String name = nameText.getText();
			String description = descriptionText.getText();
			String type = typeList.getSelectedItem().toString();
			int id = 0;
			boolean test = false;
			boolean test2 = true;
			//We generate a new id and verify is not already use
			do {
				id = 1000 + (int)(Math.random() * (100000 - 10000));
				int i = 0;
				while(i<pokedeck.size() && test2) {
					Card c = pokedeck.get(i);
					if(c.getID() == id) {
						test2 = false;
					}
					i++;
				}
				if(test2) {
					test = true;
				}
			}while(!test);
			
			Card c = new Card(name, description, id, type);
			System.out.println(c);
			pokedeck.add(c);
			System.out.println(pokedeck);
		}
	}
	
}

