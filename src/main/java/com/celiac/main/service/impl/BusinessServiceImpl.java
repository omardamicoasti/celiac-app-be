package com.celiac.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiac.main.model.Business;
import com.celiac.main.repository.BusinessRepository;
import com.celiac.main.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	BusinessRepository b;

	@Override
	public Business saveBusiness(Business business) {
		return b.save(business);
	}

	@Override
	public List<Business> getAll() {
		return b.findAll();
	}

	@Override
	public void deleteBusiness(Business business) {
		b.delete(business);
	}
	
	@Override
	public List<Business> byUsername(String username) {
		return b.byUsername(username);
	}

	@Override
	public List<Business> byCity(String city) {
		return b.byCity(city);
	}

	@Override
	public List<Business> byCounty(String county) {
		return b.byCounty(county);
	}

	@Override
	public List<Business> byRegion(String region) {
		return b.byRegion(region);
	}

	@Override
	public List<Business> getActiveBusiness() {
		return b.getActiveBusiness();
	}

	@Override
	public void deactivateByVat(String vat) {

		b.deactivateByVat(vat);
	}

	@Override
	public void activateByVat(String vat) {
		b.activateByVat(vat);
	}

	@Override
	public List<Business> byVat(String vat) {
		return b.byVat(vat);
	}


}