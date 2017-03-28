package ripley.model;

public class MostCommonMonth
{
	int[] monthCount = new int[12];
	
	public String getMostPopularMonth()
	{
		for(int i=0;i<monthCount.length;i++)
		{
			monthCount[i] = 0;
		}
		
		for(int i=0;i<Fetch.getIncidentCount();i++)
		{
			monthCount[Fetch.getIncidentMonth(i)-1]++;
		}
		
		int largestIndex = 0;
		
		for(int i=0;i<monthCount.length;i++)
		{
			if(monthCount[largestIndex] < monthCount[i])
			{
				largestIndex = i;
			}
		}
		
		String str = "";
		
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
