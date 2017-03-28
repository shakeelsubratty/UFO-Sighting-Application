package surprisePanel.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import surprisePanel.model.CurrentGameStates;
import surprisePanel.model.GameConstants;
import surprisePanel.model.MoveValidator;
import surprisePanel.view.GamePanel;
import surprisePanel.view.PlayGame;
import surprisePanel.view.RiverBankPanel;
import surprisePanel.view.RiverPanel;

public class MovePieceListener implements ActionListener
{
	// Object states
	private RiverBankPanel leftBankPanel;
	private RiverBankPanel rightBankPanel;
	private RiverPanel riverPanel;
	
	private int character;
	private int buttonDirection;
	
	public MovePieceListener(GamePanel gp, int character, int buttonDirection)
	{
		leftBankPanel = gp.getLeftBankPanel();
		rightBankPanel = gp.getRightBankPanel();
		riverPanel = gp.getRiverPanel();
		this.character = character;
		this.buttonDirection = buttonDirection;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// If the character is on the boat
		if(CurrentGameStates.getLocation(character) == GameConstants.ON_BOAT)
		{
			// If the button points towards the bank
			if(buttonDirection == CurrentGameStates.getLocation(GameConstants.BOAT))
			{
				// Disembark the character.
				disembark();
			}
		}
		// If the character is on the bank.
		else if(CurrentGameStates.getLocation(character) != buttonDirection)
		{
			// Embark the character.
			embark();
		}
		
		// If the game is in a winning state
		if(MoveValidator.checkWin())
		{
			// Update title of GUI.
			PlayGame.setTitle("You win!");
			
			// Disable game controls.
			PlayGame.setPlayable(false);
		}
	}
	
	public void embark()
	{
		// If the character is on the left bank
		if(buttonDirection == GameConstants.RIGHT)
		{
			// If the character is successfully added to the boat
			if(riverPanel.addToBoat(character))
			{
				// Hide the character on the left bank.
				leftBankPanel.setCharacterVisible(character, false);
				leftBankPanel.update(leftBankPanel.getGraphics());
				
				// Update the character's location in the model.
				CurrentGameStates.setLocation(character, GameConstants.ON_BOAT);
			}
		}
		// If the character is on the right bank
		else
		{
			// If the character is successfully added to the boat
			if(riverPanel.addToBoat(character))
			{
				// Hide the character on the right bank.
				rightBankPanel.setCharacterVisible(character, false);
				rightBankPanel.update(rightBankPanel.getGraphics());
				
				// Update the character's location in the model.
				CurrentGameStates.setLocation(character, GameConstants.ON_BOAT);
			}
		}
	}
	
	public void disembark()
	{
		// If the character is currently on the boat
		if(CurrentGameStates.getLocation(character) == GameConstants.ON_BOAT)
		{
			// If the character is moving to the left bank
			if(buttonDirection == GameConstants.LEFT)
			{
				// If the character is successfully removed from the boat
				if(riverPanel.removeFromBoat(character))
				{
					// Show the character on the left bank.
					leftBankPanel.setCharacterVisible(character, true);
					leftBankPanel.update(leftBankPanel.getGraphics());
					
					// Update the character's location in the model.
					CurrentGameStates.setLocation(character, GameConstants.LEFT );
				}
			}
			// If the character is moving to the right bank
			else
			{
				// If the character is successfully removed from the boat
				if(riverPanel.removeFromBoat(character))
				{
					// Show the character on the right bank.
					rightBankPanel.setCharacterVisible(character, true);
					rightBankPanel.update(rightBankPanel.getGraphics());
					
					// Update the character's location in the model.
					CurrentGameStates.setLocation(character, GameConstants.RIGHT);
				}
			}
		}
	}
}