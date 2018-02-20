package hagman;

import java.util.List;
import java.util.Random;

public class HangmanGame {

	public static final int DEFAULT_ATTEMPTS_LEFT = 6;

	private static final char UNGUESSED_CHAR = '_';

	private String challengeWord;

	private StringBuilder guessedCharacters;

	private int attemptsLeft = DEFAULT_ATTEMPTS_LEFT;

	private Random random;

	public HangmanGame(Random random, List<String> dictionary) {
		// TODO Auto-generated constructor stub
	}

	public void guess(char c) {
		// TODO Auto-generated method stub

	}

	public boolean isWon() {
		// TODO Auto-generated method stub
		return false;
	}

}
