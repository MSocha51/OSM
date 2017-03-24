package osm.view;

import javafx.scene.layout.Pane;
import osm.controller.TableController;
import osm.controller.TestFormController;
import osm.model.BloodPressureTest;

public class TestForm extends Pane implements TestFormController { //TODO change Pane type
	
	private TableController tableController;

	@Override
	public void clearForm() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTest(BloodPressureTest test) {
		// TODO Auto-generated method stub

	}

	public TableController getTableController() {
		return tableController;
	}

	public void setTableController(TableController tableController) {
		this.tableController = tableController;
	}
	
	

}
