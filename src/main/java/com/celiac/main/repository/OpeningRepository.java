package com.celiac.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.celiac.main.model.Opening;

@Repository
public interface OpeningRepository extends JpaRepository<Opening, Long> {
	
	// Get opening by vat
	
	@Query(value = "select * from opening where vat = ?1", nativeQuery = true)
	public List<Opening> getOpeningByVat(String vat);
	
	// Get opening by day
	
	@Query(value = "select * from business where day = ?1", nativeQuery = true)
	public List<Opening> getOpeningByDay(String day);
	
	// Get opening by meal
	
	@Query(value = "select * from business where meal = ?1", nativeQuery = true)
	public List<Opening> getOpeningByMeal(String meal);
	
}
