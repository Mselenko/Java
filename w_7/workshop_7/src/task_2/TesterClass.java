package task_2;

import java.util.Scanner;

public class TesterClass {
	static String[][] pattern = new String[6][7];
	static GameMethods game = new GameMethods();
	
	 @SuppressWarnings("static-access")
	 
	public static void main (String[] args)
	  {
		   	boolean turn = true; 
		    int counter = 0; 
		    String color;
		    int position;
		    
		    while(turn) 
		    {
		    	game.drawGame(pattern);
		    	System.out.println("_______________");
		    	
		    	if (counter % 2 == 0) 
		    	{
		    		System.out.print("Drop a Yellow disk at column (0�6): ");
		    		color = "Y";
		    	}else 
		    	{
		    		System.out.print("Drop a Red disk at column (0�6): ");
		    		color = "R";
		    	}
		    	counter++;
		    	position = validate();
		    	
		    	game.pushLetter(position, color, pattern);
		    	
		    	String winner = game.gameWinner(pattern);
		    	
				if (winner != null)
		           {
		    		 game.drawGame(pattern);
		             turn = false;

		             if (winner == "R")
		               System.out.println("The red player won");
		            else if (winner== "Y")
		              System.out.println("The yellow player won");
		        }
		    }
	  }
	 
	 public static int validate() 
	 {
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);	 
		 
		 while (!input.hasNextInt()) 
			{
				System.out.print("Please enter number: ");
				input.next();
			}
		 
		 int data = input.nextInt();
	    	
		 while (data > 7 ) 
			 {
				 System.out.print("Please enter integer from 0 to 6: ");
				 data = input.nextInt();
			 }
	    	return data;
	 }

}
