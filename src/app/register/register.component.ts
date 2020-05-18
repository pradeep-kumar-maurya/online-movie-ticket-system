import { Component, OnInit } from '@angular/core';
import { Register, MovieServiceService } from '../movie-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  register_message:string;

  register_obj:Register = new Register(0,"","");

  checkAuthentication0:boolean = true;
  check0:boolean = false;
  check1:boolean = true;
  check2:boolean = false;
  check_city:boolean = false;
  check_theatre:boolean = false;
  check_movies:boolean = false;

  cities:any;
  theatres:any;
  movie_details:any;

  constructor(private service:MovieServiceService) { }

  ngOnInit(): void {

  }

  register(){
    if(this.register_obj.sno > 0 && this.register_obj.sno < 1000 && this.register_obj.username.length > 5 && this.register_obj.username.length < 31 && this.register_obj.password.length > 5 && this.register_obj.password.length < 16){
      this.service.registerUser(this.register_obj).subscribe((data)=>this.register_message = data);
      this.checkAuthentication0 = false;
      this.check0 = true;
      this.check1 = false;
      this.check2 = false;
    }
    else{
      var x = document.getElementById("uid");
      x.innerHTML = "Try new user id"
      var x1 = document.getElementById("uname1");
      x1.innerHTML = "Username should be >5 & <31";
      var x2 = document.getElementById("pass1");
      x2.innerHTML = "Password should be >5 & <16";
    }
  }

  checkMovies(){
    this.service.cityNames().subscribe((data)=>this.cities=data);
    this.check2 = true;
    this.check_city = true;
  }

  select_city(city_name:string){
    this.service.selectedCity(city_name).subscribe((data)=>this.theatres=data);
    this.check_theatre = true;
  }

  select_theatre(theatre_name:string){
    this.service.selected_theatre(theatre_name).subscribe((data)=>this.movie_details=data);
    this.check_movies = true;
  }

}
