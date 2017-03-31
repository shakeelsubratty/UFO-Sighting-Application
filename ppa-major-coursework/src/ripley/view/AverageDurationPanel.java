package ripley.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import ripley.model.SoftwareConstants;

/**
 * Class which creates the panel for the additional statistic:
 * Average Duration of Sighting per state.
 * 
 * @author Alex Franch Tapia - K1631466
 *
 */
public class AverageDurationPanel extends StatisticsOutput {

	// Drop down menu with all states.
	private JComboBox<String> jcbStates;

	public AverageDurationPanel(String title) {
		
		super(title,"0");
		jcbStates = new JComboBox<String>(SoftwareConstants.STATES);
		addDropDown();
		//averageDurationModel = new AverageDurationModel();
		//averageDurationModel.addObserver(this);
	}
	
	/**
	 * Method which adds the drop down menu to the panel and sets it to null. 
	 */
	private void addDropDown() {
		
		super.add(jcbStates,BorderLayout.SOUTH);
		jcbStates.setSelectedItem(null);	
		
	}
		
	/**
	 * Method which returns the selected state.
	 * @return selected state
	 */
	public String getDropDownState() {
		return jcbStates.getSelectedItem().toString();
	}
	
	/**
	 * Method to add action listener to the drop down menu to select a state.
	 * @param l
	 */
	public void addListener(ActionListener l) {
		
		jcbStates.addActionListener(l);
	}


}

