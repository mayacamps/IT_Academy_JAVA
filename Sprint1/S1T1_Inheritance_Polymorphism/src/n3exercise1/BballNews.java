package n3exercise1;

public class BballNews extends News{

	// ATRIBUTES
	private String comp, team;
	
	// CONSTRUCTOR
	public BballNews(String headline, String comp, String team) {
		super(headline);
		this.comp = comp;
		this.team = team;
	}
	
	// GETTERS N SETTERS
	public String getComp() {
		return this.comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	// METHODS
	@Override
	public int calcNewsPrice() {
		int price = 250;
		
		price += (this.comp.equalsIgnoreCase("Eurolliga")) ? 75 : 0;
		
		price += (this.team.equalsIgnoreCase("Barça") || this.team.equalsIgnoreCase("Madrid")) ? 75 : 0;
		
		return price;
	}

	@Override
	public int calcNewsPoints() {
		int points = 4;
		
		points += (this.comp.equalsIgnoreCase("Eurolliga")) ? 3 : 0;
		
		points += (this.comp.equalsIgnoreCase("ACB")) ? 2 : 0;
		
		points += (this.team.equalsIgnoreCase("Barça") || this.team.equalsIgnoreCase("Madrid")) ? 1 : 0;
		
		return points;
	}

	@Override
	public String toString() {
		return "Sport: Basketball"
				+ "\nHeadline: " + this.getHeadline()
				+ "\nCompetition: " + this.getComp()
				+ "\nTeam: " + this.getTeam() 
//				+ "\nPrice: " + this.getPrice() + " eur"
//				+ "\nPoints: " + this.getPoints()	
				+ "\n";
	}

}
