package surprisePanel.model;

import javax.swing.JOptionPane;

public class MoveValidator
{
	/**
	 * 
	 * @return true if the move is valid.
	 */
	public static boolean isValidMove()
	{
		// If the farmer is not on the boat
		if(CurrentGameStates.getLocation(GameConstants.FARMER) != GameConstants.ON_BOAT)
		{
			return false;
		}
		// If the fox and the goose are alone together.
		else if(CurrentGameStates.getLocation(GameConstants.FOX) == CurrentGameStates.getLocation(GameConstants.GOOSE))
		{
			return false;
		}
		// If the goose and the bean are alone together.
		else if(CurrentGameStates.getLocation(GameConstants.GOOSE) == CurrentGameStates.getLocation(GameConstants.BEANS))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static boolean checkWin()
	{
		// For each character
		for(int i=0;i<GameConstants.NO_OF_CHARACTERS;i++)
		{
			// If the character is not on the left bank
			if(CurrentGameStates.getLocation(i) != GameConstants.LEFT)
			{
				return false;
			}
		}
		return true;
	}
}
