import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class DiceTest {
	
	private Dice dice;
	private Dice diceWithRoll;
	private Dice diceWithPredictableRoll;
	private Die die1;
	private Die die2;
	

	@Before
	public void setUp() throws Exception {

		int[] init_rolls = new int[] {1,2,3};
		die1 = new Die(init_rolls);
		die2 = new Die(init_rolls);

		dice = new Dice(die1, die2);
		diceWithRoll = new Dice();
		diceWithPredictableRoll = new Dice(init_rolls);
	}

	@Test
	public void testGetDie1LastRoll() {
		diceWithPredictableRoll.roll();
		assertEquals(1, diceWithPredictableRoll.getDie1LastRoll());
	}

	@Test
	public void testGetDie2LastRoll() {
		diceWithPredictableRoll.roll();
		assertEquals(1, diceWithPredictableRoll.getDie2LastRoll());
	}

	@Test
	public void testInitializationOfDiceShouldGetZero() {
		assertEquals("The result of initialize a dice without rolling is not 0", 0, dice.getLastRoll());
	}
	
	@Test
	public void testInitializationOfDiceWithOneRollShouldGetTwo() {
		dice.roll();
		assertEquals("The result of a dice with 1 time of rolling is not 2", 2, dice.getLastRoll());
	}
	
	@Test
	public void testInitializationOfDiceWithTwoRollShouldGetFour() {
		dice.roll();
		dice.roll();
		assertEquals("The result of a dice with 2 times of rolling is not 4", 4, dice.getLastRoll());
	}
	
	@Test
	public void testInitializationOfDiceWithThreeRollShouldGetSix() {
		dice.roll();
		dice.roll();
		dice.roll();
		assertEquals("The result of a dice with 3 times of rolling is not 6", 6, dice.getLastRoll());
	}
	
	@Test(expected = RuntimeException.class)
	public void testInitializationOfDiceWithNullPredictableRolls() {
		Dice predictableDice = new Dice(null);
	}
	

}
