package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ProductListService;
import vo.PageBean;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parameter = request.getParameter("currentPage");
		if(parameter==null) parameter="1";
		int currentPage=Integer.parseInt(parameter);
		int currentCount=12;
		ProductListService service = new ProductListService();
		PageBean pageBean = null;
		try {
			pageBean = service.findPageBean(currentPage,currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/product_list.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}