package ripley.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class used for testing panels - REMOVE BEFORE FINAL SUBMISSION
 * 
 * @author Aaron - K1630486
 *
 */
public class Test
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		MapPanel test = new MapPanel("img/map.png", "img/alien.png");
		
		frame.setLayout(new BorderLayout());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false);
		frame.add(test, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
