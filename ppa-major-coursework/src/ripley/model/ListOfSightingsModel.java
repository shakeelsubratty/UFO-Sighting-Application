package ripley.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;

import api.ripley.Incident;

public class ListOfSightingsModel 
{
	private DefaultComboBoxModel<String> listModel; //Model for the displayed list
	
	public ListOfSightingsModel(int state)
	{
		ArrayList<Incident> incidents = Fetch.getIncidentsInState(state);
		ArrayList<String> incidentStrings = parseIncidents(incidents);
		
		String[] arr = new String[incidentStrings.size()];
		listModel = new DefaultComboBoxModel<>(incidentStrings.toArray(arr));	//Add data to list model

	}
	
	public DefaultComboBoxModel<String> getListModel()
	{
		return listModel;
	}

	/**
	 * Parse incidents to extract info and present in a concise way
	 * @param incArr
	 * @return
	 */
	private ArrayList<String> parseIncidents(ArrayList<Incident> incArr)
	{
		ArrayList<String> newIncidentsArray = new ArrayList<>();
		for (Incident incident : incArr) 
		{
			newIncidentsArray.add("ID: " + incident.getIncidentID() + " | Time: " + incident.getDateAndTime() + " | City: " + incident.getCity() +
					" | Shape: " + incident.getShape() + " | Duration: " + parseDuration(incident.getDuration())
					+ " | Posted: " + incident.getPosted());
		}
		
		return newIncidentsArray;
	}
	
	private int parseDuration(String duration)
	{
		int time = -1;
		String durationPattern = "((([\\d])+)\\s((second(s)?|sec(s)?)|(minut(e)?(s)?|min(s)?)|(hour(s)?)?))";
		Pattern pattern = Pattern.compile(durationPattern); 
		Matcher matcher = pattern.matcher(duration);
		if(matcher.find())
		{
			int x =  Integer.parseInt(matcher.group(2));
			if(matcher.group(12) != null)
			{
				x *= 60;
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
