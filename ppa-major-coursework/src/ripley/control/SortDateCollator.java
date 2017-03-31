package ripley.control;

import java.util.regex.Matcher;

public class SortDateCollator extends SortCollator 
{
	public SortDateCollator(String patternString) 
	{
		super(patternString);
	}

	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		if(targetMatcher.find())
		{
			return parseDate(matcher,targetMatcher);
		}
		return 0;
	}
	
	private int parseDate(Matcher matcher, Matcher targetMatcher)
	{
		if(Integer.parseInt(matcher.group(1)) == Integer.parseInt(targetMatcher.group(1)))
		{
			if(Integer.parseInt(matcher.group(2)) == Integer.parseInt(targetMatcher.group(2)))
			{
				if(Integer.parseInt(matcher.group(3)) == Integer.parseInt(targetMatcher.group(3)))
				{
					//If date is the same, parse the time to determine order
					return parseTime(matcher,targetMatcher);
				}
				else if(Integer.parseInt(matcher.group(3)) >= Integer.parseInt(targetMatcher.group(3)))
					return 1;
				else
					return -1;
			}
			else if(Integer.parseInt(matcher.group(2)) >= Integer.parseInt(targetMatcher.group(2)))
				return 1;
			else 
				return -1;
		}
		else if(Integer.parseInt(matcher.group(1)) >= Integer.parseInt(targetMatcher.group(1)))
			return 1;
		else 
			return -1;
	}
	
	private int parseTime(Matcher matcher, Matcher targetMatcher)
	{
		if(Integer.parseInt(matcher.group(5)) == Integer.parseInt(targetMatcher.group(5)))
		{
			if(Integer.parseInt(matcher.group(6)) == Integer.parseInt(targetMatcher.group(6)))
			{
				if(Integer.parseInt(matcher.group(7)) == Integer.parseInt(targetMatcher.group(7)))
				{
					return 0;
				}
				else if(Integer.parseInt(matcher.group(7)) >= Integer.parseInt(targetMatcher.group(7)))
						return 1;
				else
					return -1;
			}
			else if(Integer.parseInt(matcher.group(6)) >= Integer.parseInt(targetMatcher.group(6)))
					return 1;
			else
				return -1;
		}
		else if(Integer.parseInt(matcher.group(5)) >= Integer.parseInt(targetMatcher.group(5)))
				return 1;
		else
			return -1;
	}

}
