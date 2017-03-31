package ripley.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import ripley.control.ListOfSightingsClickListener;
import ripley.control.SortSightingsClickListener;
import ripley.model.SoftwareConstants;

/**
 * List of Sightings window.
 * @author Shakeel Subratty - K1631133
 */
public class ListOfSightings extends JFrame 
{
	private JList<String> incidentList;
	
	/**
	 * Creates list of sightings window for a given state.
	 * @param state
	 * @param listModel
	 * @param sortModel
	 */
	public ListOfSightings(int state, DefaultComboBoxModel<String> listModel, DefaultComboBoxModel<String> sortModel)
	{
		super(SoftwareConstants.STATES[state]);
		setPreferredSize(new Dimension(800, 400));
		
		initialise(listModel,sortModel);
	}
	
	/**
	 * Intialise JLists for list of sightings window.
	 * @param listModel
	 * @param sortModel
	 */
	public void initialise(DefaultComboBoxModel<String> listModel, DefaultComboBoxModel<String> sortModel)
	{
		setLayout(new BorderLayout());
		
		incidentList = new JList<>(listModel);
		incidentList.addMouseListener(new ListOfSightingsClickListener());
		JScrollPane jspList = new JScrollPane(incidentList);
		
		JComboBox<String> sortComboBox = new JComboBox<>(sortModel);
		sortComboBox.addActionListener(new SortSightingsClickListener(listModel));
		
		add(sortComboBox,BorderLayout.NORTH);
		add(jspList,BorderLayout.CENTER);	
		pack();
		setVisible(true);
	}

}
