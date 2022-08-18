package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import com.celiac.main.model.Opening;

public interface OpeningService {
	void saveOpening(Opening opening);
	List<Opening> getAll();
	Optional<Opening> findByIdOpening(Long id_opening);
	void deleteOpening(Opening opening);
}
