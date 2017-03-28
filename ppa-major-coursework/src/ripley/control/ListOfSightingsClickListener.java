package ripley.control;

import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import ripley.model.Fetch;

public class ListOfSightingsClickListener extends DoubleClickListener 
{
	private String idRegex = "ID: ([\\da-zA-Z]+)";
	private Pattern idPattern = Pattern.compile(idRegex);
	
	private String incidentDetails;
	
	public ListOfSightingsClickListener(DefaultComboBoxModel<String> model) 
	{
		super(model);
	}
	
	@Override
	public void clickEvent(MouseEvent e)
	{
		int index = ((JList<String>)e.getComponent()).getSelectedIndex(); //Select the index of the item that was selected
		Matcher matcher = idPattern.matcher(((JList<String>)e.getComponent()).getSelectedValue());
		if(matcher.find())
		{			
			incidentDetails = Fetch.getIncidentDetails(matcher.group(1));
			
			JLabel textLabel = new JLabel("<html>"+ formatIncidentDetails(incidentDetails) + "</html>");
			JOptionPane.showMessageDialog(e.getComponent(),textLabel);
			System.out.println(incidentDetails);
		}
	}
	
	private String formatIncidentDetails(String incidentDetails) 
	{
		String returnedIncidentDetails = "";
		String newLine = "<br>";
		String[] detailsArr = incidentDetails.split(" ");
		for(int i = 0; i < detailsArr.length; i++)
		{
				if(Math.floorMod(i, 30) == 1 && i != 1)
				{
					detailsArr[i] += newLine;
				}
			
			returnedIncidentDetails += " " + detailsArr[i] + " ";
		}
		return returnedIncidentDetails;
	}

}
