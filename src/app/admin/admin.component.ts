import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  username:string;
  password:string;

  auth:any;

  check0:boolean = true;

  constructor(private admin_service:AdminServiceService, private app:AppComponent) { }

  ngOnInit(): void {
  }

  validate(){
    this.admin_service.authenticate(this.username, this.password).subscribe((data)=>{this.auth=data;
      if(this.auth != null){
        this.check0 = false;
        this.app.adminMethod();
      }
      else{
        var x = document.getElementById("uname1");
        x.innerHTML = "Incorret username";
        var x1 = document.getElementById("pass1");
        x1.innerHTML = "Incorret password";
      }
  });
}
}
