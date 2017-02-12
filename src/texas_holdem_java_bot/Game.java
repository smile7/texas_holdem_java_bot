package texas_holdem_java_bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
	public static final int NUMBER_OF_PLAYERS = 2;
	public List<Card> communityCards = new ArrayList<Card>();
	//public List<Card> computerCards = new ArrayList<Card>();
	public List<Card> player1Cards = new ArrayList<Card>();
	public int cardCounter = 0;
	public int boardCounter = 0;	
	
	public int newGame(List<Card> computerCards) { //, List<Card> communityCards) {
		Player player1 = new Player("Human");
		Player computer = new Player("Computer");
		//computer.setCard(computerCards.get(0), 0);
		//computer.setCard(computerCards.get(1), 1);
		
		Board board = new Board();
		Deck deck = new Deck();
		deck.shuffleDeck();
		
		// DEALING CARDS TO PLAYERS
		for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
			player1.setCard(deck.getCard(cardCounter++), i);
			//computer.setCard(deck.getCard(cardCounter++), i);
		}
		player1Cards.add(player1.getCard(0));
		player1Cards.add(player1.getCard(1));
		//computerCards.add(computer.getCard(0));
		//computerCards.add(computer.getCard(1));

		//player1.printHand();
		//computer.printHand();
		//System.out.println();

		//if (communityCards.size() == 0) {
			// DEALING FLOP
			for (int i = 0; i < 3; i ++) {
				board.setFlop(deck.getCard(cardCounter++), boardCounter++);
			}
			//board.printFlop();
			communityCards.add(board.getFlop(0));
			communityCards.add(board.getFlop(1));
			communityCards.add(board.getFlop(2));
		//}
		
		// DEAL TURN
		board.setTurn(deck.getCard(cardCounter++));
		//board.printTurn();
		communityCards.add(board.getTurn());

		// DEAL RIVER
		board.setRiver(deck.getCard(cardCounter++));
		//board.printRiver();
		communityCards.add(board.getRiver());
		//System.out.println("\n");
		
		// compare
		int[] evaluatedHandPlayer1 = Evaluator.Hand(communityCards, computerCards);
		int[] evaluatedHandPlayer2 = Evaluator.Hand(communityCards, player1Cards);
		
		// returns 1 if pl.1 has won, 2 if pl.2 has won and 0 for tie
		int winner = Evaluator.compareHands(evaluatedHandPlayer1, evaluatedHandPlayer2);
		if (winner == 1) {
			//System.out.print(player1.getName() + " wins with ");
			//Evaluator.displayWinnigCards(evaluatedHandPlayer1);
			return 1;
		} else if (winner == 2) {
			//System.out.print(player2.getName() + " wins with ");
			//Evaluator.displayWinnigCards(evaluatedHandPlayer2);
			return 2;
		} else if (winner == 0) {
			//System.out.println("Players have equal strength of cards. They split the pot.");
		}
		return 0;
	}	

	/*
	 * DEMO for hand evaluation
	 * 
	 * */
	public int newGame() {
		Player bot = new Player("Bot");
		List<Card> botCards = new ArrayList<Card>();
		Player player = new Player("sisi");
		List<Card> plCards = new ArrayList<Card>();
		Board board = new Board();
		Deck deck = new Deck();
		List<Card> communityCardsReal = new ArrayList<Card>();
		
		deck.shuffleDeck();
		player.setCard(deck.getCard(cardCounter++), 0);
		player.setCard(deck.getCard(cardCounter++), 1);
		bot.setCard(deck.getCard(cardCounter++), 0);
		bot.setCard(deck.getCard(cardCounter++), 1);
		//bot.setCard(new Card(Suit.clubs, Value.ace), 0);
		//bot.setCard(new Card(Suit.diamonds, Value.ace), 1);
		plCards.add(player.getCard(0));
		plCards.add(player.getCard(1));
		botCards.add(bot.getCard(0));
		botCards.add(bot.getCard(1));
		//bot.printHand();

		MonteCarloAlgorithm calc = new MonteCarloAlgorithm();
		int percentageToWin = calc.calculateStrength(botCards);//, communityCardsReal);
		boolean isFolded = false;
		if(percentageToWin >= 60) {
			System.out.println("Bot raises.");
		//} else if (percentageToWin < 65 && percentageToWin > 50) {
		//	System.out.println("Bot should call.");
		} else {
			System.out.println("Bot folds.");
			isFolded = true;
		}
		
		for (int i = 0; i < 3; i ++) {
			board.setFlop(deck.getCard(cardCounter++), boardCounter++);
		}
		communityCardsReal.add(board.getFlop(0));
		communityCardsReal.add(board.getFlop(1));
		communityCardsReal.add(board.getFlop(2));
		
		board.setTurn(deck.getCard(cardCounter++));
		communityCards.add(board.getTurn());

		board.setRiver(deck.getCard(cardCounter++));
		communityCards.add(board.getRiver());

		int[] evaluatedHandComp = Evaluator.Hand(communityCards, botCards);
		int[] evaluatedHandPlayer = Evaluator.Hand(communityCards, plCards);
		int botIsGood = 0;
		
		int winner = Evaluator.compareHands(evaluatedHandComp, evaluatedHandPlayer);
		if (winner == 1) {
			System.out.print(bot.getName() + " wins with ");
			Evaluator.displayWinnigCards(evaluatedHandComp);
			return 1;
		} else if (winner == 2) {
			System.out.print(player.getName() + " wins with ");
			Evaluator.displayWinnigCards(evaluatedHandPlayer);			
			//if(isFolded) {
			//	botIsGood++;
			//}			
			return 2;
		} else if (winner == 0) {
			System.out.println("Players have equal strength of cards. They split the pot.");
		}
		return 0;
	}
	
}