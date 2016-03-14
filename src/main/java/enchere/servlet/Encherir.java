/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.ConfigService;
import enchere.service.EncherirService;
import enchere.service.UtilisateurService;
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
@WebServlet(name = "Encherir", urlPatterns = {"/encherir"})
public class Encherir extends AutowireServlet {

    @Autowired
    ConfigService config;

    @Autowired
    EncherirService encherirService;
    @Autowired
    ArticleService articleService;
    @Autowired
    UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        config.TimeArticle();

        Long i = Long.parseLong(req.getParameter("id"));
        Article a = articleService.findOne(i);
        if (req.getSession().getAttribute("user") == null) {
            req.setAttribute("erreur", "Vous devez vous identifier pour encherir");
            req.setAttribute("article", a);
            req.getRequestDispatcher("Description.jsp").include(req, resp);
            return;
        }
        Utilisateur u = utilisateurService.findOneByLogin(req.getSession().getAttribute("user").toString());
        Integer j = a.getListeEnchere().size();
        if (a.getUtilisateur().getLogin().equals(u.getLogin())) {
            req.setAttribute("erreur", "Vous ne pouvez pas encherir sur l'un de vos articles");
            req.setAttribute("article", a);
            req.getRequestDispatcher("Description.jsp").include(req, resp);
            return;

        } else if (j > 0) {
            if (a.getListeEnchere().get(j - 1).getUtilisateur().getLogin().equals(u.getLogin())) {
                req.setAttribute("erreur", "Vous etes la derniere personne a avoir encheri");
                req.setAttribute("article", a);
                req.getRequestDispatcher("Description.jsp").include(req, resp);
                return;
            }
        }
//        if (a.getUtilisateur().getLogin().equals(u.getLogin())) {
//            req.setAttribute("erreur", "Vous ne pouvez pas encherir sur l'un de vos articles");
//            req.setAttribute("article", a);
//            req.getRequestDispatcher("Description.jsp").include(req, resp);
//            return;
//        }
        encherirService.Encherir(u, a);
        req.setAttribute("article", a);
        req.getRequestDispatcher("ValidationEnchere.jsp").include(req, resp);

    }

}
