package surprisePanel.model;

public class CurrentGameStates
{
	// Class states
	private static int[] positions;
	private static int score;
	
	public static void startGame(int numberOfPieces)
	{
		positions = new int[numberOfPieces];
		
		// Start all pieces on the right of the river.
		for(int i=0;i<numberOfPieces;i++)
		{
			positions[i] = GameConstants.RIGHT;
		}
	}

	public static int getLocation(int character)
	{
		return positions[character];
	}
	
	public static void setLocation(int character, int location)
	{
		positions[character] = location;
	}
	
	public static int getScore()
	{
		return score;
	}
	
	public static void incrementScore()
	{
		score--;
	}
}