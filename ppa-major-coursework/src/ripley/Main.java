package ripley;

import ripley.model.MainWindowModel;
import ripley.view.MainWindow;

public class Main {
	public static void main(String[] args) {
		MainWindowModel windowModel = new MainWindowModel();
		MainWindow mainWindow = new MainWindow(windowModel.ripleyYearArray());
		
		mainWindow.setVisible(true);
		
		//Observable needs to be added to required model management class.
	}
}
