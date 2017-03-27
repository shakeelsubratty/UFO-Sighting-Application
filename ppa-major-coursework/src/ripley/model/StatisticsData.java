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
	static Map<String, Integer> panels;

	public StatisticsData() {
		initialise();
	}
	
	public void initialise() {
		panels = new HashMap<String, Integer>();
		panels.put("Hoaxes", 1);
		panels.put("Non US Sightings", 2);
		panels.put("Likeliest States", 3);
		panels.put("Sightings via Other Platforms", 4);

		// activePanel =;
	}
	
	/**
	 * Returns the panels stored in the panels HashMap.
	 * 
	 * @return panels		StatisticsPanel's inside of panels HashMap
	 */
	public static Map<String, Integer> getPanels() {
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
	public static Integer getData(String key) {
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