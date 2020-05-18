import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-delete-movie',
  templateUrl: './delete-movie.component.html',
  styleUrls: ['./delete-movie.component.css']
})
export class DeleteMovieComponent implements OnInit {

  movies:any;

  check1:boolean = false;

  constructor(private admin_service:AdminServiceService) { }

  ngOnInit(): void {
    this.admin_service.list_movies().subscribe((data)=>this.movies=data);
    this.check1 = true;
  }

  delete_movie(id:number){
    this.admin_service.deleteMovie(id).subscribe((data)=>this.movies=data);
  }

}
