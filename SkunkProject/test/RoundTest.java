import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import static org.junit.Assert.*;

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
    public void determineWinner() {
    	Player result=round.determineGameWinner();
    }
    
    @Test
    public void resetKitty() { 
    	KittyPot.clearKittyPot();;
    	assertEquals(0,KittyPot.getKittyChips());
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