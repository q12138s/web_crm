package service;

import java.sql.SQLException;
import java.util.List;

import vo.Condition;
import dao.AdminProductListDao;
import domain.Category;
import domain.Product;

public class AdminProductListService {

	public List<Product> findAllProduct() throws SQLException {
		
		//显示所有商品
		AdminProductListDao dao=new AdminProductListDao();
		//dao.findAllProduct();
		return dao.findAllProduct();
		// TODO Auto-generated method stub
		
	}

	public List<Category> findAllCategory() throws SQLException {
		AdminProductListDao dao=new AdminProductListDao();
		return dao.findAllCategory();
	}

	public void addProduct(Product product) throws SQLException {
		AdminProductListDao dao=new AdminProductListDao();
		dao.addProduct(product);
		
	}

	public void delProduct(String pid) throws SQLException {
		AdminProductListDao dao=new AdminProductListDao();
		dao.delProduct(pid);
		
	}

	public Product showProduct(String pid) throws SQLException {
		AdminProductListDao dao=new AdminProductListDao();
		return dao.showProduct(pid);
	}

	public void updateProduct(Product product) throws SQLException {
		AdminProductListDao dao=new AdminProductListDao();
		dao.updateProduct(product);
		
	}

	public List<Product> SearchProduct(Condition condition) throws SQLException {
		AdminProductListDao dao=new AdminProductListDao();
		return dao.SearchProduct(condition);
		// TODO Auto-generated method stub
		
	}

}
