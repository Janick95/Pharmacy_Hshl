package products;


import java.io.FileNotFoundException;

import application.ReaderWriter;


public class MedicineSearch {

	//Methoden


	public static void showProductAssortment() throws FileNotFoundException {
		ReaderWriter info = new ReaderWriter();
		
		Medicine m = info.readMedicine();
		Medicine m2 = info.readMedicine();
		Medicine m3 = info.readMedicine();
		Medicine m4 = info.readMedicine();
		Medicine m5 = info.readMedicine();
		Medicine m6 = info.readMedicine();
		Medicine m7 = info.readMedicine();
		Medicine m8 = info.readMedicine();
		Medicine m9 = info.readMedicine();
		Medicine m10 = info.readMedicine();
		
		System.out.println(m.toString());
		System.out.println();
		System.out.println(m2.toString());
		System.out.println();
		System.out.println(m3.toString());
		System.out.println();
		System.out.println(m4.toString());
		System.out.println();
		System.out.println(m5.toString());
		System.out.println();
		System.out.println(m6.toString());
		System.out.println();
		System.out.println(m7.toString());
		System.out.println();
		System.out.println(m8.toString());
		System.out.println();
		System.out.println(m9.toString());
		System.out.println();
		System.out.println(m10.toString());
		ReaderWriter.closeFile();
	}
	
	
	void searchForAlphabet() {
		
	}
	
	void searchForPrice() {
		
	}
	
	void searchForManufacturer() {
		
	}
	
	void searchForCategories() {
		
	}
	
	void searchForDosageForm() {
		
	}
	
	void addToCart() {
		
	}
}
