package service;

import java.sql.SQLException;

import dao.CheckusernameDao;

public class CheckusernameService {

	public boolean checkUsername(String username) throws SQLException {
		
		CheckusernameDao dao=new CheckusernameDao();
		Long isExist=dao.checkUsername(username);
		return isExist>0?true:false;
		
		
	}

}
