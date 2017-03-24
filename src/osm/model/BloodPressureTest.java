package osm.model;

/**
 * Class that represend patient blood pressure test.
 * 
 * @author msoch
 *
 */
public class BloodPressureTest {

	public Integer systole; // skurczowe
	public Integer diastole; // rozkurczowe

	public Integer getSystole() {
		return systole;
	}

	public void setSystole(Integer systole) {
		this.systole = systole;
	}

	public Integer getDiastole() {
		return diastole;
	}

	public void setDiastole(Integer diastole) {
		this.diastole = diastole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diastole == null) ? 0 : diastole.hashCode());
		result = prime * result + ((systole == null) ? 0 : systole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BloodPressureTest other = (BloodPressureTest) obj;
		if (diastole == null) {
			if (other.diastole != null)
				return false;
		} else if (!diastole.equals(other.diastole))
			return false;
		if (systole == null) {
			if (other.systole != null)
				return false;
		} else if (!systole.equals(other.systole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BloodPressureTest [systole=" + systole + ", diastole=" + diastole + "]";
	}

}
