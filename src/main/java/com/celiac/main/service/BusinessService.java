package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.celiac.main.model.Business;

@Service
public interface BusinessService {
	Business saveBusiness(Business business);
	List<Business> getAll();
	Optional<Business> findByVat(String vat);
	void deleteBusiness(Business business);
	
	Optional<Business> getBusinessByVat(String vat);
	List<Business> getBusinessByUsername(String username);
	List<Business> getBusinessByCity(String city);
	List<Business> getBusinessByCounty(String county);
	List<Business> getBusinessByRegion(String region);
	List<Business> getActiveBusiness();
	char deactivateByVat(String vat);
	char activateByVat(String vat);
	
}
