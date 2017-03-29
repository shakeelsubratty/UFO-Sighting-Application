package ripley.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import ripley.control.StatisticsPanelToggle;
import ripley.model.StatisticsData;

/**
 * Panel to display the statistics of the data within a given time frame.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsPanel extends JPanel implements Observer
{
	// GUI Components
	private static JButton leftButton;
	private static JButton rightButton;
	private static StatisticsOutput activePanel;
	private static StatisticsPanelToggle statisticsActionListener;
	private static StatisticsData statisticsData;
	
	public StatisticsPanel()
	{
		//setPreferredSize(new Dimension(450, 450));
		activePanel = new StatisticsOutput("", "");
		statisticsActionListener = new StatisticsPanelToggle();
		statisticsActionListener.addObserver(this);
		
		// Initialise GUI components
		initialise();
	}
	
	private void initialise()
	{
		// Set Layout Manager
		this.setLayout(new BorderLayout());
		
		// JButton leftButton
		leftButton = new JButton("<");
		leftButton.addActionListener(statisticsActionListener);
		
		
		// JButton rightButton
		rightButton = new JButton(">");
		rightButton.addActionListener(statisticsActionListener);
		
		// Add components to panel
		this.add(leftButton, BorderLayout.WEST);
		this.add(activePanel, BorderLayout.CENTER);
		this.add(rightButton, BorderLayout.EAST);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		activePanel = StatisticsData.getActivePanel();
		
		// validate() and repaint() ?? 
		this.remove(activePanel);
		this.add(activePanel, BorderLayout.CENTER);
		
		this.validate();
		this.repaint();
	}
}
