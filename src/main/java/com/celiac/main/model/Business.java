package com.celiac.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Business implements Serializable {
	
	private static final long serialVersionUID = 3022592016185574724L;

	@Id
	@Column(nullable = false, unique = true)
	private String vat;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String county;
	
	@Column(nullable = false)
	private String region;
	
	@Column(nullable = false)
	private String email;
		
	@Column(nullable = false)
	private String telephone;
	
	@Column(nullable = false)
	private char active = 'y';
	
	public Business(String vat, String name, String street, String city, String county, String region, String email,
			String telephone, char active) {
		this.vat = vat;
		this.name = name;
		this.street = street;
		this.city = city;
		this.county = county;
		this.region = region;
		this.email = email;
		this.telephone = telephone;
		this.active = active;
	}
	
	public Business() {
	}

	@Override
	public String toString() {
		return "business [vat=" + vat + ", name=" + name + ", street=" + street + ", city=" + city + ", county="
				+ county + ", region=" + region + ", email=" + email + ", telephone=" + telephone + "]";
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}
	
	
		
}

