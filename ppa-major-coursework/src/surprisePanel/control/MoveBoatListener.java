package surprisePanel.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import surprisePanel.model.CurrentGameStates;
import surprisePanel.model.GameConstants;
import surprisePanel.model.MoveValidator;
import surprisePanel.view.PlayGame;
import surprisePanel.view.RiverPanel;

public class MoveBoatListener implements ActionListener
{
	// Object states
	private int position;
	private RiverPanel riverPanel;

	public MoveBoatListener(RiverPanel riverPanel, int position)
	{
		this.position = position;
		this.riverPanel = riverPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{	
		// Check that the move is valid based on the current game state.
		if(MoveValidator.isValidMove())
		{
			// Adjust score to account for the boat moving.
			CurrentGameStates.incrementScore();
			
			// Update score on GUI.
			PlayGame.setTitle("SCORE: " + CurrentGameStates.getScore());
			
			// Update the location of the boat in the model.
			CurrentGameStates.setLocation(GameConstants.BOAT, position);
			
			// Move the boat on the GUI.
			riverPanel.moveBoat(position);
		}
		// If the farmer is on the boat and the move was invalid
		else if(CurrentGameStates.getLocation(GameConstants.FARMER) == GameConstants.ON_BOAT) 
		{
			String title = "GAME OVER: ";
			
			// If the fox and the goose are left alone together
			if(CurrentGameStates.getLocation(GameConstants.FOX) == CurrentGameStates.getLocation(GameConstants.GOOSE))
			{
				// Update title to display the reason the game ended.
				title += "The alien killed the dog!";
			}
			// If the goose and the bean are left alone together
			else
			{
				// Update title to display the reason the game ended.
				title += "The dog ate the bone!";
			}
			
			// Update title of GUI.
			PlayGame.setTitle(title);
			
			// Disable the controls for the game.
			PlayGame.setPlayable(false);
		}
	}
}
