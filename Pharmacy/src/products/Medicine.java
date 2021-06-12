package products;

import java.util.Scanner;

public class Medicine {

	// Variablen
	String productName;
	double price;
	String brand;
	String size;
	String form;
	int pzn;
	String category;

	int quantityInProducts;
	boolean inShoppingCart;
	int quantityInShoppingCart;
	boolean availability;

	static Scanner scanner;
	//
	// Konstruktoren
	//
	public Medicine(String productName, Double price, String brand, String size, String form, int pzn, String category) {
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.size = size;
		this.form = form;
		this.pzn = pzn;
		this.category = category;

	}

	// Getter
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setForm(String form) {
		this.form = form;
	}
	
	public void setPZN(int pzn) {
		this.pzn = pzn;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	// Setter
	public String getProductName() {
		return productName;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getForm() {
		return form;
	}
	
	public int getPZN() {
		return pzn;
	}
	
	public String getCategory() {
		return category;
	}
	
	//
	// Methoden
	//
	@Override
	public String toString() {
		return String.format("Produktname: %s\nPreis: %f€\nMarke: %s\nAnzahl: %s\nForm: %s\nPZN: %d\nKategorie: %s", productName, price, brand, size, form, pzn, category);
	}
}
