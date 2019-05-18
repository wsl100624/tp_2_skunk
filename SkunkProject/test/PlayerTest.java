import org.junit.Test;
import org.junit.Before;


import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setup() throws Exception {
        player = new Player("TestPlayer");
    }
    
    @Test
    public void winTheRound() {
        Round round = new Round();
        int kittyChips = KittyPot.getKittyChips();
        int playerScore = player.getChipScore();
        player.winTheRound();
        assertEquals(kittyChips + playerScore,player.getChipScore());

    }

    @Test
    public void setChipScore() {
    	player.setChipScore(150);
    	assertEquals(200,player.getChipScore());
    }
    
    @Test
    public void getChipScore() {
        assertEquals(50, player.getChipScore());
    }

    @Test
    public void getOverallScore() {
        assertEquals(0, player.getOverallScore());
    }

    @Test
    public void setOverallScore() {
        player.setOverallScore(1);
        assertEquals(1, player.getOverallScore());
    }

    @Test
    public void getRollScore() {
        assertEquals(0, player.getRollScore());
    }

    @Test
    public void setRollScore() {
        player.setRollScore(1);
        assertEquals(1, player.getRollScore());
    }

    @Test
    public void getTurnScore() {
        assertEquals(0, player.getTurnScore());
    }

    @Test
    public void setTurnScore() {
        player.setTurnScore(1);
        assertEquals(1, player.getTurnScore());
    }

    @Test
    public void paySingleSkunk() {
        player.paySingleSkunk();
        assertEquals(49, player.getChipScore());
    }
    @Test
    public void payDoubleSkunk() {
        player.payDoubleSkunk();
        assertEquals(46, player.getChipScore());
    }
    @Test
    public void payDeuceSkunk() {
        player.paySkunkDeuce();
        assertEquals(48, player.getChipScore());
    }

    @Test
    public void toString1() {
        assertEquals("TestPlayer", player.toString());
    }



    
    @Test
    public void resetPlayer() {
    	player.resetPlayer();
    	assertEquals(0, player.getOverallScore());
    	assertEquals(0, player.getRollScore());
    	assertEquals(0, player.getTurnScore());
    }
        
}