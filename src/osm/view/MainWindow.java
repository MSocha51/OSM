package osm.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import osm.controller.PatientTableController;
import osm.repository.PatientRepository;

public class MainWindow extends Application{
	
	private TestForm testForm;
	private PatientForm patientForm;
	private PatientTable patientTable;
	
	private PatientTableController patientTableController;
	
	private PatientRepository pateintRepository;

	
	static public void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		createControllers();
		createTies();		
		createRepository();
		injectDependancy();
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10,10,10,10));
		root.add(patientForm,0,0);
		root.add(patientTable,1,0,4,2);
		root.add(testForm, 0, 1);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Badania Pacientów");
		primaryStage.setScene(scene);
		scene.getStylesheets().add
		 (MainWindow.class.getResource("/Style.css").toExternalForm());
		primaryStage.show();		
	}
	private void createControllers() {
		patientTableController = new PatientTableController();
		
	}	


	private void createTies(){
		testForm = new TestForm();
		patientForm = new PatientForm();
		patientTable = new PatientTable(patientTableController);
	}
	
	private void createRepository() {
		pateintRepository = new PatientRepository();
		
	}
	
	private void injectDependancy() {
		patientTableController.setTableView(patientTable);
		patientTableController.setPatientRepository(pateintRepository);
		patientTableController.setPatientFormView(patientForm);
		patientTableController.setTestFormView(testForm);
		
	}
}

