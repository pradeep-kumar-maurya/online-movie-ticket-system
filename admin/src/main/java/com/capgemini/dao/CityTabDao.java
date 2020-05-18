package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.bean.CityTab;

public interface CityTabDao extends JpaRepository<CityTab, Integer>{

	@Query("select c from CityTab c where city_Name=?1")
	public CityTab findCity(String city_Name);

	@Query("select c from CityTab c where city_Id=?1")
	public CityTab findCity(int id);

}
