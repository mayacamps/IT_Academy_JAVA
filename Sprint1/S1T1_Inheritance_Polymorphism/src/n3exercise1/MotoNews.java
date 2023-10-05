package n3exercise1;

public class MotoNews extends News {
	
	// VARIABLES
	String team;
	
	// CONSTRUCTOR
	public MotoNews(String headline, String team) {
		super(headline);
		this.team = team;
	}

	// GETTERS N SETTERS
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	// METHODS
	@Override
	public int calcNewsPrice() {
		int price = 100;
		price += (this.getTeam().equalsIgnoreCase("Honda") || this.getTeam().equalsIgnoreCase("Yamaha")) ? 50 : 0;
		
		return price;
	}

	@Override
	public int calcNewsPoints() {
		int points = 3;
		points += (this.getTeam().equalsIgnoreCase("Honda") || this.getTeam().equalsIgnoreCase("Yamaha")) ? 3 : 0;
		
		return points;
	}

	@Override
	public String toString() {
		return "Sport: Motorcycle"
				+ "\nHeadline: " + this.getHeadline()
				+ "\nTeam: " + this.getTeam()
//				+ "\nPrice: " + this.getPrice() + " eur"
//				+ "\nPoints: " + this.getPoints()	
				+ "\n";
	}

}
