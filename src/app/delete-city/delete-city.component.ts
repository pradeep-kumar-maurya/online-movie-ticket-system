import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-delete-city',
  templateUrl: './delete-city.component.html',
  styleUrls: ['./delete-city.component.css']
})
export class DeleteCityComponent implements OnInit {

  cities:any;

  check1:boolean = false;

  constructor(private admin_service:AdminServiceService) { }

  ngOnInit(): void {
    this.admin_service.listOfCities().subscribe((data)=>this.cities=data);
    console.log(this.cities);
    this.check1 = true;
  }

  delete_city(id:number){
    this.admin_service.deleteCity(id).subscribe((data)=>this.cities=data);
  }

}
