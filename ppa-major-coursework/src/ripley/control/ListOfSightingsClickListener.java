package ripley.control;

import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

public class ListOfSightingsClickListener extends DoubleClickListener {

	public ListOfSightingsClickListener(DefaultComboBoxModel<String> model) 
	{
		super(model);
	}
	
	@Override
	public void clickEvent(MouseEvent e)
	{
		int index = ((JList<String>)e.getComponent()).getSelectedIndex(); //Select the index of the item that was selected
		//JOptionPane.showMessageDialog(e.getComponent(),((JList<Incident>)e.getSource()).getSelectedValue().getSummary());
		System.out.println("List Sigtings");
	}

}
