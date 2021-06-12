package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import products.Medicine;

public class ReaderWriter {

	static Scanner scanner;
	static File medFile = new File("src\\products.txt");

	// Constructors
	public ReaderWriter() {

		if (medFile.exists()) {
			try {
				scanner = new Scanner(medFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Fehler. Die Datei existiert nicht.");
		}
	}

	// read out medicines
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

	// counts the rows of a textfile
	public static int countLines() throws IOException {
		int lines = 0;

		FileReader fr = new FileReader(medFile);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null && !line.isEmpty()) {
			line = br.readLine();
			lines++;
		}

		br.close();

		return lines;
	}

	// closes the opened file or scanner
	public static void closeFile() {
		scanner.close();
	}
}
