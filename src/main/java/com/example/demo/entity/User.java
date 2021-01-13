package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.sun.istack.NotNull;

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
	
	
	
	public User() {
		
	}
	
	public User(String email, String password, String firstNname, String lastName, String phoneNumber,
			String role) {
		this.email = email;
		this.password = password;
		this.firstNname = firstNname;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.role = role;
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
	
	

	
}
