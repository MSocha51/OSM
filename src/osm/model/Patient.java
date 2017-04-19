package osm.model;

import java.io.Serializable;

/**
 * Class that represent patient in data storage.
 * 
 * 
 *
 */
public class Patient implements Serializable{

	private static final long serialVersionUID = 6236272868861085741L;
	private String name;
	private String surname;
	private String pesel;
	private String sex;
	private String insurance;
	private BloodPressureTest bloodPressureTest;
	
	

	public Patient(String name, String surname, String pesel, String sex, String insurance, BloodPressureTest test) {
		this.name = name;
		this.surname = surname;
		this.pesel = pesel;
		this.sex = sex;
		this.insurance = insurance;
		this.bloodPressureTest=test;
	}

	public Patient() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	
	public BloodPressureTest getBloodPressureTest() {
		return bloodPressureTest;
	}

	public void setBloodPressureTest(BloodPressureTest bloodPressureTest) {
		this.bloodPressureTest = bloodPressureTest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((insurance == null) ? 0 : insurance.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Patient other = (Patient) obj;
		if (insurance == null) {
			if (other.insurance != null)
				return false;
		} else if (!insurance.equals(other.insurance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", surname=" + surname + ", pesel=" + pesel + ", sex=" + sex + ", insurance="
				+ insurance + "]";
	}

	public void copyPropertiesWitoutTest(Patient patient) {
		this.setName(patient.getName());
		this.setSurname(patient.getSurname());
		this.setPesel(patient.getPesel());
		this.setSex(patient.getSex());
		this.setInsurance(patient.getInsurance());
	}

}
