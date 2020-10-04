package task_1;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class TesterClass extends Application {

	public Stage mainStage=new Stage();
	ButtonActions action = new ButtonActions(mainStage);
	
	
	@Override
	public void start(Stage stage) 
	{
		action.startMain();	
	}
		
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}








