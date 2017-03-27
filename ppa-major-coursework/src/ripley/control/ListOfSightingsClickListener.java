package ripley.control;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import api.ripley.Incident;

public class ListOfSightingsClickListener extends DoubleClickListener {

	public ListOfSightingsClickListener(DefaultComboBoxModel<String> model) 
	{
		super(model);
	}
	
	@Override
	public void clickEvent(MouseEvent e)
	{
		int index = ((JList<String>)e.getComponent()).getSelectedIndex(); //Select the index of the item that was selected
		JOptionPane.showMessageDialog(e.getComponent(),((JList<Incident>)e.getSource()).getSelectedValue().getSummary());
		System.out.println("List Sigtings");
	}

}
