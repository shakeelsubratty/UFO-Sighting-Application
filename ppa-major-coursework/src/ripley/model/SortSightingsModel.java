package ripley.model;

import javax.swing.DefaultComboBoxModel;

/**
 * Defines the combo box model for the Sort Sightings JList
 * @author Shakeel Subratty - K1631133
 *
 */
public class SortSightingsModel 
{
	private DefaultComboBoxModel<String> sortModel;
	/**
	 * Initialise sort model
	 */
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
