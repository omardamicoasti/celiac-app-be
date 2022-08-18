package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import com.celiac.main.model.BusinessDish;

public interface BusinessDishService {
	void saveBusinessDish(BusinessDish businessDish);
	List<BusinessDish> getAll();
	Optional<BusinessDish> findByIdDb(Long id_bd);
	void deleteBusinessDish(BusinessDish businessDish);
	
	List<BusinessDish> getBusinessDishesByVat(String vat);
}
