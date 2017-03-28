package surprisePanel.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel
{
	// GUI components
	private JLabel label;
	private JButton leftButton;
	private JButton rightButton;
	
	// Object states
	private String name;
	
	public ControlPanel(String name)
	{
		this.name = name;
		initialise();
		
	}

	/**
	 * Initialises GUI components
	 */
	private void initialise()
	{
		// Configure JPanel
		this.setLayout(new FlowLayout());
		
		// JLabel label
		label = new JLabel(name);
		
		// JButton leftButton
		leftButton = new JButton("<");
		
		// JButton rightButton
		rightButton = new JButton(">");
		
		// Add components to JPanel
		this.add(label);
		this.add(leftButton);
		this.add(rightButton);
	}
	
	public JButton getLeftButton()
	{
		return leftButton;
	}
	
	public JButton getRightButton()
	{
		return rightButton;
	}
	
	public void setEnabled(boolean aFlag)
	{
		leftButton.setEnabled(aFlag);
		rightButton.setEnabled(aFlag);
	}
	
	protected void setLeftButtonActionListener(ActionListener l)
	{
		leftButton.addActionListener(l);
	}
	
	protected void setRightButtonActionListener(ActionListener l)
	{
		rightButton.addActionListener(l);
	}
}