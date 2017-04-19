package osm.validator;

import java.util.regex.Pattern;

import osm.model.Patient;

public class PatientValidator {
	
	static public boolean valid(Patient patient){
		if(!Pattern.matches("[A-ZĄĘŻŹÓŁĆŃ][a-ząężźółćń]*", patient.getName())) return false;
		if(!Pattern.matches("[A-ZĄĘŻŹÓŁĆŃ][a-ząężźółćń]*", patient.getSurname())) return false;
		if(!Pattern.matches("[0-9]{11}", patient.getPesel())) return false;
		if(!Pattern.matches("[KM]?", patient.getSex())) return false;
		return true;
	}

}
