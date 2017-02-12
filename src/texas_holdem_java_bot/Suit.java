package texas_holdem_java_bot;

public enum Suit {
	clubs(1, (char)'\u2663'),
	diamonds(2, (char)'\u2666'),
	hearts(3, (char)'\u2665'),
	spades(4, (char)'\u2660');
	
	private int suitValue;
	private char image;
		
	private Suit(int suitValue, char image) {
		this.suitValue = suitValue;
		this.image = image;
	}

	public int getSuitValue() {
		return this.suitValue;
	}
	
	public char getSuitImage() {
		return this.image;
	}
}
