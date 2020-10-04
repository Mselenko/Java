package task_2;

import java.io.*;
import java.util.*;

public class PhoneNumberGenerator {

	private char letters[][];
	private char[] word = new char[7];
	String phoneNumber;

	PhoneNumberGenerator() 
	{
		word = null;
		letters = null;
		phoneNumber = "";
	}

	PhoneNumberGenerator(char letters[][], String phoneNumber) 
	{
		this.letters = letters;
		this.phoneNumber = phoneNumber;
	}

	public void generateWords(OutputStreamWriter stream) throws IOException 
	{

		int[] digit = new int[7];

		for (int i = 0; i < 7; i++) 
		{
			digit[i] = Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));
		}

		for (int letter0 = 0; letter0 < 3; letter0++) {
			word[0] = letters[digit[0]][letter0];

			for (int letter1 = 0; letter1 < 3; letter1++) {
				word[1] = letters[digit[1]][letter1];

				for (int letter2 = 0; letter2 < 3; letter2++) {
					word[2] = letters[digit[2]][letter2];

					for (int letter3 = 0; letter3 < 3; letter3++) {
						word[3] = letters[digit[3]][letter3];

						for (int letter4 = 0; letter4 < 3; letter4++) {
							word[4] = letters[digit[4]][letter4];

							for (int letter5 = 0; letter5 < 3; letter5++) {
								word[5] = letters[digit[5]][letter5];

								for (int letter6 = 0; letter6 < 3; letter6++) {
									word[6] = letters[digit[6]][letter6];
							
									stream.write(Arrays.toString(word) + "\n");
								}
							}
						}
					}
				}
			}
		}
	}
}
