package ripley.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Panel to display the statistics of the data within a given time frame.
 * 
 * @author Lewis - K1630576
 * 		   Aaron - K1630486
 *
 */
public class StatisticsWindow extends JPanel
{
	// GUI Components
	private JButton leftButton;
	private JButton rightButton;
	private StatisticsPanel activePanel;
	
	public StatisticsWindow()
	{	
		StatisticsPanel hoaxes = new StatisticsPanel("Hoaxes", "test");
		StatisticsPanel nonUSASightings = new StatisticsPanel("Non US Sightings", "test");
		StatisticsPanel likeliestStates = new StatisticsPanel("Likeliest States", "test");
		StatisticsPanel otherPlatformSightings = new StatisticsPanel("Sightings via Other Platforms", "test");
		activePanel = hoaxes;
		// Initialise GUI components
		initialise();
	}
	
	private void initialise()
	{
		// Set Layout Manager
		this.setLayout(new BorderLayout());
		
		// JButton leftButton
		leftButton = new JButton("<");
		
		// JButton rightButton
		rightButton = new JButton(">");
		
		// Add components to panel
		this.add(leftButton, BorderLayout.WEST);
		this.add(activePanel, BorderLayout.CENTER);
		this.add(rightButton, BorderLayout.EAST);
	}
	
	public void setLeftButtonListener(ActionListener l)
	{
		leftButton.addActionListener(l);
	}
	
	public void setRightButtonListener(ActionListener l)
	{
		rightButton.addActionListener(l);
	}
}
