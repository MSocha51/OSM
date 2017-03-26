package osm.view;

import javafx.stage.Window;

public class MainWindow extends Window{
	
	private TestForm testForm;
	private PatientForm patientForm;
	private PatientTable patientTable;

	public MainWindow(){
		createTies();
		injectDependancy();
		//TODO add everything layout,etc
		
	}
	
	private void createTies(){
		testForm = new TestForm();
		patientForm = new PatientForm();
		patientTable = new PatientTable();
	}
	
	private void injectDependancy() {
		testForm.setTableController(patientTable);
		patientForm.setTableController(patientTable);		
		patientTable.setPateintForm(patientForm);
		patientTable.setTestForm(testForm);
	}
	
	static public void main(String args[]){
		new MainWindow();
	}
}
