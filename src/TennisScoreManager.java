package kata.src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Manage a Tennis game between two players.
 */
public class TennisScoreManager {

	private Player playerA = new Player("Player A");
	private Player playerB = new Player("Player B");
	private String winner;

	/**
	 * Used to log the score after each ball.
	 */
	private enum score  {
			ZERO, FIFTEEN, THIRTY, FORTY, AD
	}

	/**
	 * Plays a tennis game from input sequence.
	 * Display score after each ball.
	 * Return the winner of the game.
	 *
	 * @param sequence input for the game
	 * @return String winner name
	 */
	public String manageScore(String sequence)
	{
		// Reset Score
		playerA.setScore(0);
		playerB.setScore(0);
		winner = "";

		// Check sequence validity
		if(isSequenceValid(sequence))
		{
			// Split the sequence
			String[] splitArray = sequence.split("(?<=A)|(?=A)|(?<=B)|(?=B)");

			for (String element : splitArray) {
				if ("A".equals(element))
				{
					// Compute score A
					incrementPlayer(playerA, playerB);
				}
				else {
					// Compute score B
					incrementPlayer(playerB, playerA);
				}

				// Check winner
				if (winner != null && !winner.isEmpty())
				{
					System.out.println("Winner is: " + winner + ".\n");
					return winner;
				}

				// Log score if no winner
				System.out.println("Player A: " + score.values()[playerA.getScore()]);
				System.out.println("Player B: " + score.values()[playerB.getScore()] + "\n");
			}
			return "Draw";
		}
		else
		{
			System.out.println("Sequence " + sequence + " does not match expected format, try again.");
			return "Error input format.";
		}
	}

	/**
	 * Checks if the input is valid.
	 * Expected format only accept a list of "A" or "B".
	 * Only 50 balls are allowed (more than enough)
	 *
	 * @param sequence input for the game
	 * @return boolean true if the input is valid
	 */
	private boolean isSequenceValid(String sequence)
	{
		if (sequence != null && sequence.length() < 50)
		{
			String regex = "^[AB]*$";

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(sequence);

			return matcher.matches();
		}
		else
		{
			return  false;
		}
	}

	/**
	 * Increments player score.
	 *
	 * @param firstPlayer Player that score the point
	 * @param secondPlayer adversary
	 */
	private void incrementPlayer(Player firstPlayer, Player secondPlayer)
	{
		if (score.FORTY.ordinal() == firstPlayer.getScore())
		{
			if (score.AD.ordinal() == secondPlayer.getScore())
			{
				// case 40/40AD -> 40/40
				secondPlayer.decrementScore();
			}
			else  if ( score.FORTY.ordinal() != secondPlayer.getScore())
			{
				// Game firstPlayer  (40/x) -> win
				winner = firstPlayer.getName();
			}
			else
			{
				// case 40/40
				firstPlayer.incrementScore();
			}
		}
		 else if (score.AD.ordinal() == firstPlayer.getScore())
		{
			// Game first player 40AD/40 -> win
			winner = firstPlayer.getName();
		}
		else
		{
			firstPlayer.incrementScore();
		}
	}

	public void setPlayerA(Player player) {
		this.playerA = player;
	}

	public void setPlayerB(Player player) {
		this.playerB = player;
	}
}


