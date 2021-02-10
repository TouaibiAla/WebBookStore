package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.NonNull;

@Entity
@Table
public class Reclamation {
   
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReclamation;
	
	@Column @NotNull
	private String sujet;
	
	@Column @NotNull
	private String description;
	
	@Column @NotNull
	@Enumerated(EnumType.STRING)
	private Etat etat;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Commande commande;

	public Reclamation() {
	}

	public Reclamation(Long idReclamation, String sujet, String description, Etat etat, User user, Commande commande) {
		this.idReclamation = idReclamation;
		this.sujet = sujet;
		this.description = description;
		this.etat = etat;
		this.user = user;
		this.commande = commande;
	}
	
	public Long getIdReclamation() {
		return idReclamation;
	}

	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	
	
	
}
