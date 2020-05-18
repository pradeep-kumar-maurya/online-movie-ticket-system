package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.Authentication;
import com.capgemini.bean.CityTab;
import com.capgemini.bean.MovieTab;
import com.capgemini.bean.TheatreTab;
import com.capgemini.controllerAdvice.NoDataFoundException;

public interface ServiceI {

	String register(Authentication auth) throws NoDataFoundException;

	List<CityTab> listOfCities();

	List<TheatreTab> listOfTheatres(String name);

	List<MovieTab> listOfMovies(String name);

}
