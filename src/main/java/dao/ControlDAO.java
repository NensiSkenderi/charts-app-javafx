package dao;


public class ControlDAO {

	private static ControlDAO dao = new ControlDAO();
	private login_dao loginDao = new login_dao();
	private users_dao usersDao = new users_dao();
	private activity_trail_dao activityTrailDao = new activity_trail_dao();
	private country_dao countryDao = new country_dao();
	
	public static ControlDAO getControlDao() {
		return dao;
	}
	
	public login_dao getLoginDao() {
		return loginDao;
	}
	
	public users_dao getUsersDao() {
		return usersDao;
	}
	
	public activity_trail_dao getActivityTrailDao() {
		return activityTrailDao;
	}
	
	public country_dao getCountryDao() {
		return countryDao;
	}
}
