package n1exercise2;

public class Car {

	// ATRIBUTES
	/* 
	The only variable that can be initialized in the constructor
	is "model" since it is the only non-final one. It is also the
	only one we can create a set method for.
	*/
	private static final String brand = "Ford";
	private static String model;
	private final int power = 120;

	// CONSTRUCTOR
	public Car(String model) {
		Car.model = model;
	}
	
	// GETTERS
	public static String getModel() {
		return model;
	}

	public static String getBrand() {
		return brand;
	}

	public int getPower() {
		return power;
	}
	
	// SETTERS
	public static void setModel(String model) {
		Car.model = model;
	}

	// METHODS
	public static String slowDown() {
		return "The car is slowing down";
	}
	
	public String accelerate() {
		return "The car is accelerating";
	}
}
