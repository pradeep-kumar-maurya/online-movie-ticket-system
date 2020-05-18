package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bean.Authentication;
import com.capgemini.bean.Booking;
import com.capgemini.bean.Customer;
import com.capgemini.bean.Languages;
import com.capgemini.bean.Payments;
import com.capgemini.bean.Seats;
import com.capgemini.bean.Shows;
import com.capgemini.exceptions.InvalidDetailsException;
import com.capgemini.service.ServiceI;

@RestController
@CrossOrigin("http://localhost:4200")
public class MyController {

	@Autowired
	private ServiceI service;
	
	@GetMapping("/authenticate/{username}/{password}")
	public ResponseEntity<Authentication> authenticate(@PathVariable("username") String uname, @PathVariable("password") String pass) {
		Authentication auth = service.authenticate(uname, pass);
		ResponseEntity<Authentication> response = new ResponseEntity<Authentication>(auth,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/shows")
	public ResponseEntity<List<Shows>> getShows(){
		List<Shows> list = service.getShows();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/languages")
	public ResponseEntity<List<Languages>> getLanguage(){
		List<Languages> list = service.getLanguage();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/seats")
	public ResponseEntity<List<Seats>> getSeats(){
		List<Seats> list = service.getSeats();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/get_seat/{seat_type}")
	public ResponseEntity<Seats> getSeat(@PathVariable("seat_type") String seat_type){
		Seats s = service.getSeat(seat_type);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@PutMapping("/update_seats")
	public ResponseEntity<String> updateSeats(@RequestBody Seats seat_obj) throws InvalidDetailsException {
		String string = service.updateSeats(seat_obj);
		return new ResponseEntity<>(string,HttpStatus.OK);
	}

	@PostMapping("/payments") 
	public ResponseEntity<Payments> payments(@RequestBody Payments pay) {
		Payments p = service.payments(pay); 
		return new ResponseEntity<>(p,HttpStatus.OK); 
	}
	
	@GetMapping("/account_data/{account_no}")
	public ResponseEntity<Customer> getAccountData(@PathVariable("account_no") int acc_no) {
		Customer cust = service.getAccountData(acc_no);
		return  new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@PutMapping("/update_account_data")
	public ResponseEntity<String>updateAccountDetails(@RequestBody Customer cust) {
		String string = service.updateAccountDetails(cust);
		return new ResponseEntity<>(string, HttpStatus.OK);
	}
	
	@PostMapping("/booking")
	public ResponseEntity<String> booking(@RequestBody Booking book){
		String string = service.booking(book);
		return new ResponseEntity<>(string, HttpStatus.OK);
	}

}