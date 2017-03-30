package ripley.model;

import java.util.ArrayList;
import java.util.Observable;

import ripley.view.AverageDurationPanel;
import ripley.view.StatisticsOutput;
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
	
	/**
	 * Setup the statistics model storage for the panels and activePanel.
	 */
	public StatisticsData() {
		activePanelIndex = 0;
		panels = new ArrayList<StatisticsOutput>();
	}
	
	/**
	 * Initialise the panels, placing the statistics in their required panel.
	 */
	public void initialise() {
		
		// Call parsing of data, to retrieve from various sources
		StatisticsParse.initialise();
		
		panels.add(new StatisticsOutput("Hoaxes", Integer.toString(StatisticsParse.hoaxes)));
		panels.add(new StatisticsOutput("Non US Sightings", Integer.toString(StatisticsParse.nonUSSightings)));
		panels.add(new StatisticsOutput("Likeliest States", StatisticsParse.likeliestState));
		panels.add(new StatisticsOutput("TimeStamp of Last Tweet Containing: 'Alien'", StatisticsParse.sightingsOtherPlatforms));
		panels.add(new AverageDurationPanel("Average Duration Per State"));
		panels.add(new StatisticsOutput("Most Common Month", MostCommonMonth.getMostPopularMonth()));
		panels.add((new StatisticsOutput("Most Common Type of Sighting", MostCommonTypeOfSighting.getMostCommonTypeOfSighting())));
		panels.add(new StatisticsOutput("Incident's containing 'Flying Object'", Integer.toString(IncidentWordFrequency.getWord("flying object"))));
		
		// Notify view of change
		setActivePanel(0);
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
	
	/**
	 * Get the index of the current active panel.
	 * 
	 * @return activePanelIndex		The index of the current active panel
	 */
	public int getActivePanelIndex() {
		return activePanelIndex;
	}
	
	/**
	 * Set the active panel, moving in a required direction for left/right buttons
	 * 
	 * @param direction		The direction to move the view in
	 */
	public void setActivePanel(int direction) {

		// If direction is to the left (left button)
		if(direction == 0) {
			
			// If the current view is at the start of the array
			if(activePanelIndex == 0) {
				
				// Move to the end of the array (loop)
				activePanelIndex = panels.size()-1;
			} else {
				
				// Move to the panel on the left
				activePanelIndex--;
			}
			
		// Otherwise, direction is to the right (right button)
		} else {
			
			// If the current view is at the end of the array
			if(activePanelIndex == panels.size()-1) {
				
				// Move to the start of the array (loop)
				activePanelIndex = 0;
			} else {
				
				// Move to the panel on the right
				activePanelIndex++;
			}
		}
		/*
		 * 			
			if(activePanels.get(activePanelIndex) != null) {
				setActivePanel(direction);
			}
		 */
		
		// Set the new active panel
		activePanel = panels.get(activePanelIndex);
		
		if(StatisticsWindow.checkActiveIndexes(activePanelIndex) == true) {
			setActivePanel(direction);
		}
		
		// Call the view to update
		setChanged();
		notifyObservers();
	}
}