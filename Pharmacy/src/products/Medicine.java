package products;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Medicine {

	// Variablen
	String productName;
	double price;
	String brand;
	Double size;
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
	protected Medicine(String productName, Double price, String brand, Double size, String form, int pzn, String category) {
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
		return String.format("Produktname: %s\nPreis: %f\nMarke: %s\nAnzahl: %f\nForm: %s\nPZN: %d\nKategorie: %s", productName, price, brand, size, form, pzn, category);
	}

	// Gibt initialisierte Objekte vom Typ Medicine zurück
	public static Medicine initializeMedicine() throws FileNotFoundException {
		File file = new File("products.txt");
		
		if (file.exists()) {

			scanner = new Scanner(file);

			if(scanner.hasNext()) {
				String productName = scanner.next();
				double price = scanner.nextDouble();
				String brand = scanner.next();
				double size = scanner.nextDouble();
				String form = scanner.next();
				int pzn = scanner.nextInt();
				String category = scanner.next();
				
				return new Medicine(productName, price, brand, size, form, pzn, category);
			}else {
				return null;
			}
			
		} else {
				System.out.println("Fehler. Die Datei existiert nicht.");
				return null;
			}
		
	}

	// Schließt die Textdatei bzw. den Scanner
	public static void closeFile() {
		scanner.close();
	}
}
