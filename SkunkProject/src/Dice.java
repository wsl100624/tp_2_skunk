import edu.princeton.cs.introcs.StdOut;

 
class Dice
{

	private int lastRoll;
	private Die die1;
	private Die die2;


	Dice()
	{

		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	Dice(Die die1, Die die2)
	{
		this.die1 = die1;
		this.die2 = die2;
	}
	
	Dice(int[] predictable_rolls) {
		if (predictable_rolls == null) {
			throw new RuntimeException("The initial array of predictable rolls is null");
		}
		
		this.die1 = new Die(predictable_rolls);
		this.die2 = new Die(predictable_rolls);
	}
	
	int getDie1LastRoll()
	{
		return this.die1.getLastRoll();
	}
	
	int getDie2LastRoll()
	{
		return this.die2.getLastRoll();
	}

	int getLastRoll()
	{
		return this.lastRoll;
	}

	void roll()
	{
		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}
}
