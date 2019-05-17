import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SkunkGUIController {
	
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
	private Label gameInfoLbl1;
	
	public SkunkGUIController()
	{}
	
	@FXML
	private void initialize()
	{}
	
	@FXML
	private void test()
	{
		enterOptionsTf.setText("IT'S WORKING");
		scoreBoardLbl1.setText("OMGGGG\n WHAT IS THIS");
	}
	
	@FXML
	private void startSkunk()
	{
		gameInfoLbl1.setText("Welcome to Skunk! Please enter how many players ");
	}
	


}
