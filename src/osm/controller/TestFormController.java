package osm.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import osm.model.BloodPressureTest;
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
		if (event.getSource()==testForm.getCancelButton()){
			patientForm.clearForm();
			patientForm.setDisable(true);
			patientTable.clearActivePatient();
			testForm.clearForm();
			testForm.setDisable(true);
		}
		if(event.getSource()==testForm.getSaveButton()){
			BloodPressureTest test = testForm.getTest();
			patientTable.getActivePatient().setBloodPressureTest(test);
			patientTable.refresh();
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
