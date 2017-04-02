package osm.view;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import osm.controller.PatientFormController;
import osm.controller.TestFormController;
import osm.model.BloodPressureTest;
import osm.view.inter.TestFormView;

public class TestForm extends GridPane implements TestFormView { //TODO change Pane type
	private TestFormController testFormController;
	private Button cancelButton;
	private Button saveButton;
	private TextField systoleField;
	private TextField diastoleField;
	private DatePicker datePicker;

	public TestForm(TestFormController testFormController){
		this.testFormController = testFormController;
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
		Label systoleLabel = new Label("Ciśnienie skurczowe:");
		add(systoleLabel, 1, 2);
		systoleField = new TextField();
		add(systoleField, 2, 2);
		Label diastoleLabel = new Label("Ciśnienie rozkurczowe:");
		add(diastoleLabel, 1, 3);
		diastoleField = new TextField();
		add(diastoleField, 2, 3);
	}

	private void createDateFields() {
		Label dateLabel = new Label("Data:");
		add(dateLabel, 1, 1);
		datePicker = new DatePicker();
		add(datePicker, 2, 1);	
	}

	private void createButtons() {
		GridPane buttonPane = new GridPane();
		saveButton = new Button("Zapisz");
		buttonPane.add(saveButton,1,0);
		cancelButton = new Button("Anuluj");
		buttonPane.add(cancelButton,2,0);
		buttonPane.setHgap(10);
		add(buttonPane, 2, 4);
		cancelButton.addEventHandler(ActionEvent.ACTION, testFormController);
		saveButton.addEventHandler(ActionEvent.ACTION, testFormController);
	}
	private void setInputs(String systole, String diastole, LocalDate date ){
		systoleField.setText(systole);
		diastoleField.setText(diastole);
		datePicker.setValue(date);
	}
	@Override
	public void clearForm() {
		setInputs(null,null,null);

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

	public Button getCancelButton() {
		return cancelButton;
	}

	public Button getSaveButton() {
		return saveButton;
	}
	
	

}
