package com.celiac.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.celiac.main.model.enums.Day;
import com.celiac.main.model.enums.Meal;

@Entity
@Table
public class Opening implements Serializable {
	
	private static final long serialVersionUID = 4201940692814566659L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_opening;

	@ManyToOne
	@JoinColumn(name = "vat", nullable = false)
	private Business vat;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "day")
	private Day day;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "meal")
	private Meal meal;
	
	public Opening(Business vat, Day day, Meal meal) {
		this.vat = vat;
		this.day = day;
		this.meal = meal;
	}

	public Opening() {
	}

}
