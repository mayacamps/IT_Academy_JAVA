package n2exercise1;

public class Smartphone extends Telephone implements Camera, Clock {

	public Smartphone(String brand, String model) {
		super(brand, model);	
	}

	@Override
	public void alarm() {
		System.out.println("The alarm is ringing");
	}

	@Override
	public String takePhoto() {
		return "You are taking a photo";
	}
	

}
