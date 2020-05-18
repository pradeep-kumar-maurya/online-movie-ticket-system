import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookTicketComponent } from './book-ticket/book-ticket.component';
import { MovieServiceService } from './movie-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CancelTicketComponent } from './cancel-ticket/cancel-ticket.component';
import { AddCityComponent } from './add-city/add-city.component';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { AddTheatreComponent } from './add-theatre/add-theatre.component';
import { DeleteTheatreComponent } from './delete-theatre/delete-theatre.component';
import { DeleteCityComponent } from './delete-city/delete-city.component';
import { DeleteMovieComponent } from './delete-movie/delete-movie.component';
import { AdminServiceService } from './admin-service.service';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    BookTicketComponent,
    CancelTicketComponent,
    AddCityComponent,
    AddMovieComponent,
    AddTheatreComponent,
    DeleteTheatreComponent,
    DeleteCityComponent,
    DeleteMovieComponent,
    RegisterComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [MovieServiceService, AdminServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
