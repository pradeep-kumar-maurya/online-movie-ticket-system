package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.bean.Payments;

public interface PaymentsDao extends JpaRepository<Payments, Integer>{

	@Query("select p from Payments p where account_no=?1 and booking_id=?2")
	public Payments refund(int accno, int bookingid);

}
