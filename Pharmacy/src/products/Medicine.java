package products;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Medicine {

	// Variablen
	String productName;
	public double price;
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
	public  Medicine(String productName, Double price, String brand, String size, String form, int pzn, String category) {
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.size = size;
		this.form = form;
		this.pzn = pzn;
		this.category = category;

	}

	//
	// Methoden
	//
	@Override
	public String toString() {
		return String.format("Produktname: %s\nPreis: %f€\nMarke: %s\nAnzahl: %s\nForm: %s\nPZN: %d\nKategorie: %s", productName, price, brand, size, form, pzn, category);
	}
}
