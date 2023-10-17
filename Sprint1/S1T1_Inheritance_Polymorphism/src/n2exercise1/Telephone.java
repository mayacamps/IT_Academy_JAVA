package n2exercise1;

public class Telephone {
	private String brand, model;
	public Telephone(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	public String getBrand() {
		return this.brand;
	}

	public String getModel() {
		return this.model;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void ring(String numTel) {
		System.out.println("You are calling: " + numTel);
	}
	
}
