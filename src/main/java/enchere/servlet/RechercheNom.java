/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.service.ArticleService;
import enchere.service.ConfigService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "RechercheNom", urlPatterns = {"/recherchenom"})
public class RechercheNom extends AutowireServlet {

    @Autowired
    ArticleService articleService;
    @Autowired
    ConfigService config;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        config.TimeArticle();
        String nom = req.getParameter("nom");

        List<Article> listeArticle = articleService.findAllByNom(nom);
        req.setAttribute("liste", listeArticle);
        req.getRequestDispatcher("ArticleRechercheTri.jsp").include(req, resp);

    }

}
