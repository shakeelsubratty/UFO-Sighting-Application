package ripley.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ripley.model.Fetch;
import ripley.model.SoftwareConstants;
/**
 * Panel that displays a map of the USA, with a clickable alien on each state that displays information about sightings.
 * 
 * @author Aaron - K1630486
 *
 */
public class MapPanel extends JPanel
{
	// GUI Components
	private Image map;
	private Image alien;
	
	private static ArrayList<JButton> buttons;
	private static ArrayList<Integer> alienHeight;
	private static ArrayList<Integer> alienWidth;

	// Object states
	private String mapPath;
	private String alienPath;
	
	private static int MAX_WIDTH = 48;
	private static int MAX_HEIGHT = 64;

	/**
	 * Constructor for MapPanel
	 * 
	 * @param mapPath the path at which the map image can be found.
	 * @param alienPath the path at which the alien image can be found.
	 */
	public MapPanel(String mapPath, String alienPath)
	{
		try
		{
			map = ImageIO.read(new File(mapPath));
			alien = ImageIO.read(new File(alienPath));
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "File not found.");
			e.printStackTrace();
		}

		initialise();
	}

	/**
	 * Initialises the GUI components.
	 */
	private void initialise()
	{
		// Set to null layout
		this.setLayout(null);
		
		// Set size to 720p
		this.setPreferredSize(new Dimension(1280, 720));
		
		// Initialise buttons array
		buttons = new ArrayList<>();
		alienHeight = new ArrayList<>();
		alienWidth = new ArrayList<>();
		
		//Create a button for each alien
		for(int i=0;i<SoftwareConstants.COORDINATES.length;i++)
		{
			// Create new SightingsInfoButton for state i
			JButton btn = new SightingsInfoButton(i);
			
			alienHeight.add(32);
			alienWidth.add(24);
			
			// Set size of button
			// TODO: Make button resizable
			btn.setSize(32, 24);
			
			// Set location of button to the location of the state as defined in model.SoftwareConstants
			btn.setLocation(SoftwareConstants.COORDINATES[i][SoftwareConstants.X], 
					SoftwareConstants.COORDINATES[i][SoftwareConstants.Y]);
			
			// Add button to panel
			this.add(btn);
			buttons.add(btn);
		}
	}

	/**
	 * Changes the size of the alien associated with a given state.
	 * 
	 * @param state the number representing the state as defined in model.SoftwareConstants
	 * @param width the width of the alien and its corresponding button
	 * @param height the height of the alien and its corresponding button
	 */
	public void resizeAlien(int state, int width, int height)
	{
		alienWidth.set(state, width);
		alienHeight.set(state, height);
		buttons.get(state).setSize(width, height);
		this.validate();
		this.repaint();
	}
	
	public void updateButtons()
	{
		for(int i=0;i<buttons.size();i++)
		{
			int count = Fetch.getIncidentCountInState(i);
			
			//double tempWidth = (36 * (Fetch.getIncidentCountInState(i)/Fetch.getIncidentCount()) * 10);
			//double tempHeight = (48 * (Fetch.getIncidentCountInState(i)/Fetch.getIncidentCount()) * 10);
			
			int tempWidth = 0;
			int tempHeight = 0;
			
			if(count != 0)
			{
				
				if(count > ((Fetch.getMostSightingsCount() / 6) * 5))
				{
					tempWidth = ((MAX_WIDTH)/6) * 6;
					tempHeight = ((MAX_HEIGHT)/6) * 6;
				}
				else if(count > ((Fetch.getMostSightingsCount() / 6) * 4))
				{
					tempWidth = ((MAX_WIDTH)/6) * 5;
					tempHeight = ((MAX_HEIGHT)/6) * 5;
				}
				else if(count > ((Fetch.getMostSightingsCount() / 6) * 3))
				{
					tempWidth = ((MAX_WIDTH)/6) * 4;
					tempHeight = ((MAX_HEIGHT)/6) * 4;
				}
				else if(count > ((Fetch.getMostSightingsCount() / 6) * 2))
				{
					tempWidth = ((MAX_WIDTH)/6) * 3;
					tempHeight = ((MAX_HEIGHT)/6) * 3;
				}
				else if(count > ((Fetch.getMostSightingsCount() / 6) * 1))
				{
					tempWidth = ((MAX_WIDTH)/6) * 2;
					tempHeight = ((MAX_HEIGHT)/6) * 2;
				}
				else
				{
					tempWidth = ((MAX_WIDTH)/6) * 1;
					tempHeight = ((MAX_HEIGHT)/6) * 1;
				}
			}
			
			//alienWidth.set(i, tempWidth);
			//alienHeight.set(i, tempHeight);
			
			resizeAlien(i, tempWidth, tempHeight);
			System.out.println("Width: " + tempWidth + ", Height: " + tempHeight);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// Draw map
		g.drawImage(map, 0, 0, 1280, 720, this);

		// Draw aliens at the locations defined in model.SoftwareConstants
		for (int i = 0; i < SoftwareConstants.COORDINATES.length; i++)
		{
			g.drawImage(alien, SoftwareConstants.COORDINATES[i][SoftwareConstants.X],
					SoftwareConstants.COORDINATES[i][SoftwareConstants.Y], alienWidth.get(i), alienHeight.get(i), this);
		}
	}
}
