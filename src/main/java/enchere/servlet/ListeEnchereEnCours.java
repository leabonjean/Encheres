/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.enumeration.TypeArticle;
import enchere.service.ConfigService;
import enchere.service.UtilisateurService;
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
@WebServlet(name = "ListeEnchereEnCours", urlPatterns = {"/listeenchere"})
public class ListeEnchereEnCours extends AutowireServlet {

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    ConfigService config;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        config.TimeArticle();

//        Long idUser = Long.parseLong(req.getParameter("id"));
        Utilisateur u = utilisateurService.findOneByLogin(req.getSession().getAttribute("user").toString());
        List<Enchere> listeEnchere = u.getListeEnchere();
        List<Article> liste = new ArrayList<Article>();
        for (Enchere e : listeEnchere) {
            Article a = e.getArticle();
            if (a.getTypeArticle() == TypeArticle.DISPONIBLE) {
                liste.add(a);
            }
        }
        req.setAttribute("liste", liste);
        req.getRequestDispatcher("ListeEnchere.jsp").include(req, resp);

    }

}
