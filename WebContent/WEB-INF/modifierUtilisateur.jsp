 <%@page import="beans.Utilisateur"%>
<%@include file="inc/header.jsp" %>
    <div id="corps">
     <h1 id="titre-principal">Modification d'un utilisateur</h1>
     <% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");%>
     <form method="post">
          <div class="formItem">
            <label for="nom">Prenom</label>
            <input type="text" name="prenom" id="prenom" value="<%= utilisateur.getPrenom() %> ">
          </div>
         <div class="formItem"> 
            <label for="nom">Nom</label>
            <input type="text" name="nom" id="nom" value="<%= utilisateur.getNom() %>">
         </div>
         <div class="formItem">
            <label for="login">Login</label>
            <input type="text" name="login" id="login" value="<%= utilisateur.getLogin()%>">
         </div>
         <div class="formItem">   
            <label for="password">Password</label>
            <input type="password" name="password" id="password" value="<%= utilisateur.getPassword()%>">
         </div>
         <div class="formItem">
            <label></label>   
            <input type="submit" value="Modifier">
         </div> 
     </form>
     
<%@include file="inc/footer.jsp" %>