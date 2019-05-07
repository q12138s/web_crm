package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductListService;

import com.google.gson.Gson;

public class SearchWordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String word = request.getParameter("word");
		ProductListService service=new ProductListService();
		List<Object> productList=null;
		try {
			 productList=service.findWord(word);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson=new Gson();
		String json = gson.toJson(productList);
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}