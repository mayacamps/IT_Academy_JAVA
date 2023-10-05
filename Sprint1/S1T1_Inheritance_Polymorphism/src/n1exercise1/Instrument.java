package n1exercise1;

public abstract class Instrument {
	// ATRIBUTES
	private String name;
	private int price;
	
	// CONSTRUCTOR
	public Instrument(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// GETTERS N SETTERS
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	// METHODS
	public abstract String play();

}



