import { Component, OnInit } from '@angular/core';
import { AdminServiceService, AddMovie } from '../admin-service.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {


  movie_obj:AddMovie = new AddMovie(0,"","","","","","");

  add_message:string;

  check0:boolean = true;
  check1:boolean = false;

  constructor(private admin_service:AdminServiceService) { }

  ngOnInit(): void {
  }

  add_movie(){
    this.admin_service.addMovie(this.movie_obj).subscribe((data)=>this.add_message=data);
    this.check0 = false;
    this.check1 = true;
  }

}
