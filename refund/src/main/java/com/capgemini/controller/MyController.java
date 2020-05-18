package com.capgemini.controller;

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

import com.capgemini.bean.Customer;
import com.capgemini.bean.Payments;
import com.capgemini.bean.Refund;
import com.capgemini.bean.Seats;
import com.capgemini.exceptions.InvalidDetailsException;
import com.capgemini.service.ServiceI;

@RestController
@CrossOrigin("http://localhost:4200")
public class MyController {
	
	@Autowired
	private ServiceI service;
	
	
	@GetMapping("/refund/{acc_no}/{book_id}")
	public ResponseEntity<Payments> refund(@PathVariable("acc_no") int accno, @PathVariable("book_id") int bookingid) {
		Payments pay =  service.refund(accno, bookingid);
		return new ResponseEntity<>(pay,HttpStatus.OK);
	}
	
	@PostMapping("/refund_details")
	public ResponseEntity<String> refundDetails(@RequestBody Refund refund) {
		String string = service.refundDetails(refund);
		return new ResponseEntity<>(string, HttpStatus.OK);
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
	
	@PutMapping("/update_seats")
	public ResponseEntity<String> updateSeats(@RequestBody Seats seat_obj) throws InvalidDetailsException {
		String string = service.updateSeats(seat_obj);
		return new ResponseEntity<>(string,HttpStatus.OK);
	}
	
	@GetMapping("/get_seat/{seat_type}")
	public ResponseEntity<Seats> getSeat(@PathVariable("seat_type") String seat_type){
		Seats s = service.getSeat(seat_type);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@PutMapping("/update_payment")
	public ResponseEntity<String> updatePayment(@RequestBody Payments pay) throws InvalidDetailsException {
		String string = service.updatePayment(pay);
		return new ResponseEntity<>(string,HttpStatus.OK);
	}
}