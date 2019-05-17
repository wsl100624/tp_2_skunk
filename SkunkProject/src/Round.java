import java.util.*;

import edu.princeton.cs.introcs.StdOut;

public class Round {
	
	private Turn turn;

	private int turnTracker;
	
	private static int kittyPot;
	
	private int chipsFromOthers = 0;
	public int getChipsFromOthers()
	{
		return chipsFromOthers;
	}
	
	static int getKittyPot()
	{
		return kittyPot;
	}
	
	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	private boolean roundComplete = false;
	boolean isRoundComplete() {
		return roundComplete;
	}

	public void setRoundComplete(boolean roundComplete) {
		this.roundComplete = roundComplete;
	}

	private boolean isSkunk = false;
	private boolean lastTurns = false;
	
	Player roundWinner;
	private Player firstPotentialWinner;
	private Player potentialWinner;
	private Player oldPotentialWinner;
	
	private int scoreToBeat;
	int winningScore;
	

	public Round()
	{
		kittyPot = 0;
		turn = new Turn();
		turnTracker = 0;
	}

	int getTurnTracker() {
		return turnTracker;
	}

	private void incrementTurnTracker() {
		if(turnTracker == playerList.size() - 1)
		{
			this.turnTracker = 0;
		}
		else
		{
			this.turnTracker = this.turnTracker + 1;
		}
	}
	
	public void addPlayer(String playerName)
	{
		Player newPlayer = new Player(playerName);
		
		playerList.add(newPlayer);
	}
	
	public boolean roundPlay()
	{
		isSkunk = turn.turnPlay(getPlayerTurn());
		return isSkunk;	
	}
	
	public void switchTurns(boolean isSkunk)
	{
			turn.endTurn(isSkunk);
			
			if(!lastTurns)
			{
				lastTurns = checkForPotentialWinner();
			}
			else if(lastTurns && !(getPlayerTurn().name.matches(firstPotentialWinner.toString())))
			{
				checkForOtherWinner();;
			}
			
			incrementTurnTracker();
			
			if(lastTurns && getPlayerTurn().name.matches(firstPotentialWinner.toString()))
			{
				roundWinner = potentialWinner;
				roundComplete = true;
				payRoundWinner();
				roundWinner.winTheRound();
			}
			
	}
	
	public void listOutPlayers()
	{
		for(int i = 0; i < playerList.size(); i++)
		{
			StdOut.println(playerList.get(i).toString());
		}
	}
	
	public Player getPlayerTurn()
	{
		return playerList.get(turnTracker);
	}
	
	public String getPlayerTurnName()
	{
		return playerList.get(turnTracker).toString();
	}
	
	public static void singleSkunk()
	{
		kittyPot = kittyPot + 1;
	}
	
	public static void skunkDeuce()
	{
		kittyPot = kittyPot + 2;
	}
	
	public static void doubleSkunk()
	{
		kittyPot = kittyPot + 4;
	}
	
	public boolean checkForPotentialWinner()
	{
		if(playerList.get(turnTracker).getOverallScore() >= 100)
		{
			firstPotentialWinner = playerList.get(turnTracker);
			potentialWinner = firstPotentialWinner;
			scoreToBeat = firstPotentialWinner.getOverallScore();
			
			StdOut.println(firstPotentialWinner.toString() + " is a potential winner! Everyone will get one more chance to play");
			return true;
		}
		return false;
	}
	
	public void resetRound()
	{
		this.roundComplete = false;
		this.lastTurns = false;
		
		this.firstPotentialWinner = null;
		this.oldPotentialWinner = null;
		this.potentialWinner = null;
		this.roundWinner = null;
		
		this.chipsFromOthers = 0;
		this.winningScore = 0;
		this.turnTracker = 0;
		
		turn.resetTurn();
		resetPlayers();		
	}
	
	public void displayScores()
	{
		for (Player player : playerList)
		{
			player.showScores();
		}
	}
	
	private void resetPlayers()
	{
		for (Player player : playerList)
		{
			player.resetPlayer();
		}
	}
	
	public static void resetKitty()
	{
		kittyPot = 0;
	}
	
	private void checkForOtherWinner()
	{
		if(playerList.get(turnTracker).getOverallScore() > firstPotentialWinner.getOverallScore() && oldPotentialWinner == null)
		{
			potentialWinner = getPlayerTurn();
			scoreToBeat = potentialWinner.getOverallScore();
			
			StdOut.println(potentialWinner.toString() + " is a potential winner NOW! Beating " + firstPotentialWinner.toString() + " " + firstPotentialWinner.getOverallScore() +
					" score by scoring " + scoreToBeat);

		}
		else if(playerList.get(turnTracker).getOverallScore() == firstPotentialWinner.getOverallScore())
		{
			StdOut.println("WE HAVE A TIE");
		}
		else if(playerList.get(turnTracker).getOverallScore() > potentialWinner.getOverallScore())
		{
			oldPotentialWinner = potentialWinner;
			potentialWinner = getPlayerTurn();
			scoreToBeat = potentialWinner.getOverallScore();
			
			StdOut.println(potentialWinner.toString() + " is a potential winner NOW! Beating " + oldPotentialWinner.toString() + " " + oldPotentialWinner.getOverallScore() +
					" score by scoring " + scoreToBeat);
		}
		else if(playerList.get(turnTracker).getOverallScore() == potentialWinner.getOverallScore())
		{
			StdOut.println("WE HAVE A TIE SECOND WAY");
		}
	}
	
	private void payRoundWinner()
	{
		for(int i = 0; i < playerList.size() - 1; i++)
		{
			if(!(roundWinner.name.matches(playerList.get(i).name)))
			{
				if(playerList.get(i).getOverallScore() == 0)
				{
					playerList.get(i).setChipScore(-10);
					roundWinner.setChipScore(10);
					chipsFromOthers = chipsFromOthers + 10;
				}
				else if(playerList.get(i).getOverallScore() > 0)
				{
					playerList.get(i).setChipScore(-5);
					roundWinner.setChipScore(5);
					chipsFromOthers = chipsFromOthers + 5;
				}
			}
		}
	}
	
	public Player determineGameWinner()
	{
		Player winner = null;
		int chipScoreToBeat = 0;
		
		for(int cnt = 0; cnt < playerList.size(); cnt++)
		{
			if(cnt == 0)
			{
				winner = playerList.get(cnt);
				chipScoreToBeat = winner.getChipScore();
			}
			else
			{
				if(playerList.get(cnt).getChipScore() >= chipScoreToBeat)
				{
					winner = playerList.get(cnt);
					chipScoreToBeat = winner.getChipScore();
				}
			}			
		}
		
		return winner;
	}
	
}
