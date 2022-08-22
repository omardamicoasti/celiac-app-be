package com.celiac.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.celiac.main.model.BusinessPayment;

@Repository
public interface BusinessPaymentRepository extends JpaRepository<BusinessPayment, Long> {
	
		// Get business payment by vat
		
		@Query(value = "select * from business_payment where vat = ?1", nativeQuery = true)
		public Optional<BusinessPayment> getBusinessPaymentByVat(String vat);
			
}