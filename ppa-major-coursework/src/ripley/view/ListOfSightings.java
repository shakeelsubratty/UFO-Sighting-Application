package ripley.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import api.ripley.Incident;
import ripley.control.ListOfSightingsClickListener;
import ripley.control.SortSightingsClickListener;
import ripley.model.Fetch;
import ripley.model.SoftwareConstants;

public class ListOfSightings extends JFrame 
{
	//TODO: ensure this follows MVC (move the models?)
	private int state;
	private JList<String> incidentList;
	private DefaultComboBoxModel<String> listModel; //Model for the displayed list
	private DefaultComboBoxModel<String> sortModel;	//Model for the drop down filter
		
	public ListOfSightings(int state)
	{
		super(SoftwareConstants.STATES[state]);
		this.state = state;
		setPreferredSize(new Dimension(800, 400));
		
		initialise();
	}
	
	public void initialise()
	{
		setLayout(new BorderLayout());
		
		//Get some data, should be changed to fit with model classes
		ArrayList<Incident> incidents = Fetch.getIncidentsInState(state);
		ArrayList<String> incidentStrings = parseIncidents(incidents);
		
		String[] arr = new String[incidentStrings.size()];
		listModel = new DefaultComboBoxModel<>(incidentStrings.toArray(arr));	//Add data to list model

		incidentList = new JList<>(listModel);
		incidentList.addMouseListener(new ListOfSightingsClickListener(listModel));
		JScrollPane jspList = new JScrollPane(incidentList);
		
		sortModel = new DefaultComboBoxModel<>();
		sortModel.addElement("--");
		sortModel.addElement("Date");
		sortModel.addElement("City");
		sortModel.addElement("Shape");
		sortModel.addElement("Duration");
		sortModel.addElement("Posted");			//Add elements to drop down sort filter

		JComboBox<String> sortComboBox = new JComboBox<>(sortModel);
		sortComboBox.addActionListener(new SortSightingsClickListener(listModel));
		
		add(sortComboBox,BorderLayout.NORTH);
		add(jspList,BorderLayout.CENTER);	
		pack();
		setVisible(true);
	}
	
	/**
	 * Parse incidents to extract info and present in a concise way
	 * @param incArr
	 * @return
	 */
	private ArrayList<String> parseIncidents(ArrayList<Incident> incArr)
	{
		ArrayList<String> newIncidentsArray = new ArrayList<>();
		for (Incident incident : incArr) 
		{
			newIncidentsArray.add("ID: " + incident.getIncidentID() + " | Time: " + incident.getDateAndTime() + " | City: " + incident.getCity() +
					" | Shape: " + incident.getShape() + " | Duration: " + incident.getDuration()
					+ " | Posted: " + incident.getPosted());
		}
		
		return newIncidentsArray;
	}

}
