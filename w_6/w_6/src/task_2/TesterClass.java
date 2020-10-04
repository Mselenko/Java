package task_2;
	
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class TesterClass extends Application {
	
	
	public void start(Stage MainStage) throws FileNotFoundException 
	{
		NewPanel panel = new NewPanel();
		Scene scene = new Scene(panel, 680, 250);
		MainStage.setTitle("Address Book"); 
		MainStage.setScene(scene); 
		MainStage.show(); 
	}

	
	public static void main(String [] args) 
	{
		launch(args);
	}

}



