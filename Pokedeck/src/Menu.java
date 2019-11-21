import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JFrame{

	private JPanel panel = new JPanel();
	private static String buttons[] = {"New Card", "Edit Card", "Remove Card"};
	
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
			but.addActionListener(new ClickOn());
			this.panel.add(but);
		}
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
