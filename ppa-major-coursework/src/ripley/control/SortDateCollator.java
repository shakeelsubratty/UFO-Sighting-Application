package ripley.control;

import java.util.regex.Matcher;

/**
 * Date collator - defines ordering strategy for Date comparisons
 * @author Shakeel Subratty - K1631133
 *
 */
public class SortDateCollator extends SortCollator 
{
	/**
	 * Constructor - creates sort collator with passed pattern string
	 * @param patternString
	 */
	public SortDateCollator(String patternString) 
	{
		super(patternString);
	}

	/**
	 * Overrides SortCollator.parse(). Determines whether source date is greater, equal or less than 
	 * target date.
	 * @return Returns value of parseDate()
	 */
	@Override
	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		if(targetMatcher.find())
		{
			return parseDate(matcher,targetMatcher);
		}
		return 0;
	}
	
	/**
	 * Determines whether source date is greater, equal or less than target date.
	 * @param matcher
	 * @param targetMatcher
	 * @return 1,0,-1 accordingly
	 */
	private int parseDate(Matcher matcher, Matcher targetMatcher)
	{
		//If year is the same
		if(Integer.parseInt(matcher.group(1)) == Integer.parseInt(targetMatcher.group(1)))
		{
			//If month is the same
			if(Integer.parseInt(matcher.group(2)) == Integer.parseInt(targetMatcher.group(2)))
			{
				//If day is the same
				if(Integer.parseInt(matcher.group(3)) == Integer.parseInt(targetMatcher.group(3)))
				{
					//If date is the same, parse the time to determine order
					return parseTime(matcher,targetMatcher);
				}
				//If source day is greater than target day
				else if(Integer.parseInt(matcher.group(3)) >= Integer.parseInt(targetMatcher.group(3)))
					return 1;
				else
					return -1;
			}
			//If source month is greater than target month
			else if(Integer.parseInt(matcher.group(2)) >= Integer.parseInt(targetMatcher.group(2)))
				return 1;
			else 
				return -1;
		}
		//If source year is greater than target year
		else if(Integer.parseInt(matcher.group(1)) >= Integer.parseInt(targetMatcher.group(1)))
			return 1;
		else 
			return -1;
	}
	
	/**
	 * If source and target dates are equal, determines whether source time 
	 * is greater, equal or less than target time.
	 * @param matcher
	 * @param targetMatcher
	 * @return 1,0,-1
	 */
	private int parseTime(Matcher matcher, Matcher targetMatcher)
	{
		//If hour is the same
		if(Integer.parseInt(matcher.group(5)) == Integer.parseInt(targetMatcher.group(5)))
		{
			//If minutes is the same
			if(Integer.parseInt(matcher.group(6)) == Integer.parseInt(targetMatcher.group(6)))
			{
				//If seconds is the same
				if(Integer.parseInt(matcher.group(7)) == Integer.parseInt(targetMatcher.group(7)))
				{
					//If time is the same
					return 0;
				}
				//If source seconds is greater than target seconds
				else if(Integer.parseInt(matcher.group(7)) >= Integer.parseInt(targetMatcher.group(7)))
						return 1;
				else
					return -1;
			}
			//If source minutes is greater than target minutes
			else if(Integer.parseInt(matcher.group(6)) >= Integer.parseInt(targetMatcher.group(6)))
					return 1;
			else
				return -1;
		}
		//If source hourse is greater than target hourse
		else if(Integer.parseInt(matcher.group(5)) >= Integer.parseInt(targetMatcher.group(5)))
				return 1;
		else
			return -1;
	}

}
