package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bean.Authentication;
import com.capgemini.bean.CityTab;
import com.capgemini.bean.MovieTab;
import com.capgemini.bean.TheatreTab;
import com.capgemini.controllerAdvice.NoDataFoundException;
import com.capgemini.service.ServiceI;

@RestController
@CrossOrigin("http://localhost:4200")
public class MyController {

	@Autowired
	private ServiceI service;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Authentication auth) throws NoDataFoundException {
		String string = service.register(auth);
		return new ResponseEntity<>(string, HttpStatus.OK);
	}
	
	@GetMapping("/list_of_cities")
	public ResponseEntity<List<CityTab>> listOfCities(){
		List<CityTab> list = service.listOfCities();
		return new ResponseEntity<List<CityTab>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/list_of_theatres/{city_name}")
	public ResponseEntity<List<TheatreTab>> listOfCities(@PathVariable("city_name") String name){
		List<TheatreTab> list = service.listOfTheatres(name);
		return new ResponseEntity<List<TheatreTab>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/list_of_movies/{theatre_name}")
	public ResponseEntity<List<MovieTab>> listOfMovies(@PathVariable("theatre_name") String name){
		List<MovieTab> list = service.listOfMovies(name);
		return new ResponseEntity<List<MovieTab>>(list, HttpStatus.OK);
	}
}
