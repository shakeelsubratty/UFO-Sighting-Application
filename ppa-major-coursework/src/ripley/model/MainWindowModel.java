/**s
 * 
 */
package ripley.model;

import api.ripley.Ripley;

/**
 * @author afrancht
 *
 */
public class MainWindowModel {

/*
 * TODO:
 * Method years to string
 * Access arraylist incident
 * Find cities with brackets in name (ie outside the usa)
 * methods for stats - perhaps Lewis.
 * 
 */
	
	private Ripley ripley;
	
	public MainWindowModel(Ripley ripley) {
		
		this.ripley = ripley;
		
		
	}
	
	/**
	 * Fetches, creates and returns the string array of all the years available in the ripley API
	 * @return String with all years in the Ripley API.
	 */
	public Integer[] ripleyYearArray() {
		
		int startYear = ripley.getStartYear();
		int endYear = ripley.getLatestYear();
		int iterator = 0;
		
		Integer[] dateRange = new Integer[(endYear - startYear)];
		
		for (int i = startYear; i < endYear; i++) {
			
			dateRange[iterator] = i;
			iterator++;
		}
		
		return dateRange;
			
	}
	
	/**
	 * Method that returns string with last updated sighting.
	 */
	public String lastUpdated() {
		
		return ripley.getLastUpdated();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
