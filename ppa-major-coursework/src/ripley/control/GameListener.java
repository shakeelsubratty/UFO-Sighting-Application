package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import surprisePanel.view.PlayGame;

public class GameListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		PlayGame game = new PlayGame();
	}

}
