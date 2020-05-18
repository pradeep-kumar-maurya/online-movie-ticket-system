package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.bean.Payments;

public interface PaymentsDao extends JpaRepository<Payments, Integer>{

}
