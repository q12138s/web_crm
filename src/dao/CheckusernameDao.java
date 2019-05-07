package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.DataSourceUtils;

public class CheckusernameDao {

	public Long checkUsername(String username) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from user where username=?";
		Long query = (Long) qr.query(sql, new ScalarHandler(),username);
		return query;
	}

}
