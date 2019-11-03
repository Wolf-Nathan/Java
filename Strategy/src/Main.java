
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
	}

}
