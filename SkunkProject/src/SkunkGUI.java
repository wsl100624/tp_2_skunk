
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SkunkGUI extends Application {
	
	static Round round = new Round();
	
	public static void addPlayers(ArrayList<String> names)
	{
		for(int i = 0; i < names.size(); i++)
		{
			round.addPlayer(names.get(i));
		}
	}
	
    public static void main(String[] args) {      

		
    	launch(args);

    }
    
    
    @Override
    public void start(Stage stage) throws IOException
    {
    	ArrayList<String> playerNames;
		boolean isSkunk = false;
    	
    	// Create the FXMLLoader 
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "C:/Users/Soujirou152/git/tp_2_skunk/SkunkProject/src/SkunkGUI.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
         
        // Create the Pane and all Details
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
         
        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Skunk App!!");
        // Display the Stage
        stage.show();
        
        /*playerNames = SkunkController.initializePlayers();
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
		StdOut.println("The kitty had " + Round.getKittyPot() + " chips in it");*/
    	
    }
}
