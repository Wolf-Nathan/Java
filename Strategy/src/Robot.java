
public abstract class Robot implements RobotInterface {
	public int vie;
	public int x;
	public int y;
	
	public abstract void look();
	public abstract void move();
	public abstract void action();
	public abstract int getX();
	public abstract int getY();
	public abstract void setX(int x);
	public abstract void setY(int y);
	public abstract int getVie();

}
