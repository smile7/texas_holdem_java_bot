package texas_holdem_java_bot;

import java.util.List;

public class MonteCarloAlgorithm {
	private int NHands = 100;
	private int computerWins = 0;
	private int humanWins = 0;
	private int tie = 0;
	
	public int calculateStrength(List<Card> cardsToBeEvaluated) { //, List<Card> communityCards) {
		for (int i = 0; i < NHands; i++) {
			Game game = new Game();
			int winner = game.newGame(cardsToBeEvaluated);//, communityCards);
			if (winner == 1) {
				computerWins++;
			} else if (winner == 2) {
				humanWins++;
			} else {
				tie++;
			}
		}
		return computerWins;
	}
}
