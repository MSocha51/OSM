package osm.view.inter;

import java.util.Collection;
import osm.model.Patient;

public interface PatientTableView {
	public void reloadTable(Collection<Patient> patients);
	public Patient getActivePatient();
}