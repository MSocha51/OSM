package osm.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import osm.view.PatientForm;
import osm.view.TestForm;
import osm.view.inter.PatientTableView;
import osm.view.inter.TestFormView;

public class PatientFormController implements EventHandler<ActionEvent> {

	private PatientForm patientForm;
	private PatientTableView patientTable;
	private TestFormView testForm;
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==patientForm.getCancelButton()){
			patientForm.clearForm();
			patientTable.clearActivePatient();
			testForm.clearForm();
		}
		
	}
	public PatientForm getPatientForm() {
		return patientForm;
	}
	public void setPatientForm(PatientForm patientForm) {
		this.patientForm = patientForm;
	}
	public PatientTableView getPatientTable() {
		return patientTable;
	}
	public void setPatientTable(PatientTableView patientTable) {
		this.patientTable = patientTable;
	}
	public TestFormView getTestForm() {
		return testForm;
	}
	public void setTestForm(TestFormView testForm) {
		this.testForm = testForm;
	}
	

}
