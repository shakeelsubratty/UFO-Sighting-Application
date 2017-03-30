package ripley.control;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JOptionPane;

import ripley.model.SoftwareConstants;
import ripley.view.StatisticsWindow;

/**
 * Saves/loads statistics panel on close/opening
 * 
 * @author Aaron - K1630486
 *
 */
public class WindowOpenCloseListener implements WindowListener
{	
	@Override
	public void windowOpened(WindowEvent e)
	{
		// Load statistics
		StatisticsWindow.load(SoftwareConstants.SAVE_DATA_PATH);
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		// Save statistics
		StatisticsWindow.save(SoftwareConstants.SAVE_DATA_PATH);
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}