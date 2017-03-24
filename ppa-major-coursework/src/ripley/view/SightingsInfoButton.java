package ripley.view;

import javax.swing.JButton;

import ripley.control.AlienListener;

/**
 * Type of JButton that returns information about sightings in a given state when clicked.
 * 
 * @author Aaron - K1630486
 *
 */
public class SightingsInfoButton extends JButton
{
	// Object states
	private int state;
	
	/**
	 * Constructor for SightingsInfoButton
	 * 
	 * @param state the number that corresponds to the state as defined in model.SoftwareConstants
	 */
	public SightingsInfoButton(int state)
	{
		super();
		this.state = state;
		
		//Make button invisible
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		
		//Add ActionListener to button
		this.addActionListener(new AlienListener(state));
	}
}
