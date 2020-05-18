import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookTicketComponent } from './book-ticket/book-ticket.component';
import { CancelTicketComponent } from './cancel-ticket/cancel-ticket.component';
import { AddCityComponent } from './add-city/add-city.component';
import { AddTheatreComponent } from './add-theatre/add-theatre.component';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { DeleteCityComponent } from './delete-city/delete-city.component';
import { DeleteMovieComponent } from './delete-movie/delete-movie.component';
import { DeleteTheatreComponent } from './delete-theatre/delete-theatre.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';


const routes: Routes = [
  {path:'Book-ticket', component:BookTicketComponent},
  {path:'Cancel-ticket', component:CancelTicketComponent},
  {path:'Add-City', component:AddCityComponent},
  {path:'Add-Theatre', component:AddTheatreComponent},
  {path:'Add-Movie', component:AddMovieComponent},
  {path:'Delete-City', component:DeleteCityComponent},
  {path:'Delete-Movie', component:DeleteMovieComponent},
  {path:'Delete-Theatre', component:DeleteTheatreComponent},
  {path:'Register', component:RegisterComponent},
  {path:'Admin', component:AdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
