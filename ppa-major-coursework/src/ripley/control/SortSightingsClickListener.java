package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class SortSightingsClickListener  implements ActionListener 
{
	private DefaultComboBoxModel<String> model;
	public SortSightingsClickListener(DefaultComboBoxModel<String> model) 
	{
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int index = ((JComboBox<String>)e.getSource()).getSelectedIndex(); //Select the index of the item that was selected
		switch (index) {
		case 0:
			break;
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		case 4:
			System.out.println(4);
			break;
		case 5:
			System.out.println(5);
			break;
		default:
			break;
		}
	}
}
