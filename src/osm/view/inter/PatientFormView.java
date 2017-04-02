package osm.view.inter;

import osm.model.Patient;

public interface PatientFormView {
	public void clearForm();
	public void setPateint(Patient pateint);
	public Patient getPateint();
}
