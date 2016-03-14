<%-- 
    Document   : ValidationEnchere
    Created on : 11 mars 2016, 09:35:52
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Streaming</title>
        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <c:import url="_TITRE.jsp"/> 
        <c:import url="_MENU.jsp"/>
        <div class="contenu">
            <h1>Votre Demande d'Enchere a ete validee </h1><br>
            <div>Recapitulatif enchere :</div><br>
            <div>Vous avez encheri sur un(e) ${article.nom} dont le prix de vente est maintenant de ${article.prixActuel} euros</div>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>