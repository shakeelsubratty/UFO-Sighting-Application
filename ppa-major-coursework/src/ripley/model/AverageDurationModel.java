package ripley.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private int divideBy; // what it's divided by (some incidents may not have duration)
	
	public AverageDurationModel() {
		
		currentList = new ArrayList<Incident>();
		int state = -1;
		int average = 0;
		int divideBy = 0;
		
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
		if ( currentList.size() != 0 ) {
			
			for ( int f = 0; f < currentList.size(); f++ ) {
				
				int currentIncidentTime = parseDuration(currentList.get(f).getDuration());
				
				if ( currentIncidentTime > 0 ) {
					
					average += currentIncidentTime;
					divideBy++;
				}
				
			}
			
			// divide average by the number of incidents.
			average = average / divideBy;
			
		} else {
			
			average = 0;
		}
		
	}
	
	/**
	 * Method which returns our statistic.
	 *
	 * @return		average
	 */
	public String getAverage() {
		
		return String.valueOf(average);
	}
	
	private int parseDuration(String duration)
	{
		int time = 0;
		String durationPattern = "((([\\d])+)\\s((second(s)?|sec(s)?)|(minut(e)?(s)?|min(s)?)|(hour(s)?)?))";
		Pattern pattern = Pattern.compile(durationPattern); 
		Matcher matcher = pattern.matcher(duration);
		if(matcher.find())
		{
			int x =  Integer.parseInt(matcher.group(2));
			if(matcher.group(12) != null)
			{
				x *= 60.00;
			}
			else if(matcher.group(5) != null)
			{
				x = Math.round(x/60);
			}
			time = x;
		}
		
		return time;
	}

}
