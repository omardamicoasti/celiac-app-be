package com.celiac.main.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.celiac.main.model.Business;
import com.celiac.main.model.BusinessDish;
import com.celiac.main.model.User;
import com.celiac.main.security.BCryptEncoder;
import com.celiac.main.service.BusinessDishService;
import com.celiac.main.service.BusinessPaymentService;
import com.celiac.main.service.BusinessService;
import com.celiac.main.service.DishService;
import com.celiac.main.service.OpeningService;
import com.celiac.main.service.UserService;

@Controller
@Scope("session")
public class CustomerController {

//	@Autowired
//	UserService userService;
//
//	@Autowired
//	BusinessService businessService;
//	
//	@Autowired
//	OpeningService openingService;
//	
//	@Autowired
//	DishService dishService;
//
//	@Autowired
//	BusinessPaymentService businessPaymentService;
//	
//	@Autowired
//	BusinessDishService businessDishService;
//
//	/****************** LOGIN ***************/
//
//	@RequestMapping(value = "/loginBusinessOwner", method = RequestMethod.GET)
//	public ResponseEntity<T> loginBusinessOwner() {
////		ResponseEntity re = new ResponseEntity();
////		re.setViewName("loginBusinessOwner");
//		return null;
//	}
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ResponseEntity<T> home(HttpSession session) {
////		ResponseEntity<> re = new ResponseEntity();
////		re.setViewName("home");
//
//
//		return null;
//	}
//
//	/****************** USER REGISTRATION ***************/
//
//	@RequestMapping(value = "/registration", method = RequestMethod.GET)
//	public ResponseEntity<T> userRegistration(HttpSession session) {
//
////		ResponseEntity<> re = new ResponseEntity();
////		re.setViewName("registration");
////		re.addObject("user", new User());
////		re.addObject("user_log", (User) session.getAttribute("user"));
//
//		return null;
//	}
//
//	@RequestMapping(value = "/registration", method = RequestMethod.POST)
//	public ResponseEntity<T> userRegistration(User user, BindingResult br) {
//
////		ResponseEntity re = new ResponseEntity();
//
//		if (userService.findByUsername(user.getUsername()).isPresent()) {
//
//			re.addObject("checkUser", "User already registered");
//			re.setViewName("registration");
//
//			return null;
//		} else {
//
//			System.out.println(user.getPassword());
//			user.setPassword(BCryptEncoder.encode(user.getPassword()));
//
//			System.out.println("**********REGISTRATION********** " + user.getPassword());
//			userService.saveUser(user);
//			
//			return null;
////			return new ModelAndView("redirect:/login");
//		}
//	}
//
//	/****************** LOGIN UTENTE ***************/
//
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ResponseEntity<T> login(HttpSession session) {
//		if (session.getAttribute("user_log") != null) {
//			return null;
////			return new ModelAndView("redirect:/logout");
//		}
////		ResponseEntity re = new ResponseEntity();
//		re.setViewName("login");
//		re.addObject("user", new User());
//		return null;
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ResponseEntity<T> checkLogin(@RequestParam("username") String user, @RequestParam("password") String password,
//			HttpSession session) {
//
//		if (userService.findByUsername(user).isPresent()) {
//
//			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//			if (encoder.matches(password, userService.findByUsername(user).get().getPassword())) {
//
//				session.setAttribute("utente_log", userService.findByUsername(user).get());
//				
//				return null;
////				return new ModelAndView("redirect:/acquisti");
//
//			} else {
//				return null;
////				return new ModelAndView("redirect:/");
//			}
//			
//		} else {
//			return null;
////			return new ModelAndView("redirect:/");
//		}
//	}
//
//	/****************** UPDATE USER ***************/
//
//	@RequestMapping(value = "/updateuser", method = RequestMethod.GET)
//	public ResponseEntity<User> updateUser(HttpSession session) {
//		if (session.getAttribute("user_log") == null) {
//			return new ResponseEntity<User>;
//		}
//		ResponseEntity<User> re = new ResponseEntity<User>(null);
//		re.setViewName("updateuser");
//		User user = (User) session.getAttribute("user_log");
//
//		re.addObject("user", user);
//		re.addObject("user_log", (User) session.getAttribute("user"));
//
//		return null;
//	}
//
//	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
//	public ResponseEntity<User> updateUser(User user, BindingResult br, HttpSession session) {
//
//		System.out.println(user.getPassword());
//		user.setPassword(BCryptEncoder.encode(user.getPassword()));
//
//		System.out.println("**********UPDATE********** " + user.getPassword());
//		userService.saveUser(user);
//		session.invalidate();
//		
//		return null;
////		return new ModelAndView("redirect:/login");
//
//	}
//
//	/****************** LOGOUT UTENTE ***************/
//
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public ResponseEntity<User> logoutPage(HttpSession session) {
//
////		ResponseEntity re = new ResponseEntity();
//		re.setViewName("logout");
//
//		session.setAttribute("user_log", session.getAttribute("user_log"));
//
//		return null;
//	}
//
//	@RequestMapping(value = "/logoutuser", method = RequestMethod.GET)
//	public ResponseEntity<User> logoutUser(HttpSession session) {
//
//		session.invalidate();
//		
//		return null;
////		return new ModelAndView("redirect:/");
//	}
//
//	/****************** BUSINESS **************/
//
//	@RequestMapping(value = "/business", method = RequestMethod.GET)
//	public ResponseEntity<List<Business>> getAllBusiness() {
//		List<Business> business = businessService.getAll();
//		return new ResponseEntity<>(business, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/business/{vat}", method = RequestMethod.GET)
//	public ResponseEntity<Business> getBusinessByVat (@PathVariable("vat") String vat) {
//
//		Business business = businessService.findByVat(vat).get();
//		return new ResponseEntity<>(business, HttpStatus.OK);
//	}
//	
//	/****************** BUSINESS DISHES **************/
//	
//	@RequestMapping(value = "/business/{vat}/dishes", method = RequestMethod.GET)
//	public ResponseEntity<BusinessDish> getBusinessDishesByVat (@PathVariable("vat") String vat) {
//
//		List<BusinessDish> businessDishes = businessDishService.getBusinessDishesByVat(vat);
//		
//		// così avrò un elenco di business dish (il suo identificativo cioè id_bd,
//		// la vat del business, id_dish e il price), devo andare in dish e stampare
//		// tutti i dish che corrispondono ai miei id_dish
//		
////		return new ResponseEntity<>(businessDishes, HttpStatus.OK);
//	}

}

