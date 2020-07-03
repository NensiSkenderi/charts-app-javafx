package dao;

import java.sql.SQLException;

import utils.Utils;


public class login_dao extends DAO {

	public login_dao() {
		super();
	}

	public String get_pass() throws SQLException {
		String pass = "";
		String sql = "SELECT password FROM simon_app.users where userid = '"+Utils.idUser+"' ";
		stm = connector.prepareStatement(sql);
		rs = stm.executeQuery(sql);

		while(rs.next()) {
			pass =  Utils.decrypt(Utils.key, Utils.initVector, rs.getString(1));
		}
		return pass;
	}

	public boolean check_user_and_pass(String user,String pass) {
		String sql = "SELECT username, password, id , full_name, access, phone_number, email from simon_app.users  WHERE username = ? and password = ? ";
		try {
			stm = connector.prepareStatement(sql);
			stm.setString(1, user);
			stm.setString(2, pass);
			rs = stm.executeQuery();

			while(rs.next()) {
				Utils.username = rs.getString(1);
				Utils.password = Utils.decrypt(Utils.key, Utils.initVector, rs.getString(2));
				Utils.idUser = rs.getInt(3);
				Utils.full_name = rs.getString(4);
				Utils.access = rs.getString(5);
				Utils.phone_number = rs.getString(6);
				Utils.email = rs.getString(7);
				return rs.getString(1).equals(user) && rs.getString(2).equals(pass);
			}
			stm.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean check_user_and_fullName(String username,String fullName) {
		String sql = "SELECT username, id, full_name from simon_app.users  WHERE username = ? and full_name = ?";
		try {
			stm = connector.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, fullName);
			rs = stm.executeQuery();

			while(rs.next()) {
				Utils.username = rs.getString(1);
				Utils.idUser = rs.getInt(2);
				Utils.full_name = rs.getString(3);
				return rs.getString(1).equals(username) && rs.getString(3).equals(fullName);
			}
			stm.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}
	
	public boolean check_username(String username) throws SQLException {
		String query = "select * from simon_app.users where username = '"+username+"'";
		stm = connector.prepareStatement(query);
		rs = stm.executeQuery();
		if(rs.next() == true)
			return true;
		else 
			return false;
	}

}
