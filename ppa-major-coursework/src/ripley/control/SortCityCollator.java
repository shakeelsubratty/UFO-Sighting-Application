package ripley.control;

import java.util.regex.Matcher;

/**
 * City collator - defines ordering strategy for City comparisons
 * @author Shakeel Subratty - K1631133
 *
 */
public class SortCityCollator extends SortCollator 
{
	/**
	 * Constructor - creates collator with passed pattern string
	 * @param patternString
	 */
	public SortCityCollator(String patternString) 
	{
		super(patternString);
	}
	
	/**
	 * Overrides SortCollator.parse()
	 * Returns the value of String.compareTo() for the source and target strings
	 */
	@Override
	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		if(targetMatcher.find())
		{
			return matcher.group(1).compareTo(targetMatcher.group(1));
		}
		return 0;
	}
	
}
