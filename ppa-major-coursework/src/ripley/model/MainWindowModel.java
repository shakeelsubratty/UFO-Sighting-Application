/**s
 * 
 */
package ripley.model;

import java.util.ArrayList;
import java.util.Observable;

import api.ripley.Incident;

/**
 * @author afrancht
 *
 */
public class MainWindowModel extends Observable
{
	
	private Integer startDate;
	private Integer endDate;
	
	private long searchTime;

	/*
	 * TODO: Method years to string Access arraylist incident Find cities with
	 * brackets in name (ie outside the usa) methods for stats - perhaps Lewis.
	 * 
	 */
	
	private ArrayList<Incident> incidents;

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
	
	public void getIncidentsInSelectedRange(int startDate,int endDate)
	{
		long x = System.currentTimeMillis();
		incidents = Fetch.getIncidents(startDate,endDate);
		searchTime = System.currentTimeMillis() - x;
		System.out.println(incidents.size());
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
	/**
	 * Sets user selected date range and notifies observers of this selection
	 * @param start
	 * @param end
	 */
	public void setDateRange(Integer start, Integer end) {
		
		startDate = start;
		endDate = end;
		setChanged();
		notifyObservers(new DateRange(startDate, endDate));
		getIncidentsInSelectedRange(start, end);
		setChanged();
		notifyObservers(searchTime);
	}

}
