 <%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
 <%@ include file="inc/header.jsp" %>
 <div id="corps">
    <h1 id="titre-principal">Liste des utilisateurs</h1>   
    
			    <% ArrayList<Utilisateur> utilisateurs =  (ArrayList<Utilisateur>) request.getAttribute("utilisateurs");
			       
			    if(utilisateurs.isEmpty())
			    {%>
			       <p>La liste des utilisateurs est vide !</p>
			       <% 
			    	
			    }
			    else
			    {%>
			    
			    <table border="1" cellspacing="0" cellpacing="10">
			       <tr>
				    <th>ID</th>
				    <th>Prenom</th>
				    <th>Nom</th>
				    <th>Login</th>
				    <th>Password</th>
				    <th colspan="2">Actions</th>
				    </tr><%
				    
			    for(Utilisateur utilisateur : utilisateurs)
			    {%>
			     <tr>
			       <td><%= utilisateur.getId() %></td>
			       <td><%= utilisateur.getPrenom() %></td>
			       <td><%= utilisateur.getNom() %></td>
			       <td><%= utilisateur.getLogin() %></td>
			       <td><%= utilisateur.getPassword() %></td>
			       <td><a href="update?id=<%= utilisateur.getId() %>">Modifier</a></td>
			       <td><a href="delete?id=<%= utilisateur.getId() %>" onclick="return confirm('En etes vous sur ?')">Supprimer</a></td>
			       
			       
			       
			     </tr><% 
			    	
			    }%>
			    </table>
				   
			 <%}
			%>
</div>
 <%@ include file="inc/footer.jsp" %>