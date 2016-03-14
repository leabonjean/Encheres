<%-- 
    Document   : Paiement
    Created on : 14 mars 2016, 09:58:08
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
            <h1> Paiement :</h1>
            Recapitulatif de l'achat :<br>
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
                            Description de l'article : 
                        </td>
                        <td>
                            ${article.contenu}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Prix de depart : 
                        </td>
                        <td>
                            ${article.prixDepart}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Prix Remporte : 
                        </td>
                        <td>
                            ${article.prixActuel}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Choisir votre mode de paiement : 
                        </td>
                        <td>
                            <a href="paypal?id=${article.id}">Paypal</a><br>
                            <a href="carte?id=${article.id}">Carte Bleue</a>
                        </td>
                    </tr>
                </table>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
