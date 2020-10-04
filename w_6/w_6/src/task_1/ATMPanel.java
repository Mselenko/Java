package task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ATMPanel extends Application {

	TextField accountNumber = new TextField();
	static Account[] objects = new Account[10];

	@Override
	public void start(Stage stage) 
	{

		ButtonActions action = new ButtonActions(this, objects);
		
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(600, 300);
		gridPane.setPadding(new Insets(15, 15, 15, 15));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);

		accountNumber.setPrefColumnCount(14);

		Button button1 = new Button("Submit");
		GridPane.setHalignment(button1, HPos.LEFT);
		Button button2 = new Button("Create new PIN");
		GridPane.setHalignment(button2, HPos.RIGHT);

		button1.setOnAction(e -> {action.submit();});

		gridPane.add(new Label("Enter your account number : "), 0, 0);
		gridPane.add(accountNumber, 1, 0);

		gridPane.add(button1, 1, 6);
		Scene scene = new Scene(gridPane);

		stage.setTitle("ATM");
		stage.setScene(scene);
		stage.show();
	}
	

	public static void main(String args[]) 
	{
		serializeObject();
		launch(args);
	}

	
	public static void serializeObject()
	{

		File file = new File("account.dat");

		if (!file.exists()) 
		{
			try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file)))
			{
				for (int i = 0; i < 10; i++) 
				{
					objects[i] = new Account();
					objects[i].setBalance(100);
					objects[i].setfirstName("OBJECT " + (i + 1) + " FIRST_NAME");
					objects[i].setlastName("OBJECT " + (i + 1) + " LAST_NAME");
					objects[i].setId(i + 101);
					output.writeObject(objects[i]);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
}