package com.capgemini;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bean.Authentication;
import com.capgemini.bean.Customer;
import com.capgemini.bean.Languages;
import com.capgemini.bean.Payments;
import com.capgemini.bean.Seats;
import com.capgemini.bean.Shows;
import com.capgemini.exceptions.InvalidDetailsException;
import com.capgemini.service.ServiceI;

@SpringBootTest
class BookingApplicationTests {
	
	@Autowired
	private ServiceI service;
	
	@Test
	public void validate() {
		Authentication a = service.authenticate("pradeep", "pradeep123");
		Authentication a1 = new Authentication();
		a1.setSno(1);
		a1.setUsername("pradeep");
		a1.setPassword("pradeep123");
		Assertions.assertEquals(a1.toString(),a.toString());
	}

	@Test
	void getShows() {
		List<Shows> list = service.getShows();
		Assertions.assertEquals(4, list.size());
	}
	
	@Test
	void getLanguages() {
		List<Languages> list  = service.getLanguage();
		Assertions.assertEquals(3, list.size());
	}
	
	@Test
	void chechSeats() {
		List<Seats> list = service.getSeats();
		Assertions.assertEquals(3, list.size());
	}
	
	@Test
	void updateSeats() throws InvalidDetailsException {
		Seats seat = new Seats();
		seat.setAvailable_seats(100);
		seat.setPrice(400);
		seat.setSeat_type("BRONZE");
		seat.setSno(3);
		String s = service.updateSeats(seat);
		String s1 = "seats were updated successfully!!";
		Assertions.assertEquals(s1, s);
	}
	
	@Test
	void createPayment() {
		Payments p = new Payments();
		p.setAccount_no(1100);
		p.setBooking_id(152);
		p.setDate_of_transac("5/7/2020");
		p.setMoney_collected(800);
		p.setRefund(0);
		p.setSeat_type("Gold");
		p.setSeats_booked(1);
		Payments p1 = service.payments(p);
		Assertions.assertEquals(p.toString(), p1.toString());
	}
	
	@Test
	void checkCustomer() {
		Customer c = service.getAccountData(1000);
		Customer c1 = new Customer();
		c1.setAccount_no(1000);
		c1.setCurrent_balance(85200);
		c1.setName("pradeep kumar");
		c1.setUsername("pradeep");
		c1.setPassword("pradeep123");
		Assertions.assertEquals(c1.toString(), c.toString());
	}
	
	@Test
	void updateCustomer() {
		Customer c = new Customer();
		c.setAccount_no(1000);
		c.setCurrent_balance(100000);
		c.setName("pradeep kumar");
		c.setUsername("pradeep");
		c.setPassword("pradeep123");
		String s = service.updateAccountDetails(c);
		String s1 = "details updated successfully";
		Assertions.assertEquals(s1, s);
	}
}
