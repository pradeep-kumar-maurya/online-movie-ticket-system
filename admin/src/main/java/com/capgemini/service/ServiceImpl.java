package com.capgemini.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bean.Admin;
import com.capgemini.bean.CityTab;
import com.capgemini.bean.MovieTab;
import com.capgemini.bean.TheatreTab;
import com.capgemini.dao.AdminDao;
import com.capgemini.dao.CityTabDao;
import com.capgemini.dao.MovieTabDao;
import com.capgemini.dao.TheatreTabDao;

@Service
@Transactional
public class ServiceImpl implements ServiceI {

	@Autowired
	private AdminDao admin_dao;
	@Autowired
	private CityTabDao city_dao;
	@Autowired
	private TheatreTabDao theatre_dao;
	@Autowired
	private MovieTabDao movie_dao;


	@Override
	public Admin authenticate(String uname, String pass) {
		return admin_dao.authenticate(uname, pass);
	}

	@Override
	public String addCity(CityTab city) {
		boolean bool = city_dao.existsById(city.getCity_Id());
		if(bool) {
			return "sorry, city was not added..!!";
		}
		else {
			CityTab c = city_dao.findCity(city.getCity_Name());
			if(c != null) {
				return "sorry, city was not added..!!";
			}
			else {
				String s = city.getCity_Name().toUpperCase();
				city.setCity_Name(s);
				city_dao.save(city);
				return "City was added successfully..!!";
			}
		}
	}

	@Override
	public String addTheatre(TheatreTab theatre) {
		String s = theatre.getCity_Name().toUpperCase();
		theatre.setCity_Name(s);
		CityTab c = city_dao.findCity(theatre.getCity_Name());
		if( c != null) {
			String s1 = theatre.getTheatre_Name().toUpperCase();
			theatre.setTheatre_Name(s1);
			TheatreTab t = theatre_dao.findTheatreName(theatre.getTheatre_Name());
			if(t == null) {
				theatre_dao.save(theatre);
				return "Theatre was added successfully..!!";
			}
			else {
				return "sorry, theatre was not added..!!";
			}
		}
		else {
			return "Sorry, theatre was not added..!!";
		}
	}


	@Override
	public String addMovie(MovieTab movie) {
		boolean bool = movie_dao.existsById(movie.getMovie_Id());
		if(bool) {
			return "sorry, the movie was not added..!!";
		}
		else {
			String s = movie.getTheatre_Name().toUpperCase();
			movie.setTheatre_Name(s);
			TheatreTab t = theatre_dao.getTheatre(movie.getTheatre_Name());
			if(t != null) {
				String s1 = movie.getMovie_Name().toUpperCase();
				movie.setMovie_Name(s1);
				MovieTab m = movie_dao.getMovieName(movie.getMovie_Name());
				if(m == null) {
					movie_dao.save(movie);
					return "movie was added successfully..!!";
				}
				else {
					return "sorry, movie was not added..!!";
				}
			}
			else {
				return "sorry, movie was not added..!!";
			}
		}
	}

	@Override
	public List<CityTab> deleteCity(int id) {
		CityTab c = city_dao.findCity(id);
		if(c != null) {
			List<TheatreTab> list1 = theatre_dao.getCity(c.getCity_Name());
			if(list1.size() == 0) {
				city_dao.deleteById(id);
				List<CityTab> list = city_dao.findAll();
				return list;
			}
			else {
				List<CityTab> list = city_dao.findAll();
				return list;
			}
		}
		else {
			List<CityTab> list = city_dao.findAll();
			return list;
		}
	}

	@Override
	public List<MovieTab> deleteMovie(int id) {
		boolean bool = movie_dao.existsById(id);
		if(bool) {
			movie_dao.deleteById(id);
			List<MovieTab> list = movie_dao.findAll();
			return list;
		}
		else {
			List<MovieTab> list = movie_dao.findAll();
			return list;
		}
	}

	@Override
	public List<MovieTab> listOfMovies() {
		List<MovieTab> list = movie_dao.findAll();
		return list;
	}

	@Override
	public List<TheatreTab> deleteTheatre(int id) {
		TheatreTab t1 = theatre_dao.findTheatre(id); 
		if(t1 != null ) {
			List<MovieTab> list1 = movie_dao.getMovie(t1.getTheatre_Name());
			if(list1.size() == 0) {
				theatre_dao.deleteById(id);
				List<TheatreTab> list = theatre_dao.findAll();
				return list;
			}
			else {
				List<TheatreTab> list = theatre_dao.findAll();
				return list;
			}
		}
		else {
			List<TheatreTab> list = theatre_dao.findAll();
			return list;
		}
	}

	@Override
	public List<TheatreTab> getList() {
		List<TheatreTab> list = theatre_dao.findAll();
		return list;
	}

	@Override
	public List<CityTab> listOfCities() {
		List<CityTab> list = city_dao.findAll();
		return list;
	}
}