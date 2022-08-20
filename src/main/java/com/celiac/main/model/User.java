package com.celiac.main.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class User implements Serializable {
	
	private static final long serialVersionUID = -4551480543671717805L;
	
	@Id
	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false)
	private String email;
		
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateOfBirth;
	
	@Column(nullable = false)
	private String password;
	
//	Role could be 'customer' or 'business_owner', default is 'customer'
	@Column
	private String role = "customer";
	
	public User(String username, String name, String surname, String email, Date dateOfBirth, String password,
			String role) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.role = role;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "user [username=" + username + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", password=" + password + ", role=" + role + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}

