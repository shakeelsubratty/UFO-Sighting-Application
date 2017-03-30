package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import surprisePanel.view.PlayGame;

/**
 * Creates a new instance of Alien Capture
 * 
 * @author Aaron - K1630486
 *
 */
public class GameListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Create instance of game
		PlayGame game = new PlayGame();
		
		// Start game
		game.start();
	}

}
