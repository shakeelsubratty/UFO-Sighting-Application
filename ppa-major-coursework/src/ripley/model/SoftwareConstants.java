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
			{265, 395},			// Arizona
			{151, 402},			// California
			{454, 339},			// Colorado
			{1054, 203},		// Conneticut
			{224, 170},			// Idaho
			{753, 325},			// Illinois
			{800, 310},			// Indiana
			{670, 272},			// Iowa
			{595, 360},			// Kansas
			{847, 345},			// Kentucky
			{877, 274},			// Ohio
			{147, 196},			// Oregon
			{1104, 63},			// Maine
			{1116, 188},		// Massechusets
			{834, 225},			// Michigan
			{622, 181},			// Minnesota
			{691, 371},			// Missouri
			{393, 146},			// Montana
			{579, 280},			// Nebraska
			{178, 333},			// Nevada
			{1061, 157},		// New Hamshire
			{1051, 257},		// New Jersey
			{385, 410},			// New Mexico
			{980, 192},			// New York
			{562, 137},			// North Dakota
			{994, 249},			// Pennsylvania
			{1242, 224},		// Rhode Island
			{567, 206},			// South Dakota
			{575, 540},			// Texas
			{300, 323},			// Utah
			{1031, 147},		// Vermont
			{979, 330},			// Virginia
			{159, 59},			// Washington
			{925, 328},			// West Virginia
			{721, 205},			// Wisconsis
			{400, 249}			// Wyoming
	};
	
	public static final String[] STATES = {
			"Arizona",
			"California",
			"Colorado",
			"Conneticut",
			"Idaho",
			"Illinois",
			"Indiana",
			"Iowa",
			"Kansas",
			"Kentucky",
			"Ohio",
			"Oregon",
			"Maine",
			"Massechusets",
			"Michigan",
			"Minnesota",
			"Missouri",
			"Montana",
			"Nebraska",
			"Nevada",
			"New Hamshire",
			"New Jersey",
			"New Mexico",
			"New York",
			"North Dakota",
			"Pennsylvania",
			"Rhode Island",
			"South Dakota",
			"Texas",
			"Utah",
			"Vermont",
			"Virginia",
			"Washington",
			"West Virginia",
			"Wisconsis",
			"Wyoming"
	};
	
	public static final int X = 0;
	public static final int Y = 1;
}
