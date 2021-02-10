package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
@Entity
@Table
public class Commande {
	
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCommande;

@Column @NotNull
private Date date;

@Column @NotNull
private int etat;

@Column @NotNull
private double prix;

@ManyToOne
private User user;

@OneToMany(mappedBy="commande", cascade=CascadeType.ALL) @NotNull 
@JsonIgnore
private List<LivreCommande> livreCommande;

@OneToMany(mappedBy="commande", cascade=CascadeType.ALL) @NotNull 
@JsonIgnore
private List<Reclamation> reclamation;

public Commande() {
}

public Commande(Long idCommande, Date date, int etat, double prix, User user, List<LivreCommande> livreCommande,
		List<Reclamation> reclamation) {
	this.idCommande = idCommande;
	this.date = date;
	this.etat = etat;
	this.prix = prix;
	this.user = user;
	this.livreCommande = livreCommande;
	this.reclamation = reclamation;
}

public Long getIdCommande() {
	return idCommande;
}
public void setIdCommande(Long idCommande) {
	this.idCommande = idCommande;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getEtat() {
	return etat;
}
public void setEtat(int etat) {
	this.etat = etat;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public List<LivreCommande> getLivreCommande() {
	return livreCommande;
}

public void setLivreCommande(List<LivreCommande> livreCommande) {
	this.livreCommande = livreCommande;
}

public List<Reclamation> getReclamation() {
	return reclamation;
}

public void setReclamation(List<Reclamation> reclamation) {
	this.reclamation = reclamation;
}

@Override
public String toString() {
	return "Commande [idCommande=" + idCommande + ", date=" + date + ", etat=" + etat + ", prix=" + prix + ", user="
			+ user + ", livreCommande=" + livreCommande + ", reclamation=" + reclamation + "]";
}




}
