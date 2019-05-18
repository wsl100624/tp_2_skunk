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
		this.chipScore = Constants.PLAYER_START_CHIPS; //Refactor 2nd - make all the constants to a separate class to acheive 'High Cohesion'
	}
	
	void paySingleSkunk()
	{
		this.chipScore = this.chipScore - Constants.SINGLE_SKUNK_PENALTY;
		KittyPot.addOneChip();
	}
	
	void paySkunkDeuce()
	{
		this.chipScore = this.chipScore - Constants.DEUCE_SKUNK_PENALTY;
		KittyPot.addTwoChips();
	}
	
	void payDoubleSkunk()
	{
		this.chipScore = this.chipScore - Constants.DOUBLE_SKUNK_PENALTY;
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
