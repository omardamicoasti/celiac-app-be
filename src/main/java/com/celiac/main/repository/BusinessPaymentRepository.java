package com.celiac.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.celiac.main.model.BusinessPayment;

@Repository
public interface BusinessPaymentRepository extends JpaRepository<BusinessPayment, Long> {
	
}