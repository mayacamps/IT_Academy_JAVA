package n2exercise1;

public abstract class Telephone {

	// ATRIBUTES
	private String brand, model;
	
	//CONSTRUCTOR
	public Telephone(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	// GETTERS
	public String getBrand() {
		return this.brand;
	}

	public String getModel() {
		return this.model;
	}
	
	// SETTERS
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	// METHODS
	public void ring(String numTel) {
		System.out.println("You are calling: " + numTel);
	}
	
}
