package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.bean.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer>{

}
