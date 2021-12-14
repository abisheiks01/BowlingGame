package gameRunner;

import java.util.ArrayList;

import scoreHandler.ScoreCalculator;
import scoreHandler.ScoreReader;
import entities.Frames;

public class GameRunner {

	
	/**
	 * Runner class for the application
	 */
	public static void main(String[] args) {		
		
		ArrayList<Frames> scoresList =  new ArrayList<Frames>();
		
		ScoreReader reader = new ScoreReader();
		ScoreCalculator calc = new ScoreCalculator();
		
		
		scoresList = reader.gameInitiator();
		scoresList = reader.bonusRoundExecutor(scoresList);
		scoresList = calc.calculateScore(scoresList);
		calc.printScore(scoresList);
		
		//Here check if last frame is strike -> if so, add a frame, if that frame is also strike add another single chance  frame
		//if last frame is spare add a single chance frame
		
		}
		
	}
	
