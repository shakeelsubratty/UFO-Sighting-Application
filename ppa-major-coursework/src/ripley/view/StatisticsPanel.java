package ripley.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
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
	private JButton leftButton;
	private JButton rightButton;
	private StatisticsOutput activePanel;
	private StatisticsPanelToggle statisticsActionListener;
	private StatisticsData statisticsData;
	
	/**
	 * Sets up the statistics panel, activating listeners and displayed panel.
	 * 
	 * @param statisticsData		The model for the statistics panel
	 */
	public StatisticsPanel(StatisticsData statisticsData)
	{
		this.statisticsData = statisticsData;
		activePanel = new StatisticsOutput("", "");
		statisticsActionListener = new StatisticsPanelToggle(statisticsData);
		statisticsActionListener.addObserver(this);
		
		// Initialise GUI components
		initialise();
	}
	
	/**
	 * Initialise the panel, adding required view components and listeners.
	 */
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
	
	/**
	 * Update the active panel within this panel, fetching from Model.	
	 */
	public void updateStats(ArrayList<Integer> activePanelIndexes) {
		
		// If statistics data not yet initialised
		if(statisticsData.getActivePanel() == null) {
			statisticsData.initialise();
		}
		activePanel = statisticsData.getActivePanel();
	}
	
	/**
	 * Get the index of the active statistics within this panel.
	 * 
	 * @return	activePanelIndex		The index of the active panel
	 */
	public int getActivePanelIndex() {
		return statisticsData.getActivePanelIndex();
	}
	

	@Override
	/**
	 * View updater, when called updates the display with new changes.
	 */
	public void update(Observable o, Object arg) {
		this.remove(activePanel);
		activePanel = statisticsData.getActivePanel();
		StatisticsWindow.update();
		this.revalidate(); this.repaint();
		this.add(activePanel, BorderLayout.CENTER);
	}
}
