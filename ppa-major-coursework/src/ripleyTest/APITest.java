package ripleyTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import api.ripley.Incident;
import api.ripley.Ripley;

/**
 * 
 * @author Aaron - K1630486
 *
 * This class is a test for the functionality of the Ripley API.
 * 
 */
public class APITest
{
	public static void main(String[] args)
	{
		//Initialise keys
		String privateKey = "10tLI3GWut+yVD6ql2OMtA==";
		String publicKey = "tBgm4pVo/g/VqL46EnH7ew==";
		
		//Create instance of Ripley
		Ripley ripley = new Ripley(privateKey, publicKey);
		
		//Print start and end year
		System.out.println("Start year: " + ripley.getStartYear() + "\nLatest year: " + ripley.getLatestYear());
		
		//Get incidents from 2016
		ArrayList<Incident> list = ripley.getIncidentsInRange("1997-01-01 00:00:00", "1997-12-31 23:59:59");
		
		//Create new set
		Set<String> cities = new HashSet<>();
		
		//Print ripley version
		System.out.println(ripley.getVersion());
		
		//Add cities from incident array to set
		for(int i=0;i<list.size();i++)
		{
			cities.add(list.get(i).getCity());
		}
		System.out.println(list.size());
		//Print set
		System.out.println(cities.toString());
		
		System.out.println(ripley.getAcknowledgementString());
	}
}

