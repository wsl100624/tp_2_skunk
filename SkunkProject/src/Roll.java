
class Roll
{
	private Dice dice;
	
	private int currRoll;
	
	Roll(int[] predictable)
	{
		dice = new Dice(predictable);
	}

	Roll()
	{
		dice = new Dice();
	}
	
	void roll()
	{
		dice.roll();
		setCurrRoll();
	}

	int getCurrRoll()
	{
		return currRoll;
	}

	void setCurrRoll()
	{
		this.currRoll = dice.getLastRoll();
	}
	
	int getCurrRollDie1()
	{
		return dice.getDie1LastRoll();
	}
	
	int getCurrRollDie2()
	{
		return dice.getDie2LastRoll();
	}
	
	boolean isSkunk()
	{		
		if( (getCurrRollDie1() == 1 && getCurrRollDie2() > 2) )
		{
			return true;
		}
		
		if( (getCurrRollDie2() == 1 && getCurrRollDie1() > 2) )
		{
			return true;
		}
		
		return false;
	}
	
	boolean isSkunkDeuce()
	{		
		if( (getCurrRollDie1() == 1 && getCurrRollDie2() == 2) )
		{
			return true;
		}

		if( (getCurrRollDie2() == 1 && getCurrRollDie1() == 2) )
		{
			return true;
		}
		
		return false;
	}
	
	boolean isDoubleSkunk()
	{
		return (getCurrRollDie1() == 1 && getCurrRollDie2() == 1);

	}
	
}
