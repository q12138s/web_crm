package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import domain.User;
import service.LoginService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		LoginService service=new LoginService();
		User user=null;
		try {
			 user=service.login(username,userpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(user);
		
		if(user==null){
			request.setAttribute("login", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			String autoLogin = request.getParameter("autoLogin");
			if(autoLogin!=null){
				Cookie cookie_username = new Cookie("cookie_username",user.getUsername());
				Cookie cookie_password = new Cookie("cookie_password",user.getUserpassword());
				//设置cookie的持久化时间
				cookie_username.setMaxAge(60*60);
				cookie_password.setMaxAge(60*60);
				//设置cookie的携带路径
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				//发送cookie
				System.out.println(cookie_username+"33");
				System.out.println(cookie_password+"44");
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			System.out.println(user+"00");
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}