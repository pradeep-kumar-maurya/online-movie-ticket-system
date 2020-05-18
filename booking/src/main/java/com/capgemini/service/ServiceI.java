package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.Authentication;
import com.capgemini.bean.Booking;
import com.capgemini.bean.Customer;
import com.capgemini.bean.Languages;
import com.capgemini.bean.Payments;
import com.capgemini.bean.Seats;
import com.capgemini.bean.Shows;
import com.capgemini.exceptions.InvalidDetailsException;

public interface ServiceI {

	List<Shows> getShows();

	List<Languages> getLanguage();

	List<Seats> getSeats();

	Seats getSeat(String seat_type);

	String updateSeats(Seats seat_obj) throws InvalidDetailsException;

	Payments payments(Payments pay);

	Customer getAccountData(int acc_no);

	String updateAccountDetails(Customer cust);

	String booking(Booking book);

	Authentication authenticate(String uname, String pass);

}
