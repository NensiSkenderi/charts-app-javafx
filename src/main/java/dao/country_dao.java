package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;

public class country_dao extends DAO {

	public country_dao() {
		super();
	}
	
	public List<Data> getAll() throws SQLException{
		List<Data> data = new ArrayList<Data>();
		String query = "SELECT  count( country), country  FROM simon_app.country group by country order by country;";
		stm = connector.prepareStatement(query);
		rs = stm.executeQuery(query); 
		while(rs.next()) {
			data.add(new Data(rs.getString(2), rs.getDouble(1)));
		}
		return data;
	}
	
	public ObservableList<XYChart.Data<String, Number>> getAllBarChart() throws SQLException{
		ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
		String query = "SELECT  count( country), country  FROM simon_app.country group by country order by country;";
		stm = connector.prepareStatement(query);
		rs = stm.executeQuery(query);
		while(rs.next()) {
			String item= rs.getString(2);
			double count = rs.getDouble(1);
			data.add(new XYChart.Data<>(item, count));
		}
		return data;
	}
	
}
