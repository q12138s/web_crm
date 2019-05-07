package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.DataSourceUtils;
import vo.PageBean;
import domain.Product;

public class ProductListDao {

	public List<Product> findAll() throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product";
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
		
	}

	public int findPageBean() throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from product";
		Long query = (Long) qr.query(sql, new ScalarHandler());
		return query.intValue();
	}

	public List<Product> findProductList(int index, int currentCount) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product limit ?,?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class),index,currentCount);
		
	}

	public List<Object> findWord(String word) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where pname like ? limit 0,8";
		List<Object> query = qr.query(sql, new ColumnListHandler("pname"), "%"+word+"%");
		return query;
	}

	

}
