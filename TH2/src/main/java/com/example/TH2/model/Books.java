package com.example.TH2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Books {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookCode;
	
	@Column(nullable = false, unique = true, length = 45)
    private String title;
	@Column(nullable = false, length = 64)
    private String author;
	@Column(nullable = false, length = 64)
    private String category;

	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
