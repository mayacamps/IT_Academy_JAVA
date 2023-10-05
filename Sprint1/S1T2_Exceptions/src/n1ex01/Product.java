package n1ex01;

public class Product {

	// ATRIBUTES
	private String name;
	private int price;
	
	// CONSTRUCTOR
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// GETTERS N SETTERS
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
