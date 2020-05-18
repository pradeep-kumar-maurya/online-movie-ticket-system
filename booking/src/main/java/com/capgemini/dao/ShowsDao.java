package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.bean.Shows;

public interface ShowsDao extends JpaRepository<Shows, Integer>{

}
