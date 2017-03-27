package ripley.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ripley.view.StatisticsPanel;

/**
 * Model for the statistics window & panel.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsData {
	
	static StatisticsPanel activePanel;
	static Map<String, String> panels;
	
	public void initialise() {
		panels = new HashMap<String, String>();
		panels.put("Hoaxes", Integer.toString(StatisticsParse.hoaxes));
		panels.put("Non US Sightings", Integer.toString(StatisticsParse.nonUSSightings));
		panels.put("Likeliest States", StatisticsParse.likeliestState);
		panels.put("Sightings via Other Platforms", Integer.toString(StatisticsParse.sightingsOtherPlatforms));
	}
	
	/**
	 * Returns the panels stored in the panels HashMap.
	 * 
	 * @return panels		StatisticsPanel's inside of panels HashMap
	 */
	public static Map<String, String> getPanels() {
		return panels;
	}
	
	/**
	 * Get the set of keys within the panels HashMap.
	 * 
	 * @return	panels.keySet()		Returns the keys within the HashMap
	 */
	public static Set<String> getPanelsKeySet() {
		return panels.keySet();
	}
	
	/**
	 * Get the contents of a specific key within the HashMap.
	 * 
	 * @param key		The key to collect data in relation to
	 * @return panels.get(key)		Return the data related to the specified key
	 */
	public static String getData(String key) {
		return panels.get(key);
	}
	
	/**
	 * Get the active panel that is displayed within StatisticsWindow.
	 * 
	 * @return activePanel		Return the panel that is in active display to the user
	 */
	public static StatisticsPanel getActivePanel() {
		return activePanel;
		
	}
}