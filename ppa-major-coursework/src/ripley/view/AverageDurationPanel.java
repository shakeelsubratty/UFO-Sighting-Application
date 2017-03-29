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
public class AverageDurationPanel extends StatisticsPanel {

	// Drop down menu with all states.
	private JComboBox<String> jcbStates;

	public AverageDurationPanel() {
		
		super("Average Duration Per State","0");
		jcbStates = new JComboBox<String>(SoftwareConstants.STATES);
		addDropDown();
		
	}
	
	/**
	 * Method which adds the drop down menu to the panel and sets it to null. 
	 */
	private void addDropDown() {
		
		super.add(jcbStates,BorderLayout.SOUTH);
		jcbStates.setSelectedItem(null);	
	}
		
	/**
	 * Method which adds an action listener to our drop down. 
	 * @param l		action listener
	 */
	public void addListener(ActionListener l) {
		
		jcbStates.addActionListener(l);
	}
		
	/**
	 * Method which returns the selected state.
	 * @return selected state
	 */
	public String getDropDownState() {
		
		return (String)jcbStates.getSelectedItem();
	}


}

