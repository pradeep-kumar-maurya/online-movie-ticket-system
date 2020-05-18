import { Component, OnInit } from '@angular/core';
import { AdminServiceService, AddTheatre } from '../admin-service.service';

@Component({
  selector: 'app-add-theatre',
  templateUrl: './add-theatre.component.html',
  styleUrls: ['./add-theatre.component.css']
})
export class AddTheatreComponent implements OnInit {


  theatre_obj:AddTheatre = new AddTheatre(0,"","","","");

  add_message:string;

  check0:boolean = true;
  check1:boolean = false;

  constructor(private admin_service:AdminServiceService) { }

  ngOnInit(): void {
  }

  add_theatre(){
    this.admin_service.addTheatre(this.theatre_obj).subscribe((data)=>this.add_message=data);
    this.check0 = false;
    this.check1 = true;
  }
}
