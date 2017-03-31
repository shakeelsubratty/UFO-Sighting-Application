package ripley.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import api.ripley.Incident;

/**
 * Gets the most common word in incidents, filtering out certain words.
 * 
 * @author Lewis - K1630576
 *
 */
public class IncidentWordFrequency {
	static int wordFrequency;
	
	/**
	 * Returns the amount of times a word is mentioned in the incidents.
	 * 
	 * @param searchTerm		The word to search the frequency of
	 * @return wordFrequency		The frequency of searchTerm
	 */
	public static int getWord(String searchTerm) {
		searchTerm = searchTerm.toLowerCase();
		Collection<Incident> incidentCollection = Fetch.getIncidents();
		Collections.frequency(incidentCollection, searchTerm);
		
		return wordFrequency;
	}
	
}
