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
@RequestMapping("/business-owner")
public class BusinessOwnerController {
	
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
	
	@CrossOrigin
	@GetMapping("/business")
	public ResponseEntity<List<Business>> getAllBusiness() {
		List<Business> businesses = businessService.getAll();
		return new ResponseEntity<>(businesses, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/business")
	public ResponseEntity<Business> saveBusiness(@RequestBody Business business) {
		Business newBusiness = businessService.saveBusiness(business);
		return new ResponseEntity<>(newBusiness, HttpStatus.CREATED);
	}

	@CrossOrigin
	@GetMapping("/business-vat/{vat}")
	public ResponseEntity<List<Business>> getBusinessByVat(@PathVariable("vat") String vat) {
		List<Business> businessByVat = businessService.getBusinessByVat(vat);
		return new ResponseEntity<List<Business>>(businessByVat, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/business-username/{username}")
	public ResponseEntity<List<Business>> getBusinessByUsername(@PathVariable("username") String username) {
		List<Business> businessByUsername = businessService.getBusinessByUsername(username);
		return new ResponseEntity<List<Business>>(businessByUsername, HttpStatus.OK);
	}
	
//	@CrossOrigin
//	@DeleteMapping("/business/{id}")
//	public ResponseEntity<?> deleteBusiness(@RequestBody Business business) {
//		businessService.deleteBusiness(business);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

	@CrossOrigin
	@PutMapping("/business/activate/{vat}")
	public ResponseEntity<?> activateByVat(@PathVariable("vat") String vat) {
		businessService.activateByVat(vat);
		return new ResponseEntity<>(true, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/business/deactivate/{vat}")
	public ResponseEntity<?> deactivateByVat(@PathVariable("vat") String vat) {
		businessService.deactivateByVat(vat);
		return new ResponseEntity<>(true, HttpStatus.CREATED);
	}
	
	/* OPENING API LIST */
	
	@CrossOrigin
	@PostMapping("/opening")
	public ResponseEntity<Opening> saveOpening(@RequestBody Opening opening) {
		Opening newOpening = openingService.saveOpening(opening);
		return new ResponseEntity<>(newOpening, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/opening")
	public ResponseEntity<List<Opening>> getAllOpening() {
		List<Opening> openings = openingService.getAll();
		return new ResponseEntity<List<Opening>>(openings, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/opening/{id}")
	public ResponseEntity<?> deleteOpening(@RequestBody Opening opening) {
		openingService.deleteOpening(opening);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/* DISH API LIST */
	
	@CrossOrigin
	@PostMapping("/dish")
	public ResponseEntity<Dish> saveDish(@RequestBody Dish dish) {
		Dish newDish = dishService.saveDish(dish);
		return new ResponseEntity<>(newDish, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/dish")
	public ResponseEntity<List<Dish>> getAllDish() {
		List<Dish> dishes = dishService.getAll();
		return new ResponseEntity<List<Dish>>(dishes, HttpStatus.OK);
	}
		
	/* BUSINESS PAYMENT API LIST */
	
	@CrossOrigin
	@PostMapping("/business-payment")
	public ResponseEntity<BusinessPayment> saveBusinessPayment(@RequestBody BusinessPayment businesspayment) {
		BusinessPayment newBusinessPayment = businessPaymentService.saveBusinessPayment(businesspayment);
		return new ResponseEntity<>(newBusinessPayment, HttpStatus.CREATED);
	}
		
	@CrossOrigin
	@DeleteMapping("/business-payment/{id}")
	public ResponseEntity<?> deleteBusinessPayment(@RequestBody BusinessPayment businesspayment) {
		businessPaymentService.deleteBusinessPayment(businesspayment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/business/{vat}")
	public ResponseEntity<Optional<BusinessPayment>> getBusinessPaymentByVat(@PathVariable("vat") String vat) {
		Optional<BusinessPayment> businessPaymentByVat = businessPaymentService.getBusinessPaymentByVat(vat);
		return new ResponseEntity<Optional<BusinessPayment>>(businessPaymentByVat, HttpStatus.OK);
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
