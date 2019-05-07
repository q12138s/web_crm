package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.DataSourceUtils;
import domain.User;

public class LoginDao {

	public User login(String username, String userpassword) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where name=? and passwd=?";
		return	qr.query(sql, new BeanHandler<User>(User.class), username,userpassword);
	
	}

}
