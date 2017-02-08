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
}
