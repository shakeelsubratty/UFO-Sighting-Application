package ripley.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Panel to display the statistics of the data within a given time frame.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsOutput extends JPanel
{
	// GUI Components
	private JLabel titleLabel;
	private JLabel infoLabel;
	
	// Object states
	private String title;
	private String info;
	
	public StatisticsOutput(String title, String info)
	{
		// Update object states
		this.title = title;
		this.info = info;
		
		// Initialise GUI components
		initialise();
	}
	
	private void initialise()
	{
		// Set Layout Manager
		this.setLayout(new BorderLayout());
		
		// JLabel titleLabel
		titleLabel = new JLabel(title);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// JLabel infoLabel
		infoLabel = new JLabel(info);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Add components to panel
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(infoLabel, BorderLayout.CENTER);
	}

	/**
	 * Method which sets text for the infoLabel.
	 *
	 * @param str		text to set the infoLabel to.
	 */
	public void setInfo(String str) {
		
		infoLabel.setText(str);
	}
}
