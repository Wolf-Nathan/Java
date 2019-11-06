
public class RobotAgressif extends Robot {
	
	public RobotAgressif(int x, int y, String name) {
		this.vie= 70;
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public RobotAgressif(Robot r) {
		this.vie = r.getVie();
		this.x = r.getX();
		this.y = r.getY();
		this.name = r.getName();
	}
	
	public void look(Robot map[][]) {
		//Le robot agressif regarde d'abord si des robots sont situés autour de lui
		if(!(map[this.x-1][this.y]==null)) {
			System.out.println(this.name + " attaque !");
			if(!map[this.x-1][this.y].action(25)) {
				map[this.x-1][this.y] = null;
				this.move(map, this.x-1, this.y);
			}
		}
		else if(!(map[this.x-1][this.y-1]==null)) {
			System.out.println(this.name + " attaque !");
			if(!map[this.x-1][this.y-1].action(25)) {
				map[this.x-1][this.y-1] = null;
				this.move(map, this.x-1, this.y-1);
			}
		}
		else if(!(map[this.x-1][this.y+1]==null)) {
			System.out.println(this.name + " attaque !");
			if(!map[this.x-1][this.y+1].action(25)) {
				map[this.x-1][this.y+1] = null;
				this.move(map, this.x-1, this.y+1);
			}
		}
		else if(!(map[this.x][this.y-1]==null)) {
			System.out.println(this.name + " attaque !");
			if(!map[this.x][this.y-1].action(25)) {
				map[this.x][this.y-1] = null;
				this.move(map, this.x, this.y-1);
			}
		}
		else if(!(map[this.x][this.y+1]==null)) {
			System.out.println(this.name + " attaque !");
			if(!map[this.x][this.y+1].action(25)) {
				map[this.x][this.y+1] = null;
				this.move(map, this.x, this.y+1);
			}
		}
		else if(!(map[this.x+1][this.y]==null)) {
			System.out.println(this.name + " attaque !");
			if(!map[this.x+1][this.y].action(25)) {
				map[this.x+1][this.y] = null;
				this.move(map, this.x+1, this.y);
			}
		}
		else if(!(map[this.x+1][this.y-1]==null)) {
			System.out.println(this.name + " attaque !");
			if(!map[this.x+1][this.y-1].action(25)) {
				map[this.x+1][this.y-1] = null;
				this.move(map, this.x+1, this.y-1);
			}
		}
		else if(!(map[this.x+1][this.y+1]==null)) {
			System.out.println(this.name + " attaque !");
			if(!map[this.x+1][this.y+1].action(25)) {
				map[this.x+1][this.y+1] = null;
				this.move(map, this.x+1, this.y+1);
			}
		}
		//Si il n'y a pas de robots à coté de lui le robot agressif ne fait rien
	}
	
	public void move(Robot map[][], int x, int y) {
		System.out.println(this.name + " se déplace en " + x + "/" + y);
		map[this.x][this.y] = null;
		this.x = x;
		this.y = y;
		map[x][y] = this;
	}
	
	
	public String toString() {
		return this.name + " est un robot agressif avec " + this.vie + " point de santé et est situé aux coordonnées " + this.x + "/" + this.y; 
	}
	
	public void makeATurn(Robot map[][]) {
		this.look(map);
	}
}
