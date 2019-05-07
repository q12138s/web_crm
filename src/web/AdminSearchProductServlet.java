package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Category;
import domain.Product;
import service.AdminProductListService;
import vo.Condition;

public class AdminSearchProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//封装Condition
		Map<String, String[]> properties = request.getParameterMap();
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition, properties);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//传递数据
		AdminProductListService service = new AdminProductListService();
		List<Product> productList = null;
		try {
			productList = service.SearchProduct(condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//显示类别
		List<Category> categoryList = null;
		// AdminProductListService service=new AdminProductListService();
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("condition", condition);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);
	request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
