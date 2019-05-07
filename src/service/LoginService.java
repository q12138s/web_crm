package service;

import java.sql.SQLException;

import dao.LoginDao;
import domain.User;

public class LoginService {

	public User login(String username, String userpassword) throws SQLException {
		LoginDao dao=new LoginDao();
		return dao.login(username,userpassword);
		// TODO Auto-generated method stub
		
	}

}
