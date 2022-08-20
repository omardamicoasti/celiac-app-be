package com.celiac.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiac.main.model.BusinessDish;
import com.celiac.main.repository.BusinessDishRepository;
import com.celiac.main.service.BusinessDishService;



@Service
public class BusinessDishServiceImpl implements BusinessDishService {

	@Autowired
	BusinessDishRepository db;

	@Override
	public BusinessDish saveBusinessDish(BusinessDish businessDish) {
		return db.save(businessDish);
	}

	@Override
	public List<BusinessDish> getAll() {
		return db.findAll();
	}

	@Override
	public Optional<BusinessDish> findByIdDb(Long id_bd) {
		return db.findById(id_bd);
	}

	@Override
	public void deleteBusinessDish(BusinessDish businessDish) {
		db.delete(businessDish);
	}

	@Override
	public Optional<BusinessDish> getBusinessDishesByVat(String vat) {
		return db.getBusinessDishesByVat(vat);
	}

}
