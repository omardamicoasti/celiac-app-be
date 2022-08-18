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
	@DateTimeFormat(pattern = "yyy/MM/dd")
	private Date date_of_birth;
	
	@Column(nullable = false)
	private String password;
		
	@Column
	private String role = "USER";
	
	public User(String username, String name, String surname, String email, Date date_of_birth, String password,
			String role) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "user [username=" + username + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", date_of_birth=" + date_of_birth + ", password=" + password + ", role=" + role + "]";
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

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
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

