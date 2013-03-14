package game;

import java.util.Random;
/**
 * a class represents the current state of the game
 * @author hieule
 * @version Feb 2013
 */
public class GameState {
	private int numbHole;
	private int currentPos;
	
	/**
	 * initialize the current state of the game to specified parameter
	 * @param initNumHole
	 */
	public GameState(int initNumHole){
		numbHole = initNumHole;
		Random random = new Random();
		currentPos = random.nextInt(numbHole);
	}
	/**
	 * get the current position
	 * @return the current position
	 */
	public int getCurrentPos() {
		return currentPos;
	}
	/**
	 * set the current position to a specified value
	 * @param currentPos
	 */
	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}
	/**
	 * get the number of holes
	 * @return the number of holes
	 */
	public int getNumbHole() {
		return numbHole;
	}
	/**
	 * set the number of holes
	 * @param numbHole
	 */
	public void setNumbHole(int numbHole) {
		this.numbHole = numbHole;
	}
	/**
	 * move the mole randomly to a new position
	 */
	public void setMole(){
		Random random = new Random();
		int newPos = random.nextInt(numbHole);
		this.setCurrentPos(newPos);
	}	
	
	
}
