import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choix = 0;
		Personnage joueur = new Guerrier();
		do {
			System.out.println("Voulez-vous incarner un Guerrier ou bien un Archer ?(Guerrier tapez 1/ Archer tapez 2)");
			choix = sc.nextInt();
		}while(choix!=1 && choix!=2);
		if(choix==1) {
			joueur = new Guerrier();
			System.out.println("Vous êtes donc un guerrier.");
		}
		else if(choix == 2 ) {
			joueur = new Archer();
			System.out.println("Vous êtes donc un archer.");
		}
		System.out.println(joueur);
		
		Personnage archer = new Archer();
		Personnage guerrier = new Guerrier();
		System.out.println(archer);
		System.out.println(guerrier);
		
	}

}
