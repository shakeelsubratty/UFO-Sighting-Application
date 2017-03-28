package ripley.control;

import java.util.regex.Matcher;

public class SortDurationCollator extends SortCollator 
{
	private int sourcePos;
	private int targetPos;

	public SortDurationCollator(String patternString) 
	{
		super(patternString);
	}

	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		if(targetMatcher.find())
		{
			if(matcher.group(3)!=null && targetMatcher.group(3)!=null)
			{
				sourcePos = order(matcher);
				targetPos = order(targetMatcher);
				if (sourcePos > targetPos) 
					return 1;
				else if(sourcePos == targetPos)
				{
					if(Integer.parseInt(matcher.group(2)) > Integer.parseInt(targetMatcher.group(2)))
						return 1;
				}
			}
		}
		return 0;
	}

	private int order(Matcher matcher)
	{
		int x = 0;
		if(matcher.group(5)!=null)
		{
			if(matcher.group(6)!=null)
				x = 2;
			else
				x = 1;
		}
		else if(matcher.group(7)!=null)
		{
			if(matcher.group(9)!=null)
				x = 4;
			else
				x = 3;
		}
		else 
		{
			if(matcher.group(11)!=null)
				x = 6;
			else
				x = 5;
		}
		return x;
	}
}
