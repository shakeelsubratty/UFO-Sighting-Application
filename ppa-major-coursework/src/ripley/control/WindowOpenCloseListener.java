package ripley.control;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JOptionPane;

import ripley.model.SoftwareConstants;
import ripley.view.StatisticsWindow;

public class WindowOpenCloseListener implements WindowListener
{	
	@Override
	public void windowOpened(WindowEvent e)
	{
		StatisticsWindow.load(SoftwareConstants.SAVE_DATA_PATH);
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
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