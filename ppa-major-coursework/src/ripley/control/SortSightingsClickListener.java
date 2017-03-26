package ripley.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class SortSightingsClickListener  implements ActionListener 
{
	private DefaultComboBoxModel<String> model;
	private DefaultComboBoxModel<String> listModel;
	public SortSightingsClickListener(DefaultComboBoxModel<String> model,DefaultComboBoxModel<String> listModel) 
	{
		this.model = model;
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
		bucketSort(collator);
	}
	
	private void sortCity()
	{
		String cityPattern = "City: ([a-zA-Z-./]+\\s([a-zA-Z]+\\s)*)";
		SortCollator collator = new SortCityCollator(cityPattern);
		bucketSort(collator);
	}
	
	private void sortShape()
	{
		String shapePattern = "Shape: ([a-zA-Z-./]+\\s([a-zA-Z]+\\s)*)";
		SortShapeCollator collator = new SortShapeCollator(shapePattern);
		bucketSort(collator);

	}
	private void sortDuration()
	{
		String durationPattern = "Duration: ((\\d)+\\s(second(s)?|minute(s)?|hour(s)?))";
		SortDurationCollator collator = new SortDurationCollator(durationPattern);
		bucketSort(collator);
	}
	
	private void sortPosted()
	{
		String datePostedPattern = "Posted: (\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)";
		SortPostedDateCollator collator = new SortPostedDateCollator(datePostedPattern);
		bucketSort(collator);
	}
	private void bucketSort(SortCollator collator)
	{
		int size = listModel.getSize();
		System.out.println(size);

		for(int i = 0; i < size; i++)
		{
			for(int j = 1; j < (size - i); j++)
			{

				switch (collator.compare(listModel.getElementAt(j-1), listModel.getElementAt(j))) 
				{
				case 1:
					String temp1 = listModel.getElementAt(j-1);
					String temp2 = listModel.getElementAt(j);

					listModel.removeElementAt(j-1);
					listModel.insertElementAt(temp2, j-1);
					listModel.removeElementAt(j);
					listModel.insertElementAt(temp1, j);

					break;

				default:
					break;
				}
			}
		}
	}
}
