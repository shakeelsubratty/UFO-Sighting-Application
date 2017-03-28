package surprisePanel.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import surprisePanel.model.CurrentGameStates;
import surprisePanel.model.GameConstants;

public class RiverPanel extends ImagePanel
{
	// GUI components
	private JPanel leftBoat;
	private JPanel rightBoat;
	
	// Object states
	private String imagePath;
	private String boatPath;
	
	public RiverPanel(String imagePath, String boatPath)
	{
		super(imagePath);
		
		this.imagePath = imagePath;
		this.boatPath = boatPath;
		
		initialise();
	}
	
	private void initialise()
	{
		//JPanel leftBoat
		leftBoat = new BoatPanel(GameConstants.IMAGE_PATH + GameConstants.IMAGE_NAMES[GameConstants.BOAT]);
		
		//JPanel rightBoat
		rightBoat = new BoatPanel(GameConstants.IMAGE_PATH + GameConstants.IMAGE_NAMES[GameConstants.BOAT]);
		
		leftBoat.setVisible(false);
		
		// Configure JPanel
		this.setLayout(new GridLayout(1,2));

		// Add components to panel
		this.add(leftBoat);
		this.add(rightBoat);
	}
	
	public void moveBoat(int pos)
	{
		// If the boat is moving to the left
		if(pos == GameConstants.LEFT)
		{
			// Remove panels from river.
			this.removeAll();
			
			// Add boats to panel.
			this.add(rightBoat);
			this.add(leftBoat); // This boat contains the characters.
			
			// Update GUI.
			this.validate();
			this.repaint();
		}
		// If the boat is moving to the right
		else if(pos == GameConstants.RIGHT)
		{
			// Remove panels from the river.
			this.removeAll();
			
			// Add boats to panel.
			this.add(leftBoat); // This boat contains the characters.
			this.add(rightBoat);
			
			// Update GUI.
			this.validate();
			this.repaint();
		}
	}
	
	public boolean addToBoat(int character)
	{
		// If the character is currently on the boat in the model
		if(CurrentGameStates.getLocation(GameConstants.BOAT) == CurrentGameStates.getLocation(character))
		{
			// If the character is successfully added to the boat
			if(BoatPanel.embark(character))
			{
				// Update boats on GUI.
				((BoatPanel) leftBoat).updatePassengers();
				((BoatPanel) rightBoat).updatePassengers();
				
				return true;
			}
			// If the character is not successfully added to the boat
			else
			{
				return false;
			}
		}
		// If the character is not on the boat in the model
		else
		{
			return false;
		}
	}
	
	public boolean removeFromBoat(int character)
	{
		// If the character is successfully removed from the boat
		if(BoatPanel.disembark(character))
		{
			// Update character's location in the model.
			CurrentGameStates.setLocation(character, CurrentGameStates.getLocation(GameConstants.BOAT));
			
			// Update boats on GUI.
			((BoatPanel) leftBoat).updatePassengers();
			((BoatPanel) rightBoat).updatePassengers();
			
			return true;
		}
		// If the character is not successfully removed from the boat
		else
		{
			return false;
		}
	}
}