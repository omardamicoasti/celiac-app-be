package com.celiac.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiac.main.model.Dish;
import com.celiac.main.repository.DishRepository;
import com.celiac.main.service.DishService;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	DishRepository d;

	@Override
	public void saveDish(Dish dish) {
		d.save(dish);
	}

	@Override
	public List<Dish> getAll() {
		return d.findAll();
	}

	@Override
	public Optional<Dish> findByIdDish(Long id_dish) {
		return d.findById(id_dish);
	}

	@Override
	public void deleteDish(Dish dish) {
		d.delete(dish);
	}

}