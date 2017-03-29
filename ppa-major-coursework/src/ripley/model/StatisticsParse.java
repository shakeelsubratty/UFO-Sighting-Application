package ripley.model;

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
	private static boolean initialised;
	
	/**
	 * Initialise, parsing through each incident that is stored.
	 */
	public static void initialise() {
		if(!initialised) {
			
			//Loop through each incident
			for(Incident incident : Fetch.incidents) {
				
				// The summary of the incident
				String incidentSummary = incident.getSummary().toLowerCase();
				
				// The state of the incident
				String incidentState = incident.getState().toLowerCase();
				
				parseHoax(incidentSummary);
				parseNonUSSightings(incidentState);
				parseLikeliestState(incidentState);
				parseSightingsOtherPlatforms("Alien");
				initialised=true;
			}
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
		
		int highestStateIndex = 0;
		int highestStateValue = 0;
		int count = 0; 
		int stateCountValue;
		
		for(String state: SoftwareConstants.STATES) {
			
			stateCountValue = Fetch.getIncidentCountInState(count);
			if(highestStateValue < stateCountValue) {
				highestStateIndex = count;
				highestStateValue = stateCountValue;
			}
			count++;
		}
		
		if(highestStateValue != 0) {
			likeliestState = SoftwareConstants.STATES[highestStateIndex];
		} else {
			likeliestState = "Not enough data";
		}
	}
	
	/**
	 * Check other platforms for sightings.
	 */
	public static final void parseSightingsOtherPlatforms(String searchTerm) {
		sightingsOtherPlatforms = StatisticsTwitter.fetch(searchTerm);
	}
}
