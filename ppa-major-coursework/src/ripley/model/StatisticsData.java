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
	private static ArrayList<StatisticsOutput> activePanels = new ArrayList<StatisticsOutput>();
	
	public StatisticsData() {
		
	}
	
	public void initialise() {
		StatisticsParse.initialise();
		panels.add(new StatisticsOutput("Hoaxes", Integer.toString(StatisticsParse.hoaxes)));
		panels.add(new StatisticsOutput("Non US Sightings", Integer.toString(StatisticsParse.nonUSSightings)));
		panels.add(new StatisticsOutput("Likeliest States", StatisticsParse.likeliestState));
		panels.add(new StatisticsOutput("Recent Tweets containing: 'Alien'", Integer.toString(StatisticsParse.sightingsOtherPlatforms)));
		panels.add(new AverageDurationPanel("Average Duration Per State"));
		
		System.out.println(StatisticsParse.sightingsOtherPlatforms);
		activePanelIndex = 0;
		activePanel = panels.get(activePanelIndex);
		activePanels.add(activePanel);
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
		//activePanels.remove(activePanelIndex);
		if(direction == 0) {
			if(activePanelIndex == 0) {
				activePanelIndex = panels.size()-1;
			} else {
				activePanelIndex--;
			}
			
			for(int i=0; i<panels.size(); i++) {
				if(panels.get(activePanelIndex) != null) {
					activePanelIndex--;
				}
			}
		} else if(direction == 1) {
			if(activePanelIndex == panels.size()-1) {
				activePanelIndex = 0;
			} else {
				activePanelIndex++;
			}
			
			for(int i=0; i<panels.size(); i++) {
				if(panels.get(activePanelIndex) != null) {
					activePanelIndex++;
				}
			}
		}

		activePanel = panels.get(activePanelIndex);
		activePanels.add(activePanel);
	}
}