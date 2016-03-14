<%-- 
    Document   : Inscription
    Created on : 10 mars 2016, 10:21:12
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
            <h1>${message}</h1>
             <form  method="post" action="inscription">
            <table>
                <tr>
                    <td> <label>Login : </label></td>
                    <td><input type="text" name="login"/> </td>
                </tr>
                <tr>
                    <td> <label>Mot de Passe:</label></td>
                    <td><input type="password" name="mdp"/></td>
                </tr>
                <tr>
                    <td> <label>Retaper Mot De Passe : </label></td>
                    <td><input type="password" name="mdp2"/></td>
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
