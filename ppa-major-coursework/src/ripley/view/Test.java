package ripley.view;


import java.awt.List;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import api.ripley.Ripley;

import api.ripley.Ripley;

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
		String privateKey = "10tLI3GWut+yVD6ql2OMtA==";
		String publicKey = "tBgm4pVo/g/VqL46EnH7ew==";
		
		//Create instance of Ripley
		Ripley ripley = new Ripley(privateKey, publicKey);
		
		JFrame frame = new JFrame();


		MapPanel test = new MapPanel("img/map.png", "img/alien.png");
		
		frame.setLayout(new BorderLayout());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel statsPanel = new StatisticsPanel("Alex", "123");
		JPanel welcomePanel = new WelcomePanel(ripley);
		

		//frame.add(statsPanel);
		frame.add(welcomePanel);
		JFrame listOfSightings = new ListOfSightings("California");

		
		frame.setResizable(false);
		frame.add(test, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		listOfSightings.pack();
		listOfSightings.setVisible(true);
	}
}
