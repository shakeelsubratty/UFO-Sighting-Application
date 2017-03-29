package ripley.model;

import java.util.List;

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
	
	/**
	 * Counts the amount of public Tweets that contain a searchTerm.
	 * 
	 * @param searchTerm		The term to search for within tweets
	 * @return tweetCount		The amount of public tweets that contain the term
	 */
	public static int fetch(String searchTerm) {
		int tweetCount = 0;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
	        .setOAuthConsumerKey(SoftwareConstants.TWITTER_CONSUMER_KEY)
	        .setOAuthConsumerSecret(SoftwareConstants.TWITTER_CONSUMER_SECRET)
	        .setOAuthAccessToken(SoftwareConstants.TWITTER_ACCESS_TOKEN)
	        .setOAuthAccessTokenSecret(SoftwareConstants.TWITTER_ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            Query query = new Query(searchTerm);
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            tweetCount = tweets.size();
        } catch (TwitterException te) {}
        return tweetCount;
	}
}
