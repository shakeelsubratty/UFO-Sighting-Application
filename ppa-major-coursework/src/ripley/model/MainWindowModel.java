/**s
 * 
 */
package ripley.model;

/**
 * @author afrancht
 *
 */
public class MainWindowModel {
	
	private Integer startDate;
	private Integer endDate;

	/*
	 * TODO: Method years to string Access arraylist incident Find cities with
	 * brackets in name (ie outside the usa) methods for stats - perhaps Lewis.
	 * 
	 */

	private Integer[] dateRange;

	public MainWindowModel() {

	}

	/**
	 * Fetches, creates and returns the string array of all the years available
	 * in the ripley API
	 * 
	 * @return String with all years in the Ripley API.
	 */
	public Integer[] ripleyYearArray() {

		int startYear = Fetch.getStartYear();
		int endYear = Fetch.getEndYear();
		int iterator = 0;

		dateRange = new Integer[(endYear - startYear + 1)];

		for (int i = startYear; i <= endYear; i++) {

			dateRange[iterator] = i;
			iterator++;
		}

		return dateRange;

	}

	/**
	 * Method that returns string with last updated sighting.
	 */
	public String lastUpdated() {

		return Fetch.getLastUpdated();
	}

	public int verifyDate(Integer from, Integer to) {

		if (from == null || to == null) {

			return 1;

		} else if (to < from) {

			return 2;

		} else {

			return 3;
		}
	}
	
	public void setDateRange(Integer start, Integer end) {
		
		startDate = start;
		endDate = end;
	}

}
