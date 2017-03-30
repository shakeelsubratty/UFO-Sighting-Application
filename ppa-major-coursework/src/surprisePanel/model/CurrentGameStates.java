package surprisePanel.model;

public class CurrentGameStates
{
	// Class states
	private static int[] positions;
	private static int score;

	/**
	 * Sets the values to default, ready to start the game.
	 * 
	 * @param numberOfPieces
	 *            the number of characters that are in the game.
	 */
	public static void startGame(int numberOfPieces)
	{
		positions = new int[numberOfPieces];

		// Start all pieces on the right of the river.
		for (int i = 0; i < numberOfPieces; i++)
		{
			positions[i] = GameConstants.RIGHT;
		}
	}

	/**
	 * Gets the current location of a character.
	 * 
	 * @param character
	 *            the character to get the location of, as defined by the
	 *            constants given in {@link model.GameConstants}
	 * @return the current position, as defined by the constants given in
	 *         {@link model.GameConstants}
	 */
	public static int getLocation(int character)
	{
		return positions[character];
	}

	/**
	 * Sets the current locaiton of a character.
	 * 
	 * @param character
	 *            the character to set the location of, as defined by the
	 *            constants given in {@link model.GameConstants}
	 * @param location
	 *            the location to set, as defined by the constants given in
	 *            {@link model.GameConstants}
	 */
	public static void setLocation(int character, int location)
	{
		positions[character] = location;
	}

	/**
	 * Gets the current score.
	 * 
	 * @return the current score
	 */
	public static int getScore()
	{
		return score;
	}

	/**
	 * Decreases the score by 1.
	 */
	public static void incrementScore()
	{
		score--;
	}
}