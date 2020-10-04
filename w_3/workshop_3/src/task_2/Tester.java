package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Tester {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) 
	{

		ArrayList<Integer> arl = new ArrayList<Integer>();
			
		System.out.print("Number of banks: ");
		
		
		int banksNumber = (int) validNumber();
		double[] banks = new double[banksNumber];
		double[][] borrowers = new double[banksNumber][banksNumber];
		
		
		System.out.print("Minimum asset limit: ");
		int limit = (int) validNumber();


		for (int i = 0; i < banks.length; i++) 
		{
			System.out.print("\nEnter bank balance for bank " + (i + 1) + ": ");
			banks[i] = validNumber();

			System.out.print("Enter Number of banks Loaned: ");
			int loanedNumber = (int) validNumber();

			for (int j = 0; j < loanedNumber; j++) 
			{
				System.out.print("Bank ID: ");
				int id = (int) validNumber();
				System.out.print("Amount: ");
				borrowers[i][id] = validNumber();
			}
		}

		

		for (int j = 0; j < banksNumber; j++) 
		{
			for (int i = 0; i < banksNumber; i++) 
			{
				int total = 0;

				for (int l = 0; l < banksNumber; l++) 
				{
					total += borrowers[i][l];
				}
				
				if (total + banks[i] < limit) 
				{
					for (int m = 0; m < banksNumber; m++) 
					{
						borrowers[m][i] = 0;
						arl.add(i);
					}

				}
			}
		}

		List<Integer> newList = arl.stream().distinct().collect(Collectors.toList());
		
		System.out.print("\nUnsafe banks are " + newList.toString());

	}
	

	public static double validNumber() 
	{
		while (!input.hasNextInt() && !input.hasNextDouble()) 
		{
			System.out.print("Please enter positive number: ");
			input.next();
		}
		double valid = input.nextDouble();
		
		if (valid < 0) 
		{
			System.out.print("Please enter positive number: ");
			return validNumber();
		}
		return valid;
	}
}
