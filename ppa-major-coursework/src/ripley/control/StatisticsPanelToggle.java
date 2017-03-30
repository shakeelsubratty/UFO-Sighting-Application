package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import ripley.model.StatisticsData;

/**
 * Changes the statistics panel that is in view when a button is pressed.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsPanelToggle extends Observable implements ActionListener {

	private StatisticsData statisticsData;
	
	public StatisticsPanelToggle(StatisticsData statisticsData) {
		this.statisticsData = statisticsData;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Check which button was pressed
		if(e.getActionCommand().equals("<")) {
			statisticsData.setActivePanel(0);
		} else if(e.getActionCommand().equals(">")) {
			statisticsData.setActivePanel(1);
		}
		
		// Notify view
		setChanged();
		notifyObservers();
	}
}
