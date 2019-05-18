
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
	
	public SkunkGUIController skunkGUI;
	public SkunkEngine skunkEngine;
	
    public static void main(String[] args) {      
		
    	launch(args);
    }
    
    
    @Override
    public void start(Stage stage) throws IOException
    {
    	
    	// Create the FXMLLoader 
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "C:/Users/Soujirou152/git/tp_2_skunk/SkunkProject/src/SkunkGUI.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
         
        // Create the Pane and all Details
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
        skunkGUI = loader.getController();
        skunkEngine = new SkunkEngine(skunkGUI);
        skunkGUI.setEngine(skunkEngine);
         
        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Skunk App!!");
        // Display the Stage
        stage.show();        
    	
    }
}