import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SkunkGUIController {
		
	public SkunkEngine skunkEngine;
	private boolean rtd;
	@FXML
	private Button enterBtn;
	@FXML
	private Button rtdBtn;
	@FXML
	private Button passBtn;
	@FXML
	private TextField enterOptionsTf;
	@FXML
	private Label scoreBoardLbl;
	@FXML
	private Label gameInfoLbl;
	@FXML
	private Label scoreBoardLbl1;
	@FXML
	private TextArea gameInfoTA;
	 
	public SkunkGUIController()
	{}
	
	public void setEngine(SkunkEngine se)
	{
		this.skunkEngine = se;
	}
	
	@FXML
	private void initialize()
	{
		gameInfoTA.setText("Welcome to Skunk! Please enter how many players will be playing?\n ");
	}
	
	
	public boolean waitForDecision() 
	{
		if(rtd)
		{
			rtd = false;
			return true;
		}
		else
		{
			return rtd;
		}
	}
	
	@FXML
	private void rollTheDice()
	{
		skunkEngine.rollingDice(true);
	}
	
	@FXML
	private void noToRollTheDice()
	{
		skunkEngine.rollingDice(false);
	}
	
	public void setTextOnGameInfo(String newStr)
	{
		String old;
		
		old = gameInfoTA.getText();
		gameInfoTA.setText(old + newStr +"\n");
		gameInfoTA.appendText(""); //autoscrolls to the bottom
	}
	
	public void setTextOnScoreBoard(String newStr)
	{
		String old;		
		old = scoreBoardLbl1.getText();
		scoreBoardLbl1.setText(old + newStr +"\n");
	}
	
	public void updateTextOnScoreBoard(String newStr)
	{
		scoreBoardLbl1.setText(newStr +"\n");
	}
	
	@FXML
	private void onDataEntered() throws InterruptedException
	{
		if(skunkEngine.initPlys)
		{
			skunkEngine.numPlayers = Integer.parseInt(enterOptionsTf.getText());
			skunkEngine.readyToAddPlayers();
			return;
		}
		if(skunkEngine.sendPlyNames)
		{
			if(skunkEngine.numPlyEntered < skunkEngine.numPlayers)
			{
				skunkEngine.addPlayersToList(enterOptionsTf.getText());
			}
			else
			{
				skunkEngine.addPlayersToList(enterOptionsTf.getText());
				skunkEngine.addPlayers();
				return;
			}
		}
		if(skunkEngine.setRnds)
		{
			skunkEngine.numRounds = Integer.parseInt(enterOptionsTf.getText());
			skunkEngine.play();
		}
	}
	

}
