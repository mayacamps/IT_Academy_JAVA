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

	public int calcTotal() throws EmptySaleException {
		if (products.size() == 0) {
			throw new EmptySaleException("Empty Sale Exception");
		} else {
            for (Product product : products) {
                totalPrice += product.getPrice();
            }
		}
		return totalPrice;
	}
	
	
}
