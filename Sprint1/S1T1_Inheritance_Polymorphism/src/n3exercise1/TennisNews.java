package n3exercise1;

public class TennisNews extends News{

	// VARIABLES
	private String comp, player;
	
	// CONSTRUCTOR
	public TennisNews(String headline, String comp, String player) {
		super(headline);
		this.comp = comp;
		this.player = player;
	}

	// GETTERS N SETTERS
	public String getComp() {
		return this.comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getPlayer() {
		return this.player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
	// METHODS
	@Override
	public int calcNewsPrice() {
		int price = 150;
		price += (this.player.equalsIgnoreCase("Federer") || this.player.equalsIgnoreCase("Nadal") || this.player.equalsIgnoreCase("Djokovic")) ? 100 : 0;

		return price;
	}

	@Override
	public int calcNewsPoints() {
		int points = 4;
		points += (this.player.equalsIgnoreCase("Federer") || this.player.equalsIgnoreCase("Nadal") || this.player.equalsIgnoreCase("Djokovic")) ? 3 : 0;
		
		return points;
	}

	@Override
	public String toString() {
		return "Sport: Tennis"
				+ "\nHeadline: " + this.getHeadline()
				+ "\nCompetition: " + this.getComp()
				+ "\nPlayer: " + this.getPlayer()
//				+ "\nPrice: " + this.getPrice() + " eur"
//				+ "\nPoints: " + this.getPoints()	
				+ "\n";
	}

}
