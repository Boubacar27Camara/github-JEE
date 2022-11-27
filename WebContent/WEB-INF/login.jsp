 <%@page import="beans.Utilisateur"%>
<%@include file="inc/header.jsp" %>
    <div id="corps">
     <h1 id="titre-principal">Authentification d'un utilisateur</h1>
     <c:if test="${connexionFailed == true }">
        <p class="errorMessage">Login et/ou mot de passe incorrect</p>
     </c:if>
     <form method="post" action="login">
          <div class="formItem">
            <label>Login :</label>
            <input type="text" name="login" value="${ login }">
          </div>
         <br>
         <div class="formItem">   
            <label>Password :</label>
            <input type="password" name="password">
         </div><br>
         <div class="formItem">
            <label></label>   
            <input type="submit" value="Connecter">
         </div><br> 
     </form>
     </div>
<%@include file="inc/footer.jsp" %>