/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import enchere.entity.Utilisateur;
import enchere.service.UtilisateurAjout;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends AutowireServlet {

    @Autowired
    UtilisateurService utilService;
    @Autowired
    UtilisateurAjout utilAjout;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s = req.getParameter("login");
        String s1 = req.getParameter("password");
        
        Utilisateur u = utilService.findOneByLogin(s);
        
        if (u == null) {
            req.getRequestDispatcher("Inscription.jsp").forward(req, resp);
        } else if (s.equals(u.getLogin())) {
            
            if (s1.equals(u.getMdp())) {
                
                req.getSession().setAttribute("user", req.getParameter("login"));
                req.getSession().setAttribute("mdp", req.getParameter("password"));
                req.getRequestDispatcher("Accueil.jsp").forward(req, resp);
                
            }
            throw new RuntimeException("Mot de Passe Incorrect");
        } 
    }
}
