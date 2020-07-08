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
		//here we add all country data to a list so that it will be displayed in the pie chart
		valueList.addAll(ControlDAO.getControlDao().getCountryDao().getAll());
		//here we create that pie chart
		PieChart pieChart = new PieChart(valueList);
		//add the pie chart to vbox (vbox is a FXML element, we can find it in the view)
		vbox.getChildren().add(pieChart);
		pieChart.prefHeightProperty().bind(vbox.heightProperty());
	}

}
