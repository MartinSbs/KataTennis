package kata.cucumber;

// TODO If you already have cucumber installed and configured, comment this section
public class TennisScoringFeatureGlue{}

// TODO and uncomment this one
/*import io.cucumber.java8.En;

import kata.src.Player;
import kata.src.TennisScoreManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisScoringFeatureGlue implements En {

	private TennisScoreManager scoreManager;
	private String winner;

	public TennisScoringFeatureGlue() {
		Given("^a player named \"([^\"]*)\" and the adversary \"([^\"]*)\"$", (String playerAName, String playerBName) -> {
			scoreManager = new TennisScoreManager();

			Player playerA = new Player(playerAName);
			Player playerB = new Player(playerBName);

			scoreManager.setPlayerA(playerA);
			scoreManager.setPlayerB(playerB);
		});

		When("^the exchange are \"([^\"]*)\".$", (String input) -> {
			winner = scoreManager.manageScore(input);
		});

		Then("^\"([^\"]*)\" is the winner of the game\\.$", (String expectedWinner) -> {
			assertEquals(expectedWinner, winner);
		});
	}
}*/
