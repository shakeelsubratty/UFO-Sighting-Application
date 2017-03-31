package ripley.control;

import java.util.regex.Matcher;

/**
 * Shape collator - defines ordering strategy for shape comparisons
 * @author Shakeel Subratty - K1631133
 *
 */
public class SortShapeCollator extends SortCollator {

	/**
	 * Constructor - creates collator with passed pattern string
	 * @param patternString
	 */
	public SortShapeCollator(String patternString) 
	{
		super(patternString);
	}
	
	/**
	 * Overrides SortCollator.parse()
	 * Returns the value of String.compareTo() for the source and target strings
	 */
	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		if(targetMatcher.find())
		{
			return matcher.group(1).compareTo(targetMatcher.group(1));
		}
		return 0;
	}
	
}
