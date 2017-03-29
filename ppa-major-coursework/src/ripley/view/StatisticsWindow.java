package ripley.view;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import ripley.model.StatisticsData;

/**
 * Panel to display the statistics of the data within a given time frame.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsWindow extends JPanel
{
	private StatisticsData statisticsData;
	private static int panelNumber = 4;
	private static ArrayList<StatisticsPanel> panels = new ArrayList<StatisticsPanel>();
	
	public StatisticsWindow(StatisticsData statisticsData)
	{	
		setLayout(new GridLayout(2,2));
		setPreferredSize(new Dimension(650, 650));
		this.statisticsData = statisticsData;
		initialise();
	}
	
	private void initialise()
	{
		for(int i=0; i<panelNumber; i++) {
			StatisticsPanel statisticsPanel = new StatisticsPanel(statisticsData);
			panels.add(statisticsPanel);
			statisticsData.addObserver(statisticsPanel);
			add(statisticsPanel);
		}
	}
	
	public static void update() {
		for(StatisticsPanel panel : panels) {
			panel.updateStats();
		}
	}
}
