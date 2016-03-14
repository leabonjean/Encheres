<%-- 
    Document   : RechercherArticle
    Created on : 11 mars 2016, 12:16:28
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
            <h1>Recherche :</h1>
            <form  method="post" action="recherche">
                <table>
                    <tr>
                        <td> <label> Categorie :</label></td>
                        <td><select name="categorie">
                                <c:forEach items="${liste}" var="cat">
                                    <option value="${cat.id}">${cat.nom}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td> </td>
                        <td><input type="submit"></td>
                    </tr>
                    <tr>
                </table>
            </form>
            <form  method="post" action="recherchenom">
                <table>
                    <tr>
                        <td> <label> Nom de l'article : </label></td>
                        <td><input type="text" name="nom"/> </td>
                    </tr>
                    <tr>
                        <td> </td>
                        <td><input type="submit"></td>
                    </tr>
                    <tr>
                </table>
            </form>
            <form  method="post" action="trierprix">
                <table>
                    <tr>
                        <td> <label> Par Prix : </label></td>
                        <td><select name="prix">
                                <option value="1">Croissant</option>
                                <option value="2">Deroissant</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td> </td>
                        <td><input type="submit"></td>
                    </tr>
                    <tr>
                </table>
            </form>
            <form  method="post" action="trierdate">
                <table>
                    <tr>
                        <td> <label> Par Date :</label></td>
                        <td><select name="date">
                                <option value="1">Croissante</option>
                                <option value="2">Deroissante</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td> </td>
                        <td><input type="submit"></td>
                    </tr>
                    <tr>
                </table>
            </form>

        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
