package osm.view.inter;

import osm.model.BloodPressureTest;

public interface TestFormView {
	public void clearForm();
	public void setTest(BloodPressureTest test);
	public BloodPressureTest getTest();
	public void setDisable(boolean value);

}
