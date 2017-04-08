package osm.view.inter;

import java.util.Collection;
import osm.model.Patient;

public interface PatientTableView {
	public void reloadTable(Collection<Patient> patients);
	public Patient getActivePatient();
	public void clearActivePatient();
	public void setActivePatient(Patient patient);
	public void refresh();
}
