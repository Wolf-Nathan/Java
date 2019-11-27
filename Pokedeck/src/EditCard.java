import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditCard extends Menu {
	private JTextField nameText;
	private JButton but = new JButton("Save");
	private JTextField descriptionText;
	private String cardName;
	
	public EditCard() {}
	
	public EditCard(ArrayList<Card> pokedeck, String name) {
		this.pokedeck = pokedeck;
		this.cardName = name;
		Card c = null;
		for(int i = 0; i<pokedeck.size(); i++) {
			c = pokedeck.get(i);
			if(c.getName().equals(name)) {
				break;
			}
			System.out.println(pokedeck);
		}
		if(c == null) {
			
		}
		else {
			this.panel = new JPanel();
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Edit " + c.getName());
			but.addActionListener(new ButtonListener());
			//JTextField nameText = new JTextField(c.getName());
			this.nameText.setText(c.getName());
			this.descriptionText.setText(c.getDescription());
			//JTextField descriptionText = new JTextField(c.getDescription());
			//JTextField idText = new JTextField(c.getID());
			this.panel.add(descriptionText);
			this.panel.add(nameText);
			//this.panel.add(idText);
			this.panel.add(but);
			this.setLocationRelativeTo(null);
			this.setLayout(new BorderLayout());
			this.setContentPane(this.panel);
			this.setVisible(true);
		}
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			String name = nameText.getText();
			String description = descriptionText.getText();
			// id = Integer.parseInt(idText.getText());
			Card c = new Card(name, description);
			for(int i=0; i<pokedeck.size(); i++) {
				Card temp = pokedeck.get(i);
				if(temp.getName().equals(cardName)) {
					pokedeck.remove(i);
					pokedeck.add(c);
					break;
				}
			}
			System.out.println(c);
			pokedeck.add(c);
			System.out.println(pokedeck);
		}
	}
	
}
