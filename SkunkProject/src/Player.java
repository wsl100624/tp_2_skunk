import edu.princeton.cs.introcs.StdOut;

public class Player 
{
	
	String name;
	
	private int overallScore;
	private int chipScore;
	private int rollScore;
	private int turnScore;
	
	int getChipScore()
	{
		return chipScore;
	}
	
	public void setChipScore(int val)
	{
		this.chipScore = this.chipScore + val;
	}
	
	int getOverallScore()
	{
		return this.overallScore;
	}
	
	void setOverallScore(int val)
	{
		this.overallScore = this.overallScore + val;
	}
	
	public int getRollScore() 
	{
		return rollScore;
	}

	void setRollScore(int rollScore)
	{
		this.rollScore = rollScore;
	}

	int getTurnScore()
	{
		return turnScore;
	}

	void setTurnScore(int turnScore)
	{
		this.turnScore = turnScore;
	}
	
	
	Player(String name)
	{
		this.name = name;
		//starting score
		this.overallScore = 0;
		this.rollScore = 0;
		this.turnScore = 0;
		this.chipScore = 50;
	}
	
	public void showScores()
	{
		StdOut.println(this.toString() + "'s score is: ");
		StdOut.println("\tchip score: " + this.chipScore);
		StdOut.println("\troll score: " + this.rollScore);
		StdOut.println("\tturn score: " + this.turnScore);
		StdOut.println("\tOverall score: " + this.overallScore);
	}
	
	void paySingleSkunk()
	{
		this.chipScore = this.chipScore - 1;
		KittyPot.addOneChip();
	}
	
	void paySkunkDeuce()
	{
		this.chipScore = this.chipScore - 2;
		KittyPot.addTwoChips();
	}
	
	void payDoubleSkunk()
	{
		this.chipScore = this.chipScore - 4;
		KittyPot.addFourChips();
		this.overallScore = 0;
	}
	
	public void resetPlayer()
	{
		this.overallScore = 0;
		this.rollScore = 0;
		this.turnScore = 0;
	}
	
	
	@Override
	public  String toString()
	{
		return name;
	}
	
	void winTheRound()
	{
		this.chipScore = this.chipScore + KittyPot.getKittyChips();
	}

}
