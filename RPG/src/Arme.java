
public abstract class Arme {
	protected int degat;
	protected int portee;
	protected int prix;
	
	public Arme() {
		this.degat = 15;
		this.portee = 1;
	}
	
	public Arme(int degat, int portee) {
		this.degat = degat;
		this.portee = portee; 
	}
	
	public int getDegat() {
		return this.degat;
	}
	
	public void setDegat(int degat) {
		this.degat = degat;
	}
	
	public int getPortee() {
		return this.portee;
	}
	
	public void setPortee(int portee) {
		this.portee = portee;
	}
	
	public int getPrix() {
		return this.prix;
	}
	
	public void setPrix(int prix) {
		this.prix = prix;
	}

}
