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
	private ArrayList<JButton> buttons;

	// Object states
	private String mapPath;
	private String alienPath;

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
		
		//Create a button for each alien
		for(int i=0;i<SoftwareConstants.COORDINATES.length;i++)
		{
			// Create new SightingsInfoButton for state i
			JButton btn = new SightingsInfoButton(i);
			
			// Set size of button
			// TODO: Make button resizable
			btn.setSize(24, 32);
			
			// Set location of button to the location of the state as defined in model.SoftwareConstants
			btn.setLocation(SoftwareConstants.COORDINATES[i][SoftwareConstants.X], 
					SoftwareConstants.COORDINATES[i][SoftwareConstants.Y]);
			
			// Add button to panel
			this.add(btn);
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
					SoftwareConstants.COORDINATES[i][SoftwareConstants.Y], 24, 32, this);
		}
	}
}
