package kata.unit;

import kata.src.TennisScoreManager;
import org.junit.Before;
import org.junit.Test;

// Add junit to classpath if needed
import static org.junit.Assert.assertEquals;

public class TennisScoreManagerUnitTest {

	private TennisScoreManager manager;

	@Before
	public void setup()
	{
		manager = new TennisScoreManager();
	}

	private void assertManageScore(String sequence, String winner)
	{
		assertEquals(winner, manager.manageScore(sequence));
	}

	@Test(timeout = 10000)
	public void testWrongSequenceFormat()  {
		assertManageScore("-1", "Error input format.");
		assertManageScore(null, "Error input format.");
		assertManageScore("ABCBA", "Error input format.");
		assertManageScore("AB BA", "Error input format.");
		assertManageScore("ABAAAABA ABBAABBA ABBABBBB ABBBAABA ABAAAABA ABBAAAAB ABBABBAB ABBABABB", "Error input format.");
	}

	@Test(timeout = 10000)
	public void testManageScoreNoEntry()  {
		// Case no entry
		assertManageScore("", "Draw");
	}

	@Test(timeout = 10000)
	public void testManageScoreWinPlayerA()  {
		// Case win Player A
		assertManageScore("AAABA", "Player A");
	}

	@Test(timeout = 10000)
	public void testManageScoreWinPlayerB()  {
		// Case win Player B
		assertManageScore("BAAABBBB", "Player B");
	}

	@Test(timeout = 10000)
	public void testManageScoreADPlayerA()  {
		// Case win Player A after 40AD/40
		assertManageScore("ABABABAA", "Player A");
	}

	@Test(timeout = 10000)
	public void testManageScoreADPlayerB()  {
		// Case win Player B after 40AD/40
		assertManageScore("ABABABBB", "Player B");
	}

	@Test(timeout = 10000)
	public void testManageScoreLongGame()  {
		// Case long game
		assertManageScore("AAABBBABABABAA", "Player A");
	}

	@Test(timeout = 10000)
	public void testManageScoreDrawAtForty()  {
		// Case no winner after 40/40
		assertManageScore("ABABAB", "Draw");
	}

}
