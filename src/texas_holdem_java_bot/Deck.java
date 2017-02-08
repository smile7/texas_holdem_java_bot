package texas_holdem_java_bot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		for(Suit suit : Suit.values()) {
			for(Value value : Value.values()) {
				Card card = new Card(suit, value);
				cards.add(card);
			}
		}
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	protected Card getCard(int cardNum){
        return cards.get(cardNum);
    }

	public void shuffleDeck() {
		Collections.shuffle(cards);
		//System.out.println(cards.toString());
	}
	/*
	public Card dealHand() {
		
	}
	
	/*
	public void printCards() {

		StringBuilder suits = new StringBuilder();
		
		for (int i = 0; i < cards.size(); i++) {
	        Card card = cards.get(i);
	        suits.append(" ");
	        suits.append(card.getValue());

	        switch (card.getSuit()) {
	            case spades:
	                suits.append((char)'\u2660');
	                break;
	            case diamonds:
	                suits.append((char)'\u2666');
	                break;
	            case clubs:
	                suits.append((char)'\u2663');
	                break;
	            case hearts:
	                suits.append((char)'\u2764');
	                break;
	        }

	    }
		//System.out.println(suits);
	}
	*/
}
