package ripley.control;

import java.text.CollationKey;
import java.text.Collator;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			System.out.println(matcher.group(1));
			return matcher.group(1).compareTo(targetMatcher.group(1));
		}
		return 0;
	}
	

}
