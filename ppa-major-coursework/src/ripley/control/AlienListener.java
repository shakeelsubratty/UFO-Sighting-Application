package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ripley.model.SoftwareConstants;
import ripley.view.ListOfSightings;

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
		ListOfSightings stateSightings = new ListOfSightings(state);
	}

}
