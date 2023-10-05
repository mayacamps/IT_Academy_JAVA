package n1exercise1;

public class PercIns extends Instrument {
	public PercIns(String name, int price) {
		super(name, price);
	}
	
	@Override
	public String play() {
		return "A percussion instrument is playing";
	}
}
