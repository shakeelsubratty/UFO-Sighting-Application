package ripley.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;

import ripley.control.AverageDurationListener;
import ripley.model.AverageDurationModel;
import ripley.model.SoftwareConstants;

/**
 * Class which creates the panel for the additional statistic:
 * Average Duration of Sighting per state.
 * 
 * @author Alex Franch Tapia - K1631466
 *
 */
public class AverageDurationPanel extends StatisticsOutput implements Observer {

	// Drop down menu with all states.
	private JComboBox<String> jcbStates;
	private AverageDurationModel averageDurationModel;

	public AverageDurationPanel(String title) {
		
		super(title,"0");
		jcbStates = new JComboBox<String>(SoftwareConstants.STATES);
		addDropDown();
		averageDurationModel = new AverageDurationModel();
		averageDurationModel.addObserver(this);
	}
	
	/**
	 * Method which adds the drop down menu to the panel and sets it to null. 
	 */
	private void addDropDown() {
		
		super.add(jcbStates,BorderLayout.SOUTH);
		jcbStates.setSelectedItem(null);	
		jcbStates.addActionListener(new AverageDurationListener(this, averageDurationModel));
	}
		
	/**
	 * Method which returns the selected state.
	 * @return selected state
	 */
	public String getDropDownState() {
		return jcbStates.getSelectedItem().toString();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}

