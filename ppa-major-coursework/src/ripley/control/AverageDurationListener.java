package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ripley.model.AverageDurationModel;
import ripley.view.AverageDurationPanel;

/**
 * Class which serves as a controller for our Average Duration statistic. 
 * 
 * @author Alex Franch Tapia - K1631466
 *
 */
public class AverageDurationListener implements ActionListener {

	private AverageDurationPanel avgDPanel;
	private AverageDurationModel avgDModel;
	
	public AverageDurationListener(AverageDurationPanel avgDPanel, AverageDurationModel avgDModel) {
		this.avgDPanel = avgDPanel;
		this.avgDModel = avgDModel;
		avgDPanel.addListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// generates stat with a given string and sets the stat in the correct label. 
		System.out.println("Action");
		System.out.println(avgDPanel.getDropDownState());
		avgDModel.generateStat(avgDPanel.getDropDownState());
		System.out.println(avgDModel.getAverage());
		avgDPanel.setInfo(avgDModel.getAverage());	
	}

}
