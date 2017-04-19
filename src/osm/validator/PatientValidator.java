package osm.validator;

import java.util.regex.Pattern;

import osm.model.Patient;

public class PatientValidator {
	
	static public boolean valid(Patient patient){
		if(!Pattern.matches("[A-ZĄĘŻŹÓŁĆŃ][a-ząężźółćń]*", patient.getName())) return false;
		return true;
	}

}
