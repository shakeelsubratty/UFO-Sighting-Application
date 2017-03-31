package ripley.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import api.ripley.Incident;

/**
 * Models and returns the statistic for most common type of sighting.
 * @author Shakeel Subratty - K1631133
 */

public class MostCommonTypeOfSighting 
{
	private static TreeMap<String, Integer> typesOfSightingCount;	
	
	/**
	 * Returns the most common type of sighting within the selected dates.
	 * @return Most common type of sighting
	 */
	public static String getMostCommonTypeOfSighting()
	{
		String mostCommonType = "";	//String to be returned by method
		
		typesOfSightingCount = new TreeMap<>(); //Uses a treemap to count the number of each sighting.

		
		ArrayList<Incident> incidents = Fetch.getIncidents(); 
		for (Incident incident : incidents) 
		{
			//Check if treemap has a value for the given incident shape already
			try 
			{
				int x = typesOfSightingCount.get(incident.getShape());
				typesOfSightingCount.put(incident.getShape(), x+1); // If it does then increment by 1
			} catch (Exception e) 
			{
				typesOfSightingCount.put(incident.getShape(), 1); //If the value is null, then put a value of 1 for that shape
			}
		}
		int[] arr = new int[typesOfSightingCount.size()];
		int j = 0;
		//Move the count of each type of sighting to an array 
		for (Integer i : typesOfSightingCount.values()) 
		{
			arr[j] = i;
			j++;
		}
		
		Arrays.sort(arr); //Merge sort the array
		
		//Check each entry in the map to find the type of sighting with the highest count
		for(Map.Entry<String, Integer> entry : typesOfSightingCount.entrySet())
		{
			//arr[length-1] is the largest value
			if(entry.getValue() == arr[arr.length-1])
			{
				mostCommonType = entry.getKey();
			}
		}
		
		return mostCommonType;
	}
}
