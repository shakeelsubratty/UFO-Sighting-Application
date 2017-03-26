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

	// Ripley key's for communicating with API
	private static final String PRIVATE_KEY = "10tLI3GWut+yVD6ql2OMtA==";
	public static final String PUBLIC_KEY = "tBgm4pVo/g/VqL46EnH7ew==";
	
	// API documentation data
	private static String acknowledgement;
	private static double version;
	private static int startYear;
	
	// Incidents within the API
	private static ArrayList<Incident> incidents;
	
	/**
	 * Collects data from the Ripley API to be used within the program.
	 */
	public static void getData() {
		
		Ripley ripley = new Ripley(PRIVATE_KEY, PUBLIC_KEY);
		
		// Get working version of the Ripley API.
		version = ripley.getVersion();
		
		// Acknowledgement string for the ripley API.
		acknowledgement = ripley.getAcknowledgementString();
		
		// First year of incidents
		startYear = ripley.getStartYear();
		
		// Current date and time
		String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		// Fetch all of the incidents within the API
		// Took ~35 seconds to collect ~105000 records.
		incidents = ripley.getIncidentsInRange(startYear+"-01-01 00:00:00", currentTime);
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
}
