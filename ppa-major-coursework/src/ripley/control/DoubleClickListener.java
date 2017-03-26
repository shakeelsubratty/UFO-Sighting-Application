package ripley.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import api.ripley.Incident;

/*
 * ClickListener class - determines whether a selected list item has been double clicked 
 * and removes them.
 */
public class DoubleClickListener extends MouseAdapter 
{
	private long timeOfPreviousClick;
	private long currentTime;
	
	private DefaultComboBoxModel<String> model;
	
	public DoubleClickListener(DefaultComboBoxModel<String> model)
	{
		this.model = model;
		timeOfPreviousClick = 0; 
	}
	
	public void mouseClicked(MouseEvent e)
	{
		currentTime = System.currentTimeMillis();
		if(currentTime - timeOfPreviousClick < 400 )	//If time between clicks < 400ms
		{
			clickEvent(e);
		}
		timeOfPreviousClick = currentTime;
	}
	
	public void clickEvent(MouseEvent e)
	{
		
	}
}
