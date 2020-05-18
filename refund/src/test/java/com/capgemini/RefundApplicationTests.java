package com.capgemini;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bean.Refund;
import com.capgemini.service.ServiceI;

@SpringBootTest
class RefundApplicationTests {
	
	@Autowired
	private ServiceI service;

	@Test
	void createRefund() {
		Refund refund=new Refund();
		refund.setAccount_no(1000); 
		refund.setBooking_id(85);
		refund.setSno(1);
		refund.setMoney_refunded(400); 
		refund.setDate_of_refund("5/8/2020"); String
		ref=service.refundDetails(refund);
		Assertions.assertEquals(refund.toString(),ref.toString());
	}
}