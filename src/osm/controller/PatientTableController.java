package osm.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import osm.model.Patient;
import osm.repository.PatientRepository;
import osm.view.PatientTable;
import osm.view.inter.PatientFormView;
import osm.view.inter.TestFormView;

public class PatientTableController implements EventHandler<Event> {

	private PatientTable tableView;
	private PatientFormView patientFormView;
	private TestFormView testFormView;
	private PatientRepository patientRepository;

	@Override
	public void handle(Event event) {
		if (event.getSource() == tableView.getAddButton()) {
			patientFormView.clearForm();
			testFormView.clearForm();
			tableView.clearActivePatient();
			patientFormView.setDisable(false);
			testFormView.setDisable(true);
		}
		if (event.getSource() == tableView.getDeleteButton()) {
			Patient activePatient = tableView.getActivePatient();
			patientRepository.removePatient(activePatient);
			tableView.clearActivePatient();
			tableView.reloadTable(patientRepository.getPatients());
			testFormView.setDisable(true);
			patientFormView.setDisable(true);
		}
	}

	public void tableClicked(MouseEvent e) {
		Patient patient = tableView.getTable().getSelectionModel().getSelectedItem();
		if (patient != null) {
			patientFormView.setPatient(patient);
			if (patient.getBloodPressureTest() != null)
				testFormView.setTest(patient.getBloodPressureTest());
			else{
				testFormView.clearForm();
			}
			testFormView.setDisable(false);
			patientFormView.setDisable(false);
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
