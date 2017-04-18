package osm.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	private Set<Patient> patients;

	public PatientRepository() {
		
		try {
			File file = new File("./resources/patients");
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Object object = input.readObject();
			if(object instanceof HashSet){
				patients = (HashSet) object;
				input.close();
			}
			else{
				input.close();
				throw new IOException("Nie udało się odczytać pacientów");
			}
		} catch (IOException e) {
			e.printStackTrace();
			patients = new HashSet<>();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public Collection<Patient> getPatients() {
		return patients;
	}

	public void addPateint(final Patient patient) {
		patients.add(patient);
	}

	public Optional<Patient> getPatientByPesel(final String pesel) {
		return patients.stream().filter((p) -> p.getPesel().equals(pesel)).findAny();
	}

	public void removePatient(final Patient patient) {
		patients.remove(patient);
	}

	// Nie uzywane

	public void changePateintOrAddByPesel(final String pesel, Patient patient) {
		Patient changedPatient = getPatientByPeselAndRemove(pesel).orElse(patient);
		changedPatient.copyPropertiesWitoutTest(patient);
		addPateint(changedPatient);

	}

	public void removePatientByPesel(final String pesel) {
		patients = patients.stream().filter(p -> !p.getPesel().equals(pesel)).collect(Collectors.toSet());
	}

	private Optional<Patient> getPatientByPeselAndRemove(String pesel) {
		Optional<Patient> patient = getPatientByPesel(pesel);
		patients.remove(patient.orElse(null));
		return patient;
	}

	public void persist() throws FileNotFoundException, IOException {		
			File file = new File("./resources/patients.");
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(patients);
			output.flush();
			output.close();
	}
}
