package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/login", "/logout"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LOGIN = "/WEB-INF/login.jsp";
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getServletPath())
		{
		case "/login":	
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		case "/logout":
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login");
			
		
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if("admin".equals(login) && "passer".equals(password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("isConnected", true);
			response.sendRedirect("list");
		}
		else
		{
			request.setAttribute("connexionFailed", true);
			request.setAttribute("login", login);
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		}
		
	}
}
