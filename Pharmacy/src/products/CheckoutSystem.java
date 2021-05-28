package products;

import java.util.Date;

public class CheckoutSystem extends ShoppingCart{

	//Variablen
	String paymentMethod;
	String nameCardOwner;
	int cardNumber;
	int checkDigit;
	Date cardExpiryDate;
	boolean correctData;
	
	//Methoden
	boolean checkData() {
		return true;
	}
	
	void buy() {
		
	}
	
	void goToPaymentWebsite() {
		
	}
}
