package ripley.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ripley.control.GameListener;

/**
 * Panel introducing the Alien Capture game.
 * 
 * @author Aaron - K1630486
 *
 */
public class SurprisePanel extends JPanel
{
	// GUI Components
	private JButton button;
	private JLabel text;
	
	/**
	 * Constructor for panel
	 */
	public SurprisePanel()
	{
		super();
		initialise();
	}
	
	/**
	 * Initialises GUI components
	 */
	private void initialise()
	{
		// Message to show
		String str = "Alien Capture!"
				+ " <br> "
				+ " <br> Martin has travelled to space in the hope of catching an alien"
				+ " <br> and was successful in his journey! However, when landing, his"
				+ " <br> rocket crashed and he couldn't use it to get home!"
				+ " <br> "
				+ " <br> Luckily, he managed to find an abandoned UFO to complete his"
				+ " <br> journey back to Earth, but it only has 2 seats!"
				+ " <br> "
				+ " <br> Martin needs your help to get back to Earth, but you must be careful!"
				+ " <br> If you leave the alien alone with Martin's dog Scrap, the alien"
				+ " <br> will eat him! Also, Scrap can't be trusted with treats. If you leave"
				+ " <br> him alone with the bone, he'll eat it!"
				+ " <br> "
				+ " <br> Are you ready to take on the challenge?"
				+ " <br> ";
		
		// Format text and add to panel
		text = new JLabel(str);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setText("<html> <div style='text-align: center;'>" + str + "</div>");
		
		// Add button
		button = new JButton("Begin");
		
		// Configure panel
		this.setLayout(new BorderLayout());
		
		// Add components
		this.add(text, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
		
		// Add listener to button
		button.addActionListener(new GameListener());
	}
}
