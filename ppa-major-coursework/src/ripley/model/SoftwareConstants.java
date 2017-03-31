package ripley.model;

/**
 * A class containing static final fields used as constants throughout the program
 * 
 * @author Aaron - K1630486
 *
 */
public class SoftwareConstants
{
	/**
	 * Coordinates at which each alien should be placed.
	 */
	public static final int[][] COORDINATES = {
			{787, 475},			// Alabama
			{265, 395},			// Arizona
			{650, 420},			// Arkansas
			{141, 392},			// California
			{374, 299},			// Colorado
			{1147, 225},		// Conneticut
			{1107, 300},		// Delaware
			{1082, 380}, 		// Dist. of Columbia
			{922, 555},			// Florida
			{857, 455},			// Georgia
			{224, 160},			// Idaho
			{726, 265},			// Illinois
			{790, 260},			// Indiana
			{620, 232},			// Iowa
			{525, 325},			// Kansas
			{827, 335},			// Kentucky
			{665, 520},			// Louisiana
			{1104, 93},			// Maine
			{1132, 345},		// Maryland
			{1147, 135},		// Massechusets
			{799, 195},			// Michigan
			{612, 121},			// Minnesota
			{725, 470},			// Mississippi
			{651, 321},			// Missouri
			{393, 106},			// Montana
			{509, 245},			// Nebraska
			{158, 233},			// Nevada
			{1024, 33},			// New Hamshire
			{1137, 265},		// New Jersey
			{385, 410},			// New Mexico
			{1000, 172},		// New York
			{952, 380},			// North Carolina
			{492, 92},			// North Dakota
			{877, 254},			// Ohio
			{545, 405},			// Oklahoma
			{97, 126},			// Oregon
			{964, 229},			// Pennsylvania
			{1167, 180},		// Rhode Island
			{922, 430},			// South Carolina
			{477, 166},			// South Dakota
			{777, 405},			// Tennessee
			{575, 540},			// Texas
			{255, 263},			// Utah
			{974, 53},			// Vermont
			{964, 320},			// Virginia
			{119, 39},			// Washington
			{905, 308},			// West Virginia
			{696, 160},			// Wisconsin
			{340, 189}			// Wyoming
	};
	
	/**
	 * Names of states
	 */
	public static final String[] STATES = {
			"Alabama",
		    "Arizona", 
		    "Arkansas", 
		    "California", 
		    "Colorado", 
		    "Connecticut", 
		    "Delaware", 
		    "Dist. of Columbia", 
		    "Florida", 
		    "Georgia",
		    "Idaho", 
		    "Illinois", 
		    "Indiana", 
		    "Iowa", 
		    "Kansas", 
		    "Kentucky", 
		    "Louisiana", 
		    "Maine", 
		    "Maryland",
		    "Massachusetts", 
		    "Michigan",
		    "Minnesota", 
		    "Mississippi", 
		    "Missouri",
		    "Montana", 
		    "Nebraska", 
		    "Nevada", 
		    "New Hampshire", 
		    "New Jersey", 
		    "New Mexico", 
		    "New York", 
		    "North Carolina", 
		    "North Dakota", 
		    "Ohio", 
		    "Oklahoma", 
		    "Oregon", 
		    "Pennsylvania", 
		    "Rhode Island", 
		    "South Carolina", 
		    "South Dakota", 
		    "Tennessee", 
		    "Texas", 
		    "Utah", 
		    "Vermont", 
		    "Virginia", 
		    "Washington", 
		    "West Virginia", 
		    "Wisconsin", 
		    "Wyoming"
	};
	
	/**
	 * Official abbreviations of states
	 */
	public static final String[] STATE_ABBREVIATIONS = {
			"AL", 
		    "AZ", 
		    "AR", 
		    "CA", 
		    "CO", 
		    "CT", 
		    "DE", 
		    "DC", 
		    "FL", 
		    "GA", 
		    "ID", 
		    "IL", 
		    "IN", 
		    "IA", 
		    "KS", 
		    "KY", 
		    "LA", 
		    "ME", 
		    "MD", 
		    "MA", 
		    "MI", 
		    "MN", 
		    "MS", 
		    "MO",
		    "MT", 
		    "NE", 
		    "NV", 
		    "NH", 
		    "NJ", 
		    "NM", 
		    "NY", 
		    "NC", 
		    "ND", 
		    "OH", 
		    "OK", 
		    "OR", 
		    "PA", 
		    "RI", 
		    "SC", 
		    "SD", 
		    "TN", 
		    "TX", 
		    "UT", 
		    "VT", 
		    "VA",  
		    "WA", 
		    "WV", 
		    "WI", 
		    "WY"
	};
	
	/**
	 * Used globally to represent X value
	 */
	public static final int X = 0;
	
	/**
	 * Used globally to represent Y value
	 */
	public static final int Y = 1;
	
	/**
	 * Path of alien image
	 */
	public static final String ALIEN_PATH = "img/alien.png";
	
	/**
	 * Path of map image
	 */
	public static final String MAP_PATH = "img/map.png";
	
	/**
	 * Path of statistics panel save file
	 */
	public static final String SAVE_DATA_PATH = "sav/stats.sav";
	
	// Twitter API Credentials
	/**
	 * Twitter consumer public key
	 */
	public static final String TWITTER_CONSUMER_KEY = "McNmPhDpgqznhvle9WLbY4mhI";
	/**
	 * Twitter consumer private key
	 */
	public static final String TWITTER_CONSUMER_SECRET = "fBbRvDSmTuq5vmZTO7OTmstmP40P2TgeTbmB27lGbgrw8Sjhdb";
	/**
	 * Twitter access public key
	 */
	public static final String TWITTER_ACCESS_TOKEN = "323440607-8INMdd9TAQlqxWJxUlRwH6RLjZ6VAJFQ29tvimrm";
	/**
	 * Twitter access private key
	 */
	public static final String TWITTER_ACCESS_TOKEN_SECRET = "CRyONObtVUz1vUQDLXDBrGspSCpTUtAG0m4YJBNuW4Re6";
}
