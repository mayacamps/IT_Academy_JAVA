package n1exercise2;

public class Car {
	private static final String brand = "Ford";
	private static String model;
	private final int power = 120;

	// CONSTRUCTOR
	public Car() {
		Car.model = "Kuga";
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
