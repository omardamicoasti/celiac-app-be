package com.celiac.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.celiac.main.model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {
	
	// Get business by city
	
	@Query(value = "select * from business where city = ?1", nativeQuery = true)
	public List<Business> getBusinessByCity(String city);
	
	// Get business by county
	
	@Query(value = "select * from business where county = ?1", nativeQuery = true)
	public List<Business> getBusinessByCounty(String county);
	
	// Get business by region
	
	@Query(value = "select * from business where region = ?1", nativeQuery = true)
	public List<Business> getBusinessByRegion(String region);
	
	// Deactivate business by vat
	
	@Modifying
	@Transactional
	@Query(value = "update business set active = 'n' where vat = ?1", nativeQuery = true)
	public char deactivateByVat(String vat);
	
	// Activate business by vat
	
	@Modifying
	@Transactional
	@Query(value = "update business set active = 'y' where vat = ?1", nativeQuery = true)
	public char activateByVat(String vat);
	
	// Get all active businesses
	
	@Query(value = "select * from business where active = 'y'", nativeQuery = true)
	public List<Business> getActiveBusiness();
	
	// Get business by username 
	
	@Query(value = "select * from business where username = ?1", nativeQuery = true)
	public List<Business> getBusinessByUsername(String username);
	
	// Get business by vat 
	
	@Query(value = "select * from business where vat = ?1", nativeQuery = true)
	public Optional<Business> getBusinessByVat(String vat);

}
