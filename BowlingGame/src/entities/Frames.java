package entities;

public class Frames {

	
	private int roll1Score;
	private int roll2Score;
	private int frameScore;
	
	private boolean strikeFlag = false;
	private boolean spareFlag = false;
	
	
	public Frames(int roll1Score, int roll2Score)
	{
		this.roll1Score = roll1Score;
		this.roll2Score = roll2Score;
		frameScore = roll1Score + roll2Score;
		
		if(roll1Score == 10)
		{
			strikeFlag = true;
		}
		else if(roll1Score + roll2Score == 10)
		{
			spareFlag = true;
		}
	}
	
	public boolean isStrike()
	{
		return strikeFlag;
	}
	
	public boolean isSpare()
	{
		return spareFlag;
	}
	
	public int getBaseScore()
	{
		return frameScore;
	}
	
	public int getRoll1Score()
	{
		return roll1Score;
	}
	
	public int getRoll2Score()
	{
		return roll2Score;
	}
	
	public int addBonusScore(int bonus)
	{
		frameScore = frameScore + bonus;
		return frameScore;
	}
	
}
