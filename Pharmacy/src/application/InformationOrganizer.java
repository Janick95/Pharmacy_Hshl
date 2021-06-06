package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import products.Medicine;

public class InformationOrganizer {

	static Scanner scanner;

	// Konstruktoren
	public InformationOrganizer() {
		File file = new File("products.txt");

		if (file.exists()) {
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Fehler. Die Datei existiert nicht.");
		}
	}

	// Liest Medikamente aus
	public Medicine readMedicine() throws FileNotFoundException {

		if (scanner.hasNext()) {
			String productName = scanner.next();
			double price = scanner.nextDouble();
			String brand = scanner.next();
			String size = scanner.next();
			String form = scanner.next();
			int pzn = scanner.nextInt();
			String category = scanner.next();

			return new Medicine(productName, price, brand, size, form, pzn, category);
		} else {
			return null;
		}

	}

	// Schlieﬂt die Textdatei bzw. den Scanner
	public static void closeFile() {
		scanner.close();
	}
}
