package ripley.control;

import java.util.regex.Matcher;

public class SortShapeCollator extends SortCollator {

	public SortShapeCollator(String patternString) 
	{
		super(patternString);
	}

	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		if(targetMatcher.find())
		{
			return matcher.group(1).compareTo(targetMatcher.group(1));
		}
		return 0;
	}
	
}
