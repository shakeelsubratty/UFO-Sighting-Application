package ripley.control;

import java.text.CollationKey;
import java.text.Collator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Provides general structure for sorting classes to override 
public abstract class SortCollator extends Collator 
{
	private String patternString;
	private Pattern pattern;
	
	public SortCollator(String patternString)
	{
		this.patternString = patternString;
		this.pattern = Pattern.compile(patternString);
	}

	@Override
	public int compare(String source, String target) 
	{
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) 
		{
			Matcher targetMatcher = pattern.matcher(target);
			return parse(matcher, targetMatcher);
		}
		return -1;
	}
	
	//Subclasses override parse() to implement their own parsing methods
	//Returns 0,-1,or 1 if the source string should be equal to, behind or ahead of the
	//target string.
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
