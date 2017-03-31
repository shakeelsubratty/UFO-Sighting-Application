package ripley.control;

import java.text.CollationKey;
import java.text.Collator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides general structure for sorting classes to override 
 * @author Shakeel Subratty - K1631133
 */
public abstract class SortCollator extends Collator 
{
	private Pattern pattern;
	
	/**
	 * Constructor - creates pattern with passed in string
	 * @param patternString
	 */
	public SortCollator(String patternString)
	{
		this.pattern = Pattern.compile(patternString);
	}

	/**
	 * Compare method - takes two strings and determines their order based on the collator pattern.
	 * @param source target
	 * @return 1,0,-1 if source is greater, equal or less than target
	 */
	@Override
	public int compare(String source, String target) 
	{
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) 
		{
			Matcher targetMatcher = pattern.matcher(target);
			return parse(matcher, targetMatcher);
		}
		//If pattern not found in source, return -1
		return -1;
	}
	
	/**
	 * 	Subclasses override parse() to implement their own parsing methods
	 *	Returns 0,-1,or 1 if the source string should be equal to, behind or ahead of the
	 *	target string.
	 * @param matcher
	 * @param targetMatcher
	 * @return 1,0,-1
	 */
	abstract public int parse(Matcher matcher, Matcher targetMatcher);

	@Override
	public CollationKey getCollationKey(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
