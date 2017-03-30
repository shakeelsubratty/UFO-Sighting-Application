package ripley.model;

import javax.swing.DefaultComboBoxModel;

public class SortSightingsModel 
{
	private DefaultComboBoxModel<String> sortModel;
	public SortSightingsModel()
	{
		sortModel = new DefaultComboBoxModel<>();
		sortModel.addElement("--");
		sortModel.addElement("Date");
		sortModel.addElement("City");
		sortModel.addElement("Shape");
		sortModel.addElement("Duration");
		sortModel.addElement("Posted");			//Add elements to drop down sort filter
	}

	public DefaultComboBoxModel<String> getSortModel()
	{
		return sortModel;
	}
}
