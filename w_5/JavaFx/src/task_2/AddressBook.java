package task_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;



public class AddressBook extends Application {

	
	class NewPanel extends BorderPane {
		
		FlowPane flowPane = new FlowPane(5, 5);
		HBox ButtonPanel = new HBox(5);

	
	public NewPanel() 
	{
		TextField firstName = new TextField(); 
		firstName.setPrefColumnCount(40);
		
		TextField lastName = new TextField(); 
		lastName.setPrefColumnCount(40);
		
		TextField city = new TextField(); 
		city.setPrefColumnCount(11);
		
		ComboBox<String>  province = new ComboBox(); 
		province.getItems().add("Province");
		
		TextField postalCode = new TextField(); 
		postalCode.setPrefColumnCount(11);
		
		
		flowPane.setPadding(new Insets(5));
		flowPane.setVgap(30);
		flowPane.getChildren().addAll(new Label("First Name: "), firstName, new Label("Last Name: "), lastName, 
									  new Label("City: "), city, new Label("Province: "), province, new Label(" Postal Code: "), postalCode);
	
		
		Button buttons[] = new Button[6];
		
		buttons[0] = new Button("Add");
		buttons[1] = new Button("First");
		buttons[2] = new Button("Next");
		buttons[3] = new Button("Previous");
		buttons[4] = new Button("Last");
		buttons[5] = new Button("Update");
		
		for(int i =0; i < buttons.length; i++) 
		{
			buttons[i].setPrefWidth(120);
			ButtonPanel.getChildren().add(buttons[i]);	
		}
										            
		setCenter(flowPane);
		setBottom(ButtonPanel);
		
	}
}	
	
	
	public void start(Stage MainStage) 
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


