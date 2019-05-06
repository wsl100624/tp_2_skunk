import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdOut;
import org.junit.Before;
import org.junit.Test;

public class RollTest {
	
	private Roll predictableRoll;
	private Roll realRoll;
	
	@Before
	public void setUp() throws Exception {
		int[] init_values = new int[] {1,2,3,4,5,6};

		predictableRoll = new Roll(init_values);
		realRoll = new Roll();

		int currRoll = 1;
	}
	

	@Test
	public void setupRealRoll() {
		realRoll.roll();
		assertNotEquals(0, realRoll.getCurrRoll());
	}

	@Test
	public void getCurrRoll() throws Exception {
		assertEquals("the value is not 0 without rolling", 0, predictableRoll.getCurrRoll());
	}
	@Test
	public void setRoll() throws Exception {
		predictableRoll.setCurrRoll();
		assertEquals("the value is not 0 without rolling", 0, predictableRoll.getCurrRoll());
	}
	@Test
	public void last1Roll() throws Exception {
		assertEquals("the value is not 1 without rolling", 0, predictableRoll.getCurrRollDie1());
	}
	@Test
	public void last2Roll() throws Exception {
		assertEquals("the value is not 2 without rolling", 0, predictableRoll.getCurrRollDie2());
	}

	@Test(expected = RuntimeException.class)
	public void testInitializationOfRollWithNullPredictableRolls() {
		Roll predictableRoll = new Roll(null);
	}

	@Test
	public void testIsSkunk() {
		predictableRoll.roll();
		assertFalse(predictableRoll.isSkunk());
	}

	@Test
	public void testIsDoubleSkunk() {
		predictableRoll.roll();
		assertTrue(predictableRoll.isDoubleSkunk());
	}

	@Test
	public void testIsSkunkDeuce() {
		predictableRoll.roll();
		assertFalse(predictableRoll.isSkunkDeuce());
	}

}
