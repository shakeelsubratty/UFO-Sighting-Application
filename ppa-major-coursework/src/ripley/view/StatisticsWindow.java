package ripley.view;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ripley.model.StatisticsData;

/**
 * Panel to display the statistics of the data within a given time frame.
 * 
 * @author Lewis - K1630576
 *
 */
public class StatisticsWindow extends JPanel
{
	private StatisticsData statisticsData;
	private static int panelNumber = 4;
	private static ArrayList<StatisticsPanel> panels = new ArrayList<StatisticsPanel>();
	private static ArrayList<Integer> activePanelIndexes;
	
	/**
	 * Create view instance of the statistics panel.
	 */
	public StatisticsWindow()
	{	
		if(activePanelIndexes == null) {
			activePanelIndexes = new ArrayList<Integer>();
		}
		setLayout(new GridLayout(2,2));
		setPreferredSize(new Dimension(950, 600));
		initialise();
	}
	
	/**
	 * Sets up the panel, placing multiple instances inside of the panel to display 
	 * multiple statistics at one time.
	 */
	private void initialise()
	{
		// Create the panels.
		for(int i=0; i<panelNumber; i++) {
			statisticsData = new StatisticsData();
			StatisticsPanel statisticsPanel = new StatisticsPanel(statisticsData);
			panels.add(statisticsPanel);
			statisticsData.addObserver(statisticsPanel);
			add(statisticsPanel);
		}
	}
	
	/**
	 * Checks the active panels within the StatisticsWindow.
	 * 
	 * @param index		The index of the panels to check
	 * @return	Boolean 	Returns either true/false to indicate if the panel is already active
	 */
	public static Boolean checkActiveIndexes(int index) {
		if(activePanelIndexes.contains(index)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Updates the panels and windows with view changes.
	 */
	public static void update() {
		activePanelIndexes.clear();
		for(StatisticsPanel panel : panels) {
			activePanelIndexes.add(panel.getActivePanelIndex());
			panel.updateStats(activePanelIndexes);
		}
	}
	
	/**
	 * Saves the indexes of the active panels to be loaded on program start.
	 * 
	 * @param filePath		Location to save to
	 */
	public static void save(String filePath)
	{
		// Create file
		File file = new File(filePath);
				
		// Reset file
		if(file.exists())
		{
			file.delete();
		}
		try
		{
			file.createNewFile();
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "IOException.\n" + e);
		}
		
		ObjectOutputStream objectOut;
		
		try
		{
			// Initialise Output Stream
			objectOut = new ObjectOutputStream(new FileOutputStream(filePath));
			
			// Write to file
			objectOut.writeObject(activePanelIndexes);
					
			// Close stream
			objectOut.close();
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "File not found.\n" + e);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "IOException.\n" + e);
		}
	}
	
	/**
	 * Loads the active panels from a file.
	 * 
	 * @param filePath		The location of the saved file
	 */
	public static void load(String filePath)
	{
		// Create file
		File file = new File(filePath);
				
		// Initialise Input Stream
		ObjectInputStream objectIn;
		
		if(file.exists())
		{
			try
			{
				objectIn = new ObjectInputStream(new FileInputStream(filePath));
				
				// Read object from file
				activePanelIndexes = (ArrayList<Integer>) objectIn.readObject();
				
				// Close stream
				objectIn.close();
			}
			catch (FileNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, "File not found.\n" + e);
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "IOException.\n" + e);
			}
			catch (ClassNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, "Error: " + e);
			}
			
			System.out.println(activePanelIndexes.toString());
		}	
	}
}
