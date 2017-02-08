package texas_holdem_java_bot;

import java.util.Arrays;
import java.util.List;

public class Player {
	private String name;
	private int chips = 1500;
	private Card[] hand = new Card[2];
	
	public Player() {
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}
	
	public Player(String name, int chips, Card[] hand) {
		this.name = name;
		this.chips = chips;
		this.hand = hand;
	}

	public Player(Card card1, Card card2) {
		this.hand[0] = card1;
		this.hand[1] = card2;
	}
	
	public String getName() {
	    return this.name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
		
	public Card[] getHand() {
		return this.hand;
	}
	
	public void setHand(Card[] hand) {
		this.hand = hand;
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
