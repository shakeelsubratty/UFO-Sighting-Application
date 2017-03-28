/**
 * 
 */
package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		view.addListeners(new LeftButtonListener(), new RightButtonListener(), new ComboBoxFromListener(), new ComboBoxToListener());
		System.out.println(model.lastUpdated());
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

	class ComboBoxFromListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			checkDates();
		}
	}
	
	class ComboBoxToListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			checkDates();

		}
	}

	public void goNextPanel() {

			view.nextIndex();
			view.checkIndex();

	}

	public void goPreviousPanel() {

			view.prevIndex();
			view.checkIndex();
		}

	public void checkDates() {
		
		Integer comparator = model.verifyDate(view.getFromDate(), view.getToDate());
		
		if ( comparator == 1) {

			

		} else if ( comparator == 2) {
			
			JOptionPane.showMessageDialog(null, "The date range selected is not correct");
			
		} else if ( comparator == 3 ) {
			
			view.checkIndex();
			model.setDateRange(view.getFromDate(), view.getToDate());
			view.disableDropDowns();
		}
		

	}



}