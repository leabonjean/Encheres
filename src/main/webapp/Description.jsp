<%-- 
    Document   : Description
    Created on : 10 mars 2016, 16:27:40
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
            <table>
                <tr>
                    <td>
                        Nom de l'article :
                    </td>
                    <td>
                        ${article.nom}
                    </td>
                </tr>
                <tr>
                    <td>
                        Categorie :
                    </td>
                    <td>
                        ${article.categorie.nom}
                    </td>
                </tr>
                <tr>
                    <td>
                        Description :
                    </td>
                    <td>
                        ${article.contenu}
                    </td>
                </tr>
                <tr>
                    <td>
                        Prix Actuel :
                    </td>
                    <td>
                        ${article.prixActuel}
                    </td>
                </tr>
                <tr>
                    <td>
                        La vente de cette article expire le :
                    </td>
                    <td>
                        ${article.dateVente}
                    </td>
                </tr>
                <tr>
                    <td>
                        ${erreur}
                    </td>
                    <td>
                        <a href="encherir?id=${article.id}"> Encherir de 10 euros</a>
                    </td>
                </tr>
            </table>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
