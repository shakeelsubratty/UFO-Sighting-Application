package surprisePanel.view;

public class PlayGame
{
	private static Game game;
	
	/**
	 * Resets the game
	 */
	public static void reset()
	{
		game.dispose();
		game = new Game();
		game.setVisible(true);
	}
	
	/**
	 * Changes window title
	 * @param title
	 */
	public static void setTitle(String title)
	{
		game.setTitle(title);
	}
	
	/**
	 * Enables/disables game buttons
	 * @param aFlag
	 */
	public static void setPlayable(boolean aFlag)
	{
		game.setPlayable(aFlag);
	}
	
	public static void start()
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				game = new Game();
				game.setVisible(true);
			}
		});
	}
}
