import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Menu extends JFrame{

	protected JPanel panel = new JPanel();
	private static String buttons[] = {"New Card", "Edit Card", "Remove Card"};
	protected ArrayList<Card> pokedeck;
	
	public Menu() {}
	
	public Menu(ArrayList<Card> pokedeck) {
		this.setSize(240, 260);
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		/*this.panel.add(new JButton("New Card"));
		this.panel.add(new JButton("Edit Card"));
		this.panel.add(new JButton("Remove Card"));*/
		for(int i=0; i<buttons.length; i++) {
			JButton but = new JButton(buttons[i]);
			but.addActionListener(new ButtonListener());
			this.panel.add(but);
		}
		this.setContentPane(panel);
		this.setVisible(true);
		this.pokedeck = pokedeck;
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(((JButton) e.getSource()).getText()=="New Card") {
	            AddCard addCard = new AddCard(pokedeck);
	        }
			else if(((JButton) e.getSource()).getText()=="Remove Card") {
				RemoveCard removeCard = new RemoveCard(pokedeck);
			}
	        else {
	            System.out.println(((JButton) e.getSource()).getText());
	        }
		}
	}

}
