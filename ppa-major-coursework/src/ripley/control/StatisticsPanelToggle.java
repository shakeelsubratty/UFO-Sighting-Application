package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ripley.model.StatisticsData;

/**
 * Changes the statistics panel that is in view when a button is pressed.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsPanelToggle implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "<") {
			StatisticsData.setActivePanel(StatisticsData.getActivePanel());
		} else if(e.getActionCommand() == ">") {
			StatisticsData.setActivePanel(StatisticsData.getActivePanel());
		}
	}
}
