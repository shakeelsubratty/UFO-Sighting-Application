package surprisePanel.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import surprisePanel.model.CurrentGameStates;
import surprisePanel.model.GameConstants;

public class BoatPanel extends JPanel
{
	// GUI components
	private JLabel boat;
	private static PassengersPanel passengers;
	
	// Object states
	private String boatPath;
	
	// Static object states
	private static boolean leftSlotFree;
	private static boolean rightSlotFree;
	private static int leftPassengerInt;
	private static int rightPassengerInt;
	private static int instanceCount;
	
	public BoatPanel(String boatPath)
	{
		super();
		
		this.boatPath = boatPath;
		leftSlotFree = true;
		rightSlotFree = true;
		
		// Only set these variables if an instance of this object has not yet been created.
		if(instanceCount == 0)
		{
			leftPassengerInt = -1;
			rightPassengerInt = -1;
		}
		
		initialise();
		instanceCount++;
	}
	
	private void initialise()
	{
		// Configure JPanel
		this.setLayout(new GridLayout(2,1));
		this.setOpaque(false);
		
		// JLabel boat
		boat = new JLabel(new ImageIcon(boatPath));
		
		// PassengersPanel passengers
		passengers = new PassengersPanel();
		
		// Add components to JPanel
		this.add(passengers);
		this.add(boat);
		
	}
	
	public static void reset()
	{
		leftPassengerInt = -1;
		rightPassengerInt = -1;
		leftSlotFree = true;
		rightSlotFree = true;
	}
	
	public static boolean embark(int character)
	{
		// If the character is the farmer and the left seat on the boat is free
		if(character == GameConstants.FARMER && leftSlotFree)
		{
			// Add farmer to left seat on the boat.
			PassengersPanel.setLeftPassengerIcon(new ImageIcon(GameConstants.IMAGE_PATH + GameConstants.IMAGE_NAMES[character]));
			leftPassengerInt = character;
			
			// Mark that the left seat is no longer free.
			leftSlotFree = false;
			
			return true;
		}
		// If the right seat on the boat is free and the character is not the farmer
		else if(rightSlotFree && character != GameConstants.FARMER)
		{
			// Add character to right seat on the boat.
			PassengersPanel.setRightPassengerIcon(new ImageIcon(GameConstants.IMAGE_PATH + GameConstants.IMAGE_NAMES[character]));
			rightPassengerInt = character;
			
			// Mark that the right seat is no longer free.
			rightSlotFree = false;
			
			return true;
		}
		// If the appropriate seat on the boat is not free
		else
		{
			return false;
		}
	}
	
	public static boolean disembark(int character)
	{
		// If the character is the farmer
		if(character == GameConstants.FARMER)
		{
			// If the character is on the boat
			if(CurrentGameStates.getLocation(character) == GameConstants.ON_BOAT)
			{
				// Set the location of the character to the bank that the boat is currently at.
				CurrentGameStates.setLocation(character, CurrentGameStates.getLocation(GameConstants.BOAT));
				
				// Remove the character from the left seat of the boat.
				PassengersPanel.setLeftPassengerIcon(null);
				leftPassengerInt = -1;
				
				// Mark that the left seat is free.
				leftSlotFree = true;
				
				return true;
			}
			else
			{
				return false;
			}
		}
		// If the character is not the farmer
		else
		{
			// If the character is on the boat
			if(CurrentGameStates.getLocation(character) == GameConstants.ON_BOAT)
			{
				// Set the location of the character to the bank that the boat is currently at.
				CurrentGameStates.setLocation(character, CurrentGameStates.getLocation(GameConstants.BOAT));
				
				// Remove the character from the right seat of the boat.
				PassengersPanel.setRightPassengerIcon(null);
				rightPassengerInt = -1;
				
				// Mark that the right seat is free.
				rightSlotFree = true;
				
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public void updatePassengers()
	{
		// If there is no passenger in the left seat
		if(leftPassengerInt == -1)
		{
			// Set left seat image to null.
			PassengersPanel.setLeftPassengerIcon(null);
		}
		// If there is a passenger in the left seat
		else
		{
			// Set left seat image to the character in that seat.
			PassengersPanel.setLeftPassengerIcon(new ImageIcon(GameConstants.IMAGE_PATH + GameConstants.IMAGE_NAMES[leftPassengerInt]));
		}
		
		// If there is no passenger in the right seat
		if(rightPassengerInt == -1)
		{
			// Set the right seat image to null.
			PassengersPanel.setRightPassengerIcon(null);
		}
		// If there is a passenger in the right seat
		else
		{
			// Set right seat image to the character in that seat.
			PassengersPanel.setRightPassengerIcon(new ImageIcon(GameConstants.IMAGE_PATH + GameConstants.IMAGE_NAMES[rightPassengerInt]));
		}
	}
}
