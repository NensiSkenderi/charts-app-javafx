package controller;

import java.io.IOException;

import dao.ControlDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;

public class datasetController extends VBox {

	@FXML private VBox vbox;

	private ObservableList<PieChart.Data> valueList = FXCollections.observableArrayList();

	public datasetController() {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/dataset.fxml"));

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
		valueList.addAll(ControlDAO.getControlDao().getCountryDao().getAll());
		PieChart pieChart = new PieChart(valueList);
		vbox.getChildren().add(pieChart);
		pieChart.prefHeightProperty().bind(vbox.heightProperty());
	}

}
