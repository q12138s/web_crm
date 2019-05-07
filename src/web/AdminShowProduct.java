package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import domain.Product;
import service.AdminProductListService;

public class AdminShowProduct extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		AdminProductListService service=new AdminProductListService();
		Product product=null;
		try {
			product=service.showProduct(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Category> categoryList=null;
		//AdminProductListService service=new AdminProductListService();
			try {
				categoryList=service.findAllCategory();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}