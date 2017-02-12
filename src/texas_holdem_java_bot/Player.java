package texas_holdem_java_bot;

import java.util.Arrays;

public class Player {
	private String name;
	private int chips = 1500;
	private Card[] hand = new Card[2];
		
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
	    return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public Card getCard(int cardNum) {
		return this.hand[cardNum];
	}
	
	public void setCard(Card card, int cardNum) {
		this.hand[cardNum] = card;
	}

	public void printHand() {
		System.out.println(name + " has " + Arrays.deepToString(hand).replace("[", "").replace("]", ""));
	}
		
	@Override
	public String toString() {
		return Arrays.deepToString(hand) + "; chips " + this.chips;
	}
}
