/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Categorie;
import enchere.service.CategorieService;
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
@WebServlet(name = "RechercherArticle", urlPatterns = {"/recherchearticle"})
public class RechercherArticle extends AutowireServlet {

    @Autowired
    CategorieService categorieService;
    @Autowired
    ConfigService config;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        config.TimeArticle();
        List<Categorie> listeCat = (List<Categorie>) categorieService.findAll();
        req.setAttribute("liste", listeCat);
        req.getRequestDispatcher("RechercherArticle.jsp").include(req, resp);

    }

}
