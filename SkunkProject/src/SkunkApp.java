import edu.princeton.cs.introcs.StdOut;
import java.util.*;

public class SkunkApp 
{
	static Round round = new Round();
	
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
		boolean isSkunk = false;
			
		playerNames = SkunkController.initializePlayers();
		addPlayers(playerNames);
		
		round.listOutPlayers();
		
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
		StdOut.println("The kitty had " + Round.getKittyPot() + " chips in it");
		
	}

}
