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
			{650, 420},			// Arkansas
			{141, 392},			// California
			{374, 299},			// Colorado
			{0, 0},				// Conneticut 1054, 203
			{0, 0},				// Delaware
			{0, 0},				// Florida
			{0, 0},				// Georgia
			{224, 160},			// Idaho
			{726, 265},			// Illinois
			{790, 260},			// Indiana
			{620, 232},			// Iowa
			{525, 325},			// Kansas
			{827, 335},			// Kentucky
			{665, 520},			// Louisiana
			{1104, 93},			// Maine
			{0, 0},				// Maryland
			{0, 0},				// Massechusets 1116, 188
			{799, 195},			// Michigan
			{612, 121},			// Minnesota
			{0, 0},				// Mississippi
			{651, 321},			// Missouri
			{393, 106},			// Montana
			{509, 245},			// Nebraska
			{158, 233},			// Nevada
			{0, 0},				// New Hamshire 1061, 157
			{0, 0},				// New Jersey 1051, 257
			{385, 410},			// New Mexico
			{1000, 172},		// New York
			{0, 0},				// North Carolina
			{492, 92},			// North Dakota
			{877, 254},			// Ohio
			{545, 405},			// Oklahoma
			{97, 126},			// Oregon
			{964, 229},			// Pennsylvania
			{0, 0},				// Rhode Island 1242, 224
			{0, 0},				// South Carolina
			{477, 166},			// South Dakota
			{0, 0},				// Tennessee
			{575, 540},			// Texas
			{255, 263},			// Utah
			{0, 0},				// Vermont 1031, 147
			{954, 310},			// Virginia
			{119, 39},			// Washington
			{905, 308},			// West Virginia
			{696, 160},			// Wisconsin
			{340, 189}			// Wyoming
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
