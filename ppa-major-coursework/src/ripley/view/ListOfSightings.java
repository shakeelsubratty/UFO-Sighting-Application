package ripley.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ListOfSightings extends JFrame 
{
	private JComboBox comboBox;
	
	public ListOfSightings(String state)
	{
		super(state);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 400));
		initialise();
	}
	
	public void initialise()
	{
		setLayout(new BorderLayout());
		comboBox = new JComboBox<>();
		add(comboBox,BorderLayout.NORTH);	
		pack();
		setVisible(true);
	}

}
