import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Card> pokedeck = new ArrayList<Card>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Souhaitez-vous ajouter une carte ? (o/n)");
		String choice = sc.next();
		if(choice.equals("o")) {
			do {
				System.out.println("Veuillez rentrer le nom de la carte");
				String name = sc.next();
				sc.nextLine();
				System.out.println("Veuillez rentrer sa description");
				String description = sc.nextLine();
				Card c = new Card(name, description);
				pokedeck.add(c);
				System.out.println("Votre carte : " + c.toString() + " est ajouté.");
				System.out.println(pokedeck.toString());
				System.out.println("Voulez-vous ajouter une autre carte ?");
				choice = sc.next();
				sc.nextLine();
			}while(choice.equals("o"));
		}
		System.out.println(pokedeck.toString());
		System.out.println("Souhaitez-vous supprimer une carte ? (o/n)");
		choice = sc.next();
		if(choice.equals("o")) {
			do {
				System.out.println("Saisissez le numéro de la carte que vous souhaitez supprimer");
				int del = sc.nextInt();
				pokedeck.remove(del-1);
				System.out.println(pokedeck.toString());
				System.out.println("Voulez-vous supprimer une autre carte ?");
				choice = sc.next();
			}while(choice.equals("o"));
		}
		Menu menu = new Menu(pokedeck);
		
	}

}
