package ripley.control;

import java.util.regex.Matcher;

public class SortDurationCollator extends SortCollator 
{
	public SortDurationCollator(String patternString) 
	{
		super(patternString);
	}

	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		int x,y;
		if(targetMatcher.find())
		{
			x = Integer.parseInt(matcher.group(1));
			y = Integer.parseInt(targetMatcher.group(1));
			if(x > y)
				return 1;
			else if(x == y)
				return 0;
			
			else
				return -1;
		}
		return 0;
	}
}
