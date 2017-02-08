package texas_holdem_java_bot;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
	public static final int NUMBER_OF_PLAYERS = 2;
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
		
		// DEALING FLOP
		for (int i = 0; i < 3; i ++) {
			board.setFlop(deck.getCard(cardCounter++), boardCounter++);
		}
		board.printFlop();
		
		// DEAL TURN
		board.setTurn(deck.getCard(cardCounter++));
		board.printTurn();

		// DEAL RIVER
		board.setRiver(deck.getCard(cardCounter++));
		board.printRiver();
	}
}