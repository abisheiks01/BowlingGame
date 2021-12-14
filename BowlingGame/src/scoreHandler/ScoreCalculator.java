package scoreHandler;

import java.util.ArrayList;

import entities.Frames;

public class ScoreCalculator {

	/**
	 * Calculates the score for each frame
	 */
	public ArrayList<Frames> calculateScore(ArrayList<Frames> scoresList)
	{	
		for(int i=0; i< 10; i++)
		{
			if(scoresList.get(i).isSpare())
			{
				Frames frame = scoresList.get(i);
				frame.addBonusScore(scoresList.get(i+1).getRoll1Score());
				scoresList.set(i, frame);
			}
			else if(scoresList.get(i).isStrike())
			{
				Frames frame = scoresList.get(i);
				frame.addBonusScore(scoresList.get(i+1).getRoll1Score());
				if(!scoresList.get(i+1).isStrike())
				{
					frame.addBonusScore(scoresList.get(i+1).getRoll2Score());
				}
				else
				{
					frame.addBonusScore(scoresList.get(i+2).getRoll1Score());
					scoresList.set(i, frame);
				}
			}
		}
		return scoresList;	
	}
	
	/**
	 * Prints the total score & score for each frame
	 */
	public void printScore(ArrayList<Frames> scoresList)
	{
		System.out.println();
		System.out.println("XXxx-- Final Scores --xxXX");
		System.out.println();
		
		int totalScore = 0;
		for(int i=0; i< 9; i++)
		{
			int frameCount = i+1;
			String frameNo = "Frame " + frameCount + "  >>  ";
			String pin1 =  "Roll 1 : ";
			String pin2 =  "Roll 2 : ";
			String finalScore = "Frame Score : " + scoresList.get(i).getBaseScore();
			if(scoresList.get(i).isStrike())
			{
				pin1 = pin1 + "X";
				pin2 = pin2 + "-";
			}
			else if(scoresList.get(i).isSpare())
			{
				pin1 = pin1 + scoresList.get(i).getRoll1Score();
				pin2 = pin2 + "/";
			}
			else
			{
				pin1 = pin1 + scoresList.get(i).getRoll1Score();
				pin2 = pin2 + scoresList.get(i).getRoll2Score();
			}
			totalScore = totalScore + scoresList.get(i).getBaseScore();
			System.out.println(frameNo + pin1 + "  ||  " + pin2 + "  ||  " + finalScore);
		}
		
		if(scoresList.get(9).isStrike())
		{
			if(scoresList.get(10).isStrike())
			{
				String template = "Frame 10 >>  Roll 1 : X  ||  Roll 2 : X  ||  Roll 3 : ";
				String pin3 = "";
				if(scoresList.get(11).isStrike())
				{
					pin3 = pin3 + "X";
				}
				else
				{
					pin3 = pin3 + scoresList.get(11).getRoll1Score();
				}
				System.out.println(template + pin3 + "  ||  Frame Score : " + scoresList.get(9).getBaseScore());
			}	
			else
			{
				String template = "Frame 10 >>  Pin 1 : X";
				String pin2 =  "Roll 2 : ";
				String pin3 =  "Roll 3 : ";
				pin2 = pin2 + scoresList.get(10).getRoll1Score();
				pin3 = pin3 + scoresList.get(10).getRoll2Score();
				System.out.println(template + "  ||  " + pin2 + "  ||  " + pin3 + "  ||  Frame Score : " + scoresList.get(9).getBaseScore());
			}
		}
		else if(scoresList.get(9).isSpare())
		{
			String pin1 =  "Roll 1 : ";
			String pin2 =  "Roll 2 : ";
			String pin3 =  "Roll 3 : ";
			pin1 = pin1 + scoresList.get(9).getRoll1Score();
			pin3 = pin3 + scoresList.get(10).getRoll1Score();
			pin2 = pin2 + "/";
			System.out.println("Frame 10 >>  " + pin1 + "  ||  " + pin2 +  "  ||  " + pin3 + "  ||  Frame Score : " + scoresList.get(9).getBaseScore());
		}
		else
		{
			String pin1 =  "Roll 1 : ";
			String pin2 =  "Roll 2 : ";
			pin1 = pin1 + scoresList.get(9).getRoll1Score();
			pin2 = pin2 + scoresList.get(9).getRoll2Score();
			System.out.println("Frame 10 >>  " + pin1 + "  ||  " + pin2 + "  ||  Frame Score : " + scoresList.get(9).getBaseScore());
		}
		totalScore = totalScore + scoresList.get(9).getBaseScore();
		
		System.out.println();
		System.out.println("Total Game score : " + totalScore);
	}

}
