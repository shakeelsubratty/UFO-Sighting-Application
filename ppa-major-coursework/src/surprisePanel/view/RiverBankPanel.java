package surprisePanel.view;

import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RiverBankPanel extends ImagePanel
{
	// Object states
	private ArrayList<JLabel> positions;
	private String[] imagePaths;
	
	public RiverBankPanel(String path, String[] imagePaths)
	{
		super(path);
		
		this.imagePaths = imagePaths;
		
		positions = new ArrayList<>();
		
		initialise();
	}
	
	private void initialise()
	{
		// Configure JPanel
		this.setLayout(new GridLayout(4,1));
		
		//For each image
		for(int i=0;i<imagePaths.length;i++)
		{
			// Add characters to the river bank.
			positions.add(new JLabel(new ImageIcon(imagePaths[i])));
			this.add(positions.get(i));
		}
	}
	
	public void setCharacterVisible(int character, boolean isVisible)
	{
		positions.get(character).setVisible(isVisible);
	}
	
	public boolean isCharacterVisible(int character)
	{
		return positions.get(character).isVisible();
	}
}
