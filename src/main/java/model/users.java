package model;

public class users {

	private int id;
	private String username, password, full_name, phone_number, email, access;
	
	public users(int id, String username, String password, String full_name, String phone_number, String email, String access) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.full_name = full_name;
		this.phone_number = phone_number;
		this.email = email;
		this.access = access;
	}

	public users() {
		
	}

	public users(int id, String username) {
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
}
