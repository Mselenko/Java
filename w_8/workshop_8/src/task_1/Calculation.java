package task_1;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;


public class Calculation {


	private double addition, substraction, multiplication, division;
	private int x,y;
	List<Double> correct = new ArrayList<Double>();
	List<Double> wrong = new ArrayList<Double>();
	
	Calculation()
	{
		addition =0;
		substraction =0;
		multiplication =0;
		division =0.0;
	}
	
	Calculation(int x, int y){
		
		this.x = x;
		this.y=y;
	}
	
	public void submit(String addition, String substraction, String multiplication, String division) 
	{
		if(validate(addition,substraction,multiplication,division)) 
		{
			this.addition =Double.parseDouble(addition);
			this.substraction =Double.parseDouble(substraction);
			this.multiplication =Double.parseDouble(multiplication);
			this.division = Double.parseDouble(division);
			add_numbers();
			substract_numbers();
			multiply_numbers();
			divide_numbers();
			
			option();
		}
	}
	
	
	public boolean validate(String addition, String substraction, String multiplication, String division) 
	{
		if(!(addition.matches("[0-9]+") && substraction.matches("[0-9]+") && multiplication.matches("[0-9]+") && !division.contains("[a-zA-Z]+")))
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Please enter digits only");
			alert.showAndWait();
			return false;
		}else 
		{
			return true;
		}
	}
	
	public void add_numbers() 
	{
		if(this.addition == (x+y)) 
			correct.add(this.addition);
		else
			wrong.add(this.addition);
	}
	
	public void substract_numbers() 
	{
		if(this.substraction == (x-y)) 
			correct.add(this.substraction);
		else
			wrong.add(this.substraction);
	}
	
	public void multiply_numbers() 
	{
		if(this.multiplication == (x*y)) 
			correct.add(this.multiplication);
		else
			wrong.add(this.multiplication);
	}
	
	public void divide_numbers() 
	{
		if((double)x%y == 0 && this.division == (x/y)) 
		
			correct.add(this.division);
		else if((double)x%y != 0 && this.division == ((double)x)/y) 
			correct.add(this.division);
		else
			wrong.add(this.division);
		
		
	}
	
	public void option()
	{
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Answers");
		alert.setHeaderText(null);
		alert.setContentText("Number of Correct Answers: " + correct.size() + 
							 "\nNumber of Wrong Answers: " +  wrong.size() +
							 "\n\nWould you like to try with two other different numbers?");

		ButtonType okButton = new ButtonType("YES", ButtonData.YES);
		ButtonType noButton = new ButtonType("NO", ButtonData.NO);

		alert.getButtonTypes().setAll(okButton, noButton);
		
		alert.showAndWait().ifPresent(type -> {
		        if (type == okButton) 
		        {
		        	TesterClass tester =new TesterClass();
		        	tester.startMainStage();
		        } else 
		        {
		        	System.exit(1);
		        }
		});
	}
}
