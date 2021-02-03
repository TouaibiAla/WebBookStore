package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class Livreur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivreur;
	
	@Column @NotNull
	private String nomLivreur;
	
	@Column @NotNull
	private String prenomLivreur;
	
	@Column @NotNull
	private boolean disponibilite;
	
	
	public Livreur() {
		
	}
	
	public Livreur(String nomLivreur, String prenomLivreur) {
		
		this.nomLivreur = nomLivreur;
		this.prenomLivreur = prenomLivreur;
		this.disponibilite = true;
	}


	public Long getIdLivreur() {
		return idLivreur;
	}

	public void setIdLivreur(Long idLivreur) {
		this.idLivreur = idLivreur;
	}

	public String getNomLivreur() {
		return nomLivreur;
	}

	public void setNomLivreur(String nomLivreur) {
		this.nomLivreur = nomLivreur;
	}

	public String getPrenomLivreur() {
		return prenomLivreur;
	}

	public void setPrenomLivreur(String prenomLivreur) {
		this.prenomLivreur = prenomLivreur;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	
}
