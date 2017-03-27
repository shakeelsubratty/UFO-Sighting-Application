package ripley.control;

import java.text.CollationKey;
import java.text.Collator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortShapeCollator extends SortCollator {

	public SortShapeCollator(String patternString) 
	{
		super(patternString);
	}

	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		if(targetMatcher.find())
		{
			System.out.println(matcher.group(1).compareTo(targetMatcher.group(1)));
			return matcher.group(1).compareTo(targetMatcher.group(1));
		}
		return 0;
	}
	
}
