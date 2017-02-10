package texas_holdem_java_bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
	public static final int NUMBER_OF_PLAYERS = 2;
	public List<Card> communityCards = new ArrayList<Card>();
	public List<Card> player1Cards = new ArrayList<Card>();
	public List<Card> player2Cards = new ArrayList<Card>();
	public int cardCounter = 0;
	public int boardCounter = 0;
	
	public Game() {
		Scanner scan = new Scanner(System.in);		
		
		// TODO: for cycle for all players
		//System.out.println("Hello, player1! What is your name?");
		//String player1Name = scan.nextLine();
		//System.out.println("Hello, player2! What is your name?");
		//String player2Name = scan.nextLine();
		
		Player player1 = new Player("Sisi");
		Player player2 = new Player("Tisho");
		
		Deck deck = new Deck();
		deck.shuffleDeck();
		
		Board board = new Board();
		
		// DEALING CARDS TO PLAYERS
		for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
			player1.setCard(deck.getCard(cardCounter++), i);
			player2.setCard(deck.getCard(cardCounter++), i);
		}
		player1.printHand();
		player2.printHand();
		player1Cards.add(player1.getCard(0));
		player1Cards.add(player1.getCard(1));
		player2Cards.add(player2.getCard(0));
		player2Cards.add(player2.getCard(1));
		
		// DEALING FLOP
		for (int i = 0; i < 3; i ++) {
			board.setFlop(deck.getCard(cardCounter++), boardCounter++);
		}
		//board.printFlop();
		communityCards.add(board.getFlop(0));
		communityCards.add(board.getFlop(1));
		communityCards.add(board.getFlop(2));
				
		
		// DEAL TURN
		board.setTurn(deck.getCard(cardCounter++));
		//board.printTurn();
		communityCards.add(board.getTurn());

		// DEAL RIVER
		board.setRiver(deck.getCard(cardCounter++));
		board.printRiver();
		communityCards.add(board.getRiver());
		System.out.println();
		
		// compare
		int[] evaluatedHandPlayer1 = Evaluator.Hand(communityCards, player1Cards);
		int[] evaluatedHandPlayer2 = Evaluator.Hand(communityCards, player2Cards);
		
		// returns 1 if pl.1 has won, -1 if pl.2 has won and 0 for tie
		int winner = Evaluator.compareHands(evaluatedHandPlayer1, evaluatedHandPlayer2);
		if (winner == 1) {
			Evaluator.displayWinnigCards(evaluatedHandPlayer1);
		} else if (winner == -1) {
			Evaluator.displayWinnigCards(evaluatedHandPlayer2);
		} else if (winner == 0) {
			System.out.println("Players have equal strength of cards. They split the pot.");
		}
		
	}
}