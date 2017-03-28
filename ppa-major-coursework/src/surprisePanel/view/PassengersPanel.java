package surprisePanel.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PassengersPanel extends JPanel
{
	// GUI components
	private static JLabel leftPassenger;
	private static JLabel rightPassenger;
	
	// Static object states
	private static int instanceCount;
	
	public PassengersPanel()
	{
		super();
		initialise();
		instanceCount++;
	}
	
	private void initialise()
	{
		// Configure JPanel
		this.setOpaque(false);
		this.setLayout(new GridLayout(1,2));
		
		// If this is the first instance of the object
		if(instanceCount == 0)
		{
			//Initialise leftPassenger and rightPassenger
			leftPassenger = new JLabel();
			rightPassenger = new JLabel();
		}
		
		// Add components to JPanel
		this.add(leftPassenger);
		this.add(rightPassenger);
	}
	
	public static void reset()
	{
		leftPassenger = new JLabel();
		rightPassenger = new JLabel();
	}
	
	/**
	 * @return the leftPassenger
	 */
	public JLabel getLeftPassenger()
	{
		return leftPassenger;
	}
	/**
	 * @return the rightPassenger
	 */
	public JLabel getRightPassenger()
	{
		return rightPassenger;
	}
	/**
	 * @param leftPassenger the leftPassenger to set
	 */
	public static void setLeftPassengerIcon(ImageIcon icon)
	{
		leftPassenger.setIcon(icon);
	}
	/**
	 * @param rightPassenger the rightPassenger to set
	 */
	public static void setRightPassengerIcon(ImageIcon icon)
	{
		rightPassenger.setIcon(icon);
	}

	public static void setPassengersVisible(boolean aFlag)
	{
		leftPassenger.setVisible(aFlag);
		rightPassenger.setVisible(aFlag);
	}
}
