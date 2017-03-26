package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ripley.model.SoftwareConstants;

/**
 * ActionListener that displays an OptionPane when clicked with information about the sightings in a given state.
 * 
 * @author Aaron - K1630486
 *
 */
public class AlienListener implements ActionListener
{
	// Object states
	private int state;
	
	/**
	 * Constructor for AlienListener
	 * 
	 * @param state the number that corresponds to the state as defined in model.SoftwareConstants
	 */
	public AlienListener(int state)
	{
		super();
		this.state = state;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Show OptionPane
		// TODO: Get information from Ripley API
		JOptionPane.showMessageDialog(null, "This is a temporary MessageDialog.\n"
				+ "It will display the information about sightings in the state of " + SoftwareConstants.STATES[state] +".");
	}

}
