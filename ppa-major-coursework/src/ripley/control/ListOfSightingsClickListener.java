package ripley.control;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import api.ripley.Incident;
import ripley.model.Fetch;

public class ListOfSightingsClickListener extends DoubleClickListener 
{
	private String idRegex = "ID: ([\\da-zA-Z]+)";
	private Pattern idPattern = Pattern.compile(idRegex);
	
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
			//TODO: Make sure pop up is at the right size.
			JLabel textLabel = new JLabel("<html>"+Fetch.getIncidentDetails(matcher.group(1)) + "</html>");
			JOptionPane.showMessageDialog(e.getComponent(),textLabel);
			System.out.println(matcher.group());
		}
	}

}
