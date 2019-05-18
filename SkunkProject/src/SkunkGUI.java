
import java.io.FileInputStream;
import java.io.IOException;
import edu.princeton.cs.introcs.StdOut;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.applet.Main;

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
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/SkunkGUI.fxml"));
         
        // Create the Pane and all Details

    	AnchorPane root = (AnchorPane) loader.load();

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
