package ripley.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import api.ripley.Incident;
import api.ripley.Ripley;

/**
 * Class to fetch required data from the Ripley API.
 * 
 * @author Lewis - K1630576
 *
 */
public class Fetch {

	private static Ripley ripley;
	// Ripley key's for communicating with API
	private static final String PRIVATE_KEY = "10tLI3GWut+yVD6ql2OMtA==";
	public static final String PUBLIC_KEY = "tBgm4pVo/g/VqL46EnH7ew==";
	
	// API documentation data
	private static String acknowledgement;
	private static double version;
	private static int startYear;
	private static int endYear;
	private static int mostSightings = -1;
	private static String lastUpdated;

	
	// Incidents within the API
	protected static ArrayList<Incident> incidents;
	
	/**
	 * Collects data from the Ripley API to be used within the program.
	 */
	public static void getData() {
		
		ripley = new Ripley(PRIVATE_KEY, PUBLIC_KEY);
		
//		// Get working version of the Ripley API.
//		version = ripley.getVersion();
//		
		// Acknowledgement string for the ripley API.
		acknowledgement = ripley.getAcknowledgementString();
//		
		// First year of incidents
		startYear = ripley.getStartYear();
//		
		// Last year of incidents
		endYear = ripley.getLatestYear();
//		
//		// Current date and time
//		String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//		
//		
//		lastUpdated = ripley.getLastUpdated();
	}
	
	/**
	 * Get large details of a given incident
	 * @param id
	 * @return
	 */
	public static String getIncidentDetails(String id)
	{
		return ripley.getIncidentDetails(id);
	}
	
	/**
	 * Returns the arraylist of incidents between the chosen dates.
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static void fetchIncidents(int startDate, int endDate)
	{
		incidents = ripley.getIncidentsInRange(startDate+"-01-01 00:00:00", endDate+"-12-31 23:59:59");
	}
	
	public static ArrayList<Incident> getIncidents()
	{
		return incidents;
	}
	
	/**
	 * Loops through all incidents that have been loaded, and returns those that occurred
	 * in the specified state.
	 * @param state
	 * @return
	 */
	public static ArrayList<Incident> getIncidentsInState(int state)
	{
		ArrayList<Incident> stateIncidents = new ArrayList<>();
		
		for(Incident incident : incidents)
		{
			if(incident.getState().equals(SoftwareConstants.STATE_ABBREVIATIONS[state]))
			{
				
				stateIncidents.add(incident);
			}
		}
		return stateIncidents;
	}
	
	/**
	 * Return the number of incidents in a given state
	 * @param state
	 * @return
	 */
	public static int getIncidentCountInState(int state)
	{
		int count = 0;
		for(Incident incident : incidents)
		{
			if(incident.getState().equals(SoftwareConstants.STATE_ABBREVIATIONS[state]))
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Return the state index with the most sightings
	 * @return
	 */
	public static int getMostSightingsCount()
	{
		if(mostSightings == -1)
		{
			int largest = 0;
			for(int i=0;i<SoftwareConstants.STATES.length;i++)
			{
				int temp = getIncidentCountInState(i);
				
				if(temp > largest)
				{
					largest = temp;
				}
			}
			mostSightings = largest;
			return largest;
		}
		return mostSightings;
	}
	
	public static int getIncidentMonth(int i)
	{
		return Integer.parseInt(incidents.get(i).getDateAndTime().substring(5, 7));
	}
	
	public static int getIncidentCount()
	{
		return incidents.size();
	}
	
	/**
	 * Returns the version of the API that is in use.
	 * 
	 * @return version		The current working version of the API.
	 */
	public static double getVersion() {
		return version;
	}
	
	/**
	 * Returns the acknowledgement string that the API provides.
	 * 
	 * @return acknowledgement		The acknowledgement string provided by the API.
	 */
	public static String getAcknowledgement() {
		return acknowledgement;
	}

	public static String getLastUpdated() {
		
		return lastUpdated;
	}
	
	/**
	 * Returns the start year given by the Ripley API.
	 * @return startYear 		the first year in the Ripley API.
	 */
	public static int getStartYear() {
		
		return startYear;
	}
	
	/**
	 * Returns the last year given by the Ripley API.
	 * @return endYear 		the last year in the Ripley API.
	 */
	public static int getEndYear() {
		
		return endYear;
	}
}