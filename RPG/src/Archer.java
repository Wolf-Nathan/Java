
public class Archer extends Personnage{
	
	public Archer() {
		super(60, null, 40);
		Arme arc = new Arc();
		this.arme = arc;
	}

}
