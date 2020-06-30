package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import dao.ControlDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import model.activity_trail;
import model.users;
import utils.Controllers;
import utils.Utils;

public class dashboardController implements Initializable {
	
	@FXML
	private JFXButton btnLogout, btnActivity;
	
	@FXML
	private VBox mainVbox, vbox;

	public void initialize(URL location, ResourceBundle resources) {
		if(Utils.access.equals("User"))
			vbox.getChildren().remove(btnActivity);
		Controllers.getDataset(mainVbox);
	}

	@FXML
	public void dataset() {
		Controllers.getDataset(mainVbox);
	}
	
	@FXML
	public void activity_trail() {
		Controllers.getActivityTrailController(mainVbox);
	}
	
	@FXML
	public void edit_profile() {
		Controllers.getEditProfile(mainVbox);
	}
	
	@FXML
	public void barChart() {
		Controllers.getBarChart(mainVbox);
	}
	
	@FXML
	public void logout() throws SQLException {
		activity_trail activity = new activity_trail();
		users u = new users(Utils.idUser, Utils.full_name);
		activity.setActivity_name("Logout");
		activity.setUsers(u);
		ControlDAO.getControlDao().getActivityTrailDao().insertActivity(activity);
		Platform.exit();
	}
}
