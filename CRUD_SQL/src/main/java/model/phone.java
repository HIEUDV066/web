package model;

public class phone {
	private int id;
	private String name, describle;
	public phone() {
	}
	public phone(int id, String name, String describle) {
		this.id = id;
		this.name = name;
		this.describle = describle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	
	
}
