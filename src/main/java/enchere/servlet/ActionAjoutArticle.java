/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.enumeration.TypeArticle;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.ConfigService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
@WebServlet(name = "ActionAjoutArticle", urlPatterns = {"/actionajout"})
public class ActionAjoutArticle extends AutowireServlet {
    
    @Autowired
    ConfigService config;

    @Autowired
    CategorieService categorieService;
    @Autowired
    ArticleService articleService;
    @Autowired
    UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        config.TimeArticle();
        
        String nom = req.getParameter("nom");
        String contenu = req.getParameter("contenu");
        Float prix = Float.parseFloat(req.getParameter("prix"));
        Long categorie = Long.parseLong(req.getParameter("categorie"));

        Integer jour = Integer.parseInt(req.getParameter("date"));
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, jour);

        Article a = new Article(nom, prix, contenu);
        a.setPrixActuel(a.getPrixDepart());
        a.setDateVente(cal.getTime());
        a.setTypeArticle(TypeArticle.DISPONIBLE);

        Utilisateur u = utilisateurService.findOneByLogin(req.getSession().getAttribute("user").toString());

        Categorie c = categorieService.findOne(categorie);
        a.setCategorie(c);
        a.setUtilisateur(u);
        u.getListeArticle().add(a);
        c.getListeArticle().add(a);
        articleService.save(a);

//        utilisateurService.save(u);
//        categorieService.save(c);
        resp.sendRedirect("listerarticle");

    }

}
