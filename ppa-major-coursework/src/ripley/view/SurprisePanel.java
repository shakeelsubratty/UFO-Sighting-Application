package ripley.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ripley.control.GameListener;

public class SurprisePanel extends JPanel
{
	private JButton button;
	private JLabel text;
	
	public SurprisePanel()
	{
		super();
		initialise();
	}
	
	private void initialise()
	{
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
				+ " <br> "
				;
		text = new JLabel(str);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setText("<html> <div style='text-align: center;'>" + str + "</div>");
		
		button = new JButton("Begin");
		
		this.setLayout(new BorderLayout());
		
		this.add(text, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
		
		button.addActionListener(new GameListener());
	}
}
