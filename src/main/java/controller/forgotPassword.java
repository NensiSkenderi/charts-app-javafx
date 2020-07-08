package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.ControlDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utils.Utils;

public class forgotPassword implements Initializable {

	@FXML private JFXTextField txtUsername, txtFullName;
	@FXML private Label lblError;
	@FXML private JFXButton btnSubmit;

	@FXML
	private void submit() throws SQLException, IOException {
		if(Utils.check_empty_text(txtUsername.getText(), txtFullName.getText())) {
			lblError.setText("*Fill out all the fields!");	
			return;
		}

		//check if the user really knows his info, and then he can ask for a new Password
		if(ControlDAO.getControlDao().getLoginDao().check_user_and_fullName(txtUsername.getText(), txtFullName.getText())) {
			new Utils().openScene("newPassword", btnSubmit, "New Password", false);	
			return;
		}

		else {
			lblError.setText("Full Name or Username incorrect!");
		}
	}

	@FXML
	private void cancel() throws IOException {
		new Utils().openScene("register", btnSubmit,"Register", false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

}
