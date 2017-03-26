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
	
	public MainWindowModel() {
		
		ripley = new Ripley("10tLI3GWut+yVD6ql2OMtA==","10tLI3GWut+yVD6ql2OMtA");
		
	}
	
	public String[] ripleyYearArray() {
		
		int startYear = ripley.getStartYear();
		int endYear = ripley.getLatestYear();
		int iterator = 0;
		
		String[] dateRange = new String[(endYear - startYear)];
		
		for (int i = startYear; i < endYear; i++) {
			
			dateRange[iterator] = String.valueOf(i);
			iterator++;
		}
		
		return dateRange;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
