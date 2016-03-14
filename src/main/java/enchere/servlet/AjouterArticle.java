/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.enumeration.TypeArticle;
import enchere.service.AjoutCategorie;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.ConfigService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
@WebServlet(name = "AjouterArticle", urlPatterns = {"/ajouterarticle"})
public class AjouterArticle extends AutowireServlet {

    @Autowired
    ConfigService config;

    @Autowired
    CategorieService categorieService;
    @Autowired
    AjoutCategorie ajoutCategorie;
    @Autowired
    ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        config.TimeArticle();

        if (req.getSession().getAttribute("user") == null) {

            req.setAttribute("erreur", "Vous devez vous identifier pour pouvoir ajouter un article");

            List<Article> listeArticle = (List<Article>) articleService.findAll();
            List<Article> listeb = new ArrayList<Article>();

            GregorianCalendar cal = new GregorianCalendar();
            GregorianCalendar dateVente = new GregorianCalendar();

            for (Article a : listeArticle) {
                dateVente.setTime(a.getDateVente());
                if (cal.before(dateVente)) {
                    listeb.add(a);
                }
            }
            req.setAttribute("liste", listeb);
            req.getRequestDispatcher("ListeArticle.jsp").include(req, resp);
            return;
        }

        String s = "Ajouter un Article";
        req.setAttribute("titre", s);
        List<Categorie> listecategorie = (List<Categorie>) categorieService.findAll();
        req.setAttribute("listeCat", listecategorie);
        req.getRequestDispatcher("AjoutArticle.jsp").include(req, resp);
        return;

    }

}
