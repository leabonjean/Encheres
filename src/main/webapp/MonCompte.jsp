<%-- 
    Document   : MonCompte
    Created on : 11 mars 2016, 10:53:07
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
            <h1> Mon Compte </h1>
            <table>
                <tr>
                    <td>
                        Mes encheres : 
                    </td>
                    <td>
                        <a href="listeenchere"> Details </a>
                    </td>
                </tr>
                <tr>
                    <td>
                        Mes articles ajoutes : 
                    </td>
                    <td>
                        <a href="listearticle"> Details </a>
                    </td>
                </tr>
                <tr>
                    <td>
                        Mes articles payes : 
                    </td>
                    <td>
                        <a href="listearticlespayes"> Details </a>
                    </td>
                </tr>
                <tr>
                    <td>
                        Mes Messages : 
                    </td>
                    <td>
                        <a href="messages"> Details </a>
                    </td>
                </tr>

            </table>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
