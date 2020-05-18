import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-delete-theatre',
  templateUrl: './delete-theatre.component.html',
  styleUrls: ['./delete-theatre.component.css']
})
export class DeleteTheatreComponent implements OnInit {

  theatres:any;

  check1:boolean = false;

  constructor(private admin_service:AdminServiceService) { }

  ngOnInit(): void {
    this.admin_service.list_theatres().subscribe((data)=>this.theatres=data);
    this.check1 = true;
  }

  delete_theatre(id:number){
    this.admin_service.deleteTheatre(id).subscribe((data)=>this.theatres=data);
  }

}
