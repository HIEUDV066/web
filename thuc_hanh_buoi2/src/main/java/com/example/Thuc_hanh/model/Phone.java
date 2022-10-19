package com.example.Thuc_hanh.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Phone {
	@Id
	@Column(nullable = false, unique = true, length = 50)
	@NotEmpty(message = "id must be enter")
	private String id;

	@Column(nullable = false, length = 50 )
	@NotEmpty(message = "name must be enter")
    private String name;
	
	@Column(nullable = false, length = 64)
	@NotNull(message = "vaccinated must be enter")		
    private int price;
	
	@Column(nullable = false, length = 64)
	@NotEmpty(message = "brand must be enter")
    private String brand;
	
	@Column(nullable = false, length = 50)
	@NotNull(message = "sold must be enter")
    private int sold;
	
	public Phone() {
	}
	public Phone(String id, String name, int price, String brand, int sold) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.sold = sold;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	
	
}
