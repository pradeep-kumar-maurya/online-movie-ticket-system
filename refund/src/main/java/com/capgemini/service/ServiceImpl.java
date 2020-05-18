package com.capgemini.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Payments;
import com.capgemini.bean.Refund;
import com.capgemini.bean.Seats;
import com.capgemini.dao.CustomerDao;
import com.capgemini.dao.PaymentsDao;
import com.capgemini.dao.RefundDao;
import com.capgemini.dao.SeatsDao;
import com.capgemini.exceptions.InvalidDetailsException;

@Service
@Transactional
public class ServiceImpl implements ServiceI {

	@Autowired
	private RefundDao refund_dao;
	@Autowired
	private PaymentsDao pay_dao;
	@Autowired
	private CustomerDao cus_dao;
	@Autowired
	private SeatsDao seats_dao;

	@Override
	public String refundDetails(Refund refund) {
		boolean bool = refund_dao.existsById(refund.getSno());
		if(bool) {
			refund_dao.save(refund);
			return "inserted the refund details successfully!!";
		}
		else {
			return "sorry, something went wrong";
		}
	}

	@Override
	public Payments refund(int accno, int bookingid) {
		return pay_dao.refund(accno, bookingid);
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
	public Seats getSeat(String seat_type) {
		return seats_dao.getSeat(seat_type);
	}

	@Override
	public String updatePayment(Payments pay) throws InvalidDetailsException {
		boolean bool = pay_dao.existsById(pay.getBooking_id());
		if(bool) {
			pay_dao.save(pay);
			return "payment details updated successfully!!";
		}
		else {
			throw new InvalidDetailsException("sorry,payment details not updated!!");
		}
	}

	@Override
	public Customer getAccountData(int acc_no) {
		return cus_dao.getAccountData(acc_no);
	}
}