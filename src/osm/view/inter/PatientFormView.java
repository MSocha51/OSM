package osm.view.inter;

import javafx.scene.paint.Color;
import osm.model.Patient;

public interface PatientFormView {
	public void clearForm();
	public void setPatient(Patient patient);
	public Patient getPatient();
	public void setDisable(boolean value);
	public void setMessage(String msssage, Color color);
}
