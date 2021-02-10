package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="id", nullable=false)
	private User user;

	public Reclamation() {
	}

	public Reclamation(Long idReclamation, String sujet, String description, User user) {
		super();
		this.idReclamation = idReclamation;
		this.sujet = sujet;
		this.description = description;
		this.user = user;
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
		return user;
	}

	public void setIdUtilisateur(User idUtilisateur) {
		this.user = idUtilisateur;
	}
	
	
	
}
