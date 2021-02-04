package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table
public class Reclamation {
   
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReclamation;
	
	@Column @NonNull
	private String sujet;
	
	@Column @NonNull
	private String description;
	
	@ManyToOne
	private User idUtilisateur;

	public Reclamation() {
	}

	public Reclamation(Long idReclamation, String sujet, String description, User idUtilisateur) {
		super();
		this.idReclamation = idReclamation;
		this.sujet = sujet;
		this.description = description;
		this.idUtilisateur = idUtilisateur;
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

	public User getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(User idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	
	
}
