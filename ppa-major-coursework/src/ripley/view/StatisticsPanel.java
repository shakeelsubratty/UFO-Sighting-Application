package ripley.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Panel to display the statistics of the data within a given time frame.
 * 
 * @author Lewis - K1630576
 * @author Aaron - K1630486
 *
 */
public class StatisticsPanel extends JPanel
{
	// GUI Components
	private JLabel titleLabel;
	private JLabel infoLabel;
	
	// Object states
	private String title;
	private String info;
	
	public StatisticsPanel(String title, Integer integer)
	{
		// Update object states
		this.title = title;
		this.info = integer.toString();
		
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
	
	public void setTitle(String title)
	{
		titleLabel.setText(title);
		this.update(this.getGraphics());
	}
	
	public void setInfo(String info)
	{
		infoLabel.setText(info);
		this.update(this.getGraphics());
	}
}
