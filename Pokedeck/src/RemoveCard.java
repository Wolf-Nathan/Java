import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RemoveCard extends Menu {
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	public RemoveCard() {}
	
	public RemoveCard(ArrayList<Card> pokedeck) {
		this.panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pokedeck = pokedeck;
		this.setSize(300, 300);
		this.setTitle("Remove Card");
		for(int i=0; i<this.pokedeck.size(); i++) {
			Card c = this.pokedeck.get(i);
			JButton but = new JButton("Remove "+ c.getName() +" - " +  c.getIDToString());
			but.addActionListener(new ButtonListener());
			but.setSize(100, 30);
			this.panel.add(but);
		}
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setContentPane(this.panel);
		this.setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String buttonName = ((JButton)e.getSource()).getText();
			String del = "Remove ";
			String name = buttonName.replace(del, "");
			String split[] = name.split(" - ", 2);
			name = split[0];
			String id = split[1];
			System.out.println(name);
			for(int i = 0; i<pokedeck.size(); i++) {
				Card c = pokedeck.get(i);
				if(c.getName().contentEquals(name)) {
					if(c.getIDToString().contentEquals(id)) {
						pokedeck.remove(i);
						break;
					}
				}
				System.out.println(pokedeck);
			}
			pokedeck.remove(name);
			RemoveCard removeCard = new RemoveCard(pokedeck);
			setVisible(false);
			dispose();
			
		}
	}
	
}
