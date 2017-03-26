package ripley.control;

import java.text.CollationKey;
import java.text.Collator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortDurationCollator extends SortCollator {

	public SortDurationCollator(String patternString) 
	{
		super(patternString);
	}

	public int parse(Matcher matcher, Matcher targetMatcher)
	{
		if(targetMatcher.find())
		{
//			//System.out.println(matcher.group(3));
//			if(matcher.group(3)!=null && targetMatcher.group(3)!=null)
//			{
//				System.out.println(matcher.group(3) + matcher.group() + " + " + matcher.group() +targetMatcher.group(3));
////				if(Integer.parseInt(matcher.group(2)) > Integer.parseInt(targetMatcher.group(2)))
////				{
////					System.out.println(Integer.parseInt(matcher.group(2)) +" > "+ Integer.parseInt(targetMatcher.group(2)));
////
////					return 1;
////				}
//				
//			}
//			//return matcher.group(1).compareTo(targetMatcher.group(1));
		}
		return 0;
	}

}
