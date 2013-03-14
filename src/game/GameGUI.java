package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * a class shows the game by implementing a GUI
 * @author hieule
 * @version Feb 2013
 */
public class GameGUI extends JFrame {
	private GameState currentState;
	private ScoreKeeper currentScore;
	private JPanel panel;
	private JLabel score;
	private JButton[] field;
	private Timer time;
	private JButton start;
	
	private static int fRAMEWIDTH = 600;
	private static int fRAMEHEIGHT = 600;
	private static final ImageIcon MOLE = new ImageIcon("tank.png");
	private static final ImageIcon HOLE = new ImageIcon("grass.png");
	
	
	/** initialize and display all GUI components */
	public GameGUI(){
		currentState = new GameState(10);
		currentScore = new ScoreKeeper(10);
		time = new Timer(1000, null);
		panel = new JPanel();
		score = new JLabel("Score: " + currentScore.getCurrentScore());
		start = new JButton("Start the game!");
		field = new JButton[currentState.getNumbHole()];
		for (int i = 0; i < field.length; i++){
			if (i != currentState.getCurrentPos()){
				field[i] = new JButton();
				field[i].setIcon(HOLE);
			} else {
				field[i] = new JButton();
				field[i].setIcon(MOLE);
			}
		}
		
		/**
		 * initialize a click when user click a button
		 * @author hieule
		 *
		 */
		class Click implements ActionListener {
			private int currentIndex;
			
			public Click(int initIndex){
				currentIndex = initIndex;
			}
			@Override
			public void actionPerformed(ActionEvent event) {
				time.restart();
				if (currentIndex == currentState.getCurrentPos()){
					currentScore.score();
				} else {
					currentScore.losePoint();
				}
				field[currentState.getCurrentPos()].setIcon(HOLE);
				currentState.setMole();
				field[currentState.getCurrentPos()].setIcon(MOLE);
				score.setText("Score: " + currentScore.getCurrentScore());
			}
			
		}
		for (int i = 0; i < field.length; i++){
			field[i].addActionListener(new Click(i));
		}
		
		/**
		 * every second the object will move to a new place and 1 point will be deducted from
		 * the total score
		 * @author hieule
		 *
		 */
		class Counter implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent event) {
				time.start();
				field[currentState.getCurrentPos()].setIcon(HOLE);
				currentState.setMole();
				field[currentState.getCurrentPos()].setIcon(MOLE);
				currentScore.losePoint();
				score.setText("Score: " + currentScore.getCurrentScore());
			}	
		}
		/*for (int i = 0; i < field.length; i++){
			field[i].addActionListener(new Counter());
		}*/
		start.addActionListener(new Counter());
		time.addActionListener(new Counter());
		
		

		this.setSize(fRAMEWIDTH, fRAMEHEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		panel.add(score);
		panel.add(start);

		for (JButton currentButton: field){
			panel.add(currentButton);
		}
	}
	
	public static void main(String [] args){
		GameGUI newGame = new GameGUI();
		newGame.setVisible(true);
	}
}
