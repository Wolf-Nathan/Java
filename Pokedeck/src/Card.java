import java.io.Serializable;

public class Card implements Serializable{
	private String name;
	private String description;
	private int id;
	
	public Card() {
		
	}
	
	public Card(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Card(String name, String description, int id) {
		this.name = name;
		this.description = description;
		this.id =id;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String txt) {
		this.description = txt;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name +" "+ this.description + " ID :" + this.getIDToString();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getIDToString() {
		if(this.id != 0) {
			return String.valueOf(this.id);
		}
		return "";
	}

}
