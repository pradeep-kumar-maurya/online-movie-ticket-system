import { Component, OnInit } from '@angular/core';
import { AdminServiceService, AddCity } from '../admin-service.service';

@Component({
  selector: 'app-add-city',
  templateUrl: './add-city.component.html',
  styleUrls: ['./add-city.component.css']
})
export class AddCityComponent implements OnInit {

  city_obj:AddCity = new AddCity(0,"");

  add_message:string;

  check0:boolean = true;
  check1:boolean = false;

  constructor(private admin_service:AdminServiceService) { }

  ngOnInit(): void {
  }

  add_city(){
    if(!isNaN(this.city_obj.city_Id))
    {
    this.admin_service.addCity(this.city_obj).subscribe((data)=>this.add_message = data);
    this.check0 = false;
    this.check1 = true;
    }
}
}
