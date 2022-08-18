package com.celiac.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.celiac.main.model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
	
}
