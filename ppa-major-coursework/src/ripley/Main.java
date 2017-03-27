package ripley;

import ripley.model.MainWindowModel;
import ripley.view.MainWindow;

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
	public static void main(String[] args) {
		MainWindowModel windowModel = new MainWindowModel();
		MainWindow mainWindow = new MainWindow(windowModel.ripleyYearArray());
		
		mainWindow.setVisible(true);
		
		//Observable needs to be added to required model management class.
	}
}
