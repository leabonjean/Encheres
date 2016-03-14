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
@WebServlet(name = "Message", urlPatterns = {"/messages"})
public class Message extends AutowireServlet {

    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    ConfigService config;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        config.TimeArticle();

        Utilisateur u = utilisateurService.findOneByLogin(req.getSession().getAttribute("user").toString());
        List<Enchere> listeEnchere = u.getListeEnchere();
        List<Article> listeArticle = new ArrayList();
        List<Article> listeArticle2 = new ArrayList();
        for (Enchere e : listeEnchere) {

            Article a = e.getArticle();
            if (a.getTypeArticle() == TypeArticle.REMPORTE) {
                int i = a.getListeEnchere().size();
                Enchere e2 = a.getListeEnchere().get(i - 1);
                if (e2.getUtilisateur().getLogin() == u.getLogin()) {
                    listeArticle.add(a);
                } else {
                    listeArticle2.add(a);
                }

            }

        }

        req.setAttribute("articlesRemportes", listeArticle);
        req.setAttribute("articlesNonRemportes", listeArticle2);
        req.getRequestDispatcher("ListeMessage.jsp").include(req, resp);

    }

}
