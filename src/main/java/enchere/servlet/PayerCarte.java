/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.enumeration.TypeArticle;
import enchere.service.ArticleService;
import enchere.service.CarteService;
import enchere.service.CarteServiceMock;
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
@WebServlet(name = "PayerCarte", urlPatterns = {"/payercarte"})
public class PayerCarte extends AutowireServlet {
    
    @Autowired
    ArticleService articleService;
    @Autowired
    CarteServiceMock carteMock;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        Article a = articleService.findOne(id);
        if (carteMock.validation() == true) {
            a.setTypeArticle(TypeArticle.PAYE);
            articleService.save(a);
            req.getRequestDispatcher("PayerOkCarte.jsp").include(req, resp);
            return;
        }
        else{
            req.getRequestDispatcher("PayerKoCarte.jsp").include(req, resp);
        }

    }

    
}
