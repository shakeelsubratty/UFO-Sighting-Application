package ripley.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
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
	
	private StatisticsOutput activePanel;
	private int activePanelIndex;
	private ArrayList<StatisticsOutput> panels;
	private ArrayList<StatisticsOutput> activePanels;
	
	public StatisticsData() {
		activePanelIndex = 0;
		panels = new ArrayList<StatisticsOutput>();
		activePanels = new ArrayList<StatisticsOutput>();
	}
	
	public void initialise() {
		StatisticsParse.initialise();
		panels.add(new StatisticsOutput("Hoaxes", Integer.toString(StatisticsParse.hoaxes)));
		panels.add(new StatisticsOutput("Non US Sightings", Integer.toString(StatisticsParse.nonUSSightings)));
		panels.add(new StatisticsOutput("Likeliest States", StatisticsParse.likeliestState));
		panels.add(new StatisticsOutput("Recent Tweets containing: 'Alien'", Integer.toString(StatisticsParse.sightingsOtherPlatforms)));
		panels.add(new AverageDurationPanel("Average Duration Per State"));

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
	public StatisticsOutput getActivePanel() {
		return activePanel;
	}
	
	public void setActivePanel(int direction) {
		
		System.out.println("Size: "+panels.size());
		System.out.println("Original: "+activePanelIndex);
		activePanels.remove(activePanelIndex);
		
/*		ListIterator<StatisticsOutput> panelList = panels.listIterator();

		if(direction == 0) {
			activePanelIndex = panelList.previousIndex();
		} else {
			activePanelIndex = panelList.nextIndex();
		}
	*/	
		//System.out.println(panels.size());
		// If left
		if(direction == 0) {
			// If at start.
			if(activePanelIndex == 0) {
				activePanelIndex = panels.size()-1;
			} else {
				activePanelIndex--;
			}
		} else {
			// If at end
			if(activePanelIndex == panels.size()-1) {
				activePanelIndex = 0;
			} else {
				activePanelIndex++;
			}
			if(activePanels.get(activePanelIndex) != null) {
				setActivePanel(direction);
			}
		}

		System.out.println("After: "+activePanelIndex);
		//activePanel = panels.get(0);
		
		//setChanged();
		//notifyObservers();
		//activePanels.add(activePanel);
	}
}