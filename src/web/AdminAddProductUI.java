package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import service.AdminProductListService;

public class AdminAddProductUI extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categoryList=null;
		AdminProductListService service=new AdminProductListService();
			try {
				categoryList=service.findAllCategory();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("categoryList", categoryList);
			
			request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}