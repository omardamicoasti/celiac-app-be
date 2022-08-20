package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.celiac.main.model.Dish;

@Service
public interface DishService {
	Dish saveDish(Dish dish);
	List<Dish> getAll();
	Optional<Dish> findByIdDish(Long id_dish);
	void deleteDish(Dish dish);
}
