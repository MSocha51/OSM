package osm.view.inter;

import osm.model.Patient;

public interface PatientFormView {
	public void clearForm();
	public void setPatient(Patient patient);
	public Patient getPatient();
	public void setDisable(boolean value);
}
