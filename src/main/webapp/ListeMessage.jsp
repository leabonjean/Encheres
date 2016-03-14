<%-- 
    Document   : ListeMessage
    Created on : 14 mars 2016, 09:25:47
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
            <h1>Vos Messages : </h1>
            Articles Remportes : 
            <table>
                <c:forEach items="${articlesRemportes}" var="a">
                    <tr>
                        <td>
                            Vous avez remporte un(e) ${a.nom} 
                        </td>
                        <td><a href="payer?id=${a.id}">payer</a></td>
                    </tr>
                </c:forEach>
            </table>
            Articles Non Remportes : 
            <table>
                <c:forEach items="${articlesRemportes2}" var="a">
                    <tr>
                        <td>
                            Vous n'avez pas remporte un(e) ${a.nom} 
                        </td>
                        <td></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <c:import url="_PIED.jsp"/>
    </body>
</html>