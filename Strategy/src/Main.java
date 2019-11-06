
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot map[][] = new Robot[10][15];
		Robot joyeux = new RobotNeutre(2, 6);
		map[joyeux.getX()][joyeux.getY()] = joyeux;
		System.out.println(map[2][6]==null);
		System.out.println(map[1][4]==null);
		System.out.println(map[4][5]);
		System.out.println(map[2][6]);
		joyeux = new RobotPeureux(joyeux);
		map[2][6] = joyeux;
		System.out.println(map[2][6]);
		System.out.println(8<10 && 15<15 && map[10][16]==null);
		joyeux = new RobotNeutre(joyeux);
		map[2][6] = joyeux;
		System.out.println(map[2][6]);
		joyeux.move(map);
		System.out.println(joyeux.getX());
		System.out.println(joyeux.getY());
		System.out.println(map[2][6]);
		System.out.println(map[joyeux.getX()][joyeux.getY()]);
		
		System.out.println("Affichage de la map");
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
	}

}
