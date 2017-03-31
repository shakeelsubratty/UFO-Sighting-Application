package ripley.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * DoubleClickListener class - determines whether a selected list item has been double clicked.
 * @author Shakeel Subratty - K1631133
 *
 */
public abstract class DoubleClickListener extends MouseAdapter 
{
	private long timeOfPreviousClick;	//Tracks time of previous click
	private long currentTime;	
	
	/**
	 * Constructor that initialises time of previous click to 0
	 */
	public DoubleClickListener()
	{
		timeOfPreviousClick = 0; 
	}

	/**
	 * Action on mouse clicked. Overrides MouseAdapter.mouseClicked()
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		currentTime = System.currentTimeMillis();
		if(currentTime - timeOfPreviousClick < 400 )	//If time between clicks < 400ms
		{
			clickEvent(e);
		}
		timeOfPreviousClick = currentTime;
	}
	
	/**
	 * Defines the action to be carried out on double click event. 
	 * Overriden by sub-classes.
	 * @param e
	 */
	public abstract void clickEvent(MouseEvent e);
}
