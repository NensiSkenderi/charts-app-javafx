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
import model.users;
import utils.Utils;

public class newPassword implements Initializable {
	
	@FXML private JFXTextField txtPassword;
	@FXML private Label lblError;
	@FXML private JFXButton btnSave;
	
	@FXML
	private void save() throws SQLException, IOException {
		if(Utils.check_empty_text(txtPassword.getText())) {
			lblError.setText("*Fill in the new password!");	
		return;
	}
		else {
			users u = new users();
			u.setPassword(txtPassword.getText());
			u.setId(Utils.idUser);
			ControlDAO.getControlDao().getUsersDao().update_password(u);
			new Utils().openScene("register", btnSave,"register");
		}
	}
	
	@FXML
	private void cancel() throws IOException {
		new Utils().openScene("register", btnSave,"register");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
