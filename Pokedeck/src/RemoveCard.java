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
		this.panel2 = new JPanel(new FlowLayout());
		this.panel3 = new JPanel(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pokedeck = pokedeck;
		this.setSize(200, 300);
		//this.setResizable(false);
		this.setTitle("Remove Card");
		for(int i=0; i<this.pokedeck.size(); i++) {
			Card c = this.pokedeck.get(i);
			JLabel cardName = new JLabel(c.getName());
			JButton but = new JButton("Remove "+ c.getName());
			but.addActionListener(new ButtonListener());
			cardName.setSize(100, 30);
			but.setSize(100, 30);
			this.panel2.add(cardName);
			this.panel3.add(but);
		}
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.panel.add(panel2);
		this.panel.add(panel3);
		this.setContentPane(this.panel);
		this.setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String buttonName = ((JButton)e.getSource()).getText();
			String del = "Remove ";
			String name = buttonName.replace(del, "");
			System.out.println(name);
			for(int i = 0; i<pokedeck.size(); i++) {
				Card c = pokedeck.get(i);
				if(c.getName().contentEquals(name)) {
					pokedeck.remove(i);
					break;
				}
				System.out.println(pokedeck);
			}
			pokedeck.remove(name);
			
		}
	}
	
}
