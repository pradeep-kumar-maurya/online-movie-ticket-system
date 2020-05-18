package com.capgemini.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bean.Authentication;
import com.capgemini.bean.CityTab;
import com.capgemini.bean.MovieTab;
import com.capgemini.bean.TheatreTab;
import com.capgemini.controllerAdvice.NoDataFoundException;
import com.capgemini.dao.CityTabDao;
import com.capgemini.dao.MovieTabDao;
import com.capgemini.dao.RegisterDao;
import com.capgemini.dao.TheatreTabDao;

@Service
@Transactional
public class ServiceImpl implements ServiceI {
	
	@Autowired
	private RegisterDao reg_dao;
	@Autowired
	private CityTabDao city_dao;
	@Autowired
	private TheatreTabDao theatre_dao;
	@Autowired
	private MovieTabDao movie_dao;

	@Override
	public String register(Authentication auth) throws NoDataFoundException {
		Authentication a = reg_dao.findUsername(auth.getUsername());
		if(a == null) {
			reg_dao.save(auth);
			return "Registered successfully..!!";
		}
		else {
			throw new NoDataFoundException("sorry, something wen wrong..!!");
		}
	}

	@Override
	public List<CityTab> listOfCities() {
		List<CityTab> list = city_dao.findAll();
		return list;
	}

	@Override
	public List<TheatreTab> listOfTheatres(String name) {
		List<TheatreTab> list = theatre_dao.listOfTheatres(name);
		return list;
	}

	@Override
	public List<MovieTab> listOfMovies(String name) {
		List<MovieTab> list = movie_dao.listOfMovies(name);
		return list;
	}
}