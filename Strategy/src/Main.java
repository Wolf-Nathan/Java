import java.lang.Thread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Robot map[][] = new Robot[10][15];
		Robot joyeux = new RobotNeutre(2, 6, "Joyeux");
		map[joyeux.getX()][joyeux.getY()] = joyeux;
		Robot grincheux = new RobotNeutre(9,14, "Grincheux");
		map[grincheux.getX()][grincheux.getY()] = grincheux;
		Robot atchoum = new RobotNeutre(3,3, "Atchoum");
		map[atchoum.getX()][atchoum.getY()] = atchoum;
		Robot simplet = new RobotNeutre(0,0, "Simplet");
		map[simplet.getX()][simplet.getY()] = simplet;
		Robot prof = new RobotNeutre(9,8, "Prof");
		map[prof.getX()][prof.getY()] = prof;
		Robot timide = new RobotNeutre(0,14, "Timide");
		map[timide.getX()][timide.getY()] = timide;
		Robot dormeur = new RobotNeutre(4,7, "Dormeur");
		map[dormeur.getX()][dormeur.getY()] = dormeur;
		
		
		int robotVivant = 7;
		//C'est cette variable qui va nous permettre de savoir si il y a encore des robots en jeu et si la partie doit s'arreter
		do {
			System.out.println("Affichage de la map");
			Thread.sleep(3*1000);
			for(int i=0; i<10; i++) {
				for(int j=0; j<15; j++) {
					if(!(map[i][j]==null)) {
						System.out.print("[R]");
					}
					else {
						System.out.print("[-]");
					}
				}
				System.out.println();
			}
			if(joyeux.getVie()>0) {
				joyeux.makeATurn(map);
			}
			if(grincheux.getVie()>0) {
				grincheux.makeATurn(map);
			}
			if(atchoum.getVie()>0) {
				atchoum.makeATurn(map);
			}
			if(prof.getVie()>0) {
				prof.makeATurn(map);
			}
			if(simplet.getVie()>0) {
				simplet.makeATurn(map);
			}
			if(timide.getVie()>0) {
				timide.makeATurn(map);
			}
			if(dormeur.getVie()<0) {
				dormeur.makeATurn(map);
			}
		}while(robotVivant>1);
	}

}
