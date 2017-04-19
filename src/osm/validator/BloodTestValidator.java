package osm.validator;

import java.util.regex.Pattern;

import osm.model.BloodPressureTest;

public class BloodTestValidator {

	static public boolean valid(BloodPressureTest test){
		if(!Pattern.matches("[0-9]+", test.getDiastole().toString())) return false;
		if(!Pattern.matches("[0-9]+", test.getSystole().toString())) return false;
		return true;
	}
}