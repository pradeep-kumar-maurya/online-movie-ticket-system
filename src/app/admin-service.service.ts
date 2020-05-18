import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class AddCity{
  city_Id:number;
  city_Name:string;
  constructor(city_Id:number, city_Name:string){
    this.city_Id = city_Id;
    this.city_Name = city_Name;
  }
}

export class AddTheatre{
  theatre_Id:number;
  theatre_Name:string;
  theatre_manager:string;
  city_Name:string;
  manager_contact_no:string;
  constructor(theatre_Id:number, theatre_Name:string, theatre_manager:string, city_Name, 
    manager_contact_no:string){
      this.theatre_Id = theatre_Id;
      this.theatre_Name = theatre_Name;
      this.theatre_manager = theatre_manager;
      this.city_Name = city_Name;
      this.manager_contact_no = manager_contact_no;
    }
}

export class AddMovie{
  movie_Id:number;
  movie_Name:string;
  movie_Genre:string;
  movie_Director:string;
  movie_Length:string;
  movie_Release_Date:string;
  theatre_Name:string;
  constructor(movie_Id:number, movie_Name:string, movie_Genre:string, movie_Director:string, movie_Length:string, movie_Release_Date:string, theatre_Name:string){
    this.movie_Id = movie_Id;
    this.movie_Name = movie_Name;
    this.movie_Genre = movie_Genre;
    this.movie_Director = movie_Director;
    this.movie_Length = movie_Length;
    this.movie_Release_Date = movie_Release_Date;
    this.theatre_Name = theatre_Name;
  }
}

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(private http:HttpClient) { }

  public addCity(city){
    return this.http.post("http://localhost:8765/add/city",city,{responseType:'text'});
  }

  public addTheatre(theatre){
    return this.http.post("http://localhost:8765/add/theatre",theatre,{responseType:'text'});
  }

  public addMovie(movie){
    return this.http.post("http://localhost:8765/add/movie",movie,{responseType:'text'});
  }

  public listOfCities(){
    return this.http.get("http://localhost:8765/list_of_cities",{responseType:'json'});
  }

  public deleteCity(id:number){
    return this.http.delete("http://localhost:8765/delete_city/"+id,{responseType:'json'});
  }

  public list_movies(){
    return this.http.get("http://localhost:8765/listOfMovies",{responseType:'json'});
  }

  public deleteMovie(id:number){
    return this.http.delete("http://localhost:8765/delete/movie/"+id,{responseType:'json'});
  }

  public list_theatres(){
    return this.http.get("http://localhost:8765/list",{responseType:'json'});
  }

  public deleteTheatre(id:number){
    return this.http.delete("http://localhost:8765/delete_theatre/"+id,{responseType:'json'});
  }

  public authenticate(uname:string, pass:string){
    return this.http.get("http://localhost:8765/authenticate/"+uname+"/"+pass,{responseType:'json'});
  }
}
