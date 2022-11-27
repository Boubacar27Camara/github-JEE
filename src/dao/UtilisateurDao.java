package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.JDBCconnexion;
import beans.Utilisateur;


public class UtilisateurDao 
{
	
	private static int lastId = 1;
	private static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	  Connection conn = JDBCconnexion.getConnection();

		try {
		
		PreparedStatement ps = conn.prepareStatement("select * from Utilisateur Where PRENOM, NOM,LOGIN,PASSWORD");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Utilisateur utilisateurs1 = new Utilisateur();
//			utilisateur.setId(rs.getLong("id"));
			utilisateurs1.setPrenom(rs.getString("prenom"));
			utilisateurs1.setNom(rs.getString("nom"));
			utilisateurs1.setLogin(rs.getString("login"));
			utilisateurs1.setPassword(rs.getString("password"));
			utilisateurs.add(utilisateurs1);
		}
} catch (SQLException e){
	
	 e.printStackTrace();
    }
	
		return utilisateurs;


		}
		}
		



	

	
	public static boolean ajouter(Utilisateur utilisateur)
	{
		utilisateur.setId(lastId++);
		utilisateurs.add(utilisateur);
		return true;
	}
	
	
	
	public static ArrayList<Utilisateur> lister()
	{
		return utilisateurs;
	}
	
	public static boolean supprimer(int id) {
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == id)
			{
				utilisateurs.remove(utilisateur);
				return true;
			}
		}
		return false;
	}
	
	public static boolean modifier(Utilisateur user) {
		for(Utilisateur utilisateur : utilisateurs)
		{
			if(utilisateur.getId() == user.getId())
			{
				utilisateur.setPrenom(user.getPrenom());
				utilisateur.setNom(user.getNom());
				utilisateur.setLogin(user.getLogin());
				utilisateur.setPassword(user.getPassword());
				return true;
				
}
		}
		return false;
	}
	public static Utilisateur get(int id)
	{
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == id)
			{
				return utilisateur;
			}
		}
		return null;
	}
	


}


