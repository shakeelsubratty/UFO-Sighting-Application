package ripley.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.mysql.jdbc.StreamingNotifiable;

import api.ripley.Incident;
import api.ripley.Ripley;
import ripley.control.DoubleClickListener;
import ripley.control.ListOfSightingsClickListener;
import ripley.control.SortSightingsClickListener;

public class ListOfSightings extends JFrame 
{
	private JList<String> incidentList;
	private DefaultComboBoxModel<String> listModel;
	private DefaultComboBoxModel<String> sortModel;
	
	private Pattern pattern;
	
	public ListOfSightings(String state)
	{
		super(state);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 400));
		
//		String dateOfIncidentPattern = "\\d\\d\\d\\d-\\d\\d-\\d\\d";
//		String timeOfIncidentPattern = "\\d\\d:\\d\\d:\\d\\d";
//		String locationPattern = "([a-zA-Z()]+)\\s\\p{upper}\\p{upper}";
//		//String shapeOfIncidentPattern = "";
//		String durationPattern;
//		String datePostedPattern;
		
		//pattern = Pattern.compile(dateOfIncidentPattern);
		
		initialise();
	}
	
	public void initialise()
	{
		setLayout(new BorderLayout());
		
		ArrayList<Incident> incidents = new Ripley("10tLI3GWut+yVD6ql2OMtA==", "tBgm4pVo/g/VqL46EnH7ew==").getIncidentsInRange("2014-08-09 20:33:33", "2014-08-10 20:33:33");
		ArrayList<String> incidentStrings = parseIncidents(incidents);
		
		String[] arr = new String[incidentStrings.size()];
		listModel = new DefaultComboBoxModel<>(incidentStrings.toArray(arr));

		incidentList = new JList<>(listModel);
		incidentList.addMouseListener(new ListOfSightingsClickListener(listModel));
		JScrollPane jspList = new JScrollPane(incidentList);
		
		sortModel = new DefaultComboBoxModel<>();
		sortModel.addElement("--");
		sortModel.addElement("Date");
		sortModel.addElement("City");
		sortModel.addElement("Shape");
		sortModel.addElement("Duration");
		sortModel.addElement("Posted");

		JComboBox<String> sortComboBox = new JComboBox<>(sortModel);
		sortComboBox.addActionListener(new SortSightingsClickListener(sortModel));
		
		add(sortComboBox,BorderLayout.NORTH);
		add(jspList,BorderLayout.CENTER);	
		pack();
		setVisible(true);
	}
	
	private ArrayList<String> parseIncidents(ArrayList<Incident> incArr)
	{
		ArrayList<String> newIncidentsArray = new ArrayList<>();
		for (Incident incident : incArr) 
		{
			newIncidentsArray.add("Time: " + incident.getDateAndTime() + " | City: " + incident.getCity() +
					" | Shape: " + incident.getShape() + " | Duration: " + incident.getDuration()
					+ " | Posted: " + incident.getPosted());
		}
		
		return newIncidentsArray;
	}

}
