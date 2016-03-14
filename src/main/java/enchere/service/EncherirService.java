/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class EncherirService {

    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    EnchereService enchereService;
    @Autowired
    ArticleService articleService;

    public void Encherir(Utilisateur u, Article a) {

        Enchere e = new Enchere();
        e.setUtilisateur(u);
        e.setArticle(a);

        u.getListeEnchere().add(e);
        u.getListeArticle().add(a);
        a.setUtilisateur(u);
        a.getListeEnchere().add(e);
        utilisateurService.save(u);
        float f = 10;
        a.setPrixActuel(a.getPrixActuel() + f);
        articleService.save(a);
        enchereService.save(e);

    }

}
