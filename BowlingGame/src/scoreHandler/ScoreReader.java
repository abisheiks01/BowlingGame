package scoreHandler;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Frames;

public class ScoreReader {

	static Scanner in = new Scanner(System.in);
	
	/**
	 * Initiates the game by capturing the score inputs
	 */
	public ArrayList<Frames> gameInitiator() {		
		
		ArrayList<Frames> scoresList =  new ArrayList<Frames>();
		
		
		System.out.println("Welcome to Bowling Game.. !!");
		
		for(int i=1; i<=10; i++)
		{
			
			System.out.println("-----------------------------");
			System.out.println("Frame " + i);
			
			Frames frame = readFrameInput();
			scoresList.add(frame);
		}
		
		return scoresList;
	}
	
	/**
	 * Captures the bonus Roll scores
	 */
	public ArrayList<Frames> bonusRoundExecutor(ArrayList<Frames> scoresList)
	{
		if(scoresList.get(scoresList.size()-1).isStrike())
		{
			System.out.println("-----------------------------");
			System.out.println("Bonus Frame");
			Frames bonusFrame = readFrameInput();
			scoresList.add(bonusFrame);
			if(scoresList.get(scoresList.size()-1).isStrike())
			{
				Frames bonusFrame2 = new Frames(captureBonusScore(), 0);
				scoresList.add(bonusFrame2);
			}
		}
		else if(scoresList.get(scoresList.size()-1).isSpare())
		{
			Frames bonusFrame2 = new Frames(captureBonusScore(), 0);
			scoresList.add(bonusFrame2);
		}
		return scoresList;
	}
	
	/**
	 * Captures a single bonus roll value and returns the same
	 */
	public int captureBonusScore()
	{
		System.out.println("-----------------------------");
		System.out.println("Bonus roll ");
		return captureRoll1Score();
	}
	
	/**
	 * Captures a Frame roll values and returns it as a Frame object
	 */
	public Frames readFrameInput()
	{
		int roll1Score = captureRoll1Score();
		int roll2Score = 0;
		if(roll1Score != 10)
		{
			roll2Score = captureRoll2Score(roll1Score);
		}
		System.out.println("Frame score : " + roll1Score + " " + roll2Score);
		
		Frames frame = new Frames(roll1Score, roll2Score);
		return frame;
	}

	/**
	 * Checks whether passed String is available in the passed array
	 */
	public static boolean checkListContains(String[] array, String valueToCheck)
	{
		for (String element : array) {
		    if (element.equalsIgnoreCase(valueToCheck)) {
		        return true;
		    }
		}
		return false;
	}
	
	/**
	 * Captures the Roll 1 score and validates it
	 */
	public static int captureRoll1Score()
	{
		System.out.println("Enter Roll 1 score..");
		System.out.println("Available scores : 0 1 2 3 4 5 6 7 8 9 X");
		String input = in.next();
		int pin1Value = 0;
		
		String[] allowedInputs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		if(checkListContains(allowedInputs, input))
		{
			pin1Value = Integer.valueOf(input);
			return pin1Value;
		}
		else if(input.equalsIgnoreCase("X"))
		{
			return 10;
		}
		else
		{
			System.out.println("Invalid input : " + input + ". Enter value again..");
			return captureRoll1Score();
		}
	}
	
	/**
	 * Captures the roll 2 score and validates it against roll 1 score
	 */
	public int captureRoll2Score(int roll1Score)
	{
		System.out.println("Enter Roll 2 score..");
		String [] allowedInputs = new String [10-roll1Score];
		
		for(int i=0; i<allowedInputs.length; i++)
		{
			allowedInputs[i] = String.valueOf(i);
		}
		
		System.out.println("Available scores : / " + getListAsString(allowedInputs));
		String input = in.next();
		int roll2Score = 0;
		
		if(checkListContains(allowedInputs, input))
		{
			roll2Score = Integer.valueOf(input);
			return roll2Score;
		}
		else if(input.equalsIgnoreCase("/"))
		{
			return 10-roll1Score;
		}
		else
		{
			System.out.println("Invalid input : " + input + ". Enter value again..");
			return captureRoll2Score(roll1Score);
		}
	}
	
	/**
	 * Returns the passed array as a string
	 */
	public  String getListAsString(String[] input)
	{
		String output = "";
		for(int i=0; i<input.length; i++)
		{
			output = output + " " + input[i];
		}
		return output;
		
	}
	
	
	
}

