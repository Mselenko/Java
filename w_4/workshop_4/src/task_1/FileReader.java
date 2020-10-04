package task_1;

import java.io.IOException;
import java.io.RandomAccessFile;


public class FileReader {
	
	private int byteRead,count;
	private char letter;
	private RandomAccessFile file; 
	
	
	public FileReader()
	{
		this.count=0;
		this.letter = ' ';
		this.file = null;
	}
	
	public FileReader(RandomAccessFile file) 
	{
		this.count=0;
		this.letter = ' ';
		this.file = file;
	}
	
	
	public void countLetterOccurance(char alphabet[]) throws IOException 
	{
		System.out.println();
		
		for(int j = 0; j <26; j++ ) 
		{

			while ((byteRead = this.file.read()) != -1) 
			{
				letter = (char) Character.toUpperCase(byteRead);
				
				if(letter == alphabet[j]) count++;
			}
			
			System.out.println("Number of " + alphabet[j]+"'s" + ": " + count);
			count = 0;
			file.seek(0);
		}
	
	}
}
