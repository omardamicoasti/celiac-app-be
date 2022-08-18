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

import com.celiac.main.model.enums.Payment;

@Entity
@Table
public class BusinessPayment implements Serializable {
	
	private static final long serialVersionUID = 4201940692814566659L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_bp;
	
	@ManyToOne
	@JoinColumn(name = "vat", nullable = false)
	private Business vat;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "payment")
	private Payment payment;
	
	public BusinessPayment(Business vat, Payment payment) {
		this.vat = vat;
		this.payment = payment;
	}

	public BusinessPayment() {
	}

}
