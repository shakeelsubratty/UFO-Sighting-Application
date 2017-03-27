package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ripley.model.StatisticsData;
import ripley.view.StatisticsWindow;

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
