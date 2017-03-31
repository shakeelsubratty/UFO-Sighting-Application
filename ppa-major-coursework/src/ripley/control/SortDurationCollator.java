package ripley.control;

import java.util.regex.Matcher;

/**
 * Duration collator - defines ordering strategy for Duration comparisons
 * @author Shakeel Subratty - K1631133
 *
 */
public class SortDurationCollator extends SortCollator 
{
	/**
	 * Constructor - creates SortCollator with passed pattern string
	 * @param patternString
	 */
	public SortDurationCollator(String patternString) 
	{
		super(patternString);
	}
	
	/**
	 * Determies whether source duration is greater, equal or less than target duration
	 * by numerical ordering.
	 */
	@Override
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
