import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{

	private JPanel panel = new JPanel();
	
	public Menu() {
		this.setSize(240, 260);
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.panel.add(new JButton("New Card"));
		this.panel.add(new JButton("Edit Card"));
		this.panel.add(new JButton("Remove Card"));
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
