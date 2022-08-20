package com.celiac.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.celiac.main.model.BusinessDish;

@Repository
public interface BusinessDishRepository extends JpaRepository<BusinessDish, Long> {
	
	// Get dishes by vat
	
	@Query(value = "select * from business_dish where vat = ?1", nativeQuery = true)
	public Optional<BusinessDish> getBusinessDishesByVat(String vat);
		
}