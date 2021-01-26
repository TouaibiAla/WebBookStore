package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import com.example.demo.entity.Categorie;
@Entity
@Table
public class Livre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@Column @NotNull
private String nomLivre;
	@Column @NotNull
private String auteur;
	@Column @NotNull
private String edition;
	@Column @NotNull
private float prix;
	@Column @NotNull
private Date dateCreation;
@ManyToOne
private Categorie categorie;	
@Column @NotNull
private int stock;	
	  public Livre(){ }
	  
	  public Livre (String nomLivre,String auteur,String edition,float prix ,Date dateCreation,Catagorie categorie,int stock){
         this.nomLivre=nomLivre;
         this.auteur=auteur;
         this.edition=edition;
         this.prix=prix;       
         this.dateCreation=dateCreation;    
         this.Categorie=categorie;
         this.stock=stock;}
	

	public int getIdLivre() {
        return idLivre;
     }

     public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
     }
    
     
     public String getNomLivre() {
        return nomLivre;
     }

     public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
     }
     
     
     public String getAuteur() {
        return auteur;
     }

     public void setAuteur(String auteur) {
        this.auteur = auteur;
     }
     
     
     public String getEdition() {
        return edition;
     }

     public void setEdition(String edition) {
        this.edition = edition;
     }
     
     
     public float getPrix() {
        return prix;
     }

     public void setPrix(float prix) {
        this.prix = prix;
     }
     
     
     public Date getDateCreation() {
        return dateCreation;
     }

     public void setDateCreation (Date dateCreation) {
        this.dateCreation = dateCreation;
     }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setIdCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
  
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}