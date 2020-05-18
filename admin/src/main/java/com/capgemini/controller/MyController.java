package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bean.Admin;
import com.capgemini.bean.CityTab;
import com.capgemini.bean.MovieTab;
import com.capgemini.bean.TheatreTab;
import com.capgemini.service.ServiceI;

@RestController
@CrossOrigin("http://localhost:4200")
public class MyController {

	@Autowired
	private ServiceI service;
	
	@GetMapping("/authenticate/{username}/{password}")
	public ResponseEntity<Admin> authenticate(@PathVariable("username") String uname, @PathVariable("password") String pass){
		Admin admin = service.authenticate(uname, pass);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	@PostMapping("/add/city")
	public ResponseEntity<String> addCity(@RequestBody CityTab city){
		String string = service.addCity(city);
		return new ResponseEntity<>(string, HttpStatus.OK);	
	}
	
	@PostMapping("/add/theatre")
	public ResponseEntity<String> addTheatre(@RequestBody TheatreTab theatre){
		String string = service.addTheatre(theatre);
		return new ResponseEntity<>(string, HttpStatus.OK);
	}
	
	@PostMapping("/add/movie")
	public ResponseEntity<String> addMovie(@RequestBody MovieTab movie){
		String string = service.addMovie(movie);
		return new ResponseEntity<>(string,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_city/{city_id}")
	public ResponseEntity<List<CityTab>> deleteCity(@PathVariable("city_id") int id){
		List<CityTab> list = service.deleteCity(id);
		return new ResponseEntity<List<CityTab>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/list_of_cities")
	public ResponseEntity<List<CityTab>> listOfCities(){
		List<CityTab> list = service.listOfCities();
		return new ResponseEntity<List<CityTab>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/movie/{movie_Id}")
	public ResponseEntity<List<MovieTab>> deleteMovie(@PathVariable("movie_Id") int id){
		List<MovieTab> list = service.deleteMovie(id);
		return new ResponseEntity<List<MovieTab>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listOfMovies")
	public ResponseEntity<List<MovieTab>> listOfMovies(){
		List<MovieTab> list = service.listOfMovies();
		return new ResponseEntity<List<MovieTab>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_theatre/{theatre_id}")
	public ResponseEntity<List<TheatreTab>> deleteTheatre(@PathVariable("theatre_id") int id){
		List<TheatreTab> list = service.deleteTheatre(id);
		return new ResponseEntity<List<TheatreTab>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<TheatreTab>> list(){
		List<TheatreTab> list = service.getList();
		return new ResponseEntity<List<TheatreTab>>(list, HttpStatus.OK);
	}
}
