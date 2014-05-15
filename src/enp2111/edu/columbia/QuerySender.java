package enp2111.edu.columbia;

import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

/**
 * Class to send the queries to the WordNet database.
 * Set up using JAWS instructions: http://lyle.smu.edu/~tspell/jaws/index.html
 */

public class QuerySender 
{
	private WordNetDatabase database;
	
	public QuerySender(String databaseLocation)
	{
		System.setProperty("wordnet.database.dir", databaseLocation);
		database = WordNetDatabase.getFileInstance();
	}
	
	/**
	 * retrieve synsets from the database as shown in the example below. This code retrieves
	 * all noun synsets for query and loops through each one printing its first word form, 
	 * its description, and the number of hyponyms associated with that noun synset.
	 */
	public String getSynonyms(String query)
	{
		Synset[] synsets = database.getSynsets(query, SynsetType.NOUN);
		
		String synonyms = "";
		
		// return all synonyms in String form
		for (int i = 0; i < synsets.length; i++)
		{
			NounSynset ns = (NounSynset) synsets[i]; 
			synonyms += ns.getWordForms()[0] + ": " + ns.getDefinition() + "\n";
		}
		
		return synonyms;
	}
}
