package osm.controller;

import osm.model.BloodPressureTest;
import osm.model.Patient;

public interface TableController {
	public void addPatient(Patient patient);
	public void addTest(BloodPressureTest test);
}
