package com.example.Thuc_hanh.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Student {
	@Id
	@Column(nullable = false, unique = true, length = 50)
	@NotEmpty(message = "id must be enter")
	private String id;

	@Column(nullable = false, length = 50 )
	@NotEmpty(message = "name must be enter")
    private String name;
	
	@Column(nullable = false, length = 64)
	@DateTimeFormat(pattern="dd/mm/yyyy")
	@NotNull(message = "dob must be enter")
	@Past(message= "Invalid Date!!")
    private Date dob;
	@Column(nullable = false, length = 64)
	@NotEmpty(message = "major must be enter")
    private String maijor;
	@Column(nullable = false, length = 50)
	@NotNull(message = "vaccinated must be enter")
    private int vaccinated;
	
	
	
	
	public Student() {
	}
	public Student(String id, String name, Date dob, String maijor, int vaccinated) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.maijor = maijor;
		this.vaccinated = vaccinated;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMaijor() {
		return maijor;
	}
	public void setMaijor(String maijor) {
		this.maijor = maijor;
	}
	public int getVaccinated() {
		return vaccinated;
	}
	public void setVaccinated(int vaccinated) {
		this.vaccinated = vaccinated;
	}
	
	
}
