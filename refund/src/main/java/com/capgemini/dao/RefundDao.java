package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.bean.Refund;

public interface RefundDao extends JpaRepository<Refund, Integer>{

}
