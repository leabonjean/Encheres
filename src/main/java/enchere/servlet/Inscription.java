/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import enchere.entity.Utilisateur;
import enchere.service.ConfigService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "Inscription", urlPatterns = {"/inscription"})
public class Inscription extends AutowireServlet {

    @Autowired
    ConfigService config;

    @Autowired
    UtilisateurService utilService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        config.TimeArticle();
        
        String log = req.getParameter("login");
        String mdp = req.getParameter("mdp");
        String mdp2 = req.getParameter("mdp2");

        Utilisateur u = utilService.findOneByLogin(log);

        if (u == null) {
            if (mdp.equals(mdp2)) {
                Utilisateur u2 = new Utilisateur();
                u2.setLogin(log);
                u2.setMdp(mdp);
                utilService.save(u2);
                req.getSession().setAttribute("user", req.getParameter("login"));
                req.getSession().setAttribute("mdp", req.getParameter("password"));
                req.getRequestDispatcher("Accueil.jsp").include(req, resp);
                return;
            }
            String s = "Mot de Passe incompatible";
            req.setAttribute("message", s);
            req.getRequestDispatcher("Inscription.jsp").include(req, resp);
            return;

        } else {
            String s = "Login deja utilisé, choisissez un autre Login";
            req.setAttribute("message", s);
            req.getRequestDispatcher("Inscription.jsp").include(req, resp);
            return;
        }

    }

}
