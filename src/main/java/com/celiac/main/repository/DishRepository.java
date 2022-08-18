package com.celiac.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.celiac.main.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
	
}

