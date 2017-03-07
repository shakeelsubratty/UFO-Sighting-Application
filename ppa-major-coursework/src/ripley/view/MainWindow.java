/**
 * 
 */
package ripley.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author afrancht
 * set JPanel to the center
 *  Footer text
 *  retrun combo box values
 */
public class MainWindow extends JFrame {
	
	private JPanel jpTop;
	private JPanel jpMid;
	private JPanel jpBot;
	
	private JButton jbLeft; 
	private JButton jbRight;
	
	private JLabel jlInfo;
	private JLabel jlFrom;
	private JLabel jlTo;
	
	private JComboBox jcbFrom;
	private JComboBox jcbTo;
	
	public MainWindow() {
		
		super(""); // Sets title for the frame.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Ensures program exits upon closing the window.
		initWidgets(); // Calls our initWIdgets methods to create the widgets.
	}
	
	/**
	 *  Method which initialises and correctly aligns all the widgets that appear in the frame.
	 */
	public void initWidgets() {
		
		setPreferredSize(new Dimension(600,400)); // Sets desired size of frame.
		setLayout(new BorderLayout()); // Assigns a border layout to the frame.
		
		jlFrom = new JLabel(" From: "); // Creates label From next to the drop-down menu.
		jlTo = new JLabel(" To: "); // Creates label To next to the drop-down menu.
		
		jcbFrom = new JComboBox(); // Creates the drop-down menu next to the From label.
		jcbTo = new JComboBox(); // Creates the drop-down menu next to the To label. 
		
		// Creates the right and left angled brackets buttons. 
		jbLeft = new JButton("<"); 
		jbRight = new JButton(">");
		
		// Creates panels for the top, mid and bottom. 
		jpTop = new JPanel();
		jpMid = new JPanel();
		jpBot = new JPanel();
		
		// Creates bottom center label. 
		jlInfo = new JLabel("adfadfad");
		jlInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Adds layout managers to the top and bottom panels. 
		jpTop.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jpBot.setLayout(new BorderLayout());
		
		// Adds widgets to the top panel. 
		jpTop.add(jlFrom);
		jpTop.add(jcbFrom);
		jpTop.add(jlTo);
		jpTop.add(jcbTo);
	
		// Adds widgets to the bottom panel. 
		jpBot.add(jbLeft, BorderLayout.WEST);
		jpBot.add(jbRight, BorderLayout.EAST);
		jpBot.add(jlInfo, BorderLayout.CENTER);
		
		// Creates border for the centre panel
		jpMid.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

		//Create the combo box, select item at index 4.
		////Indices start at 0, so 4 specifies the pig.
		//jcbFrom = new JComboBox(petStrings);
		//jcbFrom.setSelectedIndex(4);
		//jcbFrom.addActionListener(this);
		
		// Adds each panel to the corresponding area in the border layout. 
		add(jpTop, BorderLayout.NORTH);
		add(jpBot, BorderLayout.SOUTH);
		add(jpMid, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		
		
	}
	
	/** 
	 * Method which sets the footer text of our window.
	 * @param footer the string that will become our footer. 
	 */
	public void setFooter(String footer) {
		
		jlInfo.setText(footer);
	}

}
