/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class AjoutCategorie {
    
    @Autowired
    CategorieService categorieService;
    
    public void AjouterCategorie(){
        Categorie c = new Categorie(1L, "Animal");
        Categorie c2 = new Categorie(2L, "Meubles");
        Categorie c3 = new Categorie(3L, "Cuisine");
        Categorie c4 = new Categorie(4L, "Automobil");
        Categorie c5 = new Categorie(5L, "Decoration");
        
        categorieService.save(c);
        categorieService.save(c2);
        categorieService.save(c3);
        categorieService.save(c4);
        categorieService.save(c5);
        
    }
    
}
