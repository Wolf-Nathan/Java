
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
	
	public void look() {
		
	}
	
	public void action() {
		
	}
	
	public void move() {
		
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
		this.y =y;
	}
	
	public int getVie() {
		return this.vie;
	}

}
