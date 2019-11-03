import java.math.*;

public class RobotNeutre extends Robot{
	
	public RobotNeutre(int x, int y) {
		this.vie = 70;
		this.x = x;
		this.y = y;
	}
	
	public RobotNeutre(Robot r) {
		this.vie = r.getVie();
		this.x = r.getX();
		this.y = r.getY();
	}
	
	public boolean look(Robot map[][], int x, int y) {
		if(x>=0 && x<=10 && y>=0 && y<=15 && map[x][y]==null)
			//Pas de robot à cette case et la case ne dépasse pas les limites de la map
			return true;
		else
			return false;
	}
	
	public void action() {
		
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
		}while(!this.look(map, newX, newY));
		map[this.x][this.y] = null;
		this.x = newX;
		this.y = newY;
		map[newX][newY] = this;
	}

}
