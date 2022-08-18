package com.celiac.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.celiac.main.model.BusinessDish;

@Repository
public interface BusinessDishRepository extends JpaRepository<BusinessDish, Long> {
	
}