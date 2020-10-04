package cardValidation;

import java.util.Scanner;

public class Validation {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String inputValue = null;

		do 
		{

			System.out.print("Enter a credit card number as a long integer between 13 and 16 digits: ");
			inputValue = input.nextLine();

		} while (inputValue.length() < 13 || inputValue.length() > 16 && !inputValue.matches("-?\\d+(\\.\\d+)?"));
		
		long cardNumber = Long.parseLong(inputValue);

		System.out.println("Card Number " + cardNumber + (isValid(cardNumber) ? " is valid" : " is not valid"));

		input.close();

	}


	public static boolean isValid(long number) 
	{
		int sum = 0;
		sum += sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		return sum % 10 == 0 ? true : false;
	}

	public static int sumOfDoubleEvenPlace(long number) 
	{

		boolean secondDigit = false;
		int sum = 0;
		int digit = 0;

		for (int i = getSize(number) - 1; i >= 0; i--) 
		{
			digit = (int) (number % 10);

			if (secondDigit) sum += getDigit(digit);
			
			secondDigit = !secondDigit;
			number /= 10;
		}

		return sum;
	}


	public static int getDigit(int number) 
	{
		number = number * 2;
		return (number/10 + number%10);
	}


	public static int sumOfOddPlace(long number) 
	{
		boolean secondDigit = true;
		int sum = 0;
		int digit = 0;

		for (int i = getSize(number) - 1; i >= 0; i--) 
		{
			digit = (int) (number % 10);

			if (secondDigit) sum += digit;

			secondDigit = !secondDigit;
			number /= 10;
		}

		return sum;
	}
	
	
	public static int getSize(long d) 
	{
		return String.valueOf(d).length();
	}

}

////5. /** Return true if the digit d is a prefix for number */
//public static boolean prefixMatched(long number, int d) {}
//
//
////7. /** Return the first k number of digits from number. If the
////* number of digits in number is less than k, return number. */
//public static long getPrefix(long number, int k) {}
