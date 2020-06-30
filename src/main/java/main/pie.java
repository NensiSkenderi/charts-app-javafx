package main;

import java.sql.SQLException;

import dao.ControlDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class pie extends Application {

	@Override
	public void start(Stage primaryStage) throws SQLException {
		HBox root = new HBox();
		ObservableList<PieChart.Data> valueList = FXCollections.observableArrayList();

		valueList.addAll(ControlDAO.getControlDao().getCountryDao().getAll());
		// create a pieChart with valueList data.
		PieChart pieChart = new PieChart(valueList);
		pieChart.setTitle("Popularity of Mobile OS");
		//adding pieChart to the root.
		root.getChildren().addAll(pieChart);
		Scene scene = new Scene(root, 1800,1800);
		primaryStage.setTitle("Pie Chart Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}