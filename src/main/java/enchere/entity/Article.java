/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import enchere.enumeration.TypeArticle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String contenu;
    private float prixDepart;
    private float prixActuel;
    private TypeArticle typeArticle=TypeArticle.DISPONIBLE;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVente;
    
    @ManyToOne
    @JoinColumn(name = "Utilisateur_Id")
    private Utilisateur utilisateur;
    
    @OneToMany(mappedBy = "article")
    List<Enchere> listeEnchere = new ArrayList<Enchere>();
    
    @ManyToOne
    @JoinColumn(name = "Categorie_Id")
    private Categorie categorie;

    
    public Article() {
    }

    public Article(String nom, float prixDepart, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
        this.prixDepart = prixDepart;

    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    
    


    
    
    public float getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(float prixDepart) {
        this.prixDepart = prixDepart;
    }

    public float getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(float prixActuel) {
        this.prixActuel = prixActuel;
    }

    public TypeArticle getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(TypeArticle typeArticle) {
        this.typeArticle = typeArticle;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Enchere> getListeEnchere() {
        return listeEnchere;
    }

    public void setListeEnchere(List<Enchere> listeEnchere) {
        this.listeEnchere = listeEnchere;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Article[ id=" + id + " ]";
    }
    
}
