package ripley.control;

import java.util.regex.Matcher;

public class SortPostedDateCollator extends SortCollator {

	/**
	 * Constructor - creates sort collator with passed pattern string
	 * @param Shakeel Subratty - K1631133
	 */
	public SortPostedDateCollator(String patternString) 
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
					//If date is the same
					return 0;
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

}
