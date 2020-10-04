package task_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Tester {

	public static void main(String[] argv) {

		Scanner input = new Scanner(System.in);
		boolean flag;

		System.out.println("##########################Task 1##########################\n");

		do {

			flag = false;

			System.out.print("Enter a filename: ");

			try (RandomAccessFile file = new RandomAccessFile(input.nextLine().trim(), "r")) 
			{

				char[] alphabet = new char[26];

				for (int i = 0; i < 26; i++) {
					alphabet[i] = (char) (65 + i);
				}

				FileReader filereader = new FileReader(file);
				filereader.countLetterOccurance(alphabet);

			} catch (FileNotFoundException e) {
				System.out.println("\nSystem cannot find this file. Please try again\n");
				flag = true;
			} catch (IOException e) {
				System.out.println("\nInput/Output Exception occures\n");
				flag = true;
			} catch (Exception e) {
				System.out.println("\nException occures\n");
				flag = true;
			}

		} while (flag);
		
	}

}
