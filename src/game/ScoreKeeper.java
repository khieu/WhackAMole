package game;
/**
 * a class represents the current score of the player
 * @author hieule
 * @version feb 2013
 *
 */
public class ScoreKeeper {
	private int currentScore;
	/**
	 * initialize the score to a specified parameter
	 * @param initScore
	 */
	public ScoreKeeper(int initScore){
		currentScore = initScore;
	}
	/**
	 * score a point. Increase the total score by 1
	 */
	public void score(){
		currentScore++;
	}
	/**
	 * lose a point. Decrease the total score by 1
	 */
	public void losePoint(){
		currentScore--;
	}
	/**
	 * get the current score
	 * @return the current score
	 */
	public int getCurrentScore() {
		return currentScore;
	}
}
