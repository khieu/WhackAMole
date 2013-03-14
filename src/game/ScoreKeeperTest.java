package game;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ScoreKeeperTest {
	private ScoreKeeper thisScore;
	@Before 
	public void setUp(){
		thisScore = new ScoreKeeper(10);
	}
	@Test
	public void testConstructor() {
		Assert.assertEquals(10, thisScore.getCurrentScore());;
	}
	@Test
	public void testScore(){
		thisScore.score();
		Assert.assertEquals(11, thisScore.getCurrentScore());
	}
	@Test
	public void testLosingPoint(){
		thisScore.losePoint();
		Assert.assertEquals(9, thisScore.getCurrentScore());
	}
}
