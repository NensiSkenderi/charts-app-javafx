package utils;

import java.io.IOException;
import java.sql.SQLException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import dao.ControlDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.activity_trail;
import model.users;

public class Utils {

	public static String key = "SimoSimoSimoSimo",initVector = "RandomInitVector"; 
	public static int idUser = 0;
	public static String full_name = "",username = "", access = "", password = "", phone_number = "", email = "";


	public static boolean check_empty_text(String... strings) {
		for(String s : strings)
			if(s == null || s.isEmpty())
				return true;

		return false;
	}

	public static void alert(String title, String text, AlertType type) {
		Alert alert = new Alert (type,text);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	public static String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());

			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public void openScene(String view_name, Button btn, String title, boolean resizable) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/"+ view_name +".fxml")); 
		Parent root=(Parent)loader.load();
		Scene scene = new Scene(root);
		Stage old_stage = (Stage)btn.getScene().getWindow();
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.getIcons().add(new Image("/images/icon.png"));
		old_stage.close();
		if(view_name == "dashboard") {
			stage.setOnCloseRequest( e-> {
				activity_trail activity = new activity_trail();
				users u = new users(Utils.idUser, Utils.full_name);
				activity.setActivity_name("Logout");
				activity.setUsers(u);
				try {
					ControlDAO.getControlDao().getActivityTrailDao().insertActivity(activity);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
		}
		stage.setResizable(resizable);
		stage.setTitle(title);
		stage.show();

	}

}
