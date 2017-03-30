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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ripley.model.Fetch;
import ripley.model.SoftwareConstants;

/**
 * Panel that displays a map of the USA, with a clickable alien on each state
 * that displays information about sightings.
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

	// Button properties
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
	 * @param mapPath
	 *            the path at which the map image can be found.
	 * @param alienPath
	 *            the path at which the alien image can be found.
	 */
	public MapPanel(String mapPath, String alienPath)
	{
		try
		{
			// Read image files
			map = ImageIO.read(new File(mapPath));
			alien = ImageIO.read(new File(alienPath));
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "File not found.");
			e.printStackTrace();
		}

		// Initialise GUI
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

		// Create a button for each alien
		for (int i = 0; i < SoftwareConstants.COORDINATES.length; i++)
		{
			// Create new SightingsInfoButton for state i
			JButton btn = new SightingsInfoButton(i);

			alienHeight.add(MAX_HEIGHT);
			alienWidth.add(MAX_WIDTH);

			// Set size of button
			// TODO: Make button resizable
			btn.setSize(MAX_HEIGHT, MAX_WIDTH);

			// Set location of button to the location of the state as defined in
			// model.SoftwareConstants
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
	 * @param state
	 *            the number representing the state as defined in
	 *            model.SoftwareConstants
	 * @param width
	 *            the width of the alien and its corresponding button
	 * @param height
	 *            the height of the alien and its corresponding button
	 */
	public void resizeAlien(int state, int width, int height)
	{
		// Save new sizes
		alienWidth.set(state, width);
		alienHeight.set(state, height);

		// Set size of button
		buttons.get(state).setSize(width, height);

		// Redraw panel
		this.validate();
		this.repaint();
	}

	/**
	 * Adjusts the size of aliens and their corresponding buttons based on the
	 * number of incidents.
	 */
	public void updateButtons()
	{
		// Repeat for each button
		for (int i = 0; i < buttons.size(); i++)
		{
			// Number of sightings for the current state
			int count = Fetch.getIncidentCountInState(i);

			// Initialise temp values
			int tempWidth = 0;
			int tempHeight = 0;

			// If there are sightings in this site
			if (count != 0)
			{
				// If number of sightings make up >83% of total sightings
				if (count > ((Fetch.getMostSightingsCount() / 6) * 5))
				{
					tempWidth = ((MAX_WIDTH) / 6) * 6;
					tempHeight = ((MAX_HEIGHT) / 6) * 6;
				}
				// If number of sightings make up >66% of total sightings
				else if (count > ((Fetch.getMostSightingsCount() / 6) * 4))
				{
					tempWidth = ((MAX_WIDTH) / 6) * 5;
					tempHeight = ((MAX_HEIGHT) / 6) * 5;
				}
				// If number of sightings make up >50% of total sightings
				else if (count > ((Fetch.getMostSightingsCount() / 6) * 3))
				{
					tempWidth = ((MAX_WIDTH) / 6) * 4;
					tempHeight = ((MAX_HEIGHT) / 6) * 4;
				}
				// If number of sightings make up >33% of total sightings
				else if (count > ((Fetch.getMostSightingsCount() / 6) * 2))
				{
					tempWidth = ((MAX_WIDTH) / 6) * 3;
					tempHeight = ((MAX_HEIGHT) / 6) * 3;
				}
				// If number of sightings make up >16% of total sightings
				else if (count > ((Fetch.getMostSightingsCount() / 6) * 1))
				{
					tempWidth = ((MAX_WIDTH) / 6) * 2;
					tempHeight = ((MAX_HEIGHT) / 6) * 2;
				}
				// If number of sightings make up <16% of total sightings
				else
				{
					tempWidth = ((MAX_WIDTH) / 6) * 1;
					tempHeight = ((MAX_HEIGHT) / 6) * 1;
				}
			}
			
			// Resize alien image
			resizeAlien(i, tempWidth, tempHeight);
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
