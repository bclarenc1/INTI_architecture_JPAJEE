<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">
	<title>Formulaire d'inscription</title>
</head>

<body>
	<h2>Formulaire d'inscription</h2>
	<form action="ServletPersonne" method="GET" id="form-contact" class="container">
		<br />
		<h4>État civil</h4>
		<input type="hidden" name="id" value="${id}" />
		<div class="from-group">
			<label for="prenom">Prénom</label>
			<input id="prenom" type="text" placeholder="Wallace" value="${prenom}" name="prenom" required/>
		</div>
		<div class="from-group">
			<label for="nom">Nom</label>
			<input id="nom" type="text"	placeholder="Ticot" value="${nom}" name="nom" required/>
		</div>
		<div class="from-group">
			<label for="age">Âge</label>
			<input id="age" type="number" placeholder="NaN" value="${age}" name="age" required/>
		</div>
		<div class="from-group">
			<label for="nom">Login</label>
			<input id="login" type="text" value="${login}" name="login" required/>
		</div>
		<div class="from-group">
			<label for="nom">Mot de passe</label>
			<input id="pwd" type="password" value="${pwd}" name="pwd" required/>
		</div>

		<h4>Autres infos</h4>
		
		<br/>
		<div>
			Adresse :
			<select name="idadresse">
				<optgroup>
				<option value="0">(none)</option>
				<c:if test="${not empty adresses}">
					<c:forEach items="${adresses}" var="a">
						<option value="${a.idAdresse}"> <c:out value="[${a.idAdresse}] ${a.numRue} ${a.nomRue}, ${a.cp} ${a.ville}"/> </option>
					</c:forEach>
				</c:if>
				</optgroup>
			</select>
		</div>
		<br/>
		
		<div>
            <input type="submit" name="ajouter" value="Ajouter" />
            <input type="submit" name="modifier" value="Modifier" />
        </div>                
	</form>
	
<%-- 	<div>
 		nom = <c:out value="${lenom}"/><br/>
		prenom = <c:out value="${leprenom}"/><br/>
		age = <c:out value="${leage}"/><br/>
	</div> --%>

<div class="container">
  <h2>Tous les gens</h2>
  <p>de la BDD Personnes</p>
  <table class="table table-bordered table-sm ">

    <thead class=greenrow>
    	<tr>
			<th>ID</th>
        	<th>Prénom</th>
        	<th>Nom</th>
        	<th>Âge</th>
        	<th>ID adresse</th>
        	<th>Login</th>
        	<th>Mot de passe</th>
        </tr>
    </thead>

    <tbody>
   		<c:if test="${not empty people}">
			<c:forEach items="${people}" var="pers">
				<tr>
					<td><c:out value="${pers.id}"/></td>
					<td><c:out value="${pers.prenom}"/></td>
					<td><c:out value="${pers.nom}"/></td>
					<td><c:out value="${pers.age}"/></td>
					<td><c:out value="${pers.getAdresse().idAdresse}"/></td>
					<td><c:out value="${pers.getConnexion().login}"/></td>
					<td><c:out value="${pers.getConnexion().mdp}"/></td>
					<td><a href="ModifierPersonne?idPersonne=${pers.id}">modifier</a></td>
 					<td><a href="SupprimerPersonne?idPersonne=${pers.id}">supprimer</a></td>
				</tr> 
			</c:forEach>
		</c:if>
    </tbody>

  </table>
</div>
 
</body>
</html>