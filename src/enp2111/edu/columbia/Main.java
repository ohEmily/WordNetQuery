package enp2111.edu.columbia;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		WordList list = new WordList();
		
		// attempt to read in words. Quit if failed.
		try {
			readInWords("data.csv", list);
		} catch (IOException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		
		System.out.println(list.toString());
	}
	
	/**
	 * Reads word-sentence pairs from the file into the list, where sentence 
	 * is column A, word is column B.
	 */
	private static void readInWords(String fileName, WordList list) throws IOException
	{
		Path filePath = Paths.get(fileName);
		Scanner scanner = new Scanner(filePath);
		scanner.useDelimiter("\t");
		
		String sentence = scanner.next();
		String word = scanner.next();
		
		list.addTuple(word, sentence);
		
		scanner.close();
		
	}
}
