package products;


import java.io.FileNotFoundException;


public class MedicineSearch {

	//Methoden


	public static void showProductAssortment() throws FileNotFoundException {
		Medicine m = Medicine.initializeMedicine();
		Medicine m2 = Medicine.initializeMedicine();		 
		System.out.println(m.toString());
		System.out.println();
		System.out.println(m2.toString());
		Medicine.closeFile();
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
