package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.Admin;
import com.capgemini.bean.CityTab;
import com.capgemini.bean.MovieTab;
import com.capgemini.bean.TheatreTab;

public interface ServiceI {

	String addCity(CityTab city);

	String addTheatre(TheatreTab theatre);

	String addMovie(MovieTab movie);

	Admin authenticate(String uname, String pass);

	List<CityTab> deleteCity(int id);

	List<MovieTab> deleteMovie(int id);

	List<MovieTab> listOfMovies();

	List<TheatreTab> deleteTheatre(int id);

	List<TheatreTab> getList();

	List<CityTab> listOfCities();

}
