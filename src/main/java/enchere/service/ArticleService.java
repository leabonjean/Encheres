/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ArticleService extends CrudRepository<Article, Long>{
    
    public List<Article> findAllByCategorieId(Long id);
    public List<Article> findAllByNom(String n);
//    public List<Article> findAllOrderByPrixActuelAsc();
//    public List<Article> findAllOrderByPrixActuelDesc();
    
}
