/**
 * 
 */
package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ripley.model.MainWindowModel;
import ripley.view.MainWindow;

/**
 * @author afrancht
 *
 */
public class MainWindowListener {
	
	private MainWindowModel model;
	private MainWindow view;
	
	
	public MainWindowListener(MainWindowModel model, MainWindow view) {
		
		this.model = model;
		this.view = view;
		
		view.addListeners(new LeftButtonListener(), new RightButtonListener());
	}

	
	class RightButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			goNextPanel();
			
		}
	}
	
	class LeftButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			goPreviousPanel();
			
		}
	}
	
	public void goNextPanel(){
		
		
		
	}
	
	public void goPreviousPanel() {
		
		
	}
}
