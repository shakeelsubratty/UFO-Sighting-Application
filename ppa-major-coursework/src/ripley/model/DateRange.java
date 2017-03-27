package ripley.model;

public class DateRange 
{
	private int startDate;
	private int endDate;
	
	public DateRange(int startDate, int endDate)
	{
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getStartDate()
	{
		return startDate;
	}
	
	public int getEndDate()
	{
		return endDate;
	}

}
