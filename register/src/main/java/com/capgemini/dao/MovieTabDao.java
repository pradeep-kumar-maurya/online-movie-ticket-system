package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.bean.MovieTab;

public interface MovieTabDao extends JpaRepository<MovieTab, Integer>{
	
	@Query("select m from MovieTab m where theatre_Name=?1")
	public List<MovieTab> listOfMovies(String name);

}
