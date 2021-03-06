package enp2111.edu.columbia;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Reads in a wordlist from the data.csv file
 */

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
		
		// for testing, print the whole list:
//		System.out.println(list.toString());
		
		// create new QuerySender using the dictionary files stored locally
		String filePath = new File("").getAbsolutePath().concat("\\dict");
		QuerySender qs = new QuerySender(filePath);
		
		System.out.println(qs.getSynonyms(list.getAWord()));
	}
	
	/**
	 * Reads word-sentence pairs from the file into the list, where sentence 
	 * is column A, word is column B.
	 */
	private static void readInWords(String fileName, WordList list) 
			throws IOException
	{
		CSVReader reader = new CSVReader(new FileReader(fileName), ',');
		String[] nextLine = new String[2];  // nextLine[] is an array of values from the line
		
		// skip the first row, the column headers
		reader.readNext();
		
	    while ((nextLine = reader.readNext()) != null) 
	    {
	        String word = nextLine[1];
	        String sentence = nextLine[0];
	        
	        list.addTuple(word, sentence);    
	    }

	    reader.close();
	}
}
