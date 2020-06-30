package dao;

import java.sql.SQLException;

import javafx.scene.control.Alert.AlertType;
import model.users;
import utils.Utils;

public class users_dao extends DAO {


	public void add_user(users user) throws SQLException {

		String insert_user = "insert into simon_app.users (username,full_name,password,phone_number,email, access) values(?,?,?,?,?,?)";
		stm = connector.prepareStatement(insert_user);

		stm.setString(1, user.getUsername());
		stm.setString(2, user.getFull_name());
		stm.setString(3, Utils.encrypt(Utils.key, Utils.initVector, user.getPassword()));
		stm.setString(4, user.getPhone_number());
		stm.setString(5, user.getEmail());
		stm.setString(6, user.getAccess());

		stm.executeUpdate();
		stm.close();

	}

	public void update_user(users user) throws SQLException {
			String update_user = "update simon_app.users set full_name = ?, password = ?, phone_number = ?, email = ? where id = ?";
			stm = connector.prepareStatement(update_user);

			stm.setString(1, user.getFull_name());
			stm.setString(2, Utils.encrypt(Utils.key, Utils.initVector, user.getPassword()));
			stm.setString(3, user.getPhone_number());
			stm.setString(4, user.getEmail());
			stm.setInt(5, user.getId());
			
			stm.executeUpdate();
			stm.close();
	}

}
