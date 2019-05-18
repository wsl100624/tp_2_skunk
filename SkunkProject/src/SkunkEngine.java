import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class SkunkEngine {
	
	public static Round round = new Round();
	public SkunkGUIController gui;
	Player gameWinner;
	
	public boolean sendPlyNames = false;
	public boolean initPlys = false;
	public boolean displayed = false;
	boolean isSkunk = false;
	
	public boolean setRnds = false;
	int numPlyEntered = 1;
	int numPlayers = 0;
	int numRounds = 0;
	int roundsPassed = 0;
	ArrayList<String> playerNames = new ArrayList<String>();
	
	public SkunkEngine(SkunkGUIController gui)
	{
		this.gui = gui;
		this.initPlys = true;
	}
	
	public void readyToAddPlayers()
	{
		initPlys = false;
		sendPlyNames = true;
		gui.setTextOnGameInfo("What is Player " +  numPlyEntered + " name?");
	}
	
	public void addPlayersToList(String player)
	{
		playerNames.add(player);
		numPlyEntered = numPlyEntered + 1;
		if(numPlyEntered <= numPlayers)
		{
			gui.setTextOnGameInfo("What is Player " +  numPlyEntered + " name?");			
		}
	}
	
	public void rollingDice(boolean rtd) 
	{
		if(rtd)
		{
			isSkunk = round.roundPlay();
			gui.setTextOnGameInfo("You have rolled " + round.getDie1() + " + " + round.getDie2() + " = " + round.getCurrRoll());
			if (isSkunk) 
			{
				gui.setTextOnGameInfo("You got a skunk! Your turn is ending!");
				if(round.getSingleSkunk())
				{
					gui.setTextOnGameInfo("You're skunk is a single skunk. You have to pay 1 chip to the kitty");
				}
				else if(round.getSkunkDeuce())
				{
					gui.setTextOnGameInfo("You're skunk is a skunk deuce. You have to pay 2 chips to the kitty");
				}
				else if(round.getDoubleSkunk())
				{
					gui.setTextOnGameInfo("You're skunk is a double skunk. You have to pay 4 chips to the kitty and lose all your points!!");
				}
				round.switchTurns(isSkunk);
				gui.setTextOnGameInfo(round.lastPlayerTurn().toString() + ", your overall score is " + round.lastPlayerTurn().getOverallScore());
				gui.setTextOnGameInfo("Your chips you have left is " + round.lastPlayerTurn().getChipScore());
				gui.setTextOnGameInfo("The kitty's pot is " + KittyPot.getKittyChips());
				
				gui.setTextOnGameInfo("Passing to the next player");
			}			
		}
		else
		{
			round.switchTurns(isSkunk);
			gui.setTextOnGameInfo(round.lastPlayerTurn().toString() + ", your overall score is " + round.lastPlayerTurn().getOverallScore());
			gui.setTextOnGameInfo("Your chips you have left is " + round.lastPlayerTurn().getChipScore());
			gui.setTextOnGameInfo("The kitty's pot is " + KittyPot.getKittyChips());
			
			gui.setTextOnGameInfo("Passing to the next player");
		}
		play();
		
	}
	
	private String updateScoreBoard()
	{
		String scores = round.chipAndOverAllRoundScore() + "\nKitty Pot: " + KittyPot.getKittyChips();
		
		return scores;
	}
	public void play() 
	{	
		gui.updateTextOnScoreBoard(updateScoreBoard());
		if((round.firstPotentialWinner != null && !displayed) && round.oldPotentialWinner == null)
		{
			displayed = true;
			gui.setTextOnGameInfo(round.firstPotentialWinner.toString() + " is a potential winner! Everyone will get one more chance to play");
		}
		if(round.roundWinner != null)
		{
			gui.setTextOnGameInfo(round.roundWinner.toString() + " is the winner!!!!");
			gui.setTextOnGameInfo(round.roundWinner.toString() + " wins with a score of " + round.roundWinner.getOverallScore() + 
					" and has an overall chip score of " + round.roundWinner.getChipScore() + " and collected " + round.getChipsFromOthers() + 
					" chips from the other players");
			gui.setTextOnGameInfo("The kitty had " + KittyPot.getKittyChips() + " chips in it");
			
			round.resetRound();
			KittyPot.clearKittyPot();
			
			
			if(!(roundsPassed == numRounds - 1))
			{
				gui.setTextOnGameInfo("STARTING NEW ROUND!");
				gui.setTextOnGameInfo("");
				gui.setTextOnGameInfo("");
				gui.setTextOnGameInfo("");
				gui.setTextOnGameInfo(round.getPlayerTurnName() + " Do you want to roll?");
				gui.updateTextOnScoreBoard(updateScoreBoard());
			}
			else
			{
				gui.setTextOnGameInfo("");
				gui.setTextOnGameInfo("");
				gui.setTextOnGameInfo("");
				gui.setTextOnGameInfo("ROUNDS DONE DETERMINING GAME WINNER");
				gameWinner = round.determineGameWinner();
				gui.setTextOnGameInfo(gameWinner.toString() + " IS THE WINNER!! WITH CHIP SCORE OF " + gameWinner.getChipScore());
				gui.updateTextOnScoreBoard(updateScoreBoard());
			}
			roundsPassed = roundsPassed + 1;
			
			
		}
		else
		{
			gui.setTextOnGameInfo(round.getPlayerTurnName() + " Do you want to roll?");
		}
		
	}
	public void addPlayers()
	{
		for(int i = 0; i < playerNames.size(); i++)
		{
			round.addPlayer(playerNames.get(i));
		}
		for(int cnt = 0; cnt < round.getPlayerList().size(); cnt++)
		{
			gui.setTextOnScoreBoard(round.getPlayerList().get(cnt).toString() + " \t Chip Score: " +
					round.getPlayerList().get(cnt).getChipScore() + "\t Overall Round Score: " + round.getPlayerList().get(cnt).getOverallScore());
		}
		gui.setTextOnScoreBoard("\nKitty Pot: " + KittyPot.getKittyChips());
		setRnds = true;
		sendPlyNames = false;
		gui.setTextOnGameInfo("How many rounds will you play?");
	}
	
	

}
