package com.coop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2799874789646240324L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser; // identity
	@Column(length=150)
	private String firstName; // maximo de tamaño de 150 caracteres
	@Column(length=150)
	private String lastName; // maximo de tamaño de 150 caracteres
	@Column(length=255,unique=true)
	private String email; // maximo de tamaño de 255 caracteres, unique
	@Column(length=70,unique=true)
	private String username; // maximo de tamaño de 70 caracteres, unique
	@Column(length=255)
	private String password; // maximo de tamaño de 255 caracteres
	@Column(columnDefinition = "Tinyint")
	private boolean enabled; // tipo de mysql ->tinyint

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
