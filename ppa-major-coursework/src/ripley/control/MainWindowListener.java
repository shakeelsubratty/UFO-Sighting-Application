/**
 * 
 */
package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ripley.model.MainWindowModel;
import ripley.model.StatisticsData;
import ripley.view.MainWindow;

/**
 * @author Alex Franch Tapia - K1631466
 *
 */
public class MainWindowListener {

	private MainWindowModel model;
	private MainWindow view;
	private StatisticsData statisticsData;

	

	public MainWindowListener(MainWindowModel model, MainWindow view, StatisticsData statisticsData) {

		this.model = model;
		this.view = view;
		this.statisticsData = statisticsData;
		
		view.setFooter(model.lastUpdated());
		view.addListeners(new LeftButtonListener(), new RightButtonListener(), new ComboBoxFromListener(), new ComboBoxToListener());
		System.out.println(model.lastUpdated());
	}

	/**
	 * Inner class which creates Action Listener for right button.
	 * @author Alex Franch Tapia - k1631466
	 */
	class RightButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			model.nextIndex();
			System.out.println(model.getCurrentIndex());
			checkIndex();
			view.setCentrePanel(model.getPanels().get(model.getCurrentIndex()));
		}
	}

	/**
	 * Inner class which creates Action Listener for left button.
	 * @author Alex Franch Tapia - k1631466
	 */
	class LeftButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			model.prevIndex();
			System.out.println(model.getCurrentIndex());
			checkIndex();
			view.setCentrePanel(model.getPanels().get(model.getCurrentIndex()));
			
		}
	}

	/**
 	 * Inner class which creates Action Listener for From JComboBox button.
	 * @author Alex Franch Tapia - k1631466
	 */
	class ComboBoxFromListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			checkDates();
		}
	}
	
	/**
	 * Inner class which creates Action Listener for To JComboBox button.
	 * @author Alex Franch Tapia - k1631466
	 */
	class ComboBoxToListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			checkDates();

		}
	}

	/**
	 * Method which checks that the date range introduced is valid. 
	 */
	public void checkDates() {
		
		Integer comparator = model.verifyDate(view.getFromDate(), view.getToDate());
		
		// If one has a date and the other is null, do nothing.
		if ( comparator == 1) {

			
		// If second date is smaller than the first, give an error message.
		} else if ( comparator == 2) {
			
			JOptionPane.showMessageDialog(null, "The date range selected is not correct");
		
		// If the range is correct, then enable buttons and dissable dropdowns.
		} else if ( comparator == 3 ) {
			

			model.setDateRange(view.getFromDate(), view.getToDate(), statisticsData);
			view.disableDropDowns();
			checkIndex();
		}
		

	}
	
	/**
	 * Method which checks the current index (panel) that is active and updates button functionality. 
	 */
	public void checkIndex() {
		
		if (model.getCurrentIndex() == 0) {

			view.enableButtons(false, true);

		} else if (model.getCurrentIndex() == model.getPanels().size() - 1) {

			view.enableButtons(true, false);

		} else {

			view.enableButtons(true, true);
		}
	}


}