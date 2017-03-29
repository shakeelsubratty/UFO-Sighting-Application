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

public class ListOfSightings extends JFrame 
{
	private int state;
	private JList<String> incidentList;
		
	public ListOfSightings(int state, DefaultComboBoxModel<String> listModel, DefaultComboBoxModel<String> sortModel)
	{
		super(SoftwareConstants.STATES[state]);
		this.state = state;
		setPreferredSize(new Dimension(800, 400));
		
		initialise(listModel,sortModel);
	}
	
	public void initialise(DefaultComboBoxModel<String> listModel, DefaultComboBoxModel<String> sortModel)
	{
		setLayout(new BorderLayout());
		
		incidentList = new JList<>(listModel);
		incidentList.addMouseListener(new ListOfSightingsClickListener(listModel));
		JScrollPane jspList = new JScrollPane(incidentList);
		
		JComboBox<String> sortComboBox = new JComboBox<>(sortModel);
		sortComboBox.addActionListener(new SortSightingsClickListener(listModel));
		
		add(sortComboBox,BorderLayout.NORTH);
		add(jspList,BorderLayout.CENTER);	
		pack();
		setVisible(true);
	}

}
