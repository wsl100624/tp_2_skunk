import java.util.*;

import edu.princeton.cs.introcs.StdOut;

public class Round {
	
	private Turn turn;

	private int turnTracker;
	
	public KittyPot kittyPot;
	
	private int chipsFromOthers = 0;
	public int getChipsFromOthers()
	{
		return chipsFromOthers;
	}
	
	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	ArrayList<Player> getPlayerList()
	{
		return playerList;
	}
	
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
	public Player firstPotentialWinner;
	public Player potentialWinner;
	public Player oldPotentialWinner;
	
	private int scoreToBeat;
	int winningScore;
	

	public Round()
	{
		kittyPot = new KittyPot();
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
	
	public int getDie1()
	{
		return turn.roll.getCurrRollDie1();
	}
	
	public int getDie2()
	{
		return turn.roll.getCurrRollDie2();
	}
	
	public int getCurrRoll()
	{
		return turn.roll.getCurrRoll();
	}
	
	public boolean getSingleSkunk()
	{
		return turn.isSingleSkunk();
	}
	
	public boolean getDoubleSkunk()
	{
		return turn.isDoubleSkunk();
	}
	
	public boolean getSkunkDeuce()
	{
		return turn.isSkunkDeuce();
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
				checkForOtherWinner();
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
	
	public Player lastPlayerTurn()
	{
		if(turnTracker == 0)
		{
			return playerList.get(playerList.size()-1);
		}
		return playerList.get(turnTracker - 1);
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
	
	public boolean checkForPotentialWinner()
	{
		if(playerList.get(turnTracker).getOverallScore() >= Constants.SCORE_FOR_THE_WIN) //Refactor 2nd - make all the constants to a separate class to acheive 'High Cohesion'
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
	
	public String chipAndOverAllRoundScore()
	{
		String scores = "";
		for (Player player : playerList)
		{
			scores = scores + player.toString() + " \t Chip Score: " +
				player.getChipScore() + "\t Overall Round Score: " + player.getOverallScore() + "\n";
		}
		return scores;
	}
	
	private void resetPlayers()
	{
		for (Player player : playerList)
		{
			player.resetPlayer();
		}
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
				else
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
