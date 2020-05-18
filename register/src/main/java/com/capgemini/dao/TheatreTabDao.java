package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.bean.TheatreTab;

public interface TheatreTabDao extends JpaRepository<TheatreTab, Integer>{
	
	@Query("select t from TheatreTab t where city_Name=?1")
	public List<TheatreTab> listOfTheatres(String name);

}
