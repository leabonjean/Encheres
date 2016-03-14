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
import java.util.ArrayList;
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
@WebServlet(name = "TrierPrix", urlPatterns = {"/trierprix"})
public class TrierPrix extends AutowireServlet {

    @Autowired
    ArticleService articleService;
    @Autowired
    ConfigService config;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        config.TimeArticle();
        String prix = req.getParameter("prix");
        List<Article> listeArticle = new ArrayList<Article>();
        if (prix.equals("1")) {
//            listeArticle = articleService.findAllOrderByPrixActuelAsc();
        }
        if (prix.equals("2")) {
//            listeArticle = articleService.findAllOrderByPrixActuelDesc();
        }
        req.setAttribute("liste", listeArticle);
        req.getRequestDispatcher("ArticleRechercheTri.jsp").include(req, resp);

    }

}
