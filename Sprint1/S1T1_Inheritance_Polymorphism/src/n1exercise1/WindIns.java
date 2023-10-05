package n1exercise1;

public class WindIns extends Instrument {
	public WindIns(String name, int price) {
		super(name, price);
	}

	@Override
	public String play() {
		return "A wind instrument is playing";
	}
	
}
