package ripley.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class used for testing panels - REMOVE BEFORE FINAL SUBMISSION
 * 
 * @author Aaron - K1630486
 *
 */
public class Test
{
	/*public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		JPanel statsPanel = new StatisticsPanel("Alex", "123");
		
		frame.add(statsPanel);
		
		frame.pack();
		frame.setVisible(true);
		
		frame.remove(statsPanel);
	}*/
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		MapPanel test = new MapPanel("img/map.jpg", "img/alien.jpg");
		
		frame.setLayout(new BorderLayout());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(test, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
	}
}
