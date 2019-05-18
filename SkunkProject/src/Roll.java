
class Roll
{
	private Dice dice;
	
	private int currRoll;
	
	Roll(int[] predictable)
	{
		dice = new Dice(predictable);
	}
	
	Roll(int[] pred1, int[] pred2)
	{
		Die die1 = new Die(pred1);
		Die die2 = new Die(pred2);
		
		dice = new Dice(die1, die2);
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
		boolean result=false;
		
		if( (getCurrRollDie1() == 1 && getCurrRollDie2() > 2) ||  (getCurrRollDie2() == 1 && getCurrRollDie1() > 2))
		{
			result=true;
		}
		
		return result;
	}
	
	boolean isSkunkDeuce()
	{		
		if( (getCurrRollDie1() == 1 && getCurrRollDie2() == 2) || (getCurrRollDie2() == 1 && getCurrRollDie1() == 2) )
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
