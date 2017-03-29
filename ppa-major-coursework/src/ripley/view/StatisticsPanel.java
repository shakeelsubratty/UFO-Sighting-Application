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
	private JButton leftButton;
	private JButton rightButton;
	private StatisticsOutput activePanel;
	private StatisticsPanelToggle statisticsActionListener;
	private StatisticsData statisticsData;
	
	public StatisticsPanel()
	{
		statisticsData = new StatisticsData();
		activePanel = new StatisticsOutput("", "");
		//setPreferredSize(new Dimension(450, 450));
		statisticsActionListener = new StatisticsPanelToggle(statisticsData);
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
	
	public void updateStats() {
		System.out.println("Update Stats");
		if(statisticsData.getActivePanel() == null) {
			statisticsData.initialise();
		}
		statisticsData.setActivePanel(0);
		activePanel = statisticsData.getActivePanel();
	}
	

	@Override
	public void update(Observable o, Object arg) {
		activePanel = statisticsData.getActivePanel();
		
		// validate() and repaint() ?? 
		this.remove(activePanel);
		this.add(activePanel, BorderLayout.CENTER);
		
		this.validate();
		this.repaint();
	}
}
