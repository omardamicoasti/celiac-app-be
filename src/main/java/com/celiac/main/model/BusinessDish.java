package com.celiac.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class BusinessDish implements Serializable {
	
	private static final long serialVersionUID = 4201940692814566659L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_bd;
	
	@Column(nullable = false)
	private String price;
	
	@ManyToOne
	@JoinColumn(name = "vat", nullable = false)
	private Business vat;
	
	@ManyToOne
	@JoinColumn(name = "id_dish", nullable = false)
	private Dish id_dish;
	
	public BusinessDish(String price, Business vat, Dish id_dish) {
		this.price = price;
		this.vat = vat;
		this.id_dish = id_dish;
	}
	
	public BusinessDish() {
	}

	@Override
	public String toString() {
		return "business_dish [id_bd=" + id_bd + ", price=" + price + ", vat=" + vat + ", id_dish=" + id_dish + "]";
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
