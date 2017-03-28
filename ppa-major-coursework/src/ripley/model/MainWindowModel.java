/**s
 * 
 */
package ripley.model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JPanel;

import api.ripley.Incident;
import ripley.view.MapPanel;

/**
 * @author Alex Franch Tapia - K1631466
 *
 */
public class MainWindowModel extends Observable {
	
	private Integer startDate;
	private Integer endDate;
	
	private static long searchTime;
	
	private ArrayList<JPanel> panels;
	
	private int currentIndex; 

	private ArrayList<Incident> incidents;
	
	private Integer[] dateRange;

	public MainWindowModel() {

		panels = new ArrayList<JPanel>();
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
	
	/**
	 * Fetches incidents arraylist bewteen two given dates.
	 * @param startDate
	 * @param endDate
	 */
	public void getIncidentsInSelectedRange(int startDate,int endDate)
	{
		long x = System.currentTimeMillis();
		incidents = Fetch.getIncidents(startDate,endDate);
		searchTime = System.currentTimeMillis() - x;
		System.out.println(incidents.size());
	}

	/**
	 * Method that checks if the two dates inputed are null, greater than 
	 * each other and returns an integer depending on the case.
	 */
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
	 * Sets the startDate and endDate (date range) used in the programs.
	 * @param start 	start date.
	 * @param end		end date.
	 */
	public void setDateRange(Integer start, Integer end) {
		
		startDate = start;
		endDate = end;
		setChanged();
		notifyObservers(new DateRange(startDate, endDate));
		getIncidentsInSelectedRange(start, end);
		setChanged();
		notifyObservers(searchTime);
		for(int i=0;i<panels.size();i++)
		{
			if(panels.get(i) instanceof MapPanel)
			{
				System.out.println("Buttons updated.");
				((MapPanel) panels.get(1)).updateButtons();
			}
		}
		
	}

	/**
	 * Adds a panel to the panels array list.
	 * @param panel panel introduced into the array
	 */
	public void addPanel(JPanel panel) {
		
		panels.add(panel);
		
	}

	/**
	 * Returns the current index (refers to the current panel displayed)
	 * 
	 * @return currentIndex
	 */
	public int getCurrentIndex() {
		
		return currentIndex;
	}

	/**
	 * Returns the arraylist panels.
	 * @return panels
	 */
	public ArrayList<JPanel> getPanels() {
		
		return panels;
	}

	/**
	 * Adds one to current index.
	 */
	public void nextIndex() {

		
		currentIndex++;
	}

	/**
	 * Subtracts one from current index. 
	 */
	public void prevIndex() {

		if ( currentIndex > 0) {
			
			currentIndex--;
		}
		
	}
}
