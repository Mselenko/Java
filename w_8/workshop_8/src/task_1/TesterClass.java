package task_1;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TesterClass extends Application {

	TextField additionResult = new TextField();
	TextField substarctionResult = new TextField();
	TextField multiplicationResult = new TextField();
	TextField divisionResult = new TextField();
	static Stage mainStage = new Stage();

	@Override
	public void start(Stage stage) 
	{
		startMainStage();
	}

	public void startMainStage() 
	{
		int x = (int) (Math.random() * 10);
		int y = (int) (Math.random() * 10 + 1);

		Calculation calculation = new Calculation(x, y);

		GridPane gridPane = new GridPane();
		gridPane.setMinSize(600, 500);
		gridPane.setPadding(new Insets(5, 5, 5, 5));
		gridPane.setVgap(15);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);

		gridPane.add(new Label("Two randomly generated numbers are: " + x + " and " + y), 0, 0);

		Text text0 = new Text("Two randomly generated numbers are: " + x + " and " + y);
		Text text1 = new Text("What is addition of " + x + " and " + y);
		Text text2 = new Text("What is substraction of " + x + " and " + y);
		Text text3 = new Text("What is multiplication of " + x + " and " + y);
		Text text4 = new Text("What is division of " + x + " and " + y);

		TextField textField1 = new TextField();

		TextField textField2 = new TextField();
		TextField textField3 = new TextField();
		TextField textField4 = new TextField();

		GridPane.setHalignment(text0, HPos.RIGHT);
		GridPane.setHalignment(text1, HPos.RIGHT);
		GridPane.setHalignment(text2, HPos.RIGHT);
		GridPane.setHalignment(text3, HPos.RIGHT);
		GridPane.setHalignment(text4, HPos.RIGHT);

		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			calculation.submit(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText());
		});
		
		GridPane.setHalignment(submit, HPos.RIGHT);

		gridPane.add(text1, 0, 1);
		gridPane.add(textField1, 1, 1);
		gridPane.add(text2, 0, 2);
		gridPane.add(textField2, 1, 2);
		gridPane.add(text3, 0, 3);
		gridPane.add(textField3, 1, 3);
		gridPane.add(text4, 0, 4);
		gridPane.add(textField4, 1, 4);

		gridPane.add(submit, 0, 8);

		Scene scene = new Scene(gridPane);

		mainStage.setTitle("Quiz Application");

		mainStage.setScene(scene);

		mainStage.show();

	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
