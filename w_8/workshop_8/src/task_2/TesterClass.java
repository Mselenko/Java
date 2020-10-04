package task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TesterClass {

	static boolean found;
	static boolean isCorrect;

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Map<String, String> MapedCapitals = new HashMap<>(50);

		for (String[] stateCapital : stateCapitals) 
		{
			MapedCapitals.put(stateCapital[0], stateCapital[1]);
		}

		boolean exit = true;

		do 
		{
			System.out.print("\nPlease Enter a State: ");
			String myState = input.nextLine();

			found = false;

			MapedCapitals.forEach((state, city) -> 
			{
				if (myState.equalsIgnoreCase(state)) 
				{
					System.out.println("\nThe Capital City of " + myState + " is: " + city);
					found = true;
				}

			});

			if (!found) 
			{
				System.out.println("\nNo City for the: " + myState);
			}

			do 
			{
				System.out.print("\nEnter new State? Y/N: ");

				String answer = input.nextLine().toUpperCase();

				if (answer.equals("N")) 
				{
					exit = false;
					isCorrect = false;
				} else if (answer.equals("Y")) 
				{
					exit = true;
					isCorrect = false;
				} else 
				{
					isCorrect = true;
				}

			} while (isCorrect);

		} while (exit);

	}

	private static String[][] stateCapitals = { { "Alabama", "Montgomery" }, { "Alaska", "Juneau" },
			{ "Arizona", "Phoenix" }, { "Arkansas", "Little Rock" }, { "California", "Sacramento" },
			{ "Colorado", "Denver" }, { "Connecticut", "Hartford" }, { "Delaware", "Dover" },
			{ "Florida", "Tallahassee" }, { "Georgia", "Atlanta" }, { "Hawaii", "Honolulu" }, { "Idaho", "Boise" },
			{ "Illinois", "Springfield" }, { "Maryland", "Annapolis" }, { "Minnesota", "Saint Paul" },
			{ "Iowa", "Des Moines" }, { "Maine", "Augusta" }, { "Kentucky", "Frankfort" },
			{ "Indiana", "Indianapolis" }, { "Kansas", "Topeka" }, { "Louisiana", "Baton Rouge" },
			{ "Oregon", "Salem" }, { "Oklahoma", "Oklahoma City" }, { "Ohio", "Columbus" },
			{ "North Dakota", "Bismark" }, { "New York", "Albany" }, { "New Mexico", "Santa Fe" },
			{ "New Jersey", "Trenton" }, { "New Hampshire", "Concord" }, { "Nevada", "Carson City" },
			{ "Nebraska", "Lincoln" }, { "Montana", "Helena" }, { "North Carolina", "Raleigh" },
			{ "Missouri", "Jefferson City" }, { "Mississippi", "Jackson" }, { "Massachusetts", "Boston" },
			{ "Michigan", "Lansing" }, { "Pennsylvania", "Harrisburg" }, { "Rhode Island", "Providence" },
			{ "South Carolina", "Columbia" }, { "South Dakota", "Pierre" }, { "Tennessee", "Nashville" },
			{ "Texas", "Austin" }, { "Utah", "Salt Lake City" }, { "Vermont", "Montpelier" },
			{ "Virginia", "Richmond" }, { "Washington", "Olympia" }, { "West Virginia", "Charleston" },
			{ "Wisconsin", "Madison" }, { "Wyoming", "Cheyenne" } };

}
