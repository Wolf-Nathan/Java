import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickOn implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton) e.getSource()).getText()=="New Card") {
            Card c = new Card("Pikachu", "Le pokémon soyeux");
            System.out.println(c);
        }
        else {
            System.out.println(((JButton) e.getSource()).getText());
        }
	}

}
