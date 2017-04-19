package osm.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import osm.model.Patient;
import osm.repository.PatientRepository;
import osm.validator.PatientValidator;
import osm.view.PatientForm;
import osm.view.TestForm;
import osm.view.inter.PatientTableView;
import osm.view.inter.TestFormView;

public class PatientFormController implements EventHandler<ActionEvent> {

	private PatientForm patientForm;
	private PatientTableView patientTable;
	private TestFormView testForm;
	private PatientRepository patientRepo;

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == patientForm.getCancelButton()) {
			patientForm.clearForm();
			patientForm.setDisable(true);
			patientTable.clearActivePatient();
			testForm.clearForm();
			testForm.setDisable(true);
		}
		if (event.getSource() == patientForm.getSaveButton()) {
			Patient patient = patientForm.getPatient();
			if(PatientValidator.valid(patient)){
				Patient selectedPatient = patientTable.getActivePatient();
				if (selectedPatient != null) {
					patientRepo.removePatient(selectedPatient);
					patient.setBloodPressureTest(selectedPatient.getBloodPressureTest());
				}
				patientRepo.addPateint(patient);
				patientTable.reloadTable(patientRepo.getPatients());
				patientTable.setActivePatient(patient);
				testForm.setDisable(false);
				if (patient.getBloodPressureTest() != null)
					testForm.setTest(patient.getBloodPressureTest());
			}else{
				System.out.println("Mamy problem");
			}
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

	public PatientRepository getPatientRepository() {
		return patientRepo;
	}

	public void setPatientRepository(PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}

}
