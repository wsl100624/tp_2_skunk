import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnTest {

    private Turn turn;
    private Player player;

    @Before
    public void setUp() throws Exception {
        int[] values = {1,2,3};
        turn = new Turn(values);
        player = new Player("testPlayer");
    }

    @Test
    public void getTurnCount() {
        assertEquals(0, turn.getTurnCount());
    }

    @Test
    public void turnPlay() {
        //should get double skunk because the init values is (1,1)
        assertTrue(turn.turnPlay(player));
    }

    @Test
    public void sumRollScores() {
        turn.turnPlay(player);
        assertEquals(2, turn.sumRollScores());
    }

    @Test
    public void endTurn() {
        boolean isDoubleSkunk = turn.turnPlay(player);
        assertEquals(1, turn.getTurnCount());
        int overallScore = player.getOverallScore();
        turn.endTurn(isDoubleSkunk);
        assertEquals(0, overallScore);
        
    }
}