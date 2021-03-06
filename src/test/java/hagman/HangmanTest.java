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
		String[] expectedGuessCharacters = { "t____", "tr___", "tro__", "troll" };

		for (int i = 0; i < attemptedCharacters.length - 1; i++) {
			char c = attemptedCharacters[i];
			if (game.guess(c)) {
				Assert.assertEquals(expectedGuessCharacters[i], game.getGuessedCharacters().toString());
			} else {
				Assert.fail("Letter " + c + " should be guessed correctly, but it is not.");
			}
		}
		Assert.assertTrue(game.isWon());
	}

	@Test
	public void testCompletelyFailedGuessing() {
		for (int i = 0; i < 6; i++) {
			if (game.guess('w')) {
				Assert.fail("Letter 'w' is incorrectly guessed");
			}
		}
		Assert.assertEquals(0, game.getAttemptsLeft());
	}

	@Test
	public void testWithTwoFailures() {
		for (char c : "xytroll".toCharArray()) {
			game.guess(c);
		}
		Assert.assertEquals(4, game.getAttemptsLeft());
		Assert.assertTrue(game.isWon());
	}

	@Test(expected=IllegalStateException.class)
	public void testFailTenTimes() {
		for (char c : "qwetzuipas".toCharArray()) {
			game.guess(c);
		}
		Assert.assertEquals(0, game.getAttemptsLeft());
	}
}
