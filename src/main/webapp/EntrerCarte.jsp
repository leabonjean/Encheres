<%-- 
    Document   : EntrerCarte
    Created on : 14 mars 2016, 10:57:35
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
            <h1>Entrer votre carte : </h1>
            <form  method="post" action="payercarte?id=${article.id}">
            <table>
                <tr>
                    <td>
                        Votre numero de carte :
                    </td>
                    <td>
                        <input type="text" name="num"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Votre numero date d'expiration :
                    </td>
                    <td>
                        <input type="text" name="exp"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Votre cryptogramme :
                    </td>
                    <td>
                        <input type="text" name="crypto"/>
                    </td>
                </tr>
                <tr>
                    <td>
                       
                    </td>
                    <td>
                        <input type="submit" />
                    </td>
                </tr>
            </table>
        </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
