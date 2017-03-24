package osm.view;

import javafx.scene.layout.Pane;
import osm.controller.PatientFormController;
import osm.controller.TableController;
import osm.model.Patient;

public class PatientForm extends Pane implements PatientFormController { //TODO change Pane type
	
	private TableController tableController;

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
