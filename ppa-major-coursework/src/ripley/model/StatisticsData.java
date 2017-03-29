package ripley.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import ripley.view.AverageDurationPanel;
import ripley.view.StatisticsOutput;
import ripley.view.StatisticsPanel;
import ripley.view.StatisticsWindow;

/**
 * Model for the statistics window & panel.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsData extends Observable {
	
	private static StatisticsOutput activePanel;
	private static int activePanelIndex;
	private static ArrayList<StatisticsOutput> panels = new ArrayList<StatisticsOutput>();
	
	public StatisticsData() {
		
	}
	
	public void initialise() {
		StatisticsParse.initialise();
		panels.add(new StatisticsOutput("Hoaxes", Integer.toString(StatisticsParse.hoaxes)));
		panels.add(new StatisticsOutput("Non US Sightings", Integer.toString(StatisticsParse.nonUSSightings)));
		panels.add(new StatisticsOutput("Likeliest States", StatisticsParse.likeliestState));
		panels.add(new StatisticsOutput("Recent Tweets containing: 'Alien'", Integer.toString(StatisticsParse.sightingsOtherPlatforms)));
		panels.add(new AverageDurationPanel("Average Duration Per State"));
		
		activePanelIndex = 0;
		activePanel = panels.get(activePanelIndex);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Get the active panel that is displayed within StatisticsWindow.
	 * 
	 * @return activePanel		Return the panel that is in active display to the user
	 */
	public static StatisticsOutput getActivePanel() {
		return activePanel;
	}
	
	public static void setActivePanel(int direction) {
		if(direction == 0) {
			if(activePanelIndex == 0) {
				activePanelIndex = panels.size()-1;
			} else {
				activePanelIndex--;
			}
		} else if(direction == 1) {
			if(activePanelIndex == panels.size()-1) {
				activePanelIndex = 0;
			} else {
				activePanelIndex++;
			}
		}
		activePanel = panels.get(activePanelIndex);
	}
}