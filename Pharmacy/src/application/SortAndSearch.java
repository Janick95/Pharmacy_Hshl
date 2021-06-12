package application;

import products.Medicine;

public class SortAndSearch {

	
	//
	// sort methods
	//
	
	//BubbleSorts

	public static Medicine[] sortPrice(Medicine[] meds) {

		int n = meds.length;
		boolean swapped = false;

		do {
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				if (meds[i].getPrice() > meds[i + 1].getPrice()) {
					meds = swap(meds, i, i + 1);
					swapped = true;
				}
			}
			n = n - 1;
		} while (swapped);

		return meds;
	}

	public static Medicine[] sortProductName(Medicine[] meds) {
		
		int n = meds.length;
		boolean swapped = false;
		
		do {
			swapped = false;
			for(int i = 0; i < n-1; i++) {
				char[] med1 = meds[i].getProductName().toCharArray();
				char[] med2 = meds[i+1].getProductName().toCharArray();
				//first level of search
				if(med1[0] > med2[0]) {
					meds = swap(meds, i, i+1);
					swapped = true;
				//second level of search
				}if(med1[0] == med2[0]) {
					if(med1[1] > med2[1]) {
						meds = swap(meds, i ,i+1);
					}
				}
			}
			n = n-1;
		} while(swapped);
		
		
		return meds;
	}
	
	
	
	
	
	//
	// necessary helping methods
	//
	
	//swaps two elements of an array
	public static Medicine[] swap(Medicine[] meds, int x, int y) {

		Medicine med = meds[x];
		meds[x] = meds[y];
		meds[y] = med;

		return meds;
	}
}
