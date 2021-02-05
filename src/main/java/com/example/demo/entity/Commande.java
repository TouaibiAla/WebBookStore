package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
private User idUtilisateur;

@OneToMany(mappedBy="commande", cascade=CascadeType.ALL) @NotNull 
@JsonIgnore
private List<LivreCommande> livreCommande;

public Commande() {
	super();
}
public Commande(Date date, int etat, double prix) {
	super();
	this.date = date;
	this.etat = etat;
	this.prix = prix;
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
@Override
public String toString() {
	return "Commande [idCommande=" + idCommande + ", date=" + date + ", etat=" + etat + ", prix=" + prix + "]";
}




}
