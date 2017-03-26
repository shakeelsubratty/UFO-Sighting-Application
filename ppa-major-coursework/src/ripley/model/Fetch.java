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
	String privateKey = "10tLI3GWut+yVD6ql2OMtA==";
	String publicKey = "tBgm4pVo/g/VqL46EnH7ew==";
	
	// New Ripley API instance
	Ripley ripley = new Ripley(privateKey, publicKey);
	
	// API documentation data
	String acknowledgement;
	Double version;
	Integer startYear;
	
	// Incidents within the API
	ArrayList<Incident> incidents;
	
	
	public Fetch() {
		
		// Initialise fetch from API
		initialise();
	}
	
	/**
	 * Collects data from the Ripley API to be used within the program.
	 */
	public void initialise() {
		
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
}
