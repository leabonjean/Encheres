<%-- 
    Document   : ListeArticleCompte
    Created on : 11 mars 2016, 11:39:38
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
            <h1>Mes Articles ajoutes : </h1>
            <table>
                <c:forEach items="${liste}" var="article">
                    <tr>
                        <td>
                            ${article.nom} 
                        </td>
                        <td>
                           ${article.typeArticle}
                        </td>
                        <td>
                             <a href="detailarticle?id=${article.id}">Detail</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
