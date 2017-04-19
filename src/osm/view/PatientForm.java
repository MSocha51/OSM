package osm.view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import osm.controller.PatientFormController;
import osm.model.Patient;
import osm.view.inter.PatientFormView;

public class PatientForm extends GridPane implements PatientFormView{ //TODO change Pane type
	private PatientFormController patientFormController;
	private Button cancelButton;
	private Button saveButton;
	
	private TextField nameField;
	private TextField surnameField;
	private TextField peselField;
	
	private RadioButton femaleButton;
	private RadioButton maleButton;
	
	private ChoiceBox<String> insuranceBox;
	
	public PatientForm(PatientFormController patientFormController){
		this.patientFormController=patientFormController;
		Label titleLabel = new Label("Dane pacjenta");
		add(titleLabel, 1, 0);		
		createTextFields();
		createSexFields();
		createInsuranceFields();
		createButtons();
		
		setHgap(10); 
		setVgap(10); 
		setPadding(new Insets(10, 10, 10, 10));
	}
	
	
	private void createButtons() {
		GridPane buttonPane = new GridPane();
		saveButton = new Button("Zapisz");
		buttonPane.add(saveButton,1,0);
		cancelButton = new Button("Anuluj");
		buttonPane.add(cancelButton,2,0);
		buttonPane.setHgap(10);
		add(buttonPane, 2, 6);	
		cancelButton.addEventHandler(ActionEvent.ACTION, patientFormController);
		saveButton.addEventHandler(ActionEvent.ACTION, patientFormController);
	}


	private void createInsuranceFields() {
		Label insuranceLabel = new Label("Ubezpieczenie:");
		add(insuranceLabel, 1, 5);
		insuranceBox = new ChoiceBox<>(FXCollections.observableArrayList(
				"NFZ", "Prywatne", "Brak")
			);
		add(insuranceBox, 2, 5);	
	}


	private void createSexFields() {
		Label sexLabel = new Label("Płeć:");
		add(sexLabel, 1, 4);
		GridPane sexPane = new GridPane();
		femaleButton = new RadioButton("Kobieta");
		maleButton = new RadioButton("Mężczyzna");
		final ToggleGroup group = new ToggleGroup();
		femaleButton.setToggleGroup(group);
		maleButton.setToggleGroup(group);
		sexPane.add(femaleButton, 1, 0);
		sexPane.add(maleButton, 2, 0);
		add(sexPane, 2, 4);
	}


	private void createTextFields() {
		Label nameLabel = new Label("Imię:");
		add(nameLabel, 1, 1);
		nameField = new TextField();
		add(nameField, 2, 1);
		Label surnameLabel = new Label("Nazwisko:");
		add(surnameLabel, 1, 2);
		surnameField = new TextField();
		add(surnameField, 2, 2);
		Label peselLabel = new Label("PESEL:");
		add(peselLabel, 1, 3);
		peselField = new TextField();
		add(peselField , 2, 3);
	}


	@Override
	public void clearForm() {
		setInputs(null,null,null);
		maleButton.setSelected(false);
		femaleButton.setSelected(false);
		insuranceBox.getSelectionModel().clearSelection();
	}

	@Override
	public void setPatient(Patient patient) {
		setInputs(patient.getName(),patient.getSurname(),patient.getPesel());
		Character male = 'M';
		Character female = 'K';
		String sex = patient.getSex();
		if(male.equals(sex)){
			femaleButton.setSelected(false);
		    maleButton.setSelected(true);
		}else if(female.equals(sex)){
			femaleButton.setSelected(true);
		    maleButton.setSelected(false);
		}else{
			femaleButton.setSelected(false);
		    maleButton.setSelected(false);
		}
		insuranceBox.setValue(patient.getInsurance());

	}
	private void setInputs(String name, String surname, String pesel ){
		nameField.setText(name);
		surnameField.setText(surname);
		peselField.setText(pesel);
	}

	@Override
	public Patient getPatient() {
		Patient patient = new Patient();
		patient.setName(nameField.getText());
		patient.setSurname(surnameField.getText());
		patient.setPesel(peselField.getText());
		String sex = femaleButton.isSelected()? "K" :
						maleButton.isSelected()  ? "M" :
						" ";
		patient.setSex(sex);
		patient.setInsurance(insuranceBox.getValue());
		return patient;
	}


	public Button getCancelButton() {
		return cancelButton;
	}


	public Button getSaveButton() {
		return saveButton;
	}
	
	

}
