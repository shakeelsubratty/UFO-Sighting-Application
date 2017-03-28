package surprisePanel.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import surprisePanel.control.MoveBoatListener;
import surprisePanel.control.MovePieceListener;
import surprisePanel.model.CurrentGameStates;
import surprisePanel.model.GameConstants;

public class Game extends JFrame
{
	// GUI components
	private JPanel buttonPanel;
	private JPanel gamePanel;
	private ArrayList<ControlPanel> controls;
	
	public Game()
	{
		controls = new ArrayList<>();
		
		// Initialise game states
		CurrentGameStates.startGame(5);
		
		//Initialise GUI
		initialise();
	}
	
	/**
	 * Initialise GUI components
	 */
	private void initialise()
	{
		// JFrame setup
		this.setTitle("Alien Capture");
		this.setLayout(new BorderLayout());
		
		// ArrayList<ControlPanel> controls
		controls.add(new ControlPanel("UFO"));
		controls.add(new ControlPanel("Alien"));
		controls.add(new ControlPanel("Scrap"));
		controls.add(new ControlPanel("Bone"));
		controls.add(new ControlPanel("Martin"));
		
		// GamePanel gamePanel
		gamePanel = new GamePanel();
		
		// Add ActionListeners to buttons
		// Boat
		controls.get(0).setLeftButtonActionListener(new MoveBoatListener(((GamePanel) gamePanel).getRiverPanel(), GameConstants.LEFT));
		controls.get(0).setRightButtonActionListener(new MoveBoatListener(((GamePanel) gamePanel).getRiverPanel(), GameConstants.RIGHT));
		
		// Characters
		for(int i=1;i<controls.size();i++)
		{
			controls.get(i).setLeftButtonActionListener(new MovePieceListener((GamePanel) gamePanel, i-1, GameConstants.LEFT));
			controls.get(i).setRightButtonActionListener(new MovePieceListener((GamePanel) gamePanel, i-1, GameConstants.RIGHT));
		}
		
		// JPanel buttonPanel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		for(int i=0;i<controls.size();i++)
		{
			buttonPanel.add(controls.get(i));
		}
		
		// JFrame setup
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(gamePanel, BorderLayout.CENTER);
		this.setResizable(false);
		this.pack();
	}
	
	/**
	 * Enables/disables the buttons of the game.
	 * 
	 * @param aFlag areButtonsEnabled
	 */
	public void setPlayable(boolean aFlag)
	{
		for(int i=0;i<controls.size();i++)
		{
			controls.get(i).setEnabled(false);
		}
	}
}