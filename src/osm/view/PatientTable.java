package osm.view;

import java.util.Collection;

import com.sun.glass.events.MouseEvent;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import osm.controller.PatientTableController;
import osm.model.Patient;
import osm.view.inter.PatientTableView;

public class PatientTable extends VBox implements PatientTableView {
	
	private PatientTableController tableController;
	private TableView<Patient> table;
	
	private Button addButton;
	private Button deleteButton;

	public PatientTable(PatientTableController tableController) {
		this.tableController=tableController;
		Label title = createTitle();
		table = createTable();
		Pane buttonPane = createButtonPane();
		getChildren().addAll(title, table, buttonPane);
	}

	private Label createTitle() {
		Label title = new Label("Pacienci");
		title.getStyleClass().add("title-label");
		return title;
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
		table.setOnMouseClicked(e->tableController.tableClicked(e));
		table.getColumns().addAll(nameColumn, surnameColumn, sexColumn, peselColumn, insuraceColumn, testColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.getStyleClass().add("table");
		return table;
	}

	private Pane createButtonPane() {
		HBox pane = new HBox();
		addButton = new Button("Dodaj Pacienta");
		addButton.addEventHandler(ActionEvent.ACTION,tableController);
		deleteButton = new Button("Usuń Pacienta");
		deleteButton.addEventHandler(ActionEvent.ACTION,tableController);	
		pane.getChildren().addAll(addButton, deleteButton);
		return pane;
	}

	@Override
	public void reloadTable(Collection<Patient> patients) {
		table.setItems(FXCollections.observableArrayList(patients));
	}
	@Override
	public Patient getActivePatient() {
		return table.getSelectionModel().getSelectedItem();
	}
	@Override
	public void clearActivePatient() {
		table.getSelectionModel().select(null);
	}
	@Override
	public void setActivePatient(Patient patient) {
		table.getSelectionModel().select(patient);		
	}
	@Override
	public void refresh(){
		table.refresh();
	}
	public PatientTableController getTableController() {
		return tableController;
	}

	public void setTableController(PatientTableController tableController) {
		this.tableController = tableController;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public TableView<Patient> getTable() {
		return table;
	}


}
