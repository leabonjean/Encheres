/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    
    @OneToMany(mappedBy = "categorie")
    List<Article> listeArticle = new ArrayList<Article>();

    @OneToMany(mappedBy = "souscategorie")
    List<Categorie> listeSousCategorie = new ArrayList<Categorie>();
    
    @ManyToOne
    @JoinColumn(name = "SousCategorie_Id")
    private Categorie souscategorie;

    public Categorie() {
    }

    public Categorie(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    
    


    
    
    
    
    public List<Categorie> getListeSousCategorie() {
        return listeSousCategorie;
    }

    public void setListeSousCategorie(List<Categorie> listeSousCategorie) {
        this.listeSousCategorie = listeSousCategorie;
    }

    public Categorie getSouscategorie() {
        return souscategorie;
    }

    public void setSouscategorie(Categorie souscategorie) {
        this.souscategorie = souscategorie;
    }
    
    
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Article> getListeArticle() {
        return listeArticle;
    }

    public void setListeArticle(List<Article> listeArticle) {
        this.listeArticle = listeArticle;
    }
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Categorie[ id=" + id + " ]";
    }
    
}
