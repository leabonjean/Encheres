/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.enumeration.TypeArticle;
import enchere.service.ArticleService;
import enchere.service.PaypalService;
import enchere.service.PaypalServiceMock;
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
@WebServlet(name = "Paypal", urlPatterns = {"/paypal"})
public class Paypal extends AutowireServlet {
    
    @Autowired
    PaypalServiceMock paypalService;
    @Autowired
    ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Long id = Long.parseLong(req.getParameter("id"));
        Article a = articleService.findOne(id);
        if(paypalService.validation()==true){
            a.setTypeArticle(TypeArticle.PAYE);
            articleService.save(a);
            req.getRequestDispatcher("EnCoursPaypal.jsp").include(req, resp);
            return;
        }
        else{
            req.getRequestDispatcher("PaypalFaux.jsp").include(req, resp);
        }
        
    }

    
    
    
}
