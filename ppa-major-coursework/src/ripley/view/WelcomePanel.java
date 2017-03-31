package ripley.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ripley.model.DateRange;
import ripley.model.Fetch;

/**
 * Welcome panel for application.
 * @author Shakeel Subratty - K1631133
 */
public class WelcomePanel extends JPanel implements Observer
{
	//Variables that a displayed to user
	private String startDate;
	private String endDate;
	private String dateSelected;
	private String grabbingData;
	private String timeForGrab;
	private String interaction;
	private String acknowledgement;
		
	private JLabel text;
	
	/**
	 * Create welcome panel
	 */
	public WelcomePanel()
	{
		initialise();
	}
	
	/**
	 * Intialise widgets
	 */
	private void initialise()
	{
		//BorderLayout manager
		setPreferredSize(new Dimension(450, 450));
		this.setLayout(new BorderLayout());
		
		//Initialise optional Strings
		startDate = "";
		endDate = "";
		dateSelected = "";
		grabbingData = "";
		timeForGrab = "";
		interaction = "";
		acknowledgement = Fetch.getAcknowledgement();
	
		text = new JLabel();
		updateText(text);	//Determine what text should be displayed currently
		
		add(text, BorderLayout.CENTER);
	}

	/**
	 * Updates displayed text as variable values are changed
	 * @param text
	 */
	private void updateText(JLabel text)
	{
		String str = "Welcome to the Ripley API v" + Fetch.getVersion()
			+ " <br/>Please select from the range of dates above, "
			+ " <br/> in order to begin analysing UFO sighting data."
			+ " <br/> "
			+ " <br/> PLEASE NOTE: Date ranges wider than 10 years"
			+ " <br/> may take a while to process."
			+ " <br/>"
			+ " <br/>" + dateSelected
			+ " <br/>"
			+ " <br/>" + grabbingData
			+ " <br/>"
			+ " <br/>" + timeForGrab
			+ " <br/>"
			+ " <br/>" + interaction
			+ " <br/>"
			+ " <br/>" + acknowledgement;
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setText("<html> <div style='text-align: center;'>" + str + "</div>");
		
	}


	@Override
	public void update(Observable o, Object arg) 
	{
		if(arg instanceof DateRange)
		{
			//When a range of dates is passed, update welcome panel to show this next stage
			startDate = ""+((DateRange)arg).getStartDate();
			endDate = ((DateRange)arg).getEndDate()+"";
			dateSelected = "Dates selected: " + startDate + "-" + endDate;
			grabbingData = "Grabbing data...";
			updateText(text);
		}
		if(arg instanceof Long)
		{
			//When a time is passed, update welcome panel to show grabbing information is completed
			timeForGrab = "Data grabbed in "+ ((Long)arg/1000) +" seconds (" + (Long) arg + " milliseconds)";
			interaction = "<b>Please now interact with the buttons below</b>";
			updateText(text);
		}
		
	}

}
