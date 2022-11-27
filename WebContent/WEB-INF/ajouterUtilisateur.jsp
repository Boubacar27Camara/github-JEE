 
<%@include file="inc/header.jsp" %>
    <div id="corps">
     <h1 id="titre-principal">Ajout d'un utilisateur</h1>
     <p class="messageBox ${ status ? 'succes' : 'erreur' }">${ statusMessage }</p>
     
     <form method="post">
     
            <div class="formItem">
            <label>Prenom</label>
            <input type="text" name="prenom" value="${ utilisateur.prenom }">
            <span class="erreur">${ erreurs.prenom }</span>
            </div>
             <div class="formItem">
            <label>Nom</label>
            <input type="text" name="nom" value="${ utilisateur.nom }">
            <span class="erreur">${ erreurs.nom }</span>
            </div>
             <div class="formItem">
            <label>Login</label>
            <input type="text" name="login" value="${ utilisateur.login }">
            <span class="erreur">${ erreurs.login }</span>
            </div>
            <div class="formItem">
            <label>Password</label>
            <input type="text" name="password" value="${ utilisateur.password }">
            <span class="erreur">${ erreurs.password }</span>
            </div>
            <div class="formItem">
            <label>Password (confirmation)</label>
            <input type="text" name="passwordBis">
            <span class="erreur">${ erreurs.passwordBis }</span>
            </div>
             <div class="formItem">
            <label></label>
            <input type="submit" name="Ajouter">
            
            </div>
            
     </form>
    
     </div>
<%@include file="inc/footer.jsp" %>