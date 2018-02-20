package hagman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HangmanTest {
	
	private HangmanGame game;

	@Before
	public void setUp() {
		List<String> dictionary = Arrays.asList("troll");
		game = new HangmanGame(new Random(1), dictionary);
	}

	@Test
	public void testIdealRun() {

		game.guess('t');
		game.guess('r');
		game.guess('o');
		game.guess('l');
		game.guess('l');
		Assert.assertTrue(game.isWon());

	}

	@Test
	public void testDetailedRun() {
		char[] attemptedCharacters = { 't', 'r', 'o', 'l', 'l' };

		for (char c : attemptedCharacters) {
			if (game.guess(c)) {
				System.out.println(game.getGuessedCharacters());
			} else {
				System.out.println("FAIL!" + game.getAttemptsLeft());
			}
		}
		Assert.assertTrue(game.isWon());
	}

}
