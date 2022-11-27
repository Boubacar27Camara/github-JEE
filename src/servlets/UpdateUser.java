package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class updateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/modifierUtilisateur.jsp";
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if(id != null && id.matches("[0-9]+")) {
			
			Utilisateur utilisateur = UtilisateurDao.get(Integer.parseInt(id));
			
			
			if(utilisateur !=null)
			{
				request.setAttribute("utilisateur", utilisateur);
		        getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
		        return;
		
	}
			
		}
			response.sendRedirect("list");
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Utilisateur utilisateur = new Utilisateur(Integer.parseInt(id), prenom, nom, login, password);
		UtilisateurDao.modifier(utilisateur);
		
		response.sendRedirect("list");
	}

}
