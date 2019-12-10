import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Menu extends JFrame implements Serializable{

	protected JPanel panel = new JPanel();
	private static String buttons[] = {"New Card", "Edit Card", "Remove Card", "Show Collection", "Save Pokedeck", "Load Pokedeck"};
	protected ArrayList<Card> pokedeck;
	
	public Menu() {}
	
	public Menu(ArrayList<Card> pokedeck) {
		this.setSize(240, 310);
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.panel.add(new JLabel("Welcome to Pokedeck !"));
		for(int i=0; i<buttons.length; i++) {
			JButton but = new JButton(buttons[i]);
			but.addActionListener(new ButtonListener());
			but.setPreferredSize(new Dimension(150,35));
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
			else if(((JButton) e.getSource()).getText()=="Edit Card") {
				MenuEditCard menuEditCard = new MenuEditCard(pokedeck);
			}
			else if(((JButton) e.getSource()).getText()=="Show Collection") {
				ShowCollection showCollection = new ShowCollection(pokedeck);
			}
			else if (((JButton) e.getSource()).getText()=="Save Pokedeck") {
				try {
					FileOutputStream fos = new FileOutputStream("pokedeck.serial");
					try {
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						try {
							oos.writeObject(pokedeck);
							oos.flush();
							JLabel saveMessage = new JLabel("Your pokedeck is save.");
							JOptionPane.showMessageDialog(null, saveMessage);
						}finally {
							try {
			                    oos.close();
			                } finally {
			                    fos.close();
			                }
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (((JButton) e.getSource()).getText()=="Load Pokedeck") {
				File f = new File("pokedeck.serial");
				if(f.isFile()) {
					try {
						FileInputStream fis = new FileInputStream("pokedeck.serial");
						ObjectInputStream ois = new ObjectInputStream(fis);
						try {    
			                pokedeck = (ArrayList<Card>) ois.readObject(); 
			            } catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
			                try {
			                    ois.close();
			                } finally {
			                    fis.close();
			                }
			            }
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(pokedeck != null) {
						JLabel loadMessage = new JLabel("Load pokedeck success.");
						JOptionPane.showMessageDialog(null, loadMessage);
					}
				}
				else {
					JLabel noLoadMessage = new JLabel("No pokedeck data was find :/");
					JOptionPane.showMessageDialog(null, noLoadMessage);
				}
			}
	        else {
	            System.out.println(((JButton) e.getSource()).getText());
	        }
		}
	}

}
