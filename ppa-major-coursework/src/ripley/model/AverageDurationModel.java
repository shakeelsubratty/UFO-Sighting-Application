package ripley.model;

import java.util.ArrayList;
import java.util.Observable;

import api.ripley.Incident;

/**
 * Class which calculates the statistic: Average Duration per state.
 * 
 * @author Alex Franch Tapia - K1631466
 *
 */
public class AverageDurationModel extends Observable {
	
	private ArrayList<Incident> currentList; // stores incidents in a certain state.
	private int state; // references the state by its index.
	private int average; // acutal stat.
	
	public AverageDurationModel() {
		
		currentList = new ArrayList<Incident>();
		int state = -1;
		int average = 0;
		
	}
	
	/**
	 * Method which generates the statistic and sets it to variable average.
	 * 
	 * @param str		state name for which you want the statistic.
	 */
	public void generateStat(String str) { 
		
		// Finds index that is equivalent to inputed string. 
		for ( int i = 0; i < SoftwareConstants.STATES.length ; i++) {
			
			if ( SoftwareConstants.STATES[i].equals(str) ) {
				
				state = i;
			}	
		}
		
		// Assigns to our array list all the incidents in a certain state.
		currentList = Fetch.getIncidentsInState(state);
		
		// For every incident add its duration to the average.
		for ( int f = 0; f < currentList.size(); f++ ) {
			
			average += Integer.parseInt(currentList.get(f).getDuration());
		}
		
		// divide average by the number of incidents.
		average = average / currentList.size();
		
	}
	
	/**
	 * Method which returns our statistic.
	 *
	 * @return		average
	 */
	public String getAverage() {
		
		return String.valueOf(average);
	}

}
