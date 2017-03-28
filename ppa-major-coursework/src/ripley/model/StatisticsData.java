package ripley.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import ripley.view.StatisticsPanel;
import ripley.view.StatisticsWindow;

/**
 * Model for the statistics window & panel.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsData extends Observable {
	
	private static StatisticsPanel activePanel;
	private static int activePanelIndex;
	private static ArrayList<StatisticsPanel> panels = new ArrayList<StatisticsPanel>();
	
	public StatisticsData() {
		
	}
	
	public void initialise() {
		StatisticsParse.initialise();
		panels.add(new StatisticsPanel("Hoaxes", Integer.toString(StatisticsParse.hoaxes)));
		panels.add(new StatisticsPanel("Non US Sightings", Integer.toString(StatisticsParse.nonUSSightings)));
		panels.add(new StatisticsPanel("Likeliest States", StatisticsParse.likeliestState));
		panels.add(new StatisticsPanel("Sightings via Other Platforms", Integer.toString(StatisticsParse.nonUSSightings)));
		
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
	public static StatisticsPanel getActivePanel() {
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