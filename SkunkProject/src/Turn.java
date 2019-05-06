import edu.princeton.cs.introcs.StdOut;

public class Turn 
{
	private Roll roll;
	
	private Player player;

	private int[] rollScores = new int[100];
	
	// one boolean to signify skunk, three others to signify which kind of skunk
	private boolean skunk = false;
	private boolean singleSkunk = false;
	private boolean skunkDeuce = false;
	private boolean doubleSkunk = false;

	private int count = 0;
	
	public int getTurnCount()
	{
		return count;
	}
			
	Turn()
	{
		roll = new Roll();
	}

	Turn(int[] predictableRolls) {
		roll = new Roll(predictableRolls);
	}


	
	///round
	boolean turnPlay(Player player)
	{		
		this.player = player;
			
		int die1Roll, die2Roll;
		
		clearSkunks();
		roll.roll();
		
		rollScores[count] = roll.getCurrRoll();
		
		die1Roll = roll.getCurrRollDie1();
		die2Roll = roll.getCurrRollDie2();
		
		if(roll.isSkunk())
		{
			singleSkunk = true;
			skunk = singleSkunk;
		}
		
		if(roll.isSkunkDeuce())
		{
			skunkDeuce = true;
			skunk = skunkDeuce;
		}
		
		if(roll.isDoubleSkunk())
		{
			doubleSkunk = true;
			skunk = doubleSkunk;
		}

		StdOut.println("You have rolled " + die1Roll + " + " + die2Roll + " = " + rollScores[count]);

		player.setRollScore(rollScores[count]);

		this.count = this.count + 1;
		
		return skunk;		
	}
	
	private void clearSkunks()
	{
		this.skunk = false;
		this.singleSkunk = false;
		this.skunkDeuce = false;
		this.doubleSkunk = false;
	}
	
	int sumRollScores()
	{
		int total = 0;
		
		for(int i = 0; i < rollScores.length; i++)
		{
			total = total + rollScores[i];
		}
		
		return total;
	}
	
	
	///end turn
	/// Add total score, also penalties
	void endTurn(boolean isSkunk)
	{
		if (count == 0) 
		{
			StdOut.println("Passing to the next player from the beginning");
		} 
		else 
		{

			if(!isSkunk)
			{
				int total = sumRollScores();
				player.setTurnScore(total);

				this.player.setOverallScore(player.getTurnScore());
			}
			else
			{
				// penalties 1 skunk or 2 skunks
				StdOut.println("You got a skunk! Your turn is ending!");
				if(singleSkunk)
				{
					StdOut.println("You're skunk is a single skunk. You have to pay 1 chip to the kitty");
					this.player.paySingleSkunk();
				}
				else if(skunkDeuce)
				{
					StdOut.println("You're skunk is a skunk deuce. You have to pay 2 chips to the kitty");
					this.player.paySkunkDeuce();
				}
				else if(doubleSkunk)
				{
					StdOut.println("You're skunk is a double skunk. You have to pay 4 chips to the kitty and lose all your points!!");
					this.player.payDoubleSkunk();
				}
			}

			//reset stuff
			this.count = 0;

			StdOut.println(this.player.name + ", your overall score is " + this.player.getOverallScore());
			StdOut.println("Your chips you have left is " + player.getChipScore());
			StdOut.println("The kitty's pot is " + Round.getKittyPot());
			
			StdOut.println("Passing to the next player");
		}
	}
	

}
