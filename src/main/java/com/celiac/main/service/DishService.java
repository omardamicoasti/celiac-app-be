package com.celiac.main.service;

import java.util.List;
import java.util.Optional;

import com.celiac.main.model.Dish;

public interface DishService {
	void saveDish(Dish dish);
	List<Dish> getAll();
	Optional<Dish> findByIdDish(Long id_dish);
	void deleteDish(Dish dish);
}
