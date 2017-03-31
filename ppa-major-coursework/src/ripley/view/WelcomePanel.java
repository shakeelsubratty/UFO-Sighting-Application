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
 * @author shakeelsubratty
 */
public class WelcomePanel extends JPanel implements Observer
{
	private String startDate;
	private String endDate;
	private String dateSelected;
	private String grabbingData;
	private String timeForGrab;
	private String interaction;
	private String acknowledgement;
		
	private JLabel text;
	public WelcomePanel()
	{
		initialise();
	}
	
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
		updateText(text);
		
		add(text, BorderLayout.CENTER);
	}

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
			startDate = ""+((DateRange)arg).getStartDate();
			endDate = ((DateRange)arg).getEndDate()+"";
			dateSelected = "Dates selected: " + startDate + "-" + endDate;
			grabbingData = "Grabbing data...";
			updateText(text);
		}
		if(arg instanceof Long)
		{
			timeForGrab = "Data grabbed in "+ ((Long)arg/1000) +" seconds (" + (Long) arg + " milliseconds)";
			interaction = "<b>Please now interact with the buttons below</b>";
			updateText(text);
		}
		
	}

}
