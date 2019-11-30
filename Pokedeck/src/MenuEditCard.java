import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MenuEditCard extends Menu {
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	public MenuEditCard() {}
	
	public MenuEditCard(ArrayList<Card> pokedeck) {
		this.pokedeck = pokedeck;
		this.panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Edit Card");
		this.setSize(240, 300);
		for(int i=0; i<this.pokedeck.size(); i++) {
			Card c = this.pokedeck.get(i);
			//JLabel cardName = new JLabel(c.getName());
			JButton but = new JButton("Edit "+ c.getName());
			but.addActionListener(new ButtonListener());
			//cardName.setSize(100, 30);
			but.setSize(100, 30);
			//this.panel2.add(cardName);
			this.panel.add(but);
		}
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		//this.panel.add(panel2);
		//this.panel.add(panel3);
		this.setContentPane(this.panel);
		this.setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String buttonName = ((JButton)e.getSource()).getText();
			String del = "Edit ";
			String name = buttonName.replace(del, "");
			System.out.println(name);
			EditCard editCard = new EditCard(pokedeck, name);
			setVisible(false);
			dispose();
			
		}
	}
	
}