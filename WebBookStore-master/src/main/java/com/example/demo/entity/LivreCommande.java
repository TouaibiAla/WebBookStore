package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table
public class LivreCommande implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name="idLivre", referencedColumnName="id", insertable=false, updatable=false)
	private Livre livre;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idCommande", referencedColumnName="idCommande", insertable=false, updatable=false)
	private Commande commande;
	
	@Column @NotNull
	private int quantite;
}
