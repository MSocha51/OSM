package osm.view;
import javafx.scene.control.Label;
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
		Label nameLabel = new Label("Imi�:");
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
		Label sexLabel = new Label("P�e�:");
		add(sexLabel, 1, 4);
		GridPane pane = new GridPane();
		RadioButton femaleButton = new RadioButton("Kobieta");
		RadioButton maleButton = new RadioButton("M�czyzna");
		final ToggleGroup group = new ToggleGroup();
		femaleButton.setToggleGroup(group);
		maleButton.setToggleGroup(group);
		pane.add(femaleButton, 1, 0);
		pane.add(maleButton, 2, 0);
		add(pane, 2, 4);
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
