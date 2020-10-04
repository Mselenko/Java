package task_1;

import java.util.Scanner;

public class Tester {

	public static void main(String[] argv) {
		Scanner input = new Scanner(System.in);

		double sides[] = new double[3];
		boolean flag = false;
		String value;

		System.out.println("Enter three sides of the tringle (numbers)");

		do {

			for (int i = 0; i < 3; i++) 
			{
				System.out.print(i + 1 + " side: ");

				while (!input.hasNextDouble()) 
				{
					System.out.println("Please enter number");
					System.out.print(i + 1 + " side: ");
					input.next();
				}

				sides[i] = input.nextDouble();
			}
			
			if (!(sides[0] + sides[1] > sides[2] && sides[0] + sides[2] > sides[1] && sides[1] + sides[2] > sides[0])) 
			{
				System.out.println("\nThe triangle does not exist. Enter the valid sides of the triangle\n");
				flag = true;
			}else 
			{
				flag = false;
			}

		} while (flag);

		System.out.print("\nEnter the color: ");
		String color = input.next();

		do {

			System.out.print("Is the triangle filled? true/false: ");
			value = input.next();

		} while ((!"true".equals(value)) && (!"false".equals(value)));

		
		boolean filled = Boolean.parseBoolean(value);

		Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);

		triangle.setColor(color);
		triangle.setFilled(filled);

		System.out.println(triangle);

		input.close();

	}

}