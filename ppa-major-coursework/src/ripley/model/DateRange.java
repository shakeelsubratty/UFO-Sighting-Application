package ripley.model;

/**
 * Defines DateRange object that stores a pair of integer dates,
 * for use when passing date ranges through notifyObservers() calls
 * @author Shakeel Subratty - K1631133
 *
 */
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
