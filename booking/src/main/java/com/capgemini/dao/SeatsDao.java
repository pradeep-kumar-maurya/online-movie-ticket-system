package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.bean.Seats;

public interface SeatsDao extends JpaRepository<Seats, Integer>{

	@Query("select s from Seats s where seat_type=?1")
	public Seats getSeat(String seat_type);

}
