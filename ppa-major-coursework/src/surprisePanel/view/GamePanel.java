package surprisePanel.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class GamePanel extends JPanel
{
	// GUI components
	private JPanel waterPanel;
	private JPanel leftBankPanel;
	private JPanel rightBankPanel;
	
	public GamePanel()
	{
		super();
		initialise();
	}
	
	private void initialise()
	{
		this.setLayout(new BorderLayout());
		
		// JPanel gamePanel
		String[] imagePaths = {"img/fox.png", "img/goose.png", "img/beans.png", "img/farmer.png"};
		
		// JPanel leftBankPanel
		leftBankPanel = new RiverBankPanel("img/grass.png", imagePaths);
		
		// For each character
		for(int i=0;i<imagePaths.length;i++)
		{
			// Set characters on the left bank to not visible.
			((RiverBankPanel) leftBankPanel).setCharacterVisible(i, false);
		}
		
		// JPanel rightBankPanel
		rightBankPanel = new RiverBankPanel("img/meteor.png", imagePaths);
		
		// JPanel waterPanel
		waterPanel = new RiverPanel("img/water.png", "img/boat.png");
		
		// Add components to JPanel
		this.add(leftBankPanel, BorderLayout.WEST);
		this.add(waterPanel, BorderLayout.CENTER);
		this.add(rightBankPanel, BorderLayout.EAST);
	}
	
	public RiverPanel getRiverPanel()
	{
		return (RiverPanel) waterPanel;
	}
	
	public RiverBankPanel getLeftBankPanel()
	{
		return (RiverBankPanel) leftBankPanel;
	}
	
	public RiverBankPanel getRightBankPanel()
	{
		return (RiverBankPanel) rightBankPanel;
	}
}
