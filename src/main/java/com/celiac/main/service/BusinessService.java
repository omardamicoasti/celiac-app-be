package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import com.celiac.main.model.Business;

public interface BusinessService {
	void saveBusiness(Business business);
	List<Business> getAll();
	Optional<Business> findByVat(String vat);
	void deleteBusiness(Business business);
	
	List<Business> getBusinessByCity(String city);
	List<Business> getBusinessByCounty(String county);
	List<Business> getBusinessByRegion(String region);
	List<Business> getActiveBusiness();
	char deactivateByVat(String vat);
	char activateByVat(String vat);
	
}
