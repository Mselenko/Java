package task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

class ButtonActions {

	private Stage mainStage;
	Alert alert = new Alert(AlertType.INFORMATION);

	ButtonActions(Stage mainStage) 
	{
		this.mainStage = mainStage;
	}

	public void startMain() 
	{
		GridPane gridPane = new GridPane();

		TextField year = new TextField();
		TextField gender = new TextField();
		TextField name = new TextField();

		gridPane.setMinSize(600, 300);
		gridPane.setPadding(new Insets(15, 15, 15, 15));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);

		year.setPrefColumnCount(14);

		Button button1 = new Button("Submit");
		GridPane.setHalignment(button1, HPos.LEFT);
		Button button2 = new Button("Exit");
		GridPane.setHalignment(button2, HPos.RIGHT);

		button1.setOnAction(e -> {submit(year.getText(), gender.getText(), name.getText());});
		button2.setOnAction(e -> {exit();});

		button1.setMaxWidth(100);
		button2.setMaxWidth(100);

		gridPane.add(new Label("Enter The Year: "), 0, 0);
		gridPane.add(new Label("Enter the Gender: "), 0, 1);
		gridPane.add(new Label("Enter the Name : "), 0, 2);
		gridPane.add(year, 1, 0);
		gridPane.add(gender, 1, 1);
		gridPane.add(name, 1, 2);

		gridPane.add(button1, 1, 12);
		gridPane.add(button2, 1, 12);
		Scene scene = new Scene(gridPane);

		mainStage.setTitle("Search Name Ranking Application");
		mainStage.setScene(scene);
		mainStage.show();
	}

	public void submit(String year, String gender, String name) 
	{
		int yr = Integer.parseInt(year);
		
		File file = new File("babynamesranking" + yr + ".txt");
		
		if (!file.exists()) 
		{
			alert.setHeaderText("No record for " + yr);
			alert.showAndWait();
		} else 
		{
			int rank = 0;
			
			try (Scanner read = new Scanner(file)) 
			{
				while (read.hasNext()) 
				{
					String s = read.nextLine();
					String[] str = s.split("\\s+");

					if (gender.equalsIgnoreCase("M") && str[1].equals(name)) 
					{
						rank = new Integer(str[0]);
						break;
					}
					if (gender.equalsIgnoreCase("F") && str[3].equals(name)) 
					{
						rank = new Integer(str[0]);
						break;
					}
				}
			} catch (FileNotFoundException e) {}
			  catch (Exception e) {}

			if (rank == 0) 
			{
				alert.setHeaderText("The name " + name + " is not ranked in " + yr + " year");
				alert.showAndWait();

			} else if (rank > 0 && gender.equalsIgnoreCase("M")) 
			{
				alert.setHeaderText("Boy name " + name + " is ranked #" + rank + " in " + yr + " year");
				alert.showAndWait();
				nextName();

			} else if (rank > 0 && gender.equalsIgnoreCase("F")) 
			{

				alert.setHeaderText("Girl name " + name + " is ranked #" + rank + " in " + yr + " year");
				alert.showAndWait();
				nextName();
			}

		}

	}

	public void exit() 
	{
		System.exit(1);
	}

	public void nextName() 
	{
		GridPane gridPane = new GridPane();

		TextField option = new TextField();

		gridPane.setMinSize(600, 300);
		gridPane.setPadding(new Insets(15, 15, 15, 15));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);

		option.setPrefColumnCount(14);

		Button button1 = new Button("Submit");
		GridPane.setHalignment(button1, HPos.LEFT);
		Button button2 = new Button("Exit");
		GridPane.setHalignment(button2, HPos.RIGHT);

		button1.setOnAction(e -> {option(option.getText());});
		button2.setOnAction(e -> {exit();});

		button1.setMaxWidth(100);
		button2.setMaxWidth(100);

		gridPane.add(new Label("Do you want to Search another Name: "), 0, 0);
		gridPane.add(option, 1, 0);

		gridPane.add(button1, 1, 12);
		gridPane.add(button2, 1, 12);
		Scene scene = new Scene(gridPane);

		mainStage.setTitle("Search Name Ranking Application");
		mainStage.setScene(scene);
		mainStage.show();
	}

	public void option(String option) 
	{
		if (option.equals("Y") || option.equals("y")) 
		{
			startMain();
		} else if (option.equals("N") || option.equals("N")) 
		{
			exit();
		} else 
		{
			alert.setHeaderText("Please enter Y (Yes) or N (No)");
			alert.showAndWait();
		}
	}
}