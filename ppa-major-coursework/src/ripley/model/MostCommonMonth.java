package ripley.model;

/**
 * Returns the month with the most sightings.
 * 
 * @author Aaron - K1630486
 *
 */
public class MostCommonMonth
{
	static int[] monthCount = new int[12];
	
	/**
	 * 
	 * @return the month with the most sightings
	 */
	public static String getMostPopularMonth()
	{
		// Set default values for monthCount
		for(int i=0;i<monthCount.length;i++)
		{
			monthCount[i] = 0;
		}
		
		//Store matches for each month
		for(int i=0;i<Fetch.getIncidentCount();i++)
		{
			monthCount[Fetch.getIncidentMonth(i)-1]++;
		}
		
		int largestIndex = 0;
		
		// Find largest value
		for(int i=0;i<monthCount.length;i++)
		{
			if(monthCount[largestIndex] < monthCount[i])
			{
				largestIndex = i;
			}
		}
		
		String str = "";
		
		// Return month based on value of largestIndex
		switch(largestIndex)
		{
			case 0:
				str = "January";
				break;
			case 1:
				str = "February";
				break;
			case 2:
				str = "March";
				break;
			case 3:
				str = "April";
				break;
			case 4:
				str = "May";
				break;
			case 5:
				str = "June";
				break;
			case 6:
				str = "July";
				break;
			case 7:
				str = "August";
				break;
			case 8:
				str = "September";
				break;
			case 9:
				str = "October";
				break;
			case 10:
				str = "November";
				break;
			case 11:
				str = "December";
				break;
		}
		
		return str;
	}
}
