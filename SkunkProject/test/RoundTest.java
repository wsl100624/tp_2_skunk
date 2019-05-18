import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class RoundTest {

    private Round round;
    private Turn turn;
    private Player player;
    private static Round testRound;
    private ArrayList<Player> pList=new ArrayList<Player>();

   
    @Before
    public void setUp() throws Exception {
        round = new Round();
        testRound=new Round();
    }

    
    @Test
    public void getChipsFromOthers() {
    	int chip=0;
    	assertEquals(chip,round.getChipsFromOthers());
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
    	round.switchTurns(false);
    	round.switchTurns(true);
        round.addPlayer("TestPlayer2");
        round.switchTurns(true);
        round.switchTurns(true);
        round.switchTurns(true);
        assertEquals(1, round.getTurnTracker());
        round.switchTurns(false);
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
    
    @Test
    public void determineWinner() {
    	Player result=round.determineGameWinner();
    }
    
    @Test
    public void resetKitty() { 
    	round.resetKitty();
    	assertEquals(0,round.getKittyPot());
    }
    
    @Test
    public void listPlayers() {
    	round.listOutPlayers();
    }
    
    @Test
    public void resetRound() {
    	round.resetRound();
    	assertEquals(0,round.getChipsFromOthers());
    	assertEquals(0,round.winningScore);
    	assertEquals(0,round.getTurnTracker());
    }
    
    @Test
    public void displayScore() {
    	round.displayScores();
    }
    
    @Test
    public void roundPlay() {
    	round.addPlayer("Testing");
    	round.switchTurns(true);
    	round.roundPlay();
     }
    
    @Test
    public void switchTurn2() {
    	round.addPlayer("Next");
    	round.addPlayer("Next2");
    	round.checkForPotentialWinner();
    	round.determineGameWinner();
    	round.isRoundComplete();
    	round.switchTurns(true);
    	player=round.getPlayerTurn();
    	player.resetPlayer();
    	round.switchTurns(false);
    }
}