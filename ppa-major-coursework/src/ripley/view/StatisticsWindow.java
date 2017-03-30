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
	private static ArrayList<Integer> activePanelIndexes = new ArrayList<Integer>();
	
	public StatisticsWindow()
	{	
		setLayout(new GridLayout(2,2));
		setPreferredSize(new Dimension(950, 600));
		initialise();
	}
	
	private void initialise()
	{
		for(int i=0; i<panelNumber; i++) {
			statisticsData = new StatisticsData();
			StatisticsPanel statisticsPanel = new StatisticsPanel(statisticsData);
			panels.add(statisticsPanel);
			statisticsData.addObserver(statisticsPanel);
			add(statisticsPanel);
		}
	}
	
	public static Boolean checkActiveIndexes(int index) {
		if(activePanelIndexes.get(index) != null) {
			return true;
		}
		return false;
	}
	
	public static void update() {
		System.out.println("Update Window");
		activePanelIndexes.clear();
		for(StatisticsPanel panel : panels) {
			activePanelIndexes.add(panel.getActivePanelIndex());
			System.out.println(activePanelIndexes.toString());
			panel.updateStats(activePanelIndexes);
		}
	}
}
