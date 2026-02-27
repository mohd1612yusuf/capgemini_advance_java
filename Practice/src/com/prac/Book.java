package com.prac;

public class Book {

	private int id;
	private String title;
	private String author;
	private String category;
	private double price;
	private int availableCopies;

	public Book(int id, String title, String author, String category, double price, int availableCopies) {

		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.availableCopies = availableCopies;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

	public double getPrice() {
		return price;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void decreaseCopies() {
		this.availableCopies--;
	}

	public void increaseCopies() {
		this.availableCopies++;
	}

	@Override
	public String toString() {
		return "Book{" + title + ", category=" + category + ", copies=" + availableCopies + '}';
	}
}