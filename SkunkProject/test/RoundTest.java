import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundTest {

    private Round round;

    @Before
    public void setUp() throws Exception {
        round = new Round();
    }

    @Test
    public void getTurnTracker() {
        assertEquals(0, round.getTurnTracker());
    }


    @Test
    public void isRoundComplete() {
        assertFalse(round.isRoundComplete());
    }

    @Test
    public void setRoundComplete() {
        round.setRoundComplete(true);
        assertTrue(round.isRoundComplete());
    }

    @Test
    public void switchTurns() {
        round.addPlayer("TestPlayer1");
        round.addPlayer("TestPlayer2");
        round.switchTurns(true);
        assertEquals(1, round.getTurnTracker());
    }

    @Test
    public void getPlayerTurn() {
        round.addPlayer("TestPlayer1");
        round.addPlayer("TestPlayer2");
        String playerName = round.getPlayerTurn().toString();
        assertEquals("TestPlayer1", playerName);

    }

    @Test
    public void getPlayerTurnName() {
        round.addPlayer("TestPlayer");
        assertEquals("TestPlayer", round.getPlayerTurnName());
    }

    @Test
    public void singleSkunk() {
        int sknkDie1[] = {1,2};
    	int sknkDie2[] = {3,2};
    	
    	round = new Round(sknkDie1, sknkDie2);
    	round.addPlayer("player1");
    	round.roundPlay();
        round.getSkunkDeuce();
        assertEquals(true, round.getSingleSkunk());

    }

    @Test
    public void skunkDeuce() {
    	int sknkDie1[] = {1,2};
    	int sknkDie2[] = {2,2};
    	
    	round = new Round(sknkDie1, sknkDie2);
    	round.addPlayer("player1");
    	round.roundPlay();
        round.getSkunkDeuce();
        assertEquals(true, round.getSkunkDeuce());
    }

    @Test
    public void doubleSkunk() {
        int sknkDie1[] = {1,2};
    	int sknkDie2[] = {1,2};
    	
    	round = new Round(sknkDie1, sknkDie2);
    	round.addPlayer("player1");
    	round.roundPlay();       
        assertEquals(true, round.getDoubleSkunk());
    }

    @Test
    public void checkForPotentialWinner() {
        round.addPlayer("TestPlayer1");

        round.checkForPotentialWinner();
    }
    
    @Test
    public void checkGetDice()
    {
    	round.getSingleSkunk();
        int sknkDie1[] = {1,2};
    	int sknkDie2[] = {7,2};
    	int die1,die2;
    	
    	round = new Round(sknkDie1, sknkDie2);
    	round.addPlayer("player1");
    	round.roundPlay();
    	die1 = round.getDie1();
    	die2 = round.getDie2();
        assertEquals(1, die1);
        assertEquals(7, die2);
        assertEquals(die1+die2, round.getCurrRoll());
    }
        
    
}