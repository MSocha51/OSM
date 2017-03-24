package osm.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import osm.model.Patient;

public class PatientRepository {
	
	private Set<Patient> patients = new HashSet<>();
	
	public Set<Patient> getPatients(){
		return patients;
	}
	
	public void addPateint(Patient patient){
		patients.add(patient);
	}
	
	public Optional<Patient> getPatientByPesel(final String pesel){
		return patients.stream()
			.filter((p)->p.getPesel().equals(pesel))
			.findAny();
	}
}
