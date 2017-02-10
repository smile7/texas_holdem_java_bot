package texas_holdem_java_bot;

public class Card { //implements Comparable<Card> {
	private Suit suit;
	private Value value;
	
	public Card() {
	}
	
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public int getSuitValue() {
		return this.suit.getSuitValue();
	}
	
	public Value getValue() {
		return this.value;
	}
	
	public int getValueValue() {
		return this.value.getSuitValue();
	}
	
	@Override
	public String toString() {
		return value.getValueChar() + "" + suit.getSuitImage();
	}
}
