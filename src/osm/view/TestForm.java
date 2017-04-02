package osm.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import osm.model.BloodPressureTest;
import osm.view.inter.TestFormView;

public class TestForm extends GridPane implements TestFormView { //TODO change Pane type
	

	public TestForm(){
		Label titleLabel = new Label("Badanie");
		add(titleLabel, 1, 0);
		
		createDateFields();
		createPreassureFields();
		createButtons();
		
		setHgap(10); 
		setVgap(10); 
		setPadding(new Insets(10, 10, 10, 10));
	}
	
	private void createPreassureFields() {
		Label systoleLabel = new Label("Ciœnienie skurczowe:");
		add(systoleLabel, 1, 2);
		TextField systoleField = new TextField();
		add(systoleField, 2, 2);
		Label diastoleLabel = new Label("Ciœnienie rozkurczowe:");
		add(diastoleLabel, 1, 3);
		TextField diastoleField = new TextField();
		add(diastoleField, 2, 3);
	}

	private void createDateFields() {
		Label dateLabel = new Label("Data:");
		add(dateLabel, 1, 1);
		final DatePicker datePicker = new DatePicker();
		add(datePicker, 2, 1);	
	}

	private void createButtons() {
		GridPane buttonPane = new GridPane();
		Button saveButton = new Button("Zapisz");
		buttonPane.add(saveButton,1,0);
		Button cancelButton = new Button("Anuluj");
		buttonPane.add(cancelButton,2,0);
		buttonPane.setHgap(10);
		add(buttonPane, 2, 4);	
	}
	@Override
	public void clearForm() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTest(BloodPressureTest test) {
		// TODO Auto-generated method stub

	}

	@Override
	public BloodPressureTest getTest() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
