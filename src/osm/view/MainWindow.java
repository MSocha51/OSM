package osm.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import osm.controller.PatientFormController;
import osm.controller.PatientTableController;
import osm.controller.TestFormController;
import osm.repository.PatientRepository;

public class MainWindow extends Application {

	private TestForm testForm;
	private PatientForm patientForm;
	private PatientTable patientTable;

	private PatientTableController patientTableController;
	private PatientFormController patientFormController;
	private TestFormController testFormController;
	private PatientRepository patientRepository;

	static public void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		createControllers();
		createTies();
		createRepository();
		injectDependancy();
		patientTable.reloadTable(patientRepository.getPatients());
		Pane root = createRootPane();		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Badania Pacientów");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(MainWindow.class.getResource("/Style.css").toExternalForm());
		primaryStage.show();
	}

	private void createControllers() {
		patientTableController = new PatientTableController();
		patientFormController = new PatientFormController();
		testFormController = new TestFormController();

	}

	private void createTies() {
		testForm = new TestForm(testFormController);
		patientForm = new PatientForm(patientFormController);
		patientTable = new PatientTable(patientTableController);
		patientForm.setDisable(true);
		testForm.setDisable(true);
	}

	private void createRepository() {
		patientRepository = new PatientRepository();

	}

	private void injectDependancy() {
		patientTableController.setTableView(patientTable);
		patientTableController.setPatientRepository(patientRepository);
		patientTableController.setPatientFormView(patientForm);
		patientTableController.setTestFormView(testForm);

		testFormController.setPatientForm(patientForm);
		testFormController.setPatientTable(patientTable);
		testFormController.setTestForm(testForm);

		patientFormController.setPatientForm(patientForm);
		patientFormController.setPatientTable(patientTable);
		patientFormController.setTestForm(testForm);
		patientFormController.setPatientRepository(patientRepository);

	}

	private Pane createRootPane() {
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.add(patientForm, 0, 0);
		root.add(patientTable, 1, 0, 4, 2);
		root.add(testForm, 0, 1);
		return root;
	}

	@Override
	public void stop() {
		try {
			patientRepository.persist();
		} catch (IOException e) {
			System.out.println("Nie udało się zapisać pacientów");
			e.printStackTrace();
		}
	}
}
