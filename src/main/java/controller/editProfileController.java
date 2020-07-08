package controller;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.ControlDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.users;
import utils.Utils;

public class editProfileController extends VBox {


	@FXML private JFXTextField txtUsername,txtFullName,txtPassword,txtConfirmPass,txtPhoneNumber,txtEmail;
	@FXML private JFXButton btnSave;
	@FXML private Label lblUsername,lblPassword,lblUpdate;

	public editProfileController() {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/editProfile.fxml"));

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
		lblUsername.setText(lblUsername.getText() + " " + Utils.username);
		lblPassword.setText(lblPassword.getText() + " " + Utils.password);
		txtUsername.setText(Utils.username);
		txtUsername.setDisable(true);
		txtPassword.setText(Utils.password);
		txtConfirmPass.setText(Utils.password);
		txtFullName.setText(Utils.full_name);
		txtPhoneNumber.setText(Utils.phone_number);
		txtEmail.setText(Utils.email);
	}

	@FXML
	private void saveChanges() throws SQLException {
		//user can not continue if he does not fill all the fields so we check if they are empty
		if(Utils.check_empty_text(txtUsername.getText(), txtPassword.getText(), txtFullName.getText())) {
			lblUpdate.setText("**Fill out all the fields!");	
			return;
		}
		//we check if passwords match
		if (!txtPassword.getText().toString().equals(txtConfirmPass.getText().toString())) {
			lblUpdate.setText("**Password does not match!"); 
			return;
		}

		//here we create a users object so that we can update our existing user with the values taken from the textfields
		users u = new users();
		u.setFull_name(txtFullName.getText());
		u.setUsername(txtUsername.getText());
		u.setPassword(txtPassword.getText());
		u.setEmail(txtEmail.getText());
		u.setPhone_number(txtPhoneNumber.getText());
		u.setId(Utils.idUser);
		
		//here we update this user
		ControlDAO.getControlDao().getUsersDao().update_user(u);
		lblUpdate.setText("**Profile Updated Successfully!"); 
		lblUpdate.setStyle("-fx-text-fill : #1dc22e;");
	}

}
