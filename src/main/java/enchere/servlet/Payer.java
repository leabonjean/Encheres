/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.service.ArticleService;
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
@WebServlet(name = "Payer", urlPatterns = {"/payer"})
public class Payer extends AutowireServlet {
    
    @Autowired
    ArticleService articleService;
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Long idA = Long.parseLong(req.getParameter("id"));
        Article a = articleService.findOne(idA);
        req.setAttribute("article", a);
        req.getRequestDispatcher("Paiement.jsp").include(req, resp);
        
    }
    
    

   
}
