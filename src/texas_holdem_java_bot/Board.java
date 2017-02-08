package texas_holdem_java_bot;

import java.util.Arrays;

public class Board {
	
	private Card[] flop = new Card[3];
	private Card turn = new Card();
	private Card river = new Card();
	
	public Board() {
	}
	
	protected Card getFlop(int cardNum) {
		return this.flop[cardNum];
	}
	
	protected void setFlop(Card card, int cardNum) {
		this.flop[cardNum] = card;
	}
	
	protected Card getTurn() {
		return this.turn;
	}
	
	protected void setTurn(Card card) {
		this.turn = card;
	}
	
	protected Card getRiver() {
		return this.river;
	}
	
	protected void setRiver(Card card) {
		this.river = card;
	}
	
	public void printFlop() {
		System.out.print("Board is: " + Arrays.deepToString(flop).replace("[", "").replace("]", ""));
	}
	
	public void printTurn() {
		System.out.println();
		printFlop();
		System.out.print(", " + turn.toString());
	}
	
	public void printRiver() {
		printTurn();
		System.out.print(", " + river.toString());
	}
	
	/* TODO - fix - not imp
	@Override
	public String toString() {
		if (getTurn() == null) {
			return Arrays.deepToString(flop);
		} else if (turn != null && river == null) {
			return Arrays.deepToString(flop) + turn.toString();
		} else if (turn != null && river != null) {
			return Arrays.deepToString(flop) + turn.toString() + river.toString();
		}
		return "ssssssssssssss";
	}
	*/
}
