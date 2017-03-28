package ripley;

import java.util.ArrayList;

import javax.swing.JPanel;

import ripley.control.MainWindowListener;
import ripley.model.Fetch;
import ripley.model.MainWindowModel;
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
 * @author Alex - K1631466
 *
 */
public class Main {
	
	/**
	 * Main Method - executes program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Fetch.getData();
		
		MainWindowModel windowModel = new MainWindowModel();
		WelcomePanel welcomePanel = new WelcomePanel();
		MapPanel mapPanel = new MapPanel("img/map.png", "img/alien.png");
		windowModel.addObserver(welcomePanel);		
		
		MainWindow mainWindow = new MainWindow(windowModel.ripleyYearArray());
		MainWindowListener mainWindowListener = new MainWindowListener(windowModel, mainWindow);
		mainWindow.setVisible(true);
		mainWindow.setCentrePanel(mapPanel);

		
	}
}
