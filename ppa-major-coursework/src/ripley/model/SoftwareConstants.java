package ripley.model;

import java.awt.Point;
/**
 * A class containing static final fields used as constants throughout the program
 * 
 * @author Aaron - K1630486
 *
 */
public class SoftwareConstants
{
	/* ------------------
	 * STATES LEFT TO ADD
	 * ------------------
	 * 
	 * Oklahoma
	 * Arkansas
	 * Louisiana
	 * Mississipi
	 * Alabama
	 * Georgia
	 * Florida
	 * Tenessee
	 * North Carolina
	 * South Carolina
	 * Delaware
	 * Maryland
	 * Washington D.C.
	 * 
	 */
	
	// TO MAKE COORDS DYNAMIC: 	X -> (X/1280) * map.getWidth()
	// 							Y -> (Y/720) * map.getHeight()
	
	public static final int[][] COORDINATES = {
			{0, 0},				// Alabama
			{265, 395},			// Arizona
			{0, 0},				// Arkansas
			{151, 402},			// California
			{454, 339},			// Colorado
			{1054, 203},		// Conneticut
			{0, 0},				// Delaware
			{0, 0},				// Florida
			{0, 0},				// Georgia
			{224, 170},			// Idaho
			{753, 325},			// Illinois
			{800, 310},			// Indiana
			{670, 272},			// Iowa
			{595, 360},			// Kansas
			{847, 345},			// Kentucky
			{0, 0},				// Louisiana
			{1104, 63},			// Maine
			{0, 0},				// Maryland
			{1116, 188},		// Massechusets
			{834, 225},			// Michigan
			{622, 181},			// Minnesota
			{0, 0},				// Mississippi
			{691, 371},			// Missouri
			{393, 146},			// Montana
			{579, 280},			// Nebraska
			{178, 333},			// Nevada
			{1061, 157},		// New Hamshire
			{1051, 257},		// New Jersey
			{385, 410},			// New Mexico
			{980, 192},			// New York
			{0, 0},				// North Carolina
			{562, 137},			// North Dakota
			{877, 274},			// Ohio
			{0, 0},				// Oklahoma
			{147, 196},			// Oregon
			{994, 249},			// Pennsylvania
			{1242, 224},		// Rhode Island
			{0, 0},				// South Carolina
			{567, 206},			// South Dakota
			{0, 0},				// Tennessee
			{575, 540},			// Texas
			{300, 323},			// Utah
			{1031, 147},		// Vermont
			{979, 330},			// Virginia
			{159, 59},			// Washington
			{925, 328},			// West Virginia
			{721, 205},			// Wisconsin
			{400, 249}			// Wyoming
	};
	
	public static final String[] STATES = {
			"Alabama", 
		    //"Alaska", 
		    //"American Samoa", 
		    "Arizona", 
		    "Arkansas", 
		    "California", 
		    "Colorado", 
		    "Connecticut", 
		    "Delaware", 
		    "Dist. of Columbia", 
		    "Florida", 
		    "Georgia", 
		    //"Guam", 
		    //"Hawaii", 
		    "Idaho", 
		    "Illinois", 
		    "Indiana", 
		    "Iowa", 
		    "Kansas", 
		    "Kentucky", 
		    "Louisiana", 
		    "Maine", 
		    "Maryland", 
		    //"Marshall Islands", 
		    "Massachusetts", 
		    "Michigan", 
		    //"Micronesia", 
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
		    //"Northern Marianas", 
		    "Ohio", 
		    "Oklahoma", 
		    "Oregon", 
		    //"Palau", 
		    "Pennsylvania", 
		    //"Puerto Rico", 
		    "Rhode Island", 
		    "South Carolina", 
		    "South Dakota", 
		    "Tennessee", 
		    "Texas", 
		    "Utah", 
		    "Vermont", 
		    "Virginia", 
		    //"Virgin Islands", 
		    "Washington", 
		    "West Virginia", 
		    "Wisconsin", 
		    "Wyoming"
	};
	
	public static final String[] STATE_ABBREVIATIONS = {
			"AL", 
		    //"AK", 
		    //"AS", 
		    "AZ", 
		    "AR", 
		    "CA", 
		    "CO", 
		    "CT", 
		    "DE", 
		    "DC", 
		    "FL", 
		    "GA", 
		    //"GU", 
		    //"HI", 
		    "ID", 
		    "IL", 
		    "IN", 
		    "IA", 
		    "KS", 
		    "KY", 
		    "LA", 
		    "ME", 
		    "MD", 
		    //"MH", 
		    "MA", 
		    "MI", 
		    //"FM", 
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
		    //"MP", 
		    "OH", 
		    "OK", 
		    "OR", 
		    //"PW", 
		    "PA", 
		    //"PR", 
		    "RI", 
		    "SC", 
		    "SD", 
		    "TN", 
		    "TX", 
		    "UT", 
		    "VT", 
		    "VA", 
		    //"VI", 
		    "WA", 
		    "WV", 
		    "WI", 
		    "WY"
	};
	
	public static final int X = 0;
	public static final int Y = 1;
	
	public static final String ALIEN_PATH = "img/alien.png";
	public static final String MAP_PATH = "img/map.png";
}
