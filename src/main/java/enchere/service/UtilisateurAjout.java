/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import enchere.entity.Utilisateur;

/**
 *
 * @author admin
 */
@Service
public class UtilisateurAjout {
    
    @Autowired
    UtilisateurService utilService;
    
    public void creerListe(){
        
        Utilisateur u = new Utilisateur();
        Utilisateur u2 = new Utilisateur();
        Utilisateur u3 = new Utilisateur();
        Utilisateur u4 = new Utilisateur();
        u.setLogin("Bonjean");
        u2.setLogin("Fiatte");
        u3.setLogin("Maman");
        u4.setLogin("Xabi");
        u.setMdp("blabla");
        u2.setMdp("coucou");
        u3.setMdp("he");
        u4.setMdp("azerty");
        
        utilService.save(u);
        utilService.save(u2);
        utilService.save(u3);
        utilService.save(u4);
        
    }
    
}
