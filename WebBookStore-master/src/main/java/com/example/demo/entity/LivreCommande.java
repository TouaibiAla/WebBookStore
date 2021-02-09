package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table
public class LivreCommande {
	@ManyToOne
	@JoinColumn(name="idLivre", referencedColumnName="id", insertable=false, updatable=false)
	private Livre livre;
	@ManyToOne
	@JoinColumn(name="idCommande", referencedColumnName="idCommande", insertable=false, updatable=false)
	private Commande commande;
	
	@Column @NotNull
	private int quantite;
}
