package controller;

import java.io.IOException;
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
		//here we check the user rights because only Admin can se the Activity
		//if user has User rights then we remove the button to see the activity
		if(Utils.access.equals("User"))
			vbox.getChildren().remove(btnActivity);
		Controllers.getDataset(mainVbox);
	}

	//here we open the dataset view
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
	public void logout() throws SQLException, IOException {
		activity_trail activity = new activity_trail();
		users u = new users(Utils.idUser, Utils.full_name);
		activity.setActivity_name("Logout");
		activity.setUsers(u);
		ControlDAO.getControlDao().getActivityTrailDao().insertActivity(activity);
		new Utils().openScene("register", btnLogout, "Register", false);
	}
}
