package ripley.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	// GUI Components
	private JButton leftButton;
	private JButton rightButton;
	private StatisticsOutput activePanel;
	private StatisticsPanelToggle statisticsActionListener;
	private StatisticsData statisticsData;
	
	public StatisticsPanel(StatisticsData statisticsData)
	{
		this.statisticsData = statisticsData;
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
	
	public void updateStats(ArrayList<Integer> activePanelIndexes) {
		if(statisticsData.getActivePanel() == null) {
			statisticsData.initialise();
		}
		activePanel = statisticsData.getActivePanel();
	}
	
	public int getActivePanelIndex() {
		return statisticsData.getActivePanelIndex();
	}
	

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Panel Update");
		
		this.remove(activePanel);
		
		activePanel = statisticsData.getActivePanel();
		StatisticsWindow.update();
		
		this.revalidate();
		this.repaint();
		
		// validate() and repaint() ?? 
		this.add(activePanel, BorderLayout.CENTER);
	}
}
