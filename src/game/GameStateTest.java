package game;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class GameStateTest {
	private GameState thisGame;
	@Before 
	public void setUp(){
		thisGame = new GameState(10);
	}
	@Test
	public void testConstructor() {
		Assert.assertEquals(10, thisGame.getNumbHole());
		thisGame.setCurrentPos(2);
		Assert.assertEquals(2, thisGame.getCurrentPos());
	}
	@Test
	public void testSetNumbHole(){
		thisGame.setNumbHole(7);
		Assert.assertEquals(7, thisGame.getNumbHole());
	}
	@Test
	public void testSetMole(){
		thisGame.setMole();
	}
}
