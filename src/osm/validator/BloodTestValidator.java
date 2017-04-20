package osm.validator;

import java.util.regex.Pattern;

import osm.model.BloodPressureTest;

public class BloodTestValidator {

	static public boolean valid(BloodPressureTest test){
		if(test.getDate()==null) return false;
		if(test.getDiastole()==null || !Pattern.matches("[0-9]+", test.getDiastole().toString())) return false;
		if(test.getDiastole()==null || !Pattern.matches("[0-9]+", test.getSystole().toString())) return false;
		return true;
	}
}