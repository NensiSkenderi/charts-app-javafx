package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import dao.ControlDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import model.activity_trail;

public class barChartController extends VBox {

	@FXML private VBox vbox;
	@FXML private BarChart<String, Number> barChart;

	public barChartController() {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/barChart.fxml"));

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
		ObservableList<XYChart.Data<String, Number>> data = ControlDAO.getControlDao().getCountryDao().getAllBarChart();
		XYChart.Series<String, Number> series = new XYChart.Series<>("Countries", data);
		barChart.getData().setAll(series);
		barChart.prefHeightProperty().bind(vbox.heightProperty());

	}

}
