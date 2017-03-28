package ripley.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ripley.control.StatisticsPanelToggle;
import ripley.model.StatisticsData;
import ripley.model.StatisticsParse;

/**
 * Panel to display the statistics of the data within a given time frame.
 * 
 * @author Lewis - K1630576
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
		
		//activePanel = StatisticsData.getActivePanel();
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
		leftButton.addActionListener(new StatisticsPanelToggle());
	}
	
	public void setRightButtonListener(ActionListener l)
	{
		rightButton.addActionListener(new StatisticsPanelToggle());
	}
}
