package com.capgemini.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bean.Authentication;
import com.capgemini.bean.Booking;
import com.capgemini.bean.Customer;
import com.capgemini.bean.Languages;
import com.capgemini.bean.Payments;
import com.capgemini.bean.Seats;
import com.capgemini.bean.Shows;
import com.capgemini.dao.AuthenticationDao;
import com.capgemini.dao.BookingDao;
import com.capgemini.dao.CustomerDao;
import com.capgemini.dao.LanguagesDao;
import com.capgemini.dao.PaymentsDao;
import com.capgemini.dao.SeatsDao;
import com.capgemini.dao.ShowsDao;
import com.capgemini.exceptions.InvalidDetailsException;

@Service
@Transactional
public class ServiceImpl implements ServiceI {

	@Autowired
	private AuthenticationDao auth_dao;
	@Autowired
	private ShowsDao show_dao;
	@Autowired
	private LanguagesDao lang_dao;
	@Autowired
	private SeatsDao seats_dao;
	@Autowired
	private PaymentsDao pay_dao;
	@Autowired
	private CustomerDao cus_dao;
	@Autowired
	private BookingDao book_dao;
	
	@Override
	public Authentication authenticate(String uname, String pass) {
		return auth_dao.authenticate(uname, pass);
	}
	
	@Override
	public List<Shows> getShows() {
		List<Shows> list = show_dao.findAll();
		return list;
	}

	@Override
	public List<Languages> getLanguage() {
		List<Languages> list = lang_dao.findAll();
		return list;
	}

	@Override
	public List<Seats> getSeats() {
		List<Seats> list = seats_dao.findAll();
		return list;
	}

	@Override
	public Seats getSeat(String seat_type) {
		return seats_dao.getSeat(seat_type);
	}

	@Override
	public String updateSeats(Seats seat_obj) throws InvalidDetailsException {
		boolean bool = seats_dao.existsById(seat_obj.getSno());
		if(bool) {
			seats_dao.save(seat_obj);
			return "seats were updated successfully!!";
		}
		else {
			throw new InvalidDetailsException("sorry, that particular seat does not exist!!");
		}
	}

	@Override
	public Payments payments(Payments pay) {
		boolean bool = pay_dao.existsById(pay.getBooking_id());
		if(bool) {
			return null;
		}
		else {
			return pay_dao.save(pay);
		}
	}

	@Override
	public Customer getAccountData(int acc_no) {
		return cus_dao.getAccountData(acc_no);
	}

	@Override
	public String updateAccountDetails(Customer cust) {
		boolean bool = cus_dao.existsById(cust.getAccount_no());
		if(bool == true) {
			cus_dao.save(cust);
			return "details updated successfully";
		}
		else {
			return "Sorry, details were not updated";
		}
	}

	@Override
	public String booking(Booking book) {
		boolean bool = book_dao.existsById(book.getSno());
		if(bool) {
			return "sorry..! booking data was not inserted..!!";
		}
		else {
			book_dao.save(book);
			return "booking data inserted successfully..!!";
		}
	}
}