package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.AdminProductListService;

public class AdminProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			AdminProductListService service=new AdminProductListService();
			List<Product> productList=null;
			try {
				productList=service.findAllProduct();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
