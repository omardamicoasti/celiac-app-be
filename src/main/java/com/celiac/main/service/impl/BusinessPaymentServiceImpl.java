package com.celiac.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiac.main.model.BusinessPayment;
import com.celiac.main.repository.BusinessPaymentRepository;
import com.celiac.main.service.BusinessPaymentService;

@Service
public class BusinessPaymentServiceImpl implements BusinessPaymentService {

	@Autowired
	BusinessPaymentRepository bp;

	@Override
	public BusinessPayment saveBusinessPayment(BusinessPayment businessPayment) {
		return bp.save(businessPayment);
	}

	@Override
	public List<BusinessPayment> getAll() {
		return bp.findAll();
	}

	@Override
	public Optional<BusinessPayment> findByIdBp(Long id_bp) {
		return bp.findById(id_bp);
	}

	@Override
	public void deleteBusinessPayment(BusinessPayment businessPayment) {
		bp.delete(businessPayment);
	}

	@Override
	public Optional<BusinessPayment> getBusinessPaymentByVat(String vat) {
		return bp.getBusinessPaymentByVat(vat);
	}

	@Override
	public List<BusinessPayment> getBusinessPaymentByPayment(String payment) {
		return bp.getBusinessPaymentByPayment(payment);
	}

}