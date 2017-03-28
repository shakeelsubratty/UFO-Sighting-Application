package surprisePanel.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{
	private Image image;
	
	public ImagePanel(String path)
	{
		super();
		try
		{
			image = ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "File not found.");
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g)
	{
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
