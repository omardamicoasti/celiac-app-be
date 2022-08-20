package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.celiac.main.model.Opening;

@Service
public interface OpeningService {
	Opening saveOpening(Opening opening);
	List<Opening> getAll();
	Optional<Opening> findByIdOpening(Long id_opening);
	void deleteOpening(Opening opening);
}
