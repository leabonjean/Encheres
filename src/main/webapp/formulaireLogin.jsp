<%-- 
    Document   : formulaireLogin
    Created on : 9 mars 2016, 16:19:41
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
        <form  method="post" action="login">
            <table>
                <tr>
                    <td> <label>Login : </label></td>
                    <td><input type="text" name="login"/> </td>
                </tr>
                <tr>
                    <td> <label>Mot De Passe :</label></td>
                    <td><input type="password" name="password"></input></td>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
