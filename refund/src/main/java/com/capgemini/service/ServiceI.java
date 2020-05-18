package com.capgemini.service;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Payments;
import com.capgemini.bean.Refund;
import com.capgemini.bean.Seats;
import com.capgemini.exceptions.InvalidDetailsException;

public interface ServiceI {

	String refundDetails(Refund refund);

	Payments refund(int accno, int bookingid);

	String updateAccountDetails(Customer cust);

	String updateSeats(Seats seat_obj) throws InvalidDetailsException;

	Seats getSeat(String seat_type);

	String updatePayment(Payments pay) throws InvalidDetailsException;

	Customer getAccountData(int acc_no);

}
