package ripley.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import api.ripley.Ripley;
import ripley.model.Fetch;

public class WelcomePanel extends JPanel 
{
	public WelcomePanel()
	{
		initialise();
	}
	
	private void initialise()
	{
		//BorderLayout manager
		setPreferredSize(new Dimension(450, 450));
		this.setLayout(new BorderLayout());
	
		JLabel text = new JLabel();
		String str = "Welcome to the Ripley API v" + Fetch.getVersion()
				+ " <br>Please select from the range of dates above, "
				+ " <br> in order to begin analysing UFO sighting data"
				+ " <br>"
				+ " <br> Date selected"
				+ " <br>"
				+ " <br> Grabbing data"
				+ " <br>"
				+ " <br> Data grabbed in "
				+ " <br>"
				+ " <br> <b>Please now interact with the buttons below</b>";
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setText("<html> <div style='text-align: center;'>" + str + "</div>");
		
		add(text, BorderLayout.CENTER);
	}

}
