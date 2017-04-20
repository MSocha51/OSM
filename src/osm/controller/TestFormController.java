package osm.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import osm.model.BloodPressureTest;
import osm.validator.BloodTestValidator;
import osm.view.PatientForm;
import osm.view.TestForm;
import osm.view.inter.PatientFormView;
import osm.view.inter.PatientTableView;

public class TestFormController implements EventHandler<ActionEvent> {

	private TestForm testForm;
	private PatientTableView patientTable;
	private PatientFormView patientForm;

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == testForm.getCancelButton())
			cancelAction();
		if (event.getSource() == testForm.getSaveButton())
			saveAction();
	}

	private void cancelAction() {
		patientForm.clearForm();
		patientForm.setDisable(true);
		patientTable.clearActivePatient();
		testForm.clearForm();
		testForm.setDisable(true);
	}

	private void saveAction() {		
		BloodPressureTest test = testForm.getTest();
		if(BloodTestValidator.valid(test)){
			patientTable.getActivePatient().setBloodPressureTest(test);
			patientTable.refresh();
			testForm.setTest(test);
			testForm.setMessage("Badanie dodane", Color.BLACK);
		}else{
			testForm.setMessage("Błedne dane", Color.RED);
		}

	}

	public TestForm getTestForm() {
		return testForm;
	}

	public void setTestForm(TestForm testForm) {
		this.testForm = testForm;
	}

	public PatientTableView getPatientTable() {
		return patientTable;
	}

	public void setPatientTable(PatientTableView patientTable) {
		this.patientTable = patientTable;
	}

	public PatientFormView getPatientForm() {
		return patientForm;
	}

	public void setPatientForm(PatientFormView patientForm) {
		this.patientForm = patientForm;
	}

}
