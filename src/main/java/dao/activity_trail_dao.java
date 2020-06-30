package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.activity_trail;
import model.users;

public class activity_trail_dao extends DAO {

	public activity_trail_dao() {
		super();
	}
	
	public List<activity_trail> getAllActivityTrail() throws SQLException{
		List<activity_trail> data = new ArrayList<activity_trail>();
		String query = "select a.id, activity_name, date_time, u.id, u.username from simon_app.activity_trail a join simon_app.users u on a.user_id = u.id "
				+ "order by date_time";
		stm = connector.prepareStatement(query);
		rs = stm.executeQuery(query); 
		
		while(rs.next()) {
			users u = new users(rs.getInt(4),rs.getString(5));
			
			activity_trail a = new activity_trail();
			a.setId(rs.getInt(1));
			a.setActivity_name(rs.getString(2));
			a.setCreated_date(rs.getTimestamp(3));
			a.setUsers(u);
			
			data.add(a);
		}
		return data;
	}
	
	public void insertActivity(activity_trail activity_trail) throws SQLException {

		String insert = "insert into simon_app.activity_trail(activity_name,user_id) values(?,?)";
		stm = connector.prepareStatement(insert);

		stm.setString(1, activity_trail.getActivity_name());
		stm.setInt(2, activity_trail.getUsers().getId());
		
		stm.executeUpdate();
		stm.close();
	}
	
}
