import edu.princeton.cs.introcs.StdOut;
import java.util.*;

public class SkunkApp 
{
	static Round round = new Round();
	static Player gameWinner = null;
	
	public static void addPlayers(ArrayList<String> names)
	{
		for(int i = 0; i < names.size(); i++)
		{
			round.addPlayer(names.get(i));
		}
	}
	
	public static void main(String[] args) 
	{
		StdOut.println("Welcome to Skunk");
		
		ArrayList<String> playerNames;
		int numRounds = 0;
		boolean isSkunk = false;
			
		playerNames = SkunkController.initializePlayers();
		addPlayers(playerNames);
		
		round.listOutPlayers();
		
		numRounds = SkunkController.askForRounds();
		for(int cnt = 0; cnt < numRounds; cnt++)
		{
			while(!round.isRoundComplete())
			{
				if (SkunkController.startSkunk(round.getPlayerTurnName())) 
				{
					isSkunk = round.roundPlay();
		
					if (isSkunk) 
					{
						round.switchTurns(isSkunk);
					}
					else 
					{
						while (SkunkController.continueTurn(round.getPlayerTurnName()) && !round.isRoundComplete())
						{
							isSkunk = round.roundPlay();
		
							if (isSkunk) 
							{
								break;
							}
						}
		
						round.switchTurns(isSkunk);
					}					
				} 
				else 
				{
					round.switchTurns(isSkunk);
				}
				
				isSkunk = false;	
			}
			
			StdOut.println(round.roundWinner.toString() + " is the winner!!!!");
			StdOut.println(round.roundWinner.toString() + " wins with a score of " + round.roundWinner.getOverallScore() + 
					" and has an overall chip score of " + round.roundWinner.getChipScore() + " and collected " + round.getChipsFromOthers() + 
					" chips from the other players");
			StdOut.println("The kitty had " + KittyPot.getKittyChips() + " chips in it");
			
			round.resetRound();
			KittyPot.clearKittyPot();
			if(!(cnt == numRounds - 1))
			{
				StdOut.println("STARTING NEW ROUND!");
			}
			else
			{
				StdOut.println("ROUNDS DONE DETERMINING GAME WINNER");
			}
			
			StdOut.println("");
			StdOut.println("");
			StdOut.println("");
			round.displayScores();
			StdOut.println("");
			StdOut.println("");
			StdOut.println("");
		}
		gameWinner = round.determineGameWinner();
		StdOut.println(gameWinner.toString() + " IS THE WINNER!! WITH CHIP SCORE OF " + gameWinner.getChipScore());	
		
	}

}
