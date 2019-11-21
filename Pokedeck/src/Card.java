
public class Card {
	private String name;
	private String description;
	
	public Card() {
		
	}
	
	public Card(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String txt) {
		this.description = txt;
	}
	
	public String toString() {
		return this.name +" "+ this.description;
	}

}
