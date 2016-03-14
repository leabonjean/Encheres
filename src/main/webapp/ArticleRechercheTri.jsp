<%-- 
    Document   : ArticleRechercheCategorieNom
    Created on : 11 mars 2016, 14:02:16
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
            <h1>Resultat de votre recherche : </h1>
            <table >
                <c:forEach items="${liste}" var="article">
                    <tr>
                        <td> ${article.nom}</td> <td> <a href="detailarticle?id=${article.id}"> Description </a></td>
                    </tr>
                </c:forEach>
            </table>

        <c:import url="_PIED.jsp"/>
    </body>
</html>
