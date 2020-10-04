package task_3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.Point2D;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class CircleText extends Application {

	@Override
	public void start(Stage stage) 
	{

		Pane pane = rotateLetter(0, 100, 90, "Welcome to Java");
		
		Scene scene = new Scene(pane, 450, 450);
		
		stage.setTitle("Welcome to Java");
		stage.setScene(scene);
		stage.show();
	}

	
	public Pane rotateLetter(double angle, double radius, double rotate, String string) 
	{
		Pane pane = new Pane();
		Point2D center = new Point2D(200, 200);
		String[] text = string.split("");
		Font font = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 35);

		for (int i = 0; i < text.length; i++, angle += 22, rotate += 22) 
		{
			double x = center.getX() + radius * Math.cos(Math.toRadians(angle));
			double y = center.getY() + radius * Math.sin(Math.toRadians(angle));

			Text newText = new Text(x, y, text[i]);
			newText.setFont(font);
			newText.setRotate(rotate);
			pane.getChildren().add(newText);
		}
		
		return pane;
	}

	
	public static void main(String[] args) 
	{
		launch(args);
	}
}