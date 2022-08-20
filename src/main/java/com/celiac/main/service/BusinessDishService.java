package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.celiac.main.model.BusinessDish;

@Service
public interface BusinessDishService {
	BusinessDish saveBusinessDish(BusinessDish businessDish);
	List<BusinessDish> getAll();
	Optional<BusinessDish> findByIdDb(Long id_bd);
	void deleteBusinessDish(BusinessDish businessDish);
	
	Optional<BusinessDish> getBusinessDishesByVat(String vat);
}
