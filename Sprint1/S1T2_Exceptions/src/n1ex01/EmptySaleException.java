package n1ex01;

public class EmptySaleException extends Exception {

	public EmptySaleException(String exception) {
		super(exception);
	}
	
	public String getMessage() {
		return "To make a sale, you must add products first.";
	}
}
