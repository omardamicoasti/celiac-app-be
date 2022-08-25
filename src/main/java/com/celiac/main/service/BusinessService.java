package com.celiac.main.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.celiac.main.model.Business;

@Service
public interface BusinessService {
	Business saveBusiness(Business business);
	List<Business> getAll();
	void deleteBusiness(Business business);
	
	List<Business> getBusinessByVat(String vat);
	List<Business> getBusinessByUsername(String username);
	List<Business> getBusinessByCity(String city);
	List<Business> getBusinessByCounty(String county);
	List<Business> getBusinessByRegion(String region);
	List<Business> getActiveBusiness();
	void deactivateByVat(String vat);
	void activateByVat(String vat);
	
}
