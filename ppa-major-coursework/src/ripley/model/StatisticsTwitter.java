 package ripley.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Communicates with the Twitter API to get the amount of results that contain a searchTerm.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsTwitter {
	
	private static String tweetTimeStamp = "[Unable to get Tweets] Please try again.";
	
	/**
	 * Counts the amount of public Tweets that contain a searchTerm.
	 * 
	 * @param searchTerm		The term to search for within tweets
	 * @return tweetCount		The amount of public tweets that contain the term
	 */
	public static String fetch(String searchTerm) {
		
		// Connect to the Twitter API
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
	        .setOAuthConsumerKey(SoftwareConstants.TWITTER_CONSUMER_KEY)
	        .setOAuthConsumerSecret(SoftwareConstants.TWITTER_CONSUMER_SECRET)
	        .setOAuthAccessToken(SoftwareConstants.TWITTER_ACCESS_TOKEN)
	        .setOAuthAccessTokenSecret(SoftwareConstants.TWITTER_ACCESS_TOKEN_SECRET);
        
        // setup instances
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
        	
        	// Setup a query to search twitter
            Query query = new Query(searchTerm);
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();

            // Convert output to JSONObject
			JSONObject obj = new JSONObject(tweets.get(0));
			try {
				
				// Get the TimeStamp of the most recent matching tweet
				tweetTimeStamp = obj.getString("createdAt");
				DateFormat originalDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'BST' yyyy");
				DateFormat convertedDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				try {
					tweetTimeStamp = convertedDateFormat.format(originalDateFormat.parse(tweetTimeStamp));
				} catch (ParseException e) {}
			} catch (JSONException e) {}
        } catch (TwitterException te) {}
        return tweetTimeStamp;
	}
}
