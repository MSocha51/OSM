package osm.repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import osm.model.BloodPressureTest;
import osm.model.Patient;

public class PatientRepository {

	private Set<Patient> patients = new HashSet<>();

	public PatientRepository(){
		patients.addAll(Arrays.asList(
				new Patient("Matesz", "Socha", "950314", 'M', "NFZ", null),
				new Patient("Iza", "Plucinska", "951021", 'K', "NFZ", new BloodPressureTest())
				));
	}

	public Collection<Patient> getPatients() {
		return patients;
	}

	public void addPateint(Patient patient) {
		patients.add(patient);
	}
	
	public void changePateintOrAddByPesel(final String pesel,Patient patient){
		Patient changedPatient = getPatientByPeselAndRemove(pesel).orElse(patient);
		changedPatient.copyPropertiesWitoutTest(patient);
		addPateint(changedPatient);
		
	}

	public Optional<Patient> getPatientByPesel(final String pesel) {
		return patients.stream().filter((p) -> p.getPesel().equals(pesel)).findAny();
	}

	public void removePatientByPesel(final String pesel) {
		patients = patients.stream().filter(p -> !p.getPesel().equals(pesel)).collect(Collectors.toSet());
	}

	private Optional<Patient> getPatientByPeselAndRemove(String pesel) {
		Optional<Patient> patient = getPatientByPesel(pesel);
		patients.remove(patient.orElse(null));
		return patient;
	}
}
