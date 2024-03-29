package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import dao.ControlDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.users;
import utils.Utils;

public class register implements Initializable {

	@FXML private JFXTextField txtUsername,txtFullName,txtPassword,txtPhoneNumber,txtEmail;
	@FXML private JFXButton btnRegister;
	@FXML private Label lblError;
	@FXML private JFXCheckBox checkBoxAdmin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	@FXML
	private void registerUser() throws SQLException, IOException {
		if(Utils.check_empty_text(txtUsername.getText(), txtPassword.getText(), txtFullName.getText())) {
				lblError.setText("*Fill out all the fields!");	
			return;
		}
	
		//if username already exists, you should choose a new one
		if(ControlDAO.getControlDao().getLoginDao().check_username(txtUsername.getText())) {
			lblError.setText("*Warning! Username exists!");	
			return;
		}
		
		//we create the new user from the textfields
		users u = new users();
		u.setFull_name(txtFullName.getText());
		u.setUsername(txtUsername.getText());
		u.setPassword(txtPassword.getText());
		u.setEmail(txtEmail.getText());
		u.setPhone_number(txtPhoneNumber.getText());
		if(checkBoxAdmin.isSelected())
			u.setAccess("Admin");
		else
			u.setAccess("User");
		
		//we add this user in the database
		ControlDAO.getControlDao().getUsersDao().add_user(u);
		
		//now the user can login
		new Utils().openScene("login", btnRegister,"Login", false);
	}
	
	@FXML
	private void login() throws SQLException, IOException {
		new Utils().openScene("login", btnRegister,"Login", false);
	}
	
	@FXML
	private void close() throws SQLException, IOException {
		Platform.exit();
	}
	
	@FXML
	private void forgotPassword() throws IOException {
		new Utils().openScene("forgotPassword", btnRegister, "Forgot Password", false);
	}
}
