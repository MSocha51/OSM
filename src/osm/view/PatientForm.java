package osm.view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osm.controller.PatientFormController;
import osm.controller.TableController;
import osm.model.Patient;

public class PatientForm extends GridPane implements PatientFormController { //TODO change Pane type
	
	private TableController tableController;
	
	public PatientForm(){
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
		Button saveButton = new Button("Zapisz");
		buttonPane.add(saveButton,1,0);
		Button cancelButton = new Button("Anuluj");
		buttonPane.add(cancelButton,2,0);
		buttonPane.setHgap(10);
		add(buttonPane, 2, 6);	
	}


	private void createInsuranceFields() {
		Label insuranceLabel = new Label("Ubezpieczenie:");
		add(insuranceLabel, 1, 5);
		ChoiceBox<String> insuranceBox = new ChoiceBox<>(FXCollections.observableArrayList(
				"NFZ", "Prywatne", "Brak")
			);
		add(insuranceBox, 2, 5);	
	}


	private void createSexFields() {
		Label sexLabel = new Label("P³eæ:");
		add(sexLabel, 1, 4);
		GridPane sexPane = new GridPane();
		RadioButton femaleButton = new RadioButton("Kobieta");
		RadioButton maleButton = new RadioButton("Mê¿czyzna");
		final ToggleGroup group = new ToggleGroup();
		femaleButton.setToggleGroup(group);
		maleButton.setToggleGroup(group);
		sexPane.add(femaleButton, 1, 0);
		sexPane.add(maleButton, 2, 0);
		add(sexPane, 2, 4);
	}


	private void createTextFields() {
		Label nameLabel = new Label("Imiê:");
		add(nameLabel, 1, 1);
		TextField nameField = new TextField();
		add(nameField, 2, 1);
		Label surnameLabel = new Label("Nazwisko:");
		add(surnameLabel, 1, 2);
		TextField surnameField = new TextField();
		add(surnameField, 2, 2);
		Label peselLabel = new Label("PESEL:");
		add(peselLabel, 1, 3);
		TextField peselField = new TextField();
		add(peselField , 2, 3);
	}


	@Override
	public void clearForm() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPateint(Patient pateint) {
		// TODO Auto-generated method stub

	}

	public TableController getTableController() {
		return tableController;
	}

	public void setTableController(TableController table) {
		this.tableController= table;
	}
	
	

}
