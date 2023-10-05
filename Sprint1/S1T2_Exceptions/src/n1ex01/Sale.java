package n1ex01;

import java.util.ArrayList;

public class Sale {

	// ATRIBUTES
	private ArrayList<Product> products = new ArrayList<Product>();
	private int totalPrice = 0;
	
	
	// GETTERS N SETTERS
	public ArrayList<Product> getProducts() {
		return this.products;
	}

	public int getTotalPrice() {
		return this.totalPrice;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}	

	// GENERAL METHODS
//	public int calcTotal() {
//		try {
//			if (products.size() == 0) {
//				throw new EmptySaleException("To make a sale, you must add products first.");
//			} else {
//				for (int i = 0; i < products.size(); i++) {
//					totalPrice += products.get(i).getPrice();
//				}
//			}
//		} catch (EmptySaleException e) {
////			System.err.println(e); // Shows type Exception
//			System.err.println(e.getMessage());
//		}
//		
//		return totalPrice;
//	}
	
	public int calcTotal(){
		try {
			try {
				if (products.size() == 0) {
					throw new ArrayIndexOutOfBoundsException();
				} else {
					for (int i = 0; i < products.size(); i++) {
						totalPrice += products.get(i).getPrice();
					}
				}
			} catch (ArrayIndexOutOfBoundsException a) {
				throw new EmptySaleException("To make a sale, you must add products first.");
			}
		} catch (EmptySaleException e) {
			System.err.println("EmptySaleException: " + e.getMessage());
		}
		return totalPrice;
	}
	
	
}
