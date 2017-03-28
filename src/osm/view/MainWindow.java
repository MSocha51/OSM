package osm.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	private TestForm testForm;
	private PatientForm patientForm;
	private PatientTable patientTable;
	
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
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		createTies();
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
}
