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
    public void getKittyPot() {
        assertEquals(0, Round.getKittyPot());
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
        round.singleSkunk();
        assertEquals(1, Round.getKittyPot());
    }

    @Test
    public void skunkDeuce() {
        round.skunkDeuce();
        assertEquals(2, Round.getKittyPot());
    }

    @Test
    public void doubleSkunk() {
        round.doubleSkunk();
        assertEquals(4, Round.getKittyPot());
    }

    @Test
    public void checkForPotentialWinner() {
        round.addPlayer("TestPlayer1");

        round.checkForPotentialWinner();
    }
}