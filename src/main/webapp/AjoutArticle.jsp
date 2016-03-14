<%-- 
    Document   : AjoutArticle
    Created on : 10 mars 2016, 15:57:51
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
        <h1>${titre}</h1>
        <div class="contenu">
            <form  method="post" action="actionajout">
                <table>
                    <tr>
                        <td> <label> Nom de l'article : </label></td>
                        <td><input type="text" name="nom"/> </td>
                    </tr>
                    <tr>
                        <td> <label> Description :</label></td>
                        <td><textarea name="contenu"></textarea></td>
                    </tr>
                    <tr>
                        <td> <label> Prix de Vente : </label></td>
                        <td><input type="number" name="prix"/> </td>
                    </tr>
                    <tr>
                        <td> <label> Nombre de jours disposible aux encheres : </label></td>
                        <td><input type="number" name="date"/> </td>
                    </tr>
                    <tr>
                        <td><label> Categorie : </label></td>
                        <td><select name="categorie">
                                <c:forEach items="${listeCat}" var="cat">
                                    <option value="${cat.id}">${cat.nom}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td> </td>
                        <td><input type="submit"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>