package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.ControlDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.activity_trail;

public class activityTrailController extends VBox {

	@FXML private TableView<activity_trail> tblActivityTrail;
	@FXML private TableColumn<activity_trail, String> tblcolActivityTrailId, tblcolActivityTrailName, tblcolCreatedDate, tblcolUser;
	@FXML private VBox root;
	
	public ObservableList<activity_trail> data = FXCollections.observableArrayList();
	
	public activityTrailController() {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/activityTrail.fxml"));

		fxml.setRoot(this);
		fxml.setController(this);
		try {
			fxml.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void initialize() throws Exception {
		populateTable();
	}
	
	private void populateTable() throws SQLException {
		tblActivityTrail.getItems().clear();
		data.addAll(ControlDAO.getControlDao().getActivityTrailDao().getAllActivityTrail());
		
		tblcolActivityTrailId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tblcolActivityTrailName.setCellValueFactory(new PropertyValueFactory<>("activity_name"));
		tblcolCreatedDate.setCellValueFactory(new PropertyValueFactory<>("created_date"));
		tblcolUser.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<activity_trail, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<activity_trail, String> obj) {
				return new SimpleStringProperty(obj.getValue().getUsers().getUsername());
			}
		});
		tblActivityTrail.setItems(data);
	}
	
}
