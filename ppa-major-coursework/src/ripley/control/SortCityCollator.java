package ripley.control;

import java.util.regex.Matcher;

public class SortCityCollator extends SortCollator 
{
	public SortCityCollator(String patternString) 
	{
		super(patternString);
		// TODO Auto-generated constructor stub
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
