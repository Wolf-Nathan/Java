import java.math.*;

public class RobotNeutre extends Robot{
	
	public RobotNeutre(int x, int y, String name) {
		this.vie = 70;
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public RobotNeutre(Robot r) {
		this.vie = r.getVie();
		this.x = r.getX();
		this.y = r.getY();
		this.name = r.getName();
	}
	
	public boolean look(Robot map[][], int x, int y) {
		if(x>=0 && x<10 && y>=0 && y<15)
			//La case ne dépasse pas les limites de la map
			return true;
		else
			return false;
	}
	
	public boolean robotOnCase(Robot map[][], int x, int y) {
		if(map[x][y]==null)
			return false;
		else
			return true;
	}
	
	
	public void move(Robot map[][]) {
		int newX = 0;
		int newY = 0;
		do {
			double a = Math.random();
			double b = Math.random();
			if(a<=0.33) {
				newX = this.x - 1;
			}
			else if(a>0.33 && a<=0.66) {
				newX = this.x;
			}
			else {
				newX = this.x + 1;
			}
			if(b<=0.33) {
				newY = this.y - 1;
			}
			else if(b>0.33 && b<=0.66 ) {
				newY = this.y;
			}
			else {
				newY = this.y + 1;
			}
		}while((newX == this.x && newY == this.y) || !this.look(map, newX, newY));
		if(this.robotOnCase(map  ,newX, newY)) {
			System.out.println("Un robot est présent sur la case voulue !" );
			//Un robot est présent sur la case où le robot veut se déplacer il l'attaque
			System.out.println(this.name + " attaque !");
			if(!map[newX][newY].action(15)) {
				//On enlève le robot mort
				map[newX][newY] = null;
				//On enlève notre robot de sa case
				map[this.x][this.y] = null; 
				//On lui affecte ses nouvelles coordonnées
				this.x = newX;
				this.y = newY;
				//On le positionne dans sa case
				map[newX][newY] = this;
			}
		}
		else {
			//Le robot se déplace
			map[this.x][this.y] = null;
			this.x = newX;
			this.y = newY;
			map[newX][newY] = this;
		}
	}
	
	public String toString() {
		return this.name + " est un robot neutre avec " + this.vie + " point de santé et est situé aux coordonnées " + this.x + "/" + this.y; 
	}
	
	public void makeATurn(Robot map[][]) {
		this.move(map);
	}

}
