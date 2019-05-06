
public class Die
{
	private int lastRoll;
	private boolean predictable = false;
	private int[] rolls;
	private int indexOfNextRoll = 0;

	public Die()
	{
		this.roll();
	}

	public Die(int[] predictable_rolls) {
		
		if (predictable_rolls == null) {
			throw new RuntimeException("predictable_rolls is a null int[] array");
		}
		
		this.predictable = true;
		this.rolls = predictable_rolls;
		
	}
	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		if (predictable) {
			this.lastRoll = rolls[indexOfNextRoll];
			
			indexOfNextRoll += 1;
			
			if (indexOfNextRoll == rolls.length) {
				indexOfNextRoll = 0;
			}
		} else {
			this.lastRoll = (int) (Math.random() * 6 + 1);
		}
		
	}

}
