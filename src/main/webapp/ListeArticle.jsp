<%-- 
    Document   : ListeArticle
    Created on : 10 mars 2016, 15:44:35
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
            <h1>${titre}</h1>
            <table >
                <c:forEach items="${liste}" var="article">
                    <tr>
                        <td> ${article.nom}</td> <td> <a href="detailarticle?id=${article.id}"> Description </a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
            <div>${erreur}</div>
        <div>
            <a href="ajouterarticle">   Ajouter un Article</a>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>