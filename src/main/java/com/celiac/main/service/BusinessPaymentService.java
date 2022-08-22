package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.celiac.main.model.BusinessPayment;

@Service
public interface BusinessPaymentService {
	BusinessPayment saveBusinessPayment(BusinessPayment businessPayment);
	List<BusinessPayment> getAll();
	Optional<BusinessPayment> findByIdBp(Long id_bp);
	void deleteBusinessPayment(BusinessPayment businessPayment);
	
	Optional<BusinessPayment> getBusinessPaymentByVat(String vat);
}