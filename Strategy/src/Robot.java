import java.math.*;


public class Robot implements RobotInterface {
	public int vie;
	public int x;
	public int y;
	public String name;
	
	public void look() {
		
	}
	public void move() {
		
	}
	public void action() {
		
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVie() {
		return this.vie;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void move(Robot map[][]) {
		
	}
	
	public boolean action(int degat) {
		System.out.println(this.name + " se d�fend !");
		this.vie = this.vie - degat;
		if(this.vie>0) {
			//Le robot s'est bien d�fendu il est toujours en vie
			return true;
		}
		else {
			//Le robot est mort
			System.out.println(this.name + " est mort !");
			return false;
		}
	}
	
	public String toString() {
		return this.name + " est un robot avec " + this.vie + " point de sant� et est situ� aux coordonn�es " + this.x + "/" + this.y; 
	}
	
	public void makeATurn(Robot map[][]) {
		
	}
	

}
