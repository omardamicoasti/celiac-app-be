package com.celiac.main.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.celiac.main.model.Business;

@Service
public interface BusinessService {
	Business saveBusiness(Business business);
	List<Business> getAll();
	void deleteBusiness(Business business);
	
	List<Business> byVat(String vat);
	List<Business> byUsername(String username);
	List<Business> byCity(String city);
	List<Business> byCounty(String county);
	List<Business> byRegion(String region);
	List<Business> getActiveBusiness();
	void deactivateByVat(String vat);
	void activateByVat(String vat);
	
}
