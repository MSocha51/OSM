package osm.view;

import javafx.scene.layout.Pane;
import osm.controller.PatientFormController;
import osm.controller.TableController;
import osm.controller.TestFormController;
import osm.model.BloodPressureTest;
import osm.model.Patient;

public class PatientTable extends Pane implements TableController { //TODO change Pane type
	
	private PatientFormController pateintForm;
	private TestFormController testForm;

	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTest(BloodPressureTest test) {
		// TODO Auto-generated method stub

	}

	public PatientFormController getPateintForm() {
		return pateintForm;
	}

	public void setPateintForm(PatientFormController pateintForm) {
		this.pateintForm = pateintForm;
	}

	public TestFormController getTestForm() {
		return testForm;
	}

	public void setTestForm(TestFormController testForm) {
		this.testForm = testForm;
	}
	
	
}
