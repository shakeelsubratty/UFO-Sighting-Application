package ripley.control;

import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import ripley.model.Fetch;

/**
 * Reacts to double click on list of sightings - opens window displaying appropriate, formatted information.
 * @author Shakeel Subratty - K1631133
 *
 */
public class ListOfSightingsClickListener extends DoubleClickListener 
{
	private String idRegex = "ID: ([\\da-zA-Z]+)";	//ID regex to determine what incident has been clicked
	private Pattern idPattern = Pattern.compile(idRegex);
	
	private String incidentDetails;
	
	/**
	 * Constructor that creates DoubleClickListener
	 */
	public ListOfSightingsClickListener() 
	{
		super();
	}
	
	/**
	 * Defines pop-up action displaying selected incident details on double click
	 */
	@Override
	public void clickEvent(MouseEvent e)
	{
		int index = ((JList<String>)e.getComponent()).getSelectedIndex(); //Select the index of the item that was selected
		Matcher matcher = idPattern.matcher(((JList<String>)e.getComponent()).getSelectedValue());
		if(matcher.find())
		{	System.out.println(matcher.group());
			//If selected item contains string ID, get the details for the incident with that ID
			incidentDetails = Fetch.getIncidentDetails(matcher.group(1).trim());
			
			//Show option pane with formatted incident details
			JLabel textLabel = new JLabel("<html>"+ formatIncidentDetails(incidentDetails) + "</html>");
			JOptionPane.showMessageDialog(e.getComponent(),textLabel);
		}
	}
	
	/**
	 * Takes a string and formats it by adding newlines after every 30 words.
	 * @param incidentDetails
	 * @return Formatted incident details string
	 */
	private String formatIncidentDetails(String incidentDetails) 
	{
		String returnedIncidentDetails = "";
		String newLine = "<br>";	// String to be appended
		//Iterate over every word in string
		String[] detailsArr = incidentDetails.split(" ");
		for(int i = 0; i < detailsArr.length; i++)
		{
			//After every 30th word
			if(Math.floorMod(i, 30) == 1 && i != 1)
			{
				detailsArr[i] += newLine; //Add a new line
			}
			//Add word to returned string variable
			returnedIncidentDetails += " " + detailsArr[i] + " ";
		}
		return returnedIncidentDetails;
	}

}
