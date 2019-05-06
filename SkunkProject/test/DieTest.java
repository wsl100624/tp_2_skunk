import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DieTest {
	
	private Die die;

	@Before
	public void setUp() throws Exception {
		
		int[] init_values = new int[] {1,2,3};
		die = new Die(init_values);
	}

	@Test
	public void testDieConstructor() {
		// the default constructor should never get 0 result
		Die newDie = new Die();
		int lastRoll = newDie.getLastRoll();

		assertNotEquals(0, lastRoll);
	}

	@Test
	public void testInitializationZeroOfPredictableDie() {
		assertEquals("the value is not 0 without rolling", 0, die.getLastRoll());
	}

	@Test
	public void testInitializationOneOfPredictableDie() {
		
		die.roll();
		assertEquals("the first value is not 1", 1, die.getLastRoll());
		
	}
	
	@Test
	public void testInitializationTwoOfPredictableDie() {
		
		die.roll();
		die.roll();
		assertEquals("the second value is not 2", 2, die.getLastRoll());
	}
	
	@Test
	public void testInitializationThreeOfPredictableDie() {
		
		die.roll();
		die.roll();
		die.roll();
		assertEquals("the third value is not 3", 3, die.getLastRoll());
	}
	
	@Test
	public void testInitializationFourOfPredictableDie() {
		
		die.roll();		
		die.roll();
		die.roll();
		die.roll();
		assertEquals("the fourth value didn't go back to 1", 1, die.getLastRoll());
	}
	
	@Test(expected=RuntimeException.class)
	public void testInitialNullArrayOfPredictableRolls() {
		Die die = new Die(null);
		die.roll();
	}

}
