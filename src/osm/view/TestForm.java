package osm.view;

import java.time.LocalDate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import osm.controller.PatientFormController;
import osm.controller.TestFormController;
import osm.model.BloodPressureTest;
import osm.view.inter.TestFormView;

public class TestForm extends GridPane implements TestFormView {
	private TestFormController testFormController;
	private Button cancelButton;
	private Button saveButton;
	private TextField systoleField;
	private TextField diastoleField;
	private DatePicker datePicker;
	private Text messageText;

	public TestForm(TestFormController testFormController) {
		this.testFormController = testFormController;
		Label titleLabel = new Label("Badanie");
		add(titleLabel, 1, 0);

		createDateFields();
		createPreassureFields();
		createButtons();
		createMessageText();
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(10, 10, 10, 10));
	}

	private void createPreassureFields() {
		Label systoleLabel = new Label("Ciśnienie skurczowe:");
		add(systoleLabel, 1, 2);
		systoleField = new TextField();
		// ustawienie tylko alfanumerycznych
		systoleField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue != null && !newValue.matches("\\d*")) {
					systoleField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		add(systoleField, 2, 2);
		Label diastoleLabel = new Label("Ciśnienie rozkurczowe:");
		add(diastoleLabel, 1, 3);
		diastoleField = new TextField();
		diastoleField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue != null && !newValue.matches("\\d*")) {
					diastoleField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
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
		buttonPane.add(saveButton, 1, 0);
		cancelButton = new Button("Anuluj");
		buttonPane.add(cancelButton, 2, 0);
		buttonPane.setHgap(10);
		add(buttonPane, 2, 4);
		cancelButton.addEventHandler(ActionEvent.ACTION, testFormController);
		saveButton.addEventHandler(ActionEvent.ACTION, testFormController);
	}

	private void createMessageText() {
		messageText = new Text();
		messageText.setText("");
		add(messageText, 1, 5);
	}

	private void setInputs(String systole, String diastole, LocalDate date) {
		systoleField.setText(systole);
		diastoleField.setText(diastole);
		datePicker.setValue(date);
	}

	@Override
	public void clearForm() {
		setInputs(null, null, null);
		messageText.setText("");
		messageText.setFill(Color.BLACK);
		systoleField.setStyle("-fx-control-inner-background: #FFFFFF");
		diastoleField.setStyle("-fx-control-inner-background: #FFFFFF");

	}

	@Override
	public void setTest(BloodPressureTest test) {
		Integer systole = test.getSystole();
		Integer diastole = test.getDiastole();
		setInputs(systole.toString(), diastole.toString(), test.getDate());
		if (systole > 140 || systole < 100)
			systoleField.setStyle("-fx-control-inner-background: #FF0000");
		else
			systoleField.setStyle("-fx-control-inner-background: #FFFFFF");

		if (diastole > 100 || diastole < 60)
			diastoleField.setStyle("-fx-control-inner-background: #FF0000");
		else
			diastoleField.setStyle("-fx-control-inner-background: #FFFFFF");

	}

	@Override
	public BloodPressureTest getTest() {
		BloodPressureTest test = new BloodPressureTest();
		String systole = systoleField.getText();
		String diastole = diastoleField.getText();
		try {
			test.setSystole(Integer.parseInt(systole));
			test.setDiastole(Integer.parseInt(diastole));
		} catch (NumberFormatException e) {
			test.setSystole(null);
			test.setDiastole(null);
		}
		test.setDate(datePicker.getValue());
		return test;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	@Override
	public void setMessage(String msssage, Color color) {
		messageText.setText(msssage);
		messageText.setFill(color);
	}

}
