import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddCard extends Menu {

	private JTextField nameText = new JTextField("Card name");
	private JTextField descriptionText = new JTextField("Card description");
	
	public AddCard() {}
	
	public AddCard(ArrayList<Card> pokedeck) {
		this.panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(240, 300);
		this.setTitle("Add Card");
		this.setLocationRelativeTo(null);
		this.panel.add(this.nameText);
		this.panel.add(this.descriptionText);
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
			Card c = new Card(name, description);
			System.out.println(c);
			pokedeck.add(c);
			System.out.println(pokedeck);
		}
	}
	
}

