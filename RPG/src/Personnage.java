
public abstract class Personnage {
	protected int vie;
	protected Arme arme;
	protected int force;
	protected int argent;

	public Personnage() {
		this.vie = 50;
		this.force = 50;
		this.argent = 0;
	}
	
	public Personnage(int vie, Arme arme, int force) {
		this.vie = vie;
		this.arme = arme;
		this.force = force;
		this.argent = 0;
	}
	
	public String toString() {
		String str = this.getClass() + " a " + this.vie + " points de vie, " + this.force + " points de force et poss�de " + this.arme;
		return str;
	}
	
	public int getVie() {
		return this.vie;
	}
	
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public int getForce() {
		return this.force;
	}
	
	public void setForce(int force) {
		this.force = force;
	}
	
	public Arme getArme() {
		return this.arme;
	}
	
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	
	public int getArgent() {
		return this.argent;
	}
	
	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	public void attaque(Personnage ennemi) {
		System.out.println(this + " attaque " + ennemi);
		int coup = this.force + this.arme.getDegat();
		ennemi.defend(coup);
	}
	
	public void defend(int coup) {
		this.vie = this.vie - coup;
		if(this.vie < 0) {
			System.out.println(this + " est mort !");
		}
	}
}
