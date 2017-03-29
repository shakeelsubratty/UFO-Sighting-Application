package ripley.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import api.ripley.Incident;

public class MostCommonTypeOfSighting 
{
	private TreeMap<String, Integer> typesOfSightingCount;
	
	public String getMostCommonTypeOfSighting()
	{
		String mostCommonType = "";
		
		typesOfSightingCount = new TreeMap<>();
		
		ArrayList<Incident> incidents = Fetch.getIncidents();
		for (Incident incident : incidents) 
		{
			try 
			{
				int x = typesOfSightingCount.get(incident.getShape());
				typesOfSightingCount.put(incident.getShape(), x+1);
			} catch (Exception e) 
			{
				typesOfSightingCount.put(incident.getShape(), 1);
			}
		}
		System.out.println(typesOfSightingCount.toString());
		int[] arr = new int[typesOfSightingCount.size()];
		int j = 0;
		for (Integer i : typesOfSightingCount.values()) 
		{
			arr[j] = i;
			j++;
		}
		Arrays.sort(arr);
		System.out.println(arr[typesOfSightingCount.size()-1]);
		
		for(Map.Entry<String, Integer> entry : typesOfSightingCount.entrySet())
		{
			if(entry.getValue() == arr[arr.length-1])
			{
				mostCommonType = entry.getKey();
			}
		}
		
		return mostCommonType;
	}
}
