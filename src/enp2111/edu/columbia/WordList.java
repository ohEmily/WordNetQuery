package enp2111.edu.columbia;

import java.util.ArrayList;

/**
 * Container class for a list of word-sentence tuples.
 */


public class WordList
{
	/**
	 * Nested class to store the definition pairs in. 
	 */
	private class WordTuple
	{
		private String word;
		private String sentence;
		
		WordTuple(String aWord, String aSentence)
		{
			this.word = aWord;
			this.sentence = aSentence;
		}
		
		public String getWord() { return word; }
		public String getSentence() { return sentence; }
	}
	
	// instance variables
	private ArrayList<WordTuple> words;
	
	/**
	 * Default empty constructor.
	 */
	public WordList()
	{
		words = new ArrayList<WordTuple>();
	}
	
	/**
	 * Add a word-sentence tuple to the list.
	 */
	public void addTuple(String aWord, String aSentence)
	{
		words.add(new WordTuple(aWord, aSentence));
	}
	
	/**
	 * @return String containing list formatted as [Word: "definition"]
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (WordTuple each : words)
		{
			sb.append(each.getWord());
			sb.append(": \"");
			sb.append(each.getSentence());
			sb.append("\"\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * For testing purposes: return the top word.
	 */
	public String getTopWord()
	{
		return words.get(0).getWord();
	}
}
