package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class SortSightingsClickListener  implements ActionListener 
{
	private DefaultComboBoxModel<String> listModel;
	
	public SortSightingsClickListener(DefaultComboBoxModel<String> listModel) 
	{
		this.listModel = listModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int index = ((JComboBox<String>)e.getSource()).getSelectedIndex(); //Select the index of the item that was selected
		switch (index) {
		case 0:
			break;
		case 1:
			sortDate();
			break;
		case 2:
			sortCity();
			break;
		case 3:
			sortShape();
			break;
		case 4:
			sortDuration();
			break;
		case 5:
			sortPosted();
			break;
		default:
			break;
		}
	}

	private void sortDate()
	{
		String dateOfIncidentPattern = "Time: (\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d) ";
		String timeOfIncidentPattern = "((\\d\\d):(\\d\\d):(\\d\\d))";
		
		SortDateCollator collator = new SortDateCollator(dateOfIncidentPattern + timeOfIncidentPattern);
		mergeSort(collator);
	}
	
	private void sortCity()
	{
		String cityPattern = "City: (([\\S]+\\s([\\S\\s]+)*)([a-zA-Z()]+)?)";
		SortCityCollator collator = new SortCityCollator(cityPattern);
		mergeSort(collator);
	}
	
	private void sortShape()
	{
		String shapePattern = "Shape: ([a-zA-Z-./]+\\s([a-zA-Z]+\\s)*)";
		SortShapeCollator collator = new SortShapeCollator(shapePattern);
		mergeSort(collator);

	}
	private void sortDuration()
	{
		String durationPattern = "Duration: ((-)?(\\d+))";
		SortDurationCollator collator = new SortDurationCollator(durationPattern);
		mergeSort(collator);
	}
	
	private void sortPosted()
	{
		String datePostedPattern = "Posted: (\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)";
		SortPostedDateCollator collator = new SortPostedDateCollator(datePostedPattern);
		mergeSort(collator);
	}
	
	private void mergeSort(SortCollator collator)
	{
		String[] arr = new String[listModel.getSize()];
		for(int  i = 0; i < listModel.getSize(); i++)
		{
			arr[i] = listModel.getElementAt(i);
		}
		listModel.removeAllElements();
		Arrays.sort(arr,collator);
		for(int  i = 0; i < arr.length; i++)
		{
			listModel.addElement(arr[i]);
		}
	}
	
}
