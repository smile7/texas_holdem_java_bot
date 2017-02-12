package texas_holdem_java_bot;

import java.util.ArrayList;
import java.util.List;

public class Runnable {

	public static void main(String[] args) {
		int NHands = 100;
		int computerWins = 0;
		int humanWins = 0;
		int tie = 0;
		List<Card> computerCards = new ArrayList<Card>();
		//Player computer = new Player("Computer");
				
		//computer.setCard(new Card(Suit.spades, Value.ace), 0);
		//computer.setCard(new Card(Suit.diamonds, Value.king), 1);
		//computerCards.add(computer.getCard(0));
		//computerCards.add(computer.getCard(1));
		/*
		for (int i = 0; i < NHands; i++) {
			Game game = new Game();
			int winner = game.Game();
			if (winner == 1) {
				computerWins++;
			} else if (winner == 2) {
				humanWins++;
			} else {
				tie++;
			}
		}
		//computer.printHand();
		System.out.println(" COMPUTER: " + computerWins + "\n HUMAN: " + humanWins + "\n TIE: " + tie);
		*/
		int hit = 0;
		for (int i = 0; i < 14; i++) {
			Game game = new Game();
			hit = game.newGame();
		}
		//System.out.println("\n" + hit);
		/*
		 * DEMO for hand evaluation
		 * 
		int NHands = 150000;
		int highCard = 0,
			pair = 0,
			twoPairs = 0,
			trips = 0,
			straight = 0,
			flush = 0,
			fullHouse = 0,
			quads = 0,
			straightFlush = 0,
			royalFlush = 0;
		
		
		for(int i = 0; i < NHands; i++) {
			Game game2 = new Game();
			int result = game2.Game();
			switch (result) {
			case 1:
				highCard++;
				break;
			case 2:
				pair++;
				break;
			case 3:
				twoPairs++;
				break;
			case 4:
				trips++;
				break;
			case 5:
				straight++;
				break;
			case 6:
				flush++;
				break;
			case 7:
				fullHouse++;
				break;
			case 8:
				quads++;
				break;
			case 9:
				straightFlush++;
				break;
			case 10:
				royalFlush++;
				break;
			default:
				System.out.print("There has got to be some error. Probably evaluatedHandPlayerX[0] has wrong value.");
			}
		}
		
		System.out.println("highCard: " + ((double)highCard/NHands)*100 + "%");
		System.out.println("pair: " + ((double)pair/NHands)*100 + "%");
		System.out.println("twoPairs: " + ((double)twoPairs/NHands)*100 + "%");
		System.out.println("trips: " + ((double)trips/NHands)*100 + "%");
		System.out.println("straight: " + ((double)straight/NHands)*100 + "%");
		System.out.println("flush: " + ((double)flush/NHands)*100 + "%");
		System.out.println("fullHouse: " + ((double)fullHouse/NHands)*100 + "%");
		System.out.println("quads: " + ((double)quads/NHands)*100 + "%");
		System.out.println("straightFlush: " + ((double)straightFlush/NHands)*100 + "%");
		System.out.println("royalFlush: " + ((double)royalFlush/NHands)*100 + "%");
		*/
	}
}
