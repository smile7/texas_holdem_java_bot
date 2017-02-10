package texas_holdem_java_bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Evaluator {
	
	public static int[] Hand(List<Card> communityCards, List<Card> playerCards) {
	//public static void Hand() {
		//List<Card> availableCards = new ArrayList<Card>();
		List<Card> availableCards = new ArrayList<Card>(playerCards);
		availableCards.addAll(communityCards);
		
		/*
		availableCards.add(new Card(Suit.clubs, Value.king));
		availableCards.add(new Card(Suit.hearts, Value.ace));
		availableCards.add(new Card(Suit.clubs, Value.three));
		availableCards.add(new Card(Suit.clubs, Value.four));
		availableCards.add(new Card(Suit.clubs, Value.seven));
		availableCards.add(new Card(Suit.spades, Value.ten));
		availableCards.add(new Card(Suit.diamonds, Value.queen));
		*/
		
		// find if there is a pair (2 cards of the same value), a set (3 of the same value) or a quads (4 of the same value)
		// we find that by making an int[13] of 0s and increment the appropriate index(es)
		int[] values = new int[14];

		for (int i = 0; i <= availableCards.size() - 1; i++) {
			values[availableCards.get(i).getValueValue()]++;
		}
		
		// counting for pairs
		int sameValuesOnCards = 1;
		int sameValuesOnCards2 = 1;
		int largeGroupValue = 0;
		int smallGroupValue = 0;
		
		for(int i = 13; i >= 1; i--) {
			
			if(values[i] > sameValuesOnCards) {
				
				//we have a record in there
				if (sameValuesOnCards != 1) {
					sameValuesOnCards2 = sameValuesOnCards;
					smallGroupValue = largeGroupValue;
				}
								
				sameValuesOnCards = values[i];
				largeGroupValue = i;
				
			} else if(values[i] > sameValuesOnCards2) {
				sameValuesOnCards2 = values[i];
				smallGroupValue = i;
			}
		}
		
		// find flush		
		boolean isFlush = false;
		int[] suits = new int[5];
		
		for (int i = 0; i <= availableCards.size() - 1; i++) {
			suits[availableCards.get(i).getSuitValue()]++;
		}
		
		if(suits[1] >=5) {
			isFlush = true;
			System.out.println("flush of clubs");
		}		
		if(suits[2] >=5) {
			isFlush = true;
			System.out.println("flush of diamonds");
		}
		if(suits[3] >=5) {
			isFlush = true;
			System.out.println("flush of hearts");
		}
		if(suits[4] >=5) {
			isFlush = true;
			System.out.println("flush of spades");
		}
		
		// find straight
		boolean isStraight = false;
		int topStraightValue = 0;
		
		for (int i = 1; i <= 9; i++) {
			if(values[i] >= 1 && values[i+1] >= 1 && values[i+2] >= 1
					&& values[i+3] >= 1 && values[i+4]>= 1) {
				isStraight = true;
				topStraightValue = i + 4;
				
				if((i + 5 >= 0) && (i + 5 < values.length) && (values[i+5] >= 1)) {
					topStraightValue = i + 5;
				} else if((i + 6 >= 0) && (i + 6 < values.length) && (values[i + 6] >= 1)) {
					topStraightValue = i + 6;
				} else {
					break;
				}
			}
		}
		
		// check if its the highest straight (as ACE has value of 1)
		if(values[10] >= 1 && values[11] >= 1 && values[12] >= 1
				&& values[13] >= 1 && values[1]>= 1) {
			isStraight = true;
			topStraightValue = 14;
		}
		//System.out.println(topStraightValue + "\n" + isStraight);
		
		//
		int[] orderedValues = new int[7];
		int index = 0;
		
		// if we have an ace
		if (values[1] == 1) {
			// we say ace is the highest card
			orderedValues[index] = 14;
			index++; // increment position
		}
		
		for (int i = 13; i >= 2; i--) {
			if (values[i] == 1) {
				orderedValues[index] = i;
				index++;
			}
		}
		
		// START OF HAND EVALUATION
		int[] value = new int[6];
		if(largeGroupValue == 1) {
			largeGroupValue = 14;
		}
		
		if(sameValuesOnCards == 1) { // if no pair
			value[0] = 1;            // this is the lowest type of hand so it gets the lowest value
			value[1] = orderedValues[0];
			value[2] = orderedValues[1];
		    value[3] = orderedValues[2];
		    value[4] = orderedValues[3];
		    value[5] = orderedValues[4];
		}
		
		if (sameValuesOnCards == 2 && sameValuesOnCards2 == 1) { //if 1 pair
		    value[0] = 2;                 //pair ranked higher than high card
		    value[1] = largeGroupValue;   //rank of pair
		    value[2] = orderedValues[0];  //next highest cards..
		    value[3] = orderedValues[1];
		    value[4] = orderedValues[2];
		}

		if (sameValuesOnCards == 2 && sameValuesOnCards2 == 2) { //two pairs
		    value[0] = 3;
		    //rank of greater pair
		    value[1] = largeGroupValue > smallGroupValue ? largeGroupValue : smallGroupValue;
		    //rank of smaller pair
		    value[2] = largeGroupValue < smallGroupValue ? largeGroupValue : smallGroupValue;
		    value[3] = orderedValues[0];  //extra card
		}

		if (sameValuesOnCards == 3 && sameValuesOnCards2 != 2) { //three of a kind and not full house
		    value[0] = 4;
		    value[1] = largeGroupValue;
		    value[2] = orderedValues[0];
		    value[3] = orderedValues[1];
		}

		if (isStraight)	{
		    value[0] = 5;
		    value[1] = orderedValues[0];
		}

		if (isFlush) {
		    value[0] = 6;
		    value[1] = orderedValues[0]; //get the highest flush cards
		    value[2] = orderedValues[1];
		    value[3] = orderedValues[2];
		    value[4] = orderedValues[3];
		    value[5] = orderedValues[4];
		}

		if (sameValuesOnCards == 3 && sameValuesOnCards2 == 2) { //full house
		    value[0] = 7;
		    value[1] = largeGroupValue;
		    value[2] = smallGroupValue;
		}

		if (sameValuesOnCards == 4) { //four of a kind
		    value[0] = 8;
		    value[1] = largeGroupValue;
		    value[2] = orderedValues[0];
		}

		if (isStraight && isFlush) { //straight flush
		    value[0] = 9;
		    value[1] = orderedValues[0];
		}
		
		//System.out.println(Arrays.toString(value));
		//finally
		return value;
	}
	

	public static int compareHands(int[] evaluatedHandPlayer1, int[] evaluatedHandPlayer2) {
		for (int i = 0; i < 6; i++) {
			if (evaluatedHandPlayer1[i] > evaluatedHandPlayer2[i]) {
				return 1;
			} else if (evaluatedHandPlayer1[i] < evaluatedHandPlayer2[i]) {
				return -1;
			}/* else if (evaluatedHandPlayer1[i] == evaluatedHandPlayer2[i]) {
				isTie = true;
			}*/
		}
		return 0;
	}
	
	public static void displayWinnigCards(int[] evaluatedHandArr) {
		String text;
		switch (evaluatedHandArr[0]) {
		case 1:
			text = "high card";
			break;
		case 2:
			text = "pair of ";  // TODO
			break;
		default:
			text = "There has got to be some error. Probably evaluatedHandPlayerX[0] has wrong value.";
		}
		
		System.out.println(text);
	}
}
