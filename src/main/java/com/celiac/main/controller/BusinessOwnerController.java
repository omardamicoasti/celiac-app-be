package com.celiac.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
@Scope("session")
@RequestMapping("/businessowner")
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
	
	////////////////////////////////////////////////////////////////////////// LOGIN
	
	
	
	////////////////////////////////////////////////////////////////////////// USER
	
	@CrossOrigin
	@PutMapping("/saveuser")
	public ResponseEntity<User> saveUser (@RequestBody User user) {
		User updatedUser = userService.saveUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/getalluser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = userService.getAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	////////////////////////////////////////////////////////////////////////// BUSINESS
	
	@CrossOrigin
	@GetMapping("/getallbusiness")
	public ResponseEntity<List<Business>> getAllBusiness() {
		List<Business> businesses = businessService.getAll();
		return new ResponseEntity<>(businesses, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/savebusiness")
	public ResponseEntity<Business> saveBusiness(@RequestBody Business business) {
		Business updatedBusiness = businessService.saveBusiness(business);
		return new ResponseEntity<>(updatedBusiness, HttpStatus.CREATED);
	}

	@CrossOrigin
	@GetMapping("/findbyvat/{vat}")
	public ResponseEntity<Optional<Business>> getEmployeeByVat(@PathVariable("vat") String vat) {
		Optional<Business> businessByVat = businessService.getBusinessByVat(vat);
		return new ResponseEntity<Optional<Business>>(businessByVat, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/findbyusername/{username}")
	public ResponseEntity<List<Business>> getEmployeeByUsername(@PathVariable("username") String username) {
		List<Business> businessByUsername = businessService.getBusinessByUsername(username);
		return new ResponseEntity<List<Business>>(businessByUsername, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteBusiness")
	public ResponseEntity<?> deleteBusiness(@RequestBody Business business) {
		businessService.deleteBusiness(business);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/activateByVat/{vat}")
	public ResponseEntity<?> activateByVat(@PathVariable("vat") String vat) {
		char activated = businessService.activateByVat(vat);
		return new ResponseEntity<>(activated, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/deactivateByVat/{vat}")
	public ResponseEntity<?> deactivateByVat(@PathVariable("vat") String vat) {
		char deactivated = businessService.deactivateByVat(vat);
		return new ResponseEntity<>(deactivated, HttpStatus.CREATED);
	}
	
	////////////////////////////////////////////////////////////////////////// OPENING
	
	@CrossOrigin
	@PutMapping("/saveopening")
	public ResponseEntity<Opening> saveOpening(@RequestBody Opening opening) {
		Opening updatedOpening = openingService.saveOpening(opening);
		return new ResponseEntity<>(updatedOpening, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/getallopening")
	public ResponseEntity<List<Opening>> getAllOpening() {
		List<Opening> openings = openingService.getAll();
		return new ResponseEntity<List<Opening>>(openings, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteopening")
	public ResponseEntity<?> deleteOpening(@RequestBody Opening opening) {
		openingService.deleteOpening(opening);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	////////////////////////////////////////////////////////////////////////// DISH
	
	@CrossOrigin
	@PutMapping("/savedish")
	public ResponseEntity<Dish> saveDish(@RequestBody Dish dish) {
		Dish updatedDish = dishService.saveDish(dish);
		return new ResponseEntity<>(updatedDish, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/getalldish")
	public ResponseEntity<List<Dish>> getAllDish() {
		List<Dish> dishes = dishService.getAll();
		return new ResponseEntity<List<Dish>>(dishes, HttpStatus.OK);
	}
		
	////////////////////////////////////////////////////////////////////////// BUSINESS PAYMENT
	
	@CrossOrigin
	@PutMapping("/savebusinesspayment")
	public ResponseEntity<BusinessPayment> saveBusinessPayment(@RequestBody BusinessPayment businesspayment) {
		BusinessPayment updatedBusinessPayment = businessPaymentService.saveBusinessPayment(businesspayment);
		return new ResponseEntity<>(updatedBusinessPayment, HttpStatus.CREATED);
	}
		
	@CrossOrigin
	@DeleteMapping("/deletbusinesspayment")
	public ResponseEntity<?> deleteBusinessPayment(@RequestBody BusinessPayment businesspayment) {
		businessPaymentService.deleteBusinessPayment(businesspayment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/getbusinesspaymentbyvat/{vat}")
	public ResponseEntity<Optional<BusinessPayment>> getBusinessPaymentByVat(@PathVariable("vat") String vat) {
		Optional<BusinessPayment> businessPaymentByVat = businessPaymentService.getBusinessPaymentByVat(vat);
		return new ResponseEntity<Optional<BusinessPayment>>(businessPaymentByVat, HttpStatus.OK);
	}
		
	////////////////////////////////////////////////////////////////////////// BUSINESS DISH
	
	@CrossOrigin
	@PutMapping("/savebusinessdish")
	public ResponseEntity<BusinessDish> saveBusinessDish(@RequestBody BusinessDish businessdish) {
		BusinessDish updatedBusinessDish = businessDishService.saveBusinessDish(businessdish);
		return new ResponseEntity<>(updatedBusinessDish, HttpStatus.CREATED);
	}
		
	@CrossOrigin
	@DeleteMapping("/deletbusinessdish")
	public ResponseEntity<?> deleteBusinessDish(@RequestBody BusinessPayment businesspayment) {
		businessPaymentService.deleteBusinessPayment(businesspayment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/getbusinessdishbyvat/{vat}")
	public ResponseEntity<Optional<BusinessDish>> getBusinessDishByVat(@PathVariable("vat") String vat) {
		Optional<BusinessDish> businessDishByVat = businessDishService.getBusinessDishesByVat(vat);
		return new ResponseEntity<Optional<BusinessDish>>(businessDishByVat, HttpStatus.OK);
	}
	
}
