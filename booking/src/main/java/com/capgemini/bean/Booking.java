package com.capgemini.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence")
	@SequenceGenerator(name="booking_sequence", sequenceName = "book_seq",allocationSize = 1)
	@Column(length = 5)
	private int sno;
	@Column(length = 20)
	private String city;
	@Column(length = 15)
	private String theatre;
	@Column(length = 30)
	private String movie;
	@Column(length = 30)
	private String show;
	@Column(length = 30)
	private String language;
	@Column(length = 30)
	private String screen;
	@Column(length = 15)
	private String booking_date;
	@Column(length = 10)
	private String seat_type;
	@Column(length = 3)
	private int seats_booked;
	@Column(length = 5)
	private int amount;
	@Column(length = 5)
	private int booking_Id;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTheatre() {
		return theatre;
	}
	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public String getSeat_type() {
		return seat_type;
	}
	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}
	public int getSeats_booked() {
		return seats_booked;
	}
	public void setSeats_booked(int seats_booked) {
		this.seats_booked = seats_booked;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBooking_Id() {
		return booking_Id;
	}
	public void setBooking_Id(int booking_Id) {
		this.booking_Id = booking_Id;
	}
}