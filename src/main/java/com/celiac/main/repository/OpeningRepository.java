package com.celiac.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.celiac.main.model.Opening;

@Repository
public interface OpeningRepository extends JpaRepository<Opening, Long> {
	
}
