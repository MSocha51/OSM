package osm.view;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import osm.controller.PatientFormController;
import osm.controller.TableController;
import osm.model.Patient;

public class PatientForm extends VBox implements PatientFormController { //TODO change Pane type
	
	private TableController tableController;
	
	Label nameLabel = new Label("Imiê:");
	TextField nameField = new TextField();
	
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
