package com.celiac.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiac.main.model.Opening;
import com.celiac.main.repository.OpeningRepository;
import com.celiac.main.service.OpeningService;

@Service
public class OpeningServiceImpl implements OpeningService {

	@Autowired
	OpeningRepository o;

	@Override
	public void saveOpening(Opening opening) {
		o.save(opening);
	}

	@Override
	public List<Opening> getAll() {
		return o.findAll();
	}

	@Override
	public Optional<Opening> findByIdOpening(Long id_opening) {
		return o.findById(id_opening);
	}

	@Override
	public void deleteOpening(Opening opening) {
		o.delete(opening);
	}

}