package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table
public class LivreCommande {
	@ManyToOne
	private Livre livre;
	@ManyToOne
	private Commande commande;
	
	@Column @NotNull
	private int quantite;
}
