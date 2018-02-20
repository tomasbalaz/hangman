package hagman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class HangmanTest {

	@Test
	public void testIdealRun() {

		List<String> dictionary = Arrays.asList("troll");

		HangmanGame game = new HangmanGame(new Random(1), dictionary);
		game.guess('t');
		game.guess('r');
		game.guess('o');
		game.guess('l');
		game.guess('l');
		Assert.assertTrue(game.isWon());

	}

}
