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
	public List<Business> getBusinessByUsername(String username) {
		return b.byUsername(username);
	}

	@Override
	public List<Business> getBusinessByCity(String city) {
		return b.getBusinessByCity(city);
	}

	@Override
	public List<Business> getBusinessByCounty(String county) {
		return b.getBusinessByCounty(county);
	}

	@Override
	public List<Business> getBusinessByRegion(String region) {
		return b.getBusinessByRegion(region);
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
	public List<Business> getBusinessByVat(String vat) {
		return b.byVat(vat);
	}


}