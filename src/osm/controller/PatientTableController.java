package osm.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import osm.model.Patient;
import osm.repository.PatientRepository;
import osm.view.PatientTable;
import osm.view.inter.PatientFormView;
import osm.view.inter.PatientTableView;
import osm.view.inter.TestFormView;

public class PatientTableController implements EventHandler<ActionEvent> {
	
	private PatientTable tableView;
	private PatientFormView patientFormView;
	private TestFormView testFormView;
	private PatientRepository patientRepository;
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource()==tableView.getAddButton()){
			patientFormView.clearForm();
			testFormView.clearForm();
			tableView.clearActivePatient();
		}
		if(event.getSource()==tableView.getDeleteButton()){
			Patient activePatient = tableView.getActivePatient();
			patientRepository.removePatient(activePatient);
			tableView.clearActivePatient();
			tableView.reloadTable(patientRepository.getPatients());
			
		}
	}

	public PatientTable getTableView() {
		return tableView;
	}

	public void setTableView(PatientTable tableView) {
		this.tableView = tableView;
	}

	public PatientFormView getPatientFormView() {
		return patientFormView;
	}

	public void setPatientFormView(PatientFormView patientFormView) {
		this.patientFormView = patientFormView;
	}

	public TestFormView getTestFormView() {
		return testFormView;
	}

	public void setTestFormView(TestFormView testFormView) {
		this.testFormView = testFormView;
	}

	public PatientRepository getPatientRepository() {
		return patientRepository;
	}

	public void setPatientRepository(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	

}
