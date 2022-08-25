package com.celiac.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.celiac.main.model.Business;
import com.celiac.main.model.BusinessDish;
import com.celiac.main.model.BusinessPayment;
import com.celiac.main.model.Dish;
import com.celiac.main.model.Opening;
import com.celiac.main.model.User;
import com.celiac.main.service.BusinessDishService;
import com.celiac.main.service.BusinessPaymentService;
import com.celiac.main.service.BusinessService;
import com.celiac.main.service.DishService;
import com.celiac.main.service.OpeningService;
import com.celiac.main.service.UserService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	UserService userService;

	@Autowired
	BusinessService businessService;
	
	@Autowired
	OpeningService openingService;
	
	@Autowired
	DishService dishService;

	@Autowired
	BusinessPaymentService businessPaymentService;
	
	@Autowired
	BusinessDishService businessDishService;

	/* BUSINESS API LIST */
	
//	@CrossOrigin
//	@GetMapping("/business")
//	public ResponseEntity<List<Business>> getAllBusiness() {
//		List<Business> businesses = businessService.getAll();
//		return new ResponseEntity<>(businesses, HttpStatus.OK);
//	}
	
	@CrossOrigin
	@GetMapping("/business-vat/{vat}")
	public ResponseEntity<List<Business>> getBusinessByVat(@PathVariable("vat") String vat) {
		List<Business> businessByVat = businessService.getBusinessByVat(vat);
		return new ResponseEntity<List<Business>>(businessByVat, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/business-city/{city}")
	public ResponseEntity<List<Business>> getBusinessByCity(@PathVariable("vat") String city) {
		List<Business> businessByCity = businessService.getBusinessByCity(city);
		return new ResponseEntity<List<Business>>(businessByCity, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/business-county/{county}")
	public ResponseEntity<List<Business>> getBusinessByCounty(@PathVariable("vat") String county) {
		List<Business> businessByCounty = businessService.getBusinessByCounty(county);
		return new ResponseEntity<List<Business>>(businessByCounty, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/business-region/{region}")
	public ResponseEntity<List<Business>> getBusinessByRegion(@PathVariable("vat") String region) {
		List<Business> businessByRegion = businessService.getBusinessByRegion(region);
		return new ResponseEntity<List<Business>>(businessByRegion, HttpStatus.OK);
	}

	/* OPENING API LIST */
	
	@CrossOrigin
	@GetMapping("/opening")
	public ResponseEntity<List<Opening>> getAllOpening() {
		List<Opening> openings = openingService.getAll();
		return new ResponseEntity<List<Opening>>(openings, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/opening-vat/{vat}")
	public ResponseEntity<List<Opening>> getOpeningByVat(@PathVariable("vat") String vat) {
		List<Opening> openingByVat = openingService.getOpeningByVat(vat);
		return new ResponseEntity<List<Opening>>(openingByVat, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/opening-day/{day}")
	public ResponseEntity<List<Opening>> getOpeningByDay(@PathVariable("day") String day) {
		List<Opening> openingByDay = openingService.getOpeningByDay(day);
		return new ResponseEntity<List<Opening>>(openingByDay, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/opening-meal/{meal}")
	public ResponseEntity<List<Opening>> getOpeningByMeal(@PathVariable("meal") String meal) {
		List<Opening> openingByMeal = openingService.getOpeningByMeal(meal);
		return new ResponseEntity<List<Opening>>(openingByMeal, HttpStatus.OK);
	}
		
	/* DISH API LIST */
	
	@CrossOrigin
	@GetMapping("/dish")
	public ResponseEntity<List<Dish>> getAllDish() {
		List<Dish> dishes = dishService.getAll();
		return new ResponseEntity<List<Dish>>(dishes, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/dish/{id}")
	public ResponseEntity<Optional<Dish>> findByIdDish(@PathVariable("id") Long id) {
		Optional<Dish> dishById = dishService.findByIdDish(id);
		return new ResponseEntity<Optional<Dish>>(dishById, HttpStatus.OK);
	}
		
	/* BUSINESS PAYMENT API LIST */
		
	@CrossOrigin
	@GetMapping("/business-payment-vat/{vat}")
	public ResponseEntity<Optional<BusinessPayment>> getBusinessPaymentByVat(@PathVariable("vat") String vat) {
		Optional<BusinessPayment> businessPaymentByVat = businessPaymentService.getBusinessPaymentByVat(vat);
		return new ResponseEntity<Optional<BusinessPayment>>(businessPaymentByVat, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/business-payment-payment/{payment}")
	public ResponseEntity<List<BusinessPayment>> getBusinessPaymentByPayment(@PathVariable("vat") String payment) {
		List<BusinessPayment> businessPaymentByPayment = businessPaymentService.getBusinessPaymentByPayment(payment);
		return new ResponseEntity<List<BusinessPayment>>(businessPaymentByPayment, HttpStatus.OK);
	}
		
	/* BUSINESS DISH API LIST */
	
	@CrossOrigin
	@PostMapping("/business-dish")
	public ResponseEntity<BusinessDish> saveBusinessDish(@RequestBody BusinessDish businessdish) {
		BusinessDish newBusinessDish = businessDishService.saveBusinessDish(businessdish);
		return new ResponseEntity<>(newBusinessDish, HttpStatus.CREATED);
	}
		
	@CrossOrigin
	@DeleteMapping("/business-dish/{id}")
	public ResponseEntity<?> deleteBusinessDish(@RequestBody BusinessPayment businesspayment) {
		businessPaymentService.deleteBusinessPayment(businesspayment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/business-dish/{vat}")
	public ResponseEntity<Optional<BusinessDish>> getBusinessDishByVat(@PathVariable("vat") String vat) {
		Optional<BusinessDish> businessDishByVat = businessDishService.getBusinessDishesByVat(vat);
		return new ResponseEntity<Optional<BusinessDish>>(businessDishByVat, HttpStatus.OK);
	}
	
}
