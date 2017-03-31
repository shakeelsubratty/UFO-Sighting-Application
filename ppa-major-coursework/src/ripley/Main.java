package ripley;


import ripley.control.GameListener;
import ripley.control.MainWindowListener;
import ripley.model.Fetch;
import ripley.model.MainWindowModel;
import ripley.model.SoftwareConstants;
import ripley.view.MainWindow;
import ripley.view.MapPanel;
import ripley.view.StatisticsWindow;
import ripley.view.SurprisePanel;
import ripley.view.WelcomePanel;

/**
 * Execution of the Application, setting up required View, Model & Controllers.
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
		
		// Get required data from API to start application.
		Fetch.getData();
		
		/*
		 * Setup the model and panels
		 */
		MainWindowModel mainWindowModel = new MainWindowModel();
		WelcomePanel welcomePanel = new WelcomePanel();
		
		StatisticsWindow statisticsWindow = new StatisticsWindow();

		
		MainWindow mainWindow = new MainWindow(mainWindowModel.ripleyYearArray());
		
		MainWindowListener controller = new MainWindowListener(mainWindowModel, mainWindow);
		mainWindowModel.addObserver(welcomePanel);
		
		MapPanel mapPanel = new MapPanel(SoftwareConstants.MAP_PATH, SoftwareConstants.ALIEN_PATH);
		
		SurprisePanel surprisePanel = new SurprisePanel();
		GameListener surprisePanelListener = new GameListener();
		
		// Add panels to the window
		mainWindowModel.addPanel(welcomePanel);
		mainWindowModel.addPanel(mapPanel);
		mainWindowModel.addPanel(statisticsWindow);
		mainWindowModel.addPanel(surprisePanel);
		
		mainWindow.setCentrePanel(mainWindowModel.getPanels().get(0));
	}
}
