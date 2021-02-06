package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@JoinColumn(name="fk_user_id", nullable=false)
private User user;
@ManyToOne
@JoinColumn(name="fk_livre_id", nullable=false )
private Livre livre;
/*@OneToMany(mappedBy="commande", cascade=CascadeType.ALL) @NotNull 
@JsonIgnore
private List<LivreCommande> livreCommande;*/
public Commande(Date date, int etat, double prix, User user, Livre livre) {
	super();
	this.date = date;
	this.etat = etat;
	this.prix = prix;
	this.user = user;
	this.livre = livre;
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
public Livre getLivre() {
	return livre;
}
public void setLivre(Livre livre) {
	this.livre = livre;
}
public Commande() {
	super();
}






}
