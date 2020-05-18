import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  check0:boolean = false;
  check1:boolean = true;

  title = 'movie-tickets';

  adminMethod(){
    this.check0 = true;
    this.check1 = false;
  }
}
