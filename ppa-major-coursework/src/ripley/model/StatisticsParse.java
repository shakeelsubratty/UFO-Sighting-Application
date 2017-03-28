package ripley.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import api.ripley.Incident;

/**
 * Parses through data to return the statistics required to the statistics panel.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsParse {
	
	public static int hoaxes;
	public static int nonUSSightings;
	public static String likeliestState;
	public static int sightingsOtherPlatforms;
	private static Map<String, Integer> stateStats;
	
	/**
	 * Initialise, parsing through each incident that is stored.
	 */
	public static void initialise() {
		//Loop through each incident
		for(Incident incident : Fetch.incidents) {
			
			// The summary of the incident
			String incidentSummary = incident.getSummary().toLowerCase();
			
			// The state of the incident
			String incidentState = incident.getState().toLowerCase();
			
			parseHoax(incidentSummary);
			parseNonUSSightings(incidentState);
			//parseLikeliestState(incidentState);
		}
	}
	
	/**
	 * Parses through the summary of each incident to check for hoaxes.
	 * 
	 * @param incidentSummary		The summary of the incident.
	 */
	public static final void parseHoax(String incidentSummary) {
		if(incidentSummary.contains("hoax")) {
			hoaxes++;
		}
	}
	
	/**
	 * Parses through the state of each incident, checking for incidents that are not located in US States.
	 * 
	 * @param incidentState		The state of the incident
	 */
	public static final void parseNonUSSightings(String incidentState) {
		
		boolean matchingState = false;
		
		/*
		 * TBC - Include Hawaii and Alaska.
		 */
		for(String state : SoftwareConstants.STATES) {
			if(incidentState.equals(state.toLowerCase())) {
				matchingState = true;
				break;
			}
			
		}
		
		// If state in incident is not a US state.
		if(!matchingState) {
			nonUSSightings++;
		}
	}
	
	/**
	 * Parses through each incident to calculate the state with the most incidents.
	 * 
	 * @param incidentState		The state of the incident
	 */
	public static final void parseLikeliestState(String incidentState) {
		
		// Create HashMap, storing amount of incidents per state.
		if(stateStats.containsKey(incidentState)) {
			stateStats.put(incidentState, stateStats.get(incidentState)+1);
		} else {
			stateStats.put(incidentState, 1);
		}
			
		// Loop through states
		for(String stateKey : stateStats.keySet()) {
			if(stateStats.get(stateKey) > stateStats.get(likeliestState)) {
				likeliestState = stateKey;
			}
		}
	}
	
	/**
	 * Check other platforms for sightings.
	 */
	public static final void parseSightingsOtherPlatforms() {
		// Sightings via other platforms.
	}
}
