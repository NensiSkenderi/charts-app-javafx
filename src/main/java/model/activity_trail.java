package model;

import java.sql.Timestamp;

public class activity_trail {

	private int id;
	private String activity_name;
	private users users;
	private Timestamp created_date;
	
	public activity_trail(int id, String activity_name, users users, Timestamp created_date) {
		this.id = id;
		this.activity_name = activity_name;
		this.users = users;
		this.created_date = created_date;
	}

	public activity_trail(String activity_name, users users, Timestamp created_date) {
		this.activity_name = activity_name;
		this.users = users;
		this.created_date = created_date;
	}

	public activity_trail() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public users getUsers() {
		return users;
	}

	public void setUsers(users users) {
		this.users = users;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	
	
}
