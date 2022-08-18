package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import com.celiac.main.model.BusinessPayment;

public interface BusinessPaymentService {
	void saveBusinessPayment(BusinessPayment businessPayment);
	List<BusinessPayment> getAll();
	Optional<BusinessPayment> findByIdBp(Long id_bp);
	void deleteBusinessPayment(BusinessPayment businessPayment);
}