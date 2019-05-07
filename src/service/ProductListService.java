package service;

import java.sql.SQLException;
import java.util.List;

import vo.PageBean;
import dao.ProductListDao;
import domain.Product;

public class ProductListService {

	public List<Product> findAll() throws SQLException {
	ProductListDao dao=new ProductListDao();
		return dao.findAll();
	}

	public PageBean findPageBean(int currentPage, int currentCount) throws SQLException {
		ProductListDao dao=new ProductListDao();
		PageBean pageBean=new PageBean();
		//当前页
		pageBean.setCurrentPage(currentPage);
		//当前页条数
		pageBean.setCurrentCount(currentCount);
		//总条数
		int totalCount = dao.findPageBean();
		pageBean.setTotalCount(totalCount);
		//总页数
		int totalPage=(int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//每页显示的数据
		int index=(currentPage-1)*currentCount;
		List<Product> productList=dao.findProductList(index,currentCount);
		pageBean.setProductList(productList);
		return pageBean;
	}

	public List<Object> findWord(String word) throws SQLException {
		ProductListDao dao=new ProductListDao();
		return dao.findWord(word);
	}

}
