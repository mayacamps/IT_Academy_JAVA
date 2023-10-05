package n1exercise1;

public class StringIns extends Instrument {

	public StringIns(String name, int price) {
		super(name, price);
	}
	
	@Override
	public String play() {
		return "A string instrument is playing";
	}
}
