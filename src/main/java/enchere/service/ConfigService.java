/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.enumeration.TypeArticle;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigService {
    
    @Autowired
    ArticleService articleService;
    
    public void TimeArticle(){
        
        List<Article> listeArticle = (List<Article>) articleService.findAll();
        
        GregorianCalendar cal = new GregorianCalendar();
        GregorianCalendar dateVente = new GregorianCalendar();
        
        for (Article a : listeArticle) {
            dateVente.setTime(a.getDateVente());
            if (cal.before(dateVente)) {
                return;
            }
            else{
                a.setTypeArticle(TypeArticle.REMPORTE);
                articleService.save(a);
                
            }
        }

    }
    
}
