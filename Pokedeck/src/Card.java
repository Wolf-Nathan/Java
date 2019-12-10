import java.io.Serializable;

public class Card implements Serializable{
	private String name;
	private String description;
	private String type;
	private int id;
	private static final long serialVersionUID = 42L;
	
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
	
	public Card(String name, String description, int id, String type) {
		this.name = name;
		this.description = description;
		this.id =id;
		this.type = type;
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
		return this.name +" "+ this.description + " ID :" + this.getIDToString() + " Type :" + this.getType();
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
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

}
