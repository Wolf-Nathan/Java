import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ShowCollection extends Menu {
	private JRadioButton searchByName = new JRadioButton("Name");
	private JRadioButton searchById = new JRadioButton("ID");
	private JTextField search = new JTextField("");
	
	public ShowCollection() {}
	
	public ShowCollection(ArrayList<Card> pokedeck) {
		this.pokedeck = pokedeck;
		this.setLayout(new BorderLayout());
		this.panel = new JPanel();
		JPanel panel2 = new JPanel(new FlowLayout());
		//this.panel.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 300);
		this.setTitle("My Pokedeck");
		this.search.setPreferredSize(new Dimension(45, 20));
		this.searchByName.setSelected(true);
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(this.searchByName);
		radioGroup.add(this.searchById);
		this.panel.add(this.searchByName);
		this.panel.add(this.searchById);
		this.panel.add(this.search);
		JButton research = new JButton("Research");
		this.panel.add(research);
		research.addActionListener(new ButtonListener());
		for(int i=0; i<this.pokedeck.size(); i++) {
			Card c = this.pokedeck.get(i);
			JLabel cardLabel = new JLabel(c.getName()+" "+c.getDescription()+" "+c.getIDToString());
			panel2.add(cardLabel);
		}
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		//this.setContentPane(this.panel);
		this.add(this.panel, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public ShowCollection(ArrayList<Card> pokedeck, String elementSearch, int searchType) {
		this.pokedeck = pokedeck;
		this.setLayout(new FlowLayout());
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 300);
		this.setTitle("My Pokedeck");
		this.search.setPreferredSize(new Dimension(45, 20));
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(this.searchByName);
		radioGroup.add(this.searchById);
		this.panel.add(this.searchByName);
		this.panel.add(this.searchById);
		this.panel.add(this.search);
		JButton research = new JButton("Research");
		this.panel.add(research);
		research.addActionListener(new ButtonListener());
		if(searchType == 1) {
			this.searchById.setSelected(true);
			for(int i=0; i<this.pokedeck.size(); i++) {
				Card c = this.pokedeck.get(i);
				if(c.getIDToString().contains(elementSearch)) {
					JLabel cardLabel = new JLabel(c.getName()+" "+c.getDescription()+" "+c.getIDToString());
					this.panel.add(cardLabel);
				}
			}
		}
		else if(searchType == 2) {
			this.searchByName.setSelected(true);
			for(int i=0; i<this.pokedeck.size(); i++) {
				Card c = this.pokedeck.get(i);
				if(c.getName().contains(elementSearch)) {
					JLabel cardLabel = new JLabel(c.getName()+" "+c.getDescription()+" "+c.getIDToString());
					this.panel.add(cardLabel);
				}
			}
		}
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setContentPane(this.panel);
		this.setVisible(true);
		
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(searchById.isSelected()) {
				String elementSearch = search.getText();
				ShowCollection showCollection = new ShowCollection(pokedeck, elementSearch, 1);
				setVisible(false);
				dispose();
			}
			else if(searchByName.isSelected()) {
				String elementSearch = search.getText();
				ShowCollection showCollection = new ShowCollection(pokedeck, elementSearch, 2);
				setVisible(false);
				dispose();
			}
		}
	}
}
