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
		view.setFooter(model.lastUpdated());
		view.addListeners(new LeftButtonListener(), new RightButtonListener());
		System.out.println(model.lastUpdated());
	}

	
	class RightButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			goNextPanel();
			System.out.println(view.currentIndex);
			
		}
	}
	
	class LeftButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			goPreviousPanel();
			System.out.println(view.currentIndex);
			
		}
	}
	
	public void goNextPanel(){
		
		view.nextIndex();
		view.checkIndex();
		
	}
	
	public void goPreviousPanel() {
		
		view.prevIndex();
		view.checkIndex();
	}
}
