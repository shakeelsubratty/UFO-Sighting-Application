/**
 * 
 */
package ripley.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Alex Franch Tapia - K1631466
 */
public class MainWindow extends JFrame implements Observer {

	private JPanel jpTop;
	private JPanel jpMid;
	private JPanel jpBot;

	private JButton jbLeft;
	private JButton jbRight;

	private JLabel jlInfo;
	private JLabel jlFrom;
	private JLabel jlTo;

	private JComboBox<Integer> jcbFrom;
	private JComboBox<Integer> jcbTo;

	private int currentIndex;

	public MainWindow(Integer[] allYears) {

		super(""); // Sets title for the frame.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Ensures program exits upon closing the window.
		initWidgets(allYears); // Calls our initWIdgets methods to create the widgets.
		setLocationRelativeTo(null);
		
		
	}

	/**
	 * Method which initialises and correctly aligns all the widgets that appear
	 * in the frame.
	 */
	private void initWidgets(Integer[] allYears) {

		/*
		 * Shows the current index for the current panel that is displayed. 1 -
		 * Welcome 2 - Map 3 - Statistics 4 - Surprise me
		 */
		currentIndex = 1;

		setMinimumSize(new Dimension(1300, 825)); // Sets desired size of				// frame.
		setLayout(new BorderLayout()); // Assigns a border layout to the frame.

		jlFrom = new JLabel(" From: "); // Creates label From next to the drop-down menu.
		jlTo = new JLabel(" To: "); // Creates label To next to the drop-down menu.

		jcbFrom = new JComboBox<Integer>(allYears); // Creates the drop-down menu next to the From label.
		jcbTo = new JComboBox<Integer>(allYears); // Creates the drop-down menu next to the To label.
		jcbFrom.setSelectedItem(null);
		jcbTo.setSelectedItem(null);

		// Creates the right and left angled brackets buttons.
		jbLeft = new JButton("<");
		jbRight = new JButton(">");
		
		jbLeft.setEnabled(false);
		jbRight.setEnabled(false);

		// Creates panels for the top, mid and bottom.
		jpTop = new JPanel();
		jpMid = new JPanel();
		jpBot = new JPanel();

		// Creates bottom centre label.
		jlInfo = new JLabel();
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

		// Adds each panel to the corresponding area in the border layout.
		add(jpTop, BorderLayout.NORTH);
		add(jpBot, BorderLayout.SOUTH);
		add(jpMid, BorderLayout.CENTER);

		pack();
		setVisible(true);

	}

	/**
	 * Method which sets the footer text of our window.
	 * 
	 * @param footer
	 *            the string that will become our footer.
	 */
	public void setFooter(String footer) {

		jlInfo.setText(footer);
	}

	/**
	 * Sets the centre panel of the frame.
	 * 
	 * @param centrePanel
	 *            the panel that will be our centre panel.
	 */
	public void setCentrePanel(JPanel centrePanel) {

		jpMid.removeAll();
		jpMid.repaint();
		jpMid.revalidate();
		jpMid.add(centrePanel);

	}
	

	/**
	 * Adds action listeners to the two buttons.
	 * 
	 * @param one
	 *            ActionListener
	 * @param two
	 *            ActionListener
	 */
	public void addListeners(ActionListener one, ActionListener two, ActionListener three, ActionListener four) {

		jbLeft.addActionListener(one);
		jbRight.addActionListener(two);
		jcbFrom.addActionListener(three);
		jcbTo.addActionListener(four);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	/** 
	 * Method which enables and disables buttons according to the 
	 * boolean values inputed in the constructor. 
	 */
	public void enableButtons(boolean left, boolean right) {
		
		if ( left == true && right == true ) {
			
			jbRight.setEnabled(true);
			jbLeft.setEnabled(true);
		
		} else if ( left == false && right == true ) {
			
			jbLeft.setEnabled(false);
			jbRight.setEnabled(true);
		
		} else if ( left == true && right == false) {
			
			jbRight.setEnabled(false);
			jbLeft.setEnabled(true);
		}
	}





	/**
	 * Returns the date from the From: drop down menu. 
	 * @return integer which represents the starting year.
	 */
	public Integer getFromDate() {
		
		return (Integer)jcbFrom.getSelectedItem();
	}
	
	/**
	 * Returns the date from the To: drop down menu. 
	 * @return integer which represents the ending year.
	 */
	public Integer getToDate() {
		
		return (Integer)jcbTo.getSelectedItem();
		
	}

	/** 
	 * Disables the drop down menus.
	 */
	public void disableDropDowns() {
		
		jcbFrom.setEnabled(false);
		jcbTo.setEnabled(false);
	}
}
