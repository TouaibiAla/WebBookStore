package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.example.demo.entity.Reclamation;
import com.sun.istack.NotNull;

import antlr.collections.List;
import lombok.AllArgsConstructor;


@Entity
@Table
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@Column @NotNull
private String email;
	@Column @NotNull
private String password;
	@Column @NotNull
private String firstNname;
	@Column @NotNull
private String lastName;
	@Column @NotNull
private String phoneNumber;
	@Column @NotNull
private String role;
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL) @NotNull 
	@JsonIgnore
private java.util.List<Reclamation> reclamation;
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL) @NotNull 
	@JsonIgnore
private java.util.List<Commande> commande;
	
	
	public User() {
		
	}

	public User(Long id, String email, String password, String firstNname, String lastName, String phoneNumber,
			String role, java.util.List<Reclamation> reclamation, java.util.List<Commande> commande) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstNname = firstNname;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.reclamation = reclamation;
		this.commande = commande;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public String getFirstName() {
		return firstNname;
	}
	public void setFirstName(String firstName) {
		this.firstNname = firstName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstNname() {
		return firstNname;
	}

	public void setFirstNname(String firstNname) {
		this.firstNname = firstNname;
	}

	public java.util.List<Reclamation> getReclamation() {
		return reclamation;
	}

	public void setReclamation(java.util.List<Reclamation> reclamation) {
		this.reclamation = reclamation;
	}

	public java.util.List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(java.util.List<Commande> commande) {
		this.commande = commande;
	}
	
	

	
}
