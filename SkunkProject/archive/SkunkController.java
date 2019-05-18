import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import java.util.*;

public class SkunkController 
{
	
	public SkunkController(String name)
	{
	}
	 
	//class that does the PL logic
	static boolean continueTurn(String playerName)
	{
		boolean cntinue = false;
		String choice;
		
		StdOut.println(playerName + " Do you want to roll again? 'yes' for yes 'no' for no");
		choice = StdIn.readString();
		
		
		if(choice.matches("yes"))
		{
			cntinue = true;
		}
		else if(choice.matches("no"))
		{
			cntinue = false;
		}
		else
		{
			StdOut.println("Your input did not match 'yes' or 'no' ");
		}
		
		return cntinue;
	}
	
	static boolean startSkunk(String playerName)
	{
		boolean decsn = false;
		String choice;
		
		
		StdOut.println(playerName + " Do you want to roll? 'yes' for yes 'no' for no");
		choice = StdIn.readString();
		
		
		if(choice.matches("yes"))
		{
			decsn = true;
		}
		else if(choice.matches("no"))
		{
			decsn = false;
		}
		else
		{
			StdOut.println("Your input did not match 'yes' or 'no' ");
		}
		
		return decsn;
	}
	
	static ArrayList<String> initializePlayers()
	{
		int numPlayers;
		
		StdOut.println("How many players will there be?");
		numPlayers = StdIn.readInt();
		
		 return askForPlayerName(numPlayers);
	}
	
	private static ArrayList<String> askForPlayerName(int num)
	{
		ArrayList<String> names = new ArrayList<String>();
		String name;
				
		for(int i = 1; i <= num; i++)
		{
			StdOut.println(" What is player " + i + "'s name?");
			name = StdIn.readString();
			
			names.add(name);
		}
				
		return names;
	}
	
	static int askForRounds()
	{
		int numRounds;
		
		StdOut.println("How many rounds would you like to play?");
		numRounds = StdIn.readInt();
		
		return numRounds;
		
	}
	

	
}
