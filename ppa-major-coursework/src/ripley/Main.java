package ripley;


import java.util.ArrayList;

import javax.swing.JPanel;


import ripley.control.MainWindowListener;
import ripley.model.Fetch;
import ripley.model.MainWindowModel;
import ripley.model.SoftwareConstants;
import ripley.view.MainWindow;
import ripley.view.MapPanel;

import ripley.view.StatisticsPanel;

import ripley.view.WelcomePanel;

/**
 * 
 * 
 * @author Lewis - K1630576
 * @author Aaron - K1630486
 * @author Shakeel - K1631133
 * @author Alex Franch Tapia - K1631466
 *
 */
public class Main {
	
	/**
	 * Main Method - executes program.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		Fetch.getData();
		MainWindowModel mainWindowModel = new MainWindowModel();
		WelcomePanel welcomePanel = new WelcomePanel();
		MainWindow mainWindow = new MainWindow(mainWindowModel.ripleyYearArray());
		MainWindowListener controller = new MainWindowListener(mainWindowModel, mainWindow);
		
		MapPanel mapPanel = new MapPanel(SoftwareConstants.MAP_PATH, SoftwareConstants.ALIEN_PATH);
		
		mainWindowModel.addPanel(welcomePanel);
		mainWindowModel.addPanel(mapPanel);
		
		mainWindow.setCentrePanel(mainWindowModel.getPanels().get(0));
		
	}
		//Observable needs to be added to required model management class.
	
}
