package n3exercise1;

public abstract class News {

	// ATRIBUTES
	private String headline, text;
	private int points, price;
	
	// CONSTRUCTOR
	public News(String headline) {
		this.headline = headline;
		this.text = "";
	}
	
	// GETTERS N SETTERS
	public String getHeadline() {
		return this.headline;
	}

	public String getText() {
		return this.text;
	}
	
	public int getPoints() {
		return points;
	}

	public int getPrice() {
		return price;
	}
	
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// METODES GENERALS
	public abstract int calcNewsPrice();
	public abstract int calcNewsPoints(); 
	public abstract String toString();
	
}
