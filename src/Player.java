package kata.src;


/**
 * Simple Tennis Player
 */
public class Player {
	private int score = 0;
	private final String name;

	/**
	 * Constructor
	 * @param name name of the player
	 */
	public Player(String name)
	{
		this.name = name;
	}

	/**
	 * Increment player score by 1.
	 */
	public void incrementScore() {
		score+=1;
	}

	/**
	 * Decrement player score by 1.
	 */
	public void decrementScore()
	{
		score-=1;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

}

