/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Utilisateur;
import enchere.service.AjoutCategorie;
import enchere.service.ArticleService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import enchere.service.EffacemoiCrudService;
import enchere.service.UtilisateurAjout;

/**
 *
 * @author tom
 */
@WebServlet(name = "MyServiceServlet", urlPatterns = {"/MyServiceServlet"})
public class MyServiceServlet extends AutowireServlet {

    @Autowired
    AjoutCategorie ajoutCategorie;
    
    @Autowired
    UtilisateurAjout utilAjout;
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ajoutCategorie.AjouterCategorie();
//utilAjout.creerListe();
//        req.getRequestDispatcher("formulaireLogin.jsp").include(req, resp);
        req.getRequestDispatcher("Accueil.jsp").include(req, resp);
    }
    
    
    
}
