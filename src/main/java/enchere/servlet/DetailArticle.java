/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.ConfigService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DetailArticle", urlPatterns = {"/detailarticle"})
public class DetailArticle extends AutowireServlet {

    @Autowired
    ConfigService config;

    @Autowired
    ArticleService articleService;
    @Autowired
    CategorieService categorieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        config.TimeArticle();

        Long i = Long.parseLong(req.getParameter("id"));
        Article a = articleService.findOne(i);
        String s = "Description de l'Article :";
        req.setAttribute("titre", s);
        req.setAttribute("article", a);
        req.getRequestDispatcher("Description.jsp").include(req, resp);

    }

}
