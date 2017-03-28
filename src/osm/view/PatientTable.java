package osm.view;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import osm.controller.PatientFormController;
import osm.controller.TableController;
import osm.controller.TestFormController;
import osm.model.BloodPressureTest;
import osm.model.Patient;

public class PatientTable extends VBox implements TableController {
	private ObservableList<Patient> data = FXCollections.observableArrayList(
			new Patient("Matesz", "Socha", "950314", 'M', "NFZ", null),
			new Patient("Iza", "Plucinska", "951021", 'K', "NFZ", new BloodPressureTest()));

	private PatientFormController pateintForm;
	private TestFormController testForm;

	private TableView<Patient> table;

	public PatientTable() {
		Label title = new Label("Pacienci");
		title.getStyleClass().add("title-label");

		table = createTable();

		getChildren().addAll(title, table);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private TableView<Patient> createTable() {
		TableView<Patient> table = new TableView<>();
		table.setEditable(false);

		TableColumn nameColumn = new TableColumn("Imię");
		nameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
		TableColumn surnameColumn = new TableColumn("Nazwisko");
		surnameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("surname"));
		TableColumn sexColumn = new TableColumn("Płeć");
		sexColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("sex"));
		TableColumn peselColumn = new TableColumn("PESEL");
		peselColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("pesel"));
		TableColumn insuraceColumn = new TableColumn("Ubezpieczenie");
		insuraceColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("insurance"));
		TableColumn testColumn = new TableColumn("Badanie");
		testColumn.setCellValueFactory(new Callback<CellDataFeatures<Patient, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Patient, String> param) {
				return new ReadOnlyObjectWrapper(param.getValue().getBloodPressureTest() == null ? "NIE" : "TAK");
			}
		});

		table.setItems(data);
		table.getColumns().addAll(nameColumn, surnameColumn, sexColumn, peselColumn, insuraceColumn,testColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		return table;
	}

	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTest(BloodPressureTest test) {
		// TODO Auto-generated method stub

	}

	public PatientFormController getPateintForm() {
		return pateintForm;
	}

	public void setPateintForm(PatientFormController pateintForm) {
		this.pateintForm = pateintForm;
	}

	public TestFormController getTestForm() {
		return testForm;
	}

	public void setTestForm(TestFormController testForm) {
		this.testForm = testForm;
	}

}
