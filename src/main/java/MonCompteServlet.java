/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import enchere.entity.Utilisateur;
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
@WebServlet(name = "MonCompteServlet", urlPatterns = {"/moncompte"})
public class MonCompteServlet extends AutowireServlet {
    @Autowired
    UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if(req.getSession().getAttribute("user")==null){
            String s = "Connectez-vous pour acceder a votre compte";
            req.setAttribute("message", s);
            req.getRequestDispatcher("Accueil.jsp").include(req, resp);
            return;
        }
        Utilisateur u = utilisateurService.findOneByLogin(req.getSession().getAttribute("user").toString());
        req.setAttribute("user", u);
        req.getRequestDispatcher("MonCompte.jsp").include(req, resp);
        
        
    }

  
    
}
